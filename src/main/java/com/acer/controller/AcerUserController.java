package com.acer.controller;

import com.acer.entity.AcerUser;
import com.acer.exception.AcerException;
import com.acer.repository.AcerUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/vol1/user")

public class AcerUserController {

    private AcerUserRepository acerUserRepository;

    public AcerUserController(AcerUserRepository acerUserRepository) {
        this.acerUserRepository = acerUserRepository;
    }

    //http://localhost:8080/api/vol1/user/post
    @PostMapping("/post")
    public ResponseEntity<AcerUser> createAcerPost(@RequestBody AcerUser acerUser){
        Optional<AcerUser> email = acerUserRepository.findByEmail(acerUser.getEmail());
        if(email.isPresent()){
            throw new AcerException("email is already exist");

        }
        Optional<AcerUser> username = acerUserRepository.findByUsername(acerUser.getUsername());
       if(username.isPresent()){
           throw new AcerException("username already exists ");

       }
        AcerUser saved = acerUserRepository.save(acerUser);
       return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
}
