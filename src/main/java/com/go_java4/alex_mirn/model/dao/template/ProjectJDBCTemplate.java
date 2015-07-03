package com.go_java4.alex_mirn.model.dao.template;

import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.dao.mapper.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ProjectJDBCTemplate implements Template<Project> {
    private final String CREATE = "INSERT INTO project VALUES (?);";
    private final String GET_BY_ID = "SELECT project_id, project.category_id, category.category_name, " +
            "project_name, project_description, project_total_sum, project_pledged, " +
            "project_days_left, project_history, project_video_link " +
            "FROM project " +
            "NATURAL JOIN category " +
            "WHERE project_id = ?" +
            "ORDER BY project_id;";
    private final String UPDATE = "UPDATE project SET project_name = ? WHERE project_id = ?;";
    private final String DELETE = "DELETE FROM project WHERE project_id = ?;";
    private final String GET_PROJECTS_IN_CATEGORY = "SELECT project_id, project.category_id, " +
            "category.category_name, project_name, project_description, project_total_sum, " +
            "project_pledged, project_days_left, project_history, project_video_link " +
            "FROM project " +
            "NATURAL JOIN category " +
            "WHERE category_id = ?" +
            "ORDER BY project_id;";

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    @Override
    public void create(Project entity) {
        jdbcTemplate.update(CREATE, entity.getName());
    }

    @Override
    public Project getById(Integer id) {
        Object[] args = new Object[] {id};
        return jdbcTemplate.queryForObject(GET_BY_ID, args, new ProjectMapper());
    }

    @Override
    public void update(Project entity) {
        jdbcTemplate.update(UPDATE, entity.getName(), entity.getProjectId());
    }

    @Override
    public void delete(Project entity) {
        jdbcTemplate.update(DELETE, entity.getProjectId());
    }

    public List<Project> getProjectsInCategory(int categoryId) {
        Object[] args = new Object[] {categoryId};
        return jdbcTemplate.query(GET_PROJECTS_IN_CATEGORY, args, new ProjectMapper());
    }

}
