package com.example.HiddenGemsDBMS.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "messagetoartisan")
public class ToArtisanMessages {
    @Id
    private String message_id;
    @ManyToOne
    @JoinColumn(name="user_username",referencedColumnName = "user_username" )
    private Users user;
    @ManyToOne
    @JoinColumn(name="artisan_username",referencedColumnName = "artisan_username" )
    private Artisans artisan;
    private String content;
    private LocalDateTime timestamp;

    public ToArtisanMessages() {
    }

    @Override
    public String toString() {
        return "ToArtisanMessages{" +
                "message_id='" + message_id + '\'' +
                ", user=" + user +
                ", artisan=" + artisan +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Artisans getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisans artisan) {
        this.artisan = artisan;
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
