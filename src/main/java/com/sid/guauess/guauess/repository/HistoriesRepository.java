package com.sid.guauess.guauess.repository;

import com.sid.guauess.guauess.model.Histories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriesRepository extends JpaRepository<Histories, Long> {

}
