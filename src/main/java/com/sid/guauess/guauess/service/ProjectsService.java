package com.sid.guauess.guauess.service;

import com.sid.guauess.guauess.model.Projects;
import com.sid.guauess.guauess.repository.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService extends AbstractService<Projects, Long> {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    protected JpaRepository<Projects, Long> getRepository() {
        return projectsRepository;
    }

}
