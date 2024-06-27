package com.fc;

public class Register {
	String playername, age, city, position, profile;

	public Register(String playername, String age, String city, String position, String profile) {
		super();
		this.playername = playername;
		this.age = age;
		this.city = city;
		this.position = position;
		this.profile = profile;
	}

	public String getPlayername() {
		return playername;
	}

	public String getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public String getPosition() {
		return position;
	}

	public String getProfile() {
		return profile;
	}    

}
