package org.example;
import org.example.Utilisateur;

public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
         this.userRepository = userRepository;
    }
    public Utilisateur  getUserByID(long id){
         return userRepository.findUserByID(id);
    }
}
