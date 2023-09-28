package com.cafe.management.system.repository;

import com.cafe.management.system.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
      User findByEmail(String email);

//      User findByUsername(String username);

      Boolean existsByEmail(String email);

      User findByNameOrEmail(String name, String email);

//      boolean existsByUsername(String username);

      List<User> findAll(Sort sort);

      Page<User> findAll(Pageable pageable);

      @Query("SELECT p FROM User p WHERE " +
              "p.name LIKE CONCAT('%',:query, '%')")
      List<User> searchUsers(String query);

}
