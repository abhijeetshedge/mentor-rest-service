package com.mentor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.model.Mentor;
import com.mentor.service.MentorService;

@RestController
@RequestMapping("/api/v1/mentor")
public class mentorController {
	
	@Autowired
	MentorService mentorService;
	
	@PostMapping("/register")
	public ResponseEntity<Mentor> registerMentor(@RequestBody Mentor mentor){
		return new ResponseEntity<Mentor>
		(mentorService.registerMentor(mentor), HttpStatus.CREATED);
	}

}
