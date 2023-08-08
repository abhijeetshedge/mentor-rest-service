package com.mentor.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Skill")
public class Skill {
	
	private int skillId;
	private String skill;
	
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skill(int skillId, String skill) {
		super();
		this.skillId = skillId;
		this.skill = skill;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skill=" + skill + "]";
	}
	
	

}
