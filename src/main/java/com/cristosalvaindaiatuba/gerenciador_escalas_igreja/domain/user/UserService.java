package com.cristosalvaindaiatuba.gerenciador_escalas_igreja.domain.user;

import com.cristosalvaindaiatuba.gerenciador_escalas_igreja.infra.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
        }
        if(userRepository.existsByUsername(user.getUsername())){
            throw new EmailAlreadyExistsException("Username already exists: " + user.getUsername());
        }

        return userRepository.save(user);
    }
}
