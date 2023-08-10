package com.mentor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.constants.Constants;
import com.mentor.model.Mentor;
import com.mentor.service.MentorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/mentor")
@Tag(name="Mentor Controller")
public class MentorController {

	@Autowired
	MentorService mentorService;

	@Operation(

			description="This api validates mentor data and registers it in database",
			summary="register mentor to the database",
			responses= {
					@ApiResponse(
							description = "Successfully added",
							responseCode = "201"
							),
					@ApiResponse(
							description = "Duplicate username or email",
							responseCode = "409"
							)
			})
	@PostMapping("/register")
	public ResponseEntity<Object> registerMentor(@RequestBody Mentor mentor){
		try {
			return new ResponseEntity<>(mentorService.registerMentor(mentor), 
					HttpStatus.CREATED);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}


	@Operation(
			description="validates mentors userName and password",
			summary="checks if mentors credentials are valid",
			responses= {
					@ApiResponse(
							description = "Valid User",
							responseCode = "201"
							),
					@ApiResponse(
							description = "Unauthorised User",
							responseCode = "401"
							)
			})
	@GetMapping("/login")
	public ResponseEntity<String> logInMentor(@RequestParam Map<String, String> params ){

		String loginStatus = mentorService.verifyLogInDetails(params);

		if (loginStatus.equals(Constants.valid_User)) {
			return ResponseEntity.ok(loginStatus);

		} else if (loginStatus.equals(Constants.wrong_Password)|| loginStatus.equals(Constants.wrong_Username)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginStatus);

		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(loginStatus);

		}
	}

}
