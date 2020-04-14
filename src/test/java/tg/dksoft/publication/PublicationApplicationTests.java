package tg.dksoft.publication;

import io.jsonwebtoken.lang.Assert;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.AuthorPublication;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.model.Privilege;
import tg.dksoft.publication.model.Role;
import tg.dksoft.publication.model.User;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.service.IPrivilegeService;
import tg.dksoft.publication.service.IPublicationService;
import tg.dksoft.publication.service.IRoleService;
import tg.dksoft.publication.service.IUserService;

@Transactional
@SpringBootTest
class PublicationApplicationTests {

    @Autowired
    IUserService userService;

    @Autowired
    IAuthorService authorService;

    @Autowired
    IPublicationService publicationService;
    @Autowired
    IPrivilegeService privilegeService;
    @Autowired
    IRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IBookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    void loadUsersTest() {
        Assert.notEmpty(userService.findAll());
    }

    @Test
    void loadAuthorsTest() {
        Assert.notEmpty(authorService.findAll());
    }

    @Test
    void loadPublicationsTest() {
        Assert.notEmpty(publicationService.findAll());
    }

    @Test
    void createUserTest() {

        // Create Privilege
        Privilege privilege = new Privilege();
        privilege.setPrivilege("create-user");
        privilege = privilegeService.save(privilege);

        // Create Role 
        Role userRole = new Role();
        userRole.setRoleName("TEST");
        userRole.setPrivileges(new HashSet<>(Arrays.asList(privilege)));
        userRole = roleService.save(userRole);
        User user = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setFirstName("test");
        user.setLastName("test");
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("test"));
        user.setRole(userRole);
        Assert.notNull(userService.save(user));
    }

    @Test
    void createAuthorTest() {
        Author author = new Author();
        author.setFirstName("JOHN");
        author.setLastName("Doe");
        Assert.notNull(authorService.save(author));
    }

    @Test
    void createBookTest() {
        //Create Author
        Author author = new Author();
        author.setFirstName("JOHN");
        author.setLastName("Doe");
        author = authorService.save(author);
        //Create Book
        Book book = new Book();
        book.setAuthorPublications(Collections.singleton(new AuthorPublication(book, author)));
        book.setPages(250);
        book.setDatePublication(new Date());
        book.setTitle("Mon premier livre");
        Assert.notNull(bookService.save(book));
    }

}
