package com.example.finalproject.Repository;

import com.example.finalproject.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    Session findSessionById(Integer id);

}
