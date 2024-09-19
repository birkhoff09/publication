/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

/**
 *
 * @author Birkhoff
 */
@Getter
@Setter
public abstract class AbstractModel  implements Serializable{
    @Version
    private int version;


    @CreatedDate
    @Column(name = "createDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime createDate;

    @UpdateTimestamp
    @Column(name = "updateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime updateDate;
}
