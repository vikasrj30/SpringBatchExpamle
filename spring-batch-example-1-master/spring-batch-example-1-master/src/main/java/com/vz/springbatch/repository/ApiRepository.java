package com.vz.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.springbatch.model.Api;

public interface ApiRepository extends JpaRepository<Api, Integer> {

}
