package test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.demo.entity.User;
import test.demo.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired UserRepository userRepo;

    public List<User> findAll() { return userRepo.findAll(); }
    public Optional<User> findById(String id) { return userRepo.findById(id); }
    public User save(User user) { return userRepo.save(user); }
    public void deleteById(String id) { userRepo.deleteById(id); }
}