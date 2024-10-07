package com.acer.service;

import com.acer.dto.LoginDto;
import com.acer.entity.AcerUser;
import com.acer.repository.AcerUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class AcerServiceImpl {


    private  AcerUserRepository acerUserRepository;


    public AcerServiceImpl(AcerUserRepository acerUserRepository) {
        this.acerUserRepository = acerUserRepository;
    }

    public AcerUser createAcerPost( AcerUser acerUser){

        String hashpw = BCrypt.hashpw(acerUser.getPassword(), BCrypt.gensalt(10));
        acerUser.setPassword(hashpw);
        return acerUserRepository.save(acerUser);
    }

    public boolean verifyLogin(LoginDto loginDto) {
        Optional<AcerUser> username = acerUserRepository.findByUsername(loginDto.getUsername());

        if(username.isPresent()){
            AcerUser user = username.get();
            boolean checkpw = BCrypt.checkpw(loginDto.getPassword(),user.getPassword() );
            return checkpw;
        }
        return false;
    }
}
