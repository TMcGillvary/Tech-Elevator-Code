package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();

        String employeeListSql = "SELECT employee_id, department_id, " +
                "first_name, last_name, birth_date, hire_date FROM employee";
        SqlRowSet employeeRowSet = this.jdbcTemplate.queryForRowSet(employeeListSql);

        while (employeeRowSet.next()) {
            employees.add(mapRowToEmployee(employeeRowSet));
        }
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
        List<Employee> employees = new ArrayList<Employee>();

        if (firstNameSearch != null && lastNameSearch != null) {
            String employeeNameSearchSql = "SELECT employee_id, department_id, "
                    + " first_name, last_name, birth_date, hire_date FROM employee "
                    + " WHERE first_name ILIKE concat('%', ?, '%') AND last_name ILIKE concat('%', ?, '%') ;";
            SqlRowSet employeeNames = this.jdbcTemplate.queryForRowSet(employeeNameSearchSql, firstNameSearch, lastNameSearch);

            while (employeeNames.next()) {
                employees.add(mapRowToEmployee(employeeNames));
            }
            return employees;

        }
        return null;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(Long projectId) {
        List<Employee> employees = new ArrayList<Employee>();

        String employeeProjectIdSql = "SELECT employee.employee_id, employee.department_id,"
                + " employee.first_name, employee.last_name, employee.birth_date, employee.hire_date"
                + " FROM employee JOIN project_employee AS pe ON employee.employee_id = pe.employee_id"
                + " WHERE project_id = ?;";
        SqlRowSet rowSet = this.jdbcTemplate.queryForRowSet(employeeProjectIdSql, projectId);

        while (rowSet.next()) {
            employees.add(mapRowToEmployee(rowSet));
        }
        return employees;
    }

    @Override
    public void addEmployeeToProject(Long projectId, Long employeeId) {
        String employeeInsertProjectSQL = "INSERT INTO project_employee (project_id, employee_id)"
                + " VALUES (?, ?)";
        jdbcTemplate.update(employeeInsertProjectSQL, projectId, employeeId);
    }

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
        String deleteEmployeeFromProject = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
        jdbcTemplate.update(deleteEmployeeFromProject, projectId, employeeId);
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        List<Employee> employees = new ArrayList<Employee>();

        String employeeListSql = "SELECT employee.employee_id, employee.department_id, "
                + " employee.first_name, employee.last_name, employee.birth_date, employee.hire_date"
                + " FROM employee"
                + " LEFT JOIN project_employee AS pe ON employee.employee_id = pe.employee_id"
                + " WHERE pe.employee_id IS NULL";
        SqlRowSet employeeRowSet = this.jdbcTemplate.queryForRowSet(employeeListSql);

        while (employeeRowSet.next()) {
            employees.add(mapRowToEmployee(employeeRowSet));
        }
        return employees;
    }


    private Employee mapRowToEmployee(SqlRowSet rowSet) {
        Employee employee = new Employee();
        employee.setId(rowSet.getLong("employee_id"));
        employee.setDepartmentId(rowSet.getLong("department_id"));
        employee.setFirstName(rowSet.getString("first_name"));
        employee.setLastName(rowSet.getString("last_name"));
        employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
        employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
        return employee;
    }


}
