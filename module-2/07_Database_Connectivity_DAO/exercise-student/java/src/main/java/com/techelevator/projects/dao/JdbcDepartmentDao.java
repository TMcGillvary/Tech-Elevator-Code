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
        Department department = new Department();

        String sql = "SELECT department_id, name FROM department WHERE department_id = ?;";
        SqlRowSet departmentRowSet = this.jdbcTemplate.queryForRowSet(sql, id);

        if (departmentRowSet.next()) {
            department.setId(departmentRowSet.getLong("department_id"));
            department.setName(departmentRowSet.getString("name"));
            return department;
        }
        return null;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<Department>();

        String departmentListSql = "SELECT department_id, name FROM department;";
        SqlRowSet departmentRowSet = this.jdbcTemplate.queryForRowSet(departmentListSql);

        while (departmentRowSet.next()) {
            Department department = new Department();
            department.setId(departmentRowSet.getLong("department_id"));
            department.setName(departmentRowSet.getString("name"));
            departments.add(department);
        }

        return departments;
    }

    @Override
    public void updateDepartment(Department updatedDepartment) {
        String deptUpdateSql = "UPDATE department SET name = ? WHERE department_id = ?;";
        jdbcTemplate.update(deptUpdateSql, updatedDepartment.getName(), updatedDepartment.getId());
    }

}
