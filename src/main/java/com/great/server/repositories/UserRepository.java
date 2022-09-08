package com.great.server.repositories;

import com.great.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);

    User findByRg(String rg);
}
