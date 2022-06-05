package com.kodgemisi.usermanagement;

import java.time.Instant;

public class User {

	private Long id;

	private Profile profile;

	/**
	 * Any value less than zero means unknown
	 */
	private int age = -1;

	private boolean verified;

	private Role role;

	private Instant createdAt;

	public User(Long id, Profile profile, int age, boolean verified, Role role, Instant createdAt) {
		this.id = id;
		 setProfile(profile);
		setAge(age);
		this.verified = verified;
		this.role = role;
		this.createdAt = createdAt;
	}

	public boolean isNew() {
		return id == null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVerified() {

		return verified;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	void verify() {
		this.verified = true;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", profile=" + profile + ", age=" + age + ", verified=" + verified + ", role=" + role + ", createdAt="
				+ createdAt + '}';
	}
}
