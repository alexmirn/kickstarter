package com.go_java4.alex_mirn.model.template;

import com.go_java4.alex_mirn.model.dao.DaoTemplate;
import com.go_java4.alex_mirn.model.entity.Project;
import com.go_java4.alex_mirn.model.mapper.ProjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by yalex on 02.07.15.
 */
public class ProjectJDBCTemplate implements DaoTemplate<Project> {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM project;";
        List projects = jdbcTemplate.query(sql, new ProjectMapper());
        return projects;
    }

    public List<Project> getProjectsInCategory(int categoryId) {
//        String sql = "select * FROM project where category_id = ? order by project_id;";
        String sql = "select project_id, project.category_id, category.category_name, " +
                "project_name, project_description, " +
                "project_total_sum, project_pledged, project_days_left, " +
                "project_history, project_video_link " +
                "from project " +
                "natural join category " +
                "where category_id = ?" +
                "order by project_id;";
        Object[] args = new Object[] {categoryId};
        List projects = jdbcTemplate.query(sql, args, new ProjectMapper());
        return projects;
    }

    @Override
    public void create(Project entity) {
        String sql = "INSERT INTO project VALUES (?);";
        jdbcTemplate.update(sql, entity.getName());
        return;
    }

    @Override
    public Project getById(Integer id) {
//        String sql = "SELECT * FROM project WHERE project_id = ?;";
        String sql = "select project_id, project.category_id, category.category_name, " +
                "project_name, project_description, " +
                "project_total_sum, project_pledged, project_days_left, " +
                "project_history, project_video_link " +
                "from project " +
                "natural join category " +
                "where project_id = ?" +
                "order by project_id;";
        Object[] args = new Object[] {id};

        Project project = jdbcTemplate.queryForObject(sql, args, new ProjectMapper());
        return project;
    }

    @Override
    public void update(Project entity) {
        String sql = "UPDATE project SET project_name = ? WHERE project_id = ?;";
        jdbcTemplate.update(sql, entity.getName(), entity.getProjectId());
        return;
    }

    @Override
    public void delete(Project entity) {
        String sql = "DELETE FROM category WHERE category_id = ?;";
        jdbcTemplate.update(sql, entity.getProjectId());
        return;
    }
}
