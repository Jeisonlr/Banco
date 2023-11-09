package com.example.ProyectoBancoJPA.model;

import com.example.ProyectoBancoJPA.utils.AuthorityName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authorities")
public class Authority {

    public Authority(AuthorityName authorityName){
        this.name=authorityName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;
}
