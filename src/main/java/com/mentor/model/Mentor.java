package com.mentor.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "Mentor")
public class Mentor {
	
	@NonNull
	@Indexed(unique=true)
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String jobTitle;
	private String company;
	private Category category;
	private List<Skill> skills;
	private String bio;
	private LocalDateTime createdAt;
	private boolean isActive;
	
	public Mentor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mentor(int employeeId, String firstName, String lastName, String email, String password, String jobTitle,
			String company, Category category, List<Skill> skills, String bio, LocalDateTime createdAt,
			boolean isActive) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.jobTitle = jobTitle;
		this.company = company;
		this.category = category;
		this.skills = skills;
		this.bio = bio;
		this.createdAt = createdAt;
		this.isActive = isActive;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Mentor [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", jobTitle=" + jobTitle + ", company=" + company + ", category="
				+ category + ", skills=" + skills + ", bio=" + bio + ", createdAt=" + createdAt + ", isActive="
				+ isActive + "]";
	}
	
	
	
	
	
	
	
	

}
