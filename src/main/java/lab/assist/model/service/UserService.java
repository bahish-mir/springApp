package lab.assist.model.service;

import lab.assist.model.entity.User;
import lab.assist.model.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserById(int id) {
        return userRepo.findUserById(id);
    }

    public User getUser(String login, String password) {
        return userRepo.findUserByLoginAndPassword(login, password);
    }

    public User createUser(String login, String password) {
        return userRepo.createUser(login, password);
    }
}
