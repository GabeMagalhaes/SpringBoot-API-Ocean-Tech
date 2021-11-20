package com.example.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userservice.model.Report;

public interface ReportRepository extends MongoRepository<Report, String> {
	
}
