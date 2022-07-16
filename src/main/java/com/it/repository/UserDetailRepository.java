package com.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entity.UserDetailEntity;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Integer> {



}
