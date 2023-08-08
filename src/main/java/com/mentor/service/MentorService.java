package com.mentor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.model.Mentor;
import com.mentor.repository.MentorRepository;

@Service
public class MentorService {
	
	@Autowired
	MentorRepository mentorRepository;
	
	public Mentor registerMentor(Mentor mentor) {
		
		return mentorRepository.save(mentor);
//		return "Mentor registered successfully";
	}


}
