package com.mentor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mentor.model.Mentor;

public interface MentorRepository extends MongoRepository<Mentor, Integer> {

	Mentor findByEmployeeId(int username);

}
