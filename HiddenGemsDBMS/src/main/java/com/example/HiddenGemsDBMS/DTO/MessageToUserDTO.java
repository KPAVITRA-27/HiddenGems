package com.example.HiddenGemsDBMS.DTO;

import java.time.LocalDateTime;

public class MessageToUserDTO {
    private String  messageId;
    private String userUsername;     // User's username who received the message
    private String artisanUsername;  // Artisan's username who sent the message
    private String content;
    private LocalDateTime timestamp;

    // Constructors
    public MessageToUserDTO(String messageId, String userUsername, String artisanUsername, String content, LocalDateTime timestamp) {
        this.messageId = messageId;
        this.userUsername = userUsername;
        this.artisanUsername = artisanUsername;
        this.content = content;
        this.timestamp = timestamp;
    }




    // Getters and Setters
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String  messageId) {
        this.messageId = messageId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getArtisanUsername() {
        return artisanUsername;
    }

    public void setArtisanUsername(String artisanUsername) {
        this.artisanUsername = artisanUsername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
