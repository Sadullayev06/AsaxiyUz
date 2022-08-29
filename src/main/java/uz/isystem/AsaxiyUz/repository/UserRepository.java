package uz.isystem.AsaxiyUz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.AsaxiyUz.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
