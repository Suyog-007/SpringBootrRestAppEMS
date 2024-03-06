package org.shah.springapp.ems.Domains;

import jakarta.persistence.*;
import lombok.Data;
import org.shah.springapp.ems.Services.SkillConvertor;

import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "demands")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_id")
    private String ProjectId;

    @Column(name = "project_name")
    private String ProjectName;

    @Column(name = "manager_name")
    private String MangerName;

    @Column(name = "position_level")
    private String level;

    @Column(name = "city")
    private String city;

    @Convert(converter= SkillConvertor.class)
    private Map<String,Integer> Skills = new HashMap<>();

    public void setSkills(Map<String, Integer> skills) {
        Skills = skills;
    }

    @Column(name = "status")
    private String Status;

    @Column(name = "duration")
    private double Duration;

    @Column(name = "start_date")
    private  String StartDate;

    // getters and setters


}
