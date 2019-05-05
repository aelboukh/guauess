package com.sid.guauess.guauess.service;

import com.sid.guauess.guauess.model.Histories;
import com.sid.guauess.guauess.repository.HistoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoriesService extends AbstractService<Histories, Long> {

    @Autowired
    private HistoriesRepository historiesRepository;

    @Override
    protected JpaRepository<Histories, Long> getRepository() {
        return historiesRepository;
    }

}
