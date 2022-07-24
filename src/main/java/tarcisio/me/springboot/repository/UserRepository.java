package tarcisio.me.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tarcisio.me.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u from User u WHERE u.id > :id")
    public List<User> findAllmoreThan(@Param("id") Long id);

    public List<User> findByIdGreaterThan(Long id);

    public List<User> findByNameIgnoreCase(String name);

}

// 20:18