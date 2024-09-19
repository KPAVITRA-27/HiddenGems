package com.example.HiddenGemsDBMS.Controllers;

import com.example.HiddenGemsDBMS.DTO.MessageToArtisanDTO;
import com.example.HiddenGemsDBMS.DTO.MessageToUserDTO;
import com.example.HiddenGemsDBMS.Models.Artisans;
import com.example.HiddenGemsDBMS.Models.ToArtisanMessages;
import com.example.HiddenGemsDBMS.Models.ToUserMessages;
import com.example.HiddenGemsDBMS.Models.Users;
import com.example.HiddenGemsDBMS.Repository.ArtisanRepository;
import com.example.HiddenGemsDBMS.Repository.ToArtisanMessagesRepository;
import com.example.HiddenGemsDBMS.Repository.ToUserMessagesRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ArtisanController {
//    @Autowired
//    ArtisanRepository artisanRepository;
//    @Autowired
//    ToArtisanMessagesRepository toArtisanMessagesRepository;
//    @Autowired
//    ToUserMessagesRepository toUserMessagesRepository;
//
//    @GetMapping("/artisan/login/{artisan_username}/{password}")
//    ResponseEntity<String> loginUser(@PathVariable String artisan_username, @PathVariable String password){
//        Optional<Artisans> artisansOptional=artisanRepository.findById(artisan_username);
//        if(artisansOptional.isPresent()){
//            if(artisansOptional.get().getPassword().equals(password)){
//                return ResponseEntity.ok("Logged in as user:"+artisansOptional.get().getFname());
//            }return ResponseEntity.ok("Incorrect Password");
//        }
//        return ResponseEntity.badRequest().body("No such user found");
//    }
//
//    @PostMapping("/artisan/register")
//    ResponseEntity<String>registerUser(@RequestBody Artisans artisans){
//        Optional<Artisans>artisansOptional=artisanRepository.findById(artisans.getArtisan_username());
//        Optional<Artisans>emailOptional=artisanRepository.findByEmail(artisans.getEmail());
//        if(artisansOptional.isPresent() || emailOptional.isPresent()){
//            return ResponseEntity.badRequest().body("Username or Email already in use");
//        }artisanRepository.save(artisans);
//        return ResponseEntity.ok("Registered as "+artisans.getFname()+" "+artisans.getLname());
//    }
//
//    @GetMapping("/artisan/{artisan_username}/messages")
//    public List<MessageToArtisanDTO>messageToArtisan(@PathVariable String artisan_username){
//        List<ToArtisanMessages> messages=toArtisanMessagesRepository.findByArtisan(artisan_username);
//        return messages.stream()
//                .map(message -> new MessageToArtisanDTO(
//                        message.getUser().getUser_username(), // Fetch artisan's username
//                        message.getContent(),
//                        message.getTimestamp()))
//                .collect(Collectors.toList());
//
//    }
}
