package com.go_java4.alex_mirn.model.entity;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {

	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int projectId;

	@Column(name="project_name")
	private String name;

	@Column(name="project_description")
	private String shortDescription;

	@Column(name="project_total_sum")
	private int totalSum;

	@Column(name="project_pledged")
	private int pledged;

	@Column(name="project_days_left")
	private int daysLeft;

	@Column(name="project_history")
	private String history;

	@Column(name="project_video_link")
	private String videoLink;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

//	@Column(name="project_questions")
//	private String questions;

	public Project() {}

	public Project(int id, Category category, String name, String shortDescription,
			int totalSum, int pledged, int daysLeft) {
		this.projectId = id;
		this.category = category;
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
	}

	public Project(int id, Category category, String name, String shortDescription,
			int totalSum, int pledged, int daysLeft, String history,
			String videoLink) {
		this.projectId = id;
		this.category = category;
		this.name = name;
		this.shortDescription = shortDescription;
		this.totalSum = totalSum;
		this.pledged = pledged;
		this.daysLeft = daysLeft;
		this.history = history;
		this.videoLink = videoLink;
//		this.questions = questions;
	}

	public String fullInfo() {
		return  toString()
				+ "History: " + history + "\n" + "Videolink: " + videoLink
				+ "\n";
//		+ "Answers and questions: " + questions;
	}

	@Override
	public String toString() {
		return "Project number: " + projectId + "\n" + "Project name: " + name
				+ "\n" + "Short Description: " + shortDescription + "\n"
				+ "Total sum needed: " + totalSum + "$" + "\n" + "Pledged: "
				+ totalSum + "$" + "\n" + "Days to go: " + daysLeft + "\n";
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public int getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}

	public int getPledged() {
		return pledged;
	}

	public void setPledged(int pledged) {
		this.pledged = pledged;
	}

	public int getDaysLeft(int project_days_left) {
		return daysLeft;
	}

	public void setDaysLeft(int daysLeft) {
		this.daysLeft = daysLeft;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

//	public String getQuestions() {
//		return questions;
//	}

//	public void setQuestions(String questions) {
//		this.questions = questions;
//	}
}