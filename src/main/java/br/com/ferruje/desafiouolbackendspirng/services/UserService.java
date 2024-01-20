package br.com.ferruje.desafiouolbackendspirng.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferruje.desafiouolbackendspirng.entities.User;
import br.com.ferruje.desafiouolbackendspirng.entities.DTOs.UserDTO;
import br.com.ferruje.desafiouolbackendspirng.entities.legionModel.Codename;
import br.com.ferruje.desafiouolbackendspirng.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository repo_user;

    @Autowired
    LegionService service_group;
    
    @Transactional
    public User createUser(UserDTO dto) throws Exception {
        Optional<User> usr_optional = repo_user.findByEmailAndLegion(dto.getEmail(), dto.getLegion());
        if (usr_optional.isPresent()) {
            throw new Exception(" Email já existe !");
        }
        User user = new User(dto);
        
        List<Codename> codenames = service_group.getCodenames(user.getLegion());

        for(Codename codename : codenames) {
            if (!isPresentAcodiname(codename.getCodename())){
                user.setCodename(codename.getCodename());;
            }
        }
        return repo_user.save(user);
    }

    public List<User> findAll() {
        return repo_user.findAll();
    }

    public boolean isPresentAcodiname(String codinome) {
        return repo_user.findByCodename(codinome).isPresent();
        
    }

}
