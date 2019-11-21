package tg.dksoft.publication;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tg.dksoft.publication.model.Author;
import tg.dksoft.publication.model.Book;
import tg.dksoft.publication.model.Privilege;
import tg.dksoft.publication.model.Publisher;
import tg.dksoft.publication.model.Role;
import tg.dksoft.publication.model.User;
import tg.dksoft.publication.service.IAuthorService;
import tg.dksoft.publication.service.IBookService;
import tg.dksoft.publication.service.IPrivilegeService;
import tg.dksoft.publication.service.IPublicationService;
import tg.dksoft.publication.service.IPublisherService;
import tg.dksoft.publication.service.IRoleService;
import tg.dksoft.publication.service.IUserService;

@SpringBootApplication
@EnableWebMvc
@ComponentScan
public class PublicationApplication implements CommandLineRunner {

    @Autowired
    IUserService userService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IPrivilegeService privilegeService;

    @Autowired
    IPublicationService publicationService;

    @Autowired
    IPublisherService publisherService;
    @Autowired
    IAuthorService authorService;

    @Autowired
    IBookService bookService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PublicationApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        // Create Privilege
        Privilege privilege1 = new Privilege();
        privilege1.setPrivilege("create-user");
        privilege1 = privilegeService.save(privilege1);

        Privilege privilege2 = new Privilege();
        privilege2.setPrivilege("delete-user");
        privilege2 = privilegeService.save(privilege2);

        Privilege privilege3 = new Privilege();
        privilege3.setPrivilege("create-author");
        privilege3 = privilegeService.save(privilege3);

        Privilege privilege4 = new Privilege();
        privilege4.setPrivilege("delete-author");
        privilege4 = privilegeService.save(privilege4);

        //Create Roles
        Set<Privilege> adminPrivileges = new HashSet<>();
        adminPrivileges.add(privilege1);
        adminPrivileges.add(privilege2);
        adminPrivileges.add(privilege3);
        adminPrivileges.add(privilege4);

        Set<Privilege> userPrivileges = new HashSet<>();
        userPrivileges.add(privilege3);
        userPrivileges.add(privilege4);

        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        adminRole.setPrivileges(adminPrivileges);
        adminRole = roleService.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("USER");
        userRole.setPrivileges(userPrivileges);
        userRole = roleService.save(userRole);

        // Create Users
        User admin = new User();
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setCredentialsNonExpired(true);
        admin.setEnabled(true);
        admin.setFirstName("Admin");
        admin.setLastName("Admin");
        admin.setUserName("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole(adminRole);
        userService.save(admin);

        User user = new User();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setFirstName("User");
        user.setLastName("User");
        user.setUserName("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRole(userRole);
        userService.save(user);

        // Create Publisher 
        Publisher publisher1 = new Publisher();
        publisher1.setName("Publisher One");
        publisherService.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Publisher Two");
        publisherService.save(publisher2);

        // Create Author
        Author author1 = new Author();
        author1.setFirstName("DENAKPO");
        author1.setLastName("Ferdinand");
        authorService.save(author1);

        Author author2 = new Author();
        author2.setFirstName("KARABOU");
        author2.setLastName("Armand");
        authorService.save(author2);

        //Create Book
        Book book1 = new Book();
        book1.setAuthors(Collections.singleton(author1));
        book1.setPages(250);
        book1.setDatePublication(new Date());
        book1.setTitle("Mon premier livre");
        bookService.save(book1);

        Book book2 = new Book();
        book2.setAuthors(Collections.singleton(author2));
        book2.setPages(250);
        book2.setDatePublication(new Date());
        book2.setTitle("Mon deuxieme livre");
        bookService.save(book2);
    }

}
