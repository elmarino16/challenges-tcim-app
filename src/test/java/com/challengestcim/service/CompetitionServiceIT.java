package com.challengestcim.service;

import com.challengestcim.ChallengesTcimApp;
import com.challengestcim.domain.Competition;
import com.challengestcim.domain.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ChallengesTcimApp.class)
//@Transactional
public class CompetitionServiceIT {

    @Autowired
    private CompetitionService competitionService;

    private List<Competition> allCompetitions;

    @BeforeEach
    public void init() {}

    @Test
    public void testCreateCompetition() {
        Competition competition = new Competition();
        competition.setName("Challenge des sets");
        competition = competitionService.addCompetition(competition);
        assertThat(competition.getId()).isNotNull();
    }

    @Test
    public void testGetAllCompetitions() {
        int competitionsCount = competitionService.getAllCompetitions().size();
        Competition competition = new Competition();
        competition.setName("Challenge des sets");
        competitionService.addCompetition(competition);
        assertThat(competitionService.getAllCompetitions().size()).isEqualTo(competitionsCount + 1);
    }

    @Test
    public void testEditCompetition() {
        Competition competition = new Competition();
        competition.setName("Challenge des sets");
        competition = competitionService.addCompetition(competition);
        Long id = competition.getId();
        competition.setName("challenges des 64");
        competition = competitionService.editCompetition(competition);

        assertThat(competition.getName()).isEqualTo("challenges des 64");
    }

    @Test
    public void testAddSessionToCompetition() {
        Competition competition = new Competition();
        competition.setName("Challenge des sets");
        Session session = new Session();
        session.setName("Saison Hiver");
        session.setStartDate(LocalDateTime.of(2020, 1, 1, 0, 0).toInstant(ZoneOffset.UTC));
        session.setEndDate(LocalDateTime.of(2020, 4, 0, 0, 0).toInstant(ZoneOffset.UTC));
        competition.addSession(session);
        competition = competitionService.addCompetition(competition);
        assertThat(competition.getId()).isNotNull();
        assertThat(competition.getAllSession()).isNotEmpty();
    }
}
