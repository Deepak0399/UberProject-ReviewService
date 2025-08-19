package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)// this annotation tells spring to manage the format of date in database
    @CreatedDate// this annotation tells spring to only handle it for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)// this annotation tells spring to manage the format of date in database
    @LastModifiedDate// this annotation tells spring to only handle it for object update
    protected Date updatedAt;
}
