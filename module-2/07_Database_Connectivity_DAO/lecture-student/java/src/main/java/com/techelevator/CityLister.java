package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class CityLister {

    public static void main(String[] args) {
        // Datasource
        BasicDataSource usaDataSource = new BasicDataSource();
        usaDataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        usaDataSource.setUsername("postgres");
        usaDataSource.setPassword("postgres1");

        // JDBC template
        JdbcTemplate jdbcTemplate = new JdbcTemplate(usaDataSource);
        // SELECT city_name, population FROM city WHERE state_abbreviation = 'OH';
        SqlRowSet cities = jdbcTemplate.queryForRowSet(
                "SELECT city_name, population FROM city WHERE state_abbreviation = ? ORDER BY population DESC;", "OH");

        // SqlRowSet
        while (cities.next()) {
            String cityName = cities.getString("city_name");
            int population = cities.getInt("population");

            System.out.println("Name: " + cityName + " Population: " + population);
        }

    }
}
