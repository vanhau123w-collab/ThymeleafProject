package test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> { }