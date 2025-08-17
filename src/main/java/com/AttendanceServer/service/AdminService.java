package com.AttendanceServer.service;

import com.AttendanceServer.dto.UserDTO;
import com.AttendanceServer.entities.Project;
import com.AttendanceServer.entities.User;
import com.AttendanceServer.repository.ProjectRepository;
import com.AttendanceServer.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public UserDTO createUser(UserDTO dto) {
        boolean isExist = userRepository.findByEmail(dto.getEmail()).isPresent();
        if (isExist) {
            throw new EntityExistsException("User already exists with this email");
        } else {
            Optional<Project> project = projectRepository.findById(dto.getProjectId());
            if (!project.isEmpty()) {
                User user = new User();
                user.setUserRole(dto.getUserRole());
                user.setEmail(dto.getEmail());
                user.setPassword(dto.getPassword());
                user.setProject(project.get());
                user.setName(dto.getName());

                User userCreated = userRepository.save(user);
                return userCreated.getDto();

            }
        }
        throw new EntityExistsException("Project not found with this id");
    }
}
