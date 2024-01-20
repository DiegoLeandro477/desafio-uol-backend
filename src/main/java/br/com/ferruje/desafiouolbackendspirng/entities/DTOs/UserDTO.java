package br.com.ferruje.desafiouolbackendspirng.entities.DTOs;

import br.com.ferruje.desafiouolbackendspirng.entities.User;
import lombok.Getter;
import lombok.Setter;

public class UserDTO extends User {
    @Getter
    @Setter
    private String codename;
}
