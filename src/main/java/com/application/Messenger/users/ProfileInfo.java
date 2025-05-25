package com.application.Messenger.users;

import com.application.Messenger.Common.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
public class ProfileInfo {

    private String profileName;
    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] profileImage;

    private String mobileNumber;
    private String bio;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime created_At;
    private LocalDateTime lastSeen;
}
