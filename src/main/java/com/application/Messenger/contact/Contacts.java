package com.application.Messenger.contact;

import com.application.Messenger.Common.Status;
import com.application.Messenger.users.UsersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contacts {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID contactId;

    @Column(name = "user_name")
    private String userName;

    private String mobileNumber;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] profileImage;

    private String bio;

    private Status status;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private UsersEntity user;
}
