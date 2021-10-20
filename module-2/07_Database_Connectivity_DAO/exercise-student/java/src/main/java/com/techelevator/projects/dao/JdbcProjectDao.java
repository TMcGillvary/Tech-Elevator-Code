package com.techelevator.projects.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProjectDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Project getProject(Long projectId) {
        Project project = null;

        String projectSql = "SELECT project_id, name, from_date, to_date FROM project"
                + " WHERE project_id = ?";
        SqlRowSet projectsRowSet = this.jdbcTemplate.queryForRowSet(projectSql, projectId);

        if (projectsRowSet.next()) {
            project = mapRowToProject(projectsRowSet);
        }
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<Project>();

        String projectListSql = "SELECT project_id, name, from_date, to_date FROM project;";
        SqlRowSet projectRowSet = this.jdbcTemplate.queryForRowSet(projectListSql);

        while (projectRowSet.next()) {
            projects.add(mapRowToProject(projectRowSet));
        }

        return projects;
    }

    @Override
    public Project createProject(Project newProject) {
        String projectInsertSql = "INSERT INTO project (name, from_date, to_date)" +
                " VALUES (?, ?, ?) RETURNING project_id";
        Long newProjectId = jdbcTemplate.queryForObject(projectInsertSql, Long.class,
                newProject.getName(), newProject.getFromDate(), newProject.getToDate());

        return getProject(newProjectId);
    }

    @Override
    public void deleteProject(Long projectId) {
        String deleteProjectSql1 = "DELETE FROM project_employee WHERE project_id = ?;";
        String deleteProjectSql2 = "DELETE FROM project WHERE project_id = ?;";

        jdbcTemplate.update(deleteProjectSql1, projectId);
        jdbcTemplate.update(deleteProjectSql2, projectId);

    }

    private Project mapRowToProject(SqlRowSet rowSet) {
        Project project = new Project();
        Date projectFromDate = rowSet.getDate("from_date");
        Date projectToDate = rowSet.getDate("to_date");

        project.setId(rowSet.getLong("project_id"));
        project.setName(rowSet.getString("name"));

        if (projectFromDate == null) {
            project.setFromDate(null);
        } else {
            project.setFromDate(projectFromDate.toLocalDate());
        }

        if (projectToDate == null) {
            project.setToDate(null);
        } else {
            project.setToDate(projectToDate.toLocalDate());
        }

        return project;
    }


}
