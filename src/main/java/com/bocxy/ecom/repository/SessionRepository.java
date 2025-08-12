package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session,Long> {
//    void deleteByUsername(String username);

    Session findByUserId(Long userId);
}
