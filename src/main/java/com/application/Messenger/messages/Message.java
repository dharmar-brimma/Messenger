package com.application.Messenger.messages;

import com.application.Messenger.Common.MessageStatus;
import com.application.Messenger.attachments.Attachments;
import com.application.Messenger.users.UsersEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID messageId;

    private String content;

    @Enumerated(EnumType.STRING)
    private MessageStatus messageStatus;

    private LocalDateTime sentAt;
    private LocalDateTime seenAt;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UsersEntity sender;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private UsersEntity receiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attachment_id")
    private Attachments attachment;


}
