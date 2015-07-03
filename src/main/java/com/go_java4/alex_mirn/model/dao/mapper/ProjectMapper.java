package com.go_java4.alex_mirn.model.dao.mapper;

import com.go_java4.alex_mirn.model.entity.Category;
import com.go_java4.alex_mirn.model.entity.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project>{

    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        Project project = new Project();
        project.setProjectId(resultSet.getInt("project_id"));
        project.setCategory(new Category());
        project.setCategory(new Category(i, resultSet.getString("category_name")));
        project.setName(resultSet.getString("project_name"));
        project.setShortDescription(resultSet.getString("project_description"));
        project.setTotalSum(resultSet.getInt("project_total_sum"));
        project.setPledged(resultSet.getInt("project_pledged"));
        project.setDaysLeft(resultSet.getInt("project_days_left"));
        project.setHistory(resultSet.getString("project_history"));
        project.setVideoLink(resultSet.getString("project_video_link"));

        return project;
    }
}
