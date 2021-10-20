package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDepartmentDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Department getDepartment(Long id) {
        Department department = null;

        String sql = "SELECT department_id, name FROM department WHERE department_id = ?;";
        SqlRowSet departmentRowSet = this.jdbcTemplate.queryForRowSet(sql, id);

        if (departmentRowSet.next()) {
            department = mapRowToDepartment(departmentRowSet);
        }
        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<Department>();

        String departmentListSql = "SELECT department_id, name FROM department;";
        SqlRowSet departmentRowSet = this.jdbcTemplate.queryForRowSet(departmentListSql);

        while (departmentRowSet.next()) {
            departments.add(mapRowToDepartment(departmentRowSet));
        }

        return departments;
    }

    @Override
    public void updateDepartment(Department updatedDepartment) {
        String deptUpdateSql = "UPDATE department SET name = ? WHERE department_id = ?;";
        jdbcTemplate.update(deptUpdateSql, updatedDepartment.getName(), updatedDepartment.getId());
    }

    private Department mapRowToDepartment(SqlRowSet rowSet) {
        Department department = new Department();
        department.setId(rowSet.getLong("department_id"));
        department.setName(rowSet.getString("name"));
        return department;
    }

}
