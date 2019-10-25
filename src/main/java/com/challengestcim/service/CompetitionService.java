package com.challengestcim.service;

import com.challengestcim.domain.Competition;
import com.challengestcim.repository.CompetitionRepository;
import com.challengestcim.service.dto.CompetitionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompetitionService {

    private final Logger log = LoggerFactory.getLogger(CompetitionService.class);

    private CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition addCompetition(Competition competition) {
        Competition newCompetition = competitionRepository.save(competition);
        return newCompetition;
    }

    public Competition editCompetition(Competition competition) {
        Competition updatedCompetition = competitionRepository.save(competition);
        return updatedCompetition;
    }

    public List<Competition> getAllCompetitions() {
        List<Competition> competitions = competitionRepository.findAll();
        return competitions;
    }

}
