package br.com.ferruje.desafiouolbackendspirng.entities;

import br.com.ferruje.desafiouolbackendspirng.entities.DTOs.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, email, phoneNumber, codename;

    @Enumerated(EnumType.STRING)
    private UserLegion legion;


    public User(UserDTO dto) {
        this.setName(dto.getName());
        this.setEmail(dto.getEmail());
        this.setPhoneNumber(dto.getPhoneNumber());
        this.setCodename(dto.getCodename());
        this.setLegion(dto.getLegion());
    }

}
