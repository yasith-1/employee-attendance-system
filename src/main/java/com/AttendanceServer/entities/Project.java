package com.AttendanceServer.entities;

import com.AttendanceServer.dto.ProjectDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

// 01 t krnee meka
@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String duration;

    private Date startDate;


    public ProjectDTO getDto(){
        ProjectDTO dto = new ProjectDTO();

        dto.setId(id);
        dto.setName(name);
        dto.setDuration(duration);
        dto.setStartDate(startDate);

        return dto;
    }

}
