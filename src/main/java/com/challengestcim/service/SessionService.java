package com.challengestcim.service;

import com.challengestcim.domain.Session;
import com.challengestcim.repository.SessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    private final Logger log = LoggerFactory.getLogger(SessionService.class);

    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session addSession(Session session) {
        Session newSession = sessionRepository.save(session);
        return newSession;
    }

}
