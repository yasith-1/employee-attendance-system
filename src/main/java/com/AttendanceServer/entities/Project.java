package com.AttendanceServer.entities;

import com.AttendanceServer.dto.ProjectDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

// 01 t krnee meka
@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String duration;

    private Date startDate;

    @OneToMany
    private List<User> users;


    public ProjectDTO getDto() {
        ProjectDTO dto = new ProjectDTO();

        dto.setId(id);
        dto.setName(name);
        dto.setDuration(duration);
        dto.setStartDate(startDate);

        return dto;
    }

}
