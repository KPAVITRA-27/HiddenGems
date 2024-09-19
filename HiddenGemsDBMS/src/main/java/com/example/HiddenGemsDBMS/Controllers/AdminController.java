package com.example.HiddenGemsDBMS.Controllers;

import com.example.HiddenGemsDBMS.DTO.MessageToUserDTO;
import com.example.HiddenGemsDBMS.DTO.MessageToArtisanDTO;
import com.example.HiddenGemsDBMS.Models.*;
import com.example.HiddenGemsDBMS.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ArtisanRepository artisanRepository;
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    ToArtisanMessagesRepository toArtisanMessagesRepository;
//    @Autowired
//    ToUserMessagesRepository toUserMessagesRepository;

    @GetMapping("/admin/users")
    List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/admin/artisans")
    List<Artisans> getAllArtisans(){
        return artisanRepository.findAll();
    }

//    @GetMapping("/admin/messages/users")
//    List<ToUserMessages>getMessageToUser(){
//        return toUserMessagesRepository.findAll();
//    }
//    @GetMapping("/admin/messages/artisans")
//    List<ToArtisanMessages>getMessageToArtisan(){
//        return toArtisanMessagesRepository.findAll();
//    }

//    @GetMapping("/admin/messages/artisans")
//    public List<MessageToArtisanDTO> getMessagesToArtisans() {
//        List<ToArtisanMessages> messages = toArtisanMessagesRepository.findAll();
//        return messages.stream()
//                .map(message -> new MessageToArtisanDTO(
//                        message.getMessage_id(),
//                        message.getArtisan().getArtisan_username(),  // Fetch artisan's username
//                        message.getUser().getUser_username(),       // Fetch user's username
//                        message.getContent(),
//                        message.getTimestamp()))
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/admin/messages/users")
//    public List<MessageToUserDTO> getMessagesToUsers() {
//        List<ToUserMessages> messages = toUserMessagesRepository.findAll();
//        return messages.stream()
//                .map(message -> new MessageToUserDTO(
//                        message.getMessage_id(),
//                        message.getUser().getUser_username(),     // Fetch user's username
//                        message.getArtisan().getArtisan_username(), // Fetch artisan's username
//                        message.getContent(),
//                        message.getTimestamp()))
//                .collect(Collectors.toList());
//    }
    @DeleteMapping("/admin/users/{user_username}")
    ResponseEntity<String>deleteUser(@PathVariable String user_username){
        Optional<Users>userToDelete=userRepository.findById(user_username);
        if(userToDelete.isPresent()&&userToDelete.get().isStatus()){
            userRepository.delete(userToDelete.get());
            return ResponseEntity.ok("User "+userToDelete.get().getFname()+"is successfully deleted");
        }return ResponseEntity.ok("No such User");
    }
    @DeleteMapping("/admin/artisan/{artisan_username}")
    ResponseEntity<String>deleteArtisan(@PathVariable String artisan_username){
        Optional<Artisans>artisanToDelete=artisanRepository.findById(artisan_username);
        if(artisanToDelete.isPresent()&&artisanToDelete.get().isStatus()){
            artisanRepository.delete(artisanToDelete.get());
            return ResponseEntity.ok("User "+artisanToDelete.get().getFname()+"is successfully deleted");
        }return ResponseEntity.ok("No such Artisan");
    }

    @GetMapping("/admin/login/{admin_username}/{password}")
    ResponseEntity<String>loginAdmin(@PathVariable String admin_username,@PathVariable String password){
        Optional<Admin>adminOptional=adminRepository.findById(admin_username);
        if(adminOptional.isPresent()){
            if(adminOptional.get().getPassword().equals(password)){
                return ResponseEntity.ok("Logged in as admin:"+adminOptional.get().getFname());
            }return ResponseEntity.ok("Incorrect Password");
        }
        return ResponseEntity.badRequest().body("No such admin found");
    }
}
