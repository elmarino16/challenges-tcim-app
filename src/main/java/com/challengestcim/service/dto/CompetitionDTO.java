package com.challengestcim.service.dto;

import com.challengestcim.domain.Competition;

import javax.persistence.*;
import javax.validation.constraints.Size;

public class CompetitionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompetitionDTO(Competition competition) {
        this.id = competition.getId();
        this.name = competition.getName();
    }

    public CompetitionDTO() {
    }
}
