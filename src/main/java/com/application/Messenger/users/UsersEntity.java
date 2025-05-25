package com.application.Messenger.users;

import com.application.Messenger.contact.Contacts;
import com.application.Messenger.messages.Message;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UsersEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Embedded
    private ProfileInfo profileInfo;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = "reciever", cascade = CascadeType.ALL)
    private List<Message> receivedMessages = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contacts> contacts = new ArrayList<>();
}
