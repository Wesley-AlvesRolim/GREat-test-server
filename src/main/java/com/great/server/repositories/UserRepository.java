package com.great.server.repositories;

import com.great.server.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);

    User findByRg(String rg);

    // @Modifying
    // @Transactional
    // @Query(value = "DELETE FROM users user WHERE user.cpf = ?1")
    void deleteByCpf(String cpf);

    // @Modifying
    // @Transactional
    // @Query(value = "DELETE FROM users user WHERE user.rg = ?1")
    void deleteByRg(String rg);
}
