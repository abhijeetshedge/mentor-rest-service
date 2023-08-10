package com.mentor.service;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mentor.config.SecurityConfig;
import com.mentor.constants.Constants;
import com.mentor.model.Mentor;
import com.mentor.repository.MentorRepository;

@Service
public class MentorService {
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Autowired
	SecurityConfig securityConfig;
	
	public Mentor registerMentor(Mentor mentor) {
		
		String encryptedPassword = securityConfig.encryptPassword(mentor.getPassword());
		mentor.setPassword(encryptedPassword);
		
		mentor.setActive(true);
		
		mentor.setCreatedAt(LocalDateTime.now());
		
		return mentorRepository.save(mentor);
		
//		return "Mentor registered successfully";
	}
	
	public String verifyLogInDetails(Map<String,String> credentials) {
		
		int username = Integer.parseInt(credentials.get(Constants.username));
		String password = credentials.get(Constants.password);
		
		Mentor mentor= mentorRepository.findByEmployeeId(username);
		
		if(mentor != null) {
			if(securityConfig.matchPassword(password, mentor.getPassword())){
				return Constants.valid_User;
			}else {
				return Constants.wrong_Password;
			}
		}
		else {
			return Constants.wrong_Username;
		}
		
	}
	
	public String encryptPassword(String password) {
		
		 BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		 return bcrypt.encode(password);
	}
	
	
	
	
	
	
	


}
