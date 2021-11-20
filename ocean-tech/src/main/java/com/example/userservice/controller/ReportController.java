package com.example.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.Report;
import com.example.userservice.repository.ReportRepository;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportRepository reportRepository;

	@GetMapping()
	public List<Report> get() {

		return this.reportRepository.findAll();

	}

	@GetMapping("/{id}")

	public ResponseEntity<Report> getById(@PathVariable String id) {

		Optional<Report> report = this.reportRepository.findById(id);

		if (!report.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(report.get(), HttpStatus.OK);

	}

	@PostMapping()
	public ResponseEntity<Report> post(@RequestBody Report report) {

		Report reportCreated = this.reportRepository.save(report);
		return new ResponseEntity<Report>(reportCreated, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Report> put(@PathVariable String id, @RequestBody Report report) {

		Optional<Report> reportUpdated = this.reportRepository.findById(id);

		if (!reportUpdated.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		reportUpdated.get().setSeriesDescription(report.getSeriesDescription());

		this.reportRepository.save(reportUpdated.get());

		return new ResponseEntity<Report>(reportUpdated.get(), HttpStatus.OK);

	}

}
