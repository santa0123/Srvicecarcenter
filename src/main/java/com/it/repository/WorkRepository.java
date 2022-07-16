package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.WorkEntity;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Integer> {

}
