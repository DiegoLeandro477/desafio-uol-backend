package br.com.ferruje.desafiouolbackendspirng.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferruje.desafiouolbackendspirng.entities.User;
import br.com.ferruje.desafiouolbackendspirng.entities.UserLegion;




public interface UserRepository extends JpaRepository<User, Long> {    

    public Optional<User> findByEmail(String email);
    
    public Optional<User> findByEmailAndLegion(String email, UserLegion legion);

    public Optional<User> findByCodename(String codename);
}