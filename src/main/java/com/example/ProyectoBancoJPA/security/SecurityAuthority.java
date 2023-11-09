package com.example.ProyectoBancoJPA.security;

import com.example.ProyectoBancoJPA.model.Authority;
import org.springframework.security.core.GrantedAuthority;


public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    public SecurityAuthority(Authority authority) {
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
