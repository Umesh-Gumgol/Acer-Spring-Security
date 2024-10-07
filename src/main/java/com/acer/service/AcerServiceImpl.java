package com.acer.service;

import com.acer.entity.AcerUser;
import com.acer.repository.AcerUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
}
