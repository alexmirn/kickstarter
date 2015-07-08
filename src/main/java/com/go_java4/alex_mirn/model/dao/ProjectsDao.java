package com.go_java4.alex_mirn.model.dao;

import java.util.List;

import com.go_java4.alex_mirn.model.entity.Project;

public interface ProjectsDao extends Dao<Project> {
	List<Project> getProjectsInCategory(int index);
//	List<Project> getProjectsInCategory(Category category);
}
