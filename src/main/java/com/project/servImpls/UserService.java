package com.project.servImpls;

import com.project.model.User;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserByUsername(String email){
        return userRepository.getUserByUsername(email);
    }

    public void addUser(User user){
        user.getRoles().add(roleRepository.getRoleByName("USER"));
        userRepository.save(user);
    }
    public List<User> listAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }
}
