package com.example.userservice.model;

// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Report {

	private String id;

	private String goal;
	
	private String target;
	
	private String indicator;
	
	private String seriesCode;
	
	private String seriesDescription;
	
	private String geoArea;
	
	private String timePeriod;
	
	private String value;
	
}
