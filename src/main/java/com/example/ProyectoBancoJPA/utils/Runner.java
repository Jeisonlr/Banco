package com.example.ProyectoBancoJPA.utils;

import com.example.ProyectoBancoJPA.model.Authority;
import com.example.ProyectoBancoJPA.model.User;
import com.example.ProyectoBancoJPA.repository.AuthorityRepository;
import com.example.ProyectoBancoJPA.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private  final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;


    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(this.authorityRepository.count() == 0){
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }
        if (this.userRepository.count() == 0){
            var encoders= PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                    new User("user01","password1",List.of(this.authorityRepository.findByName(AuthorityName.READ).get())),
                    new User("user02","password2",List.of(this.authorityRepository.findByName(AuthorityName.WRITE).get())),
                    new User("nicolas", encoders.encode("nicolas1125"), List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get()))

                    )
            );
        }
    }
}
