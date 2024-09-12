package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.Session;
import com.example.finalproject.Repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public void addSession(Session session) {
        sessionRepository.save(session);
    }

    public Session updateSession(Integer id, Session session) {
        Session s = sessionRepository.findSessionById(id);
        if(session == null) {
            throw new ApiException("Session not found");
        }
        s.setPrice(session.getPrice());
        s.setDate(session.getDate());
        s.setLearningMethod(session.getLearningMethod());
        s.setDuration(session.getDuration());
        return sessionRepository.save(s);
    }

    public void deleteSession(Integer id) {
        Session s = sessionRepository.findSessionById(id);
        if(s == null) {
            throw new ApiException("Session not found");
        }
        sessionRepository.deleteById(id);
    }

    //assign session to tutor
    // cancel session
    // block a student
    // max number of students
    // min price of session
    // start a session



}
