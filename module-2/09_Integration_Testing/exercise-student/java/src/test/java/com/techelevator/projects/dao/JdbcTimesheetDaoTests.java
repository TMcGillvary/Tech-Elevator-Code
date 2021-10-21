package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet fakeTimesheet;


    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        fakeTimesheet = new Timesheet(5L, 1L, 1L, LocalDate.parse("2021-10-21"), 1.0, true, "Timesheet 5");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        // Arrange already done via spring and set up method

        // Act
        Timesheet timesheet = sut.getTimesheet(1L);

        // Assert
        assertTimesheetsMatch(TIMESHEET_1, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        // Arrange already done via spring and set up method

        // Act
        Timesheet actual = sut.getTimesheet(-1L);

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        // Arrange already done

        // Act
        List<Timesheet> timesheetList = sut.getTimesheetsByEmployeeId(1L);
        // should be 2 timesheets for 1L
        Assert.assertEquals(2, timesheetList.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheetList.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheetList.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        // Arrange already done

        // Act
        List<Timesheet> timesheetList = sut.getTimesheetsByProjectId(1L);
        // should be 3 timesheets assigned to project 1
        Assert.assertEquals(3, timesheetList.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheetList.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheetList.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheetList.get(2));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        // Arrange done in setup() with fake timesheet

        // Act
        Timesheet actual = sut.createTimesheet(fakeTimesheet);

        assertTimesheetsMatch(fakeTimesheet, actual);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        // Arrange done in setup() with fake timesheet

        // Act
        Timesheet expected = sut.createTimesheet(fakeTimesheet);
        Timesheet actual = sut.getTimesheet(expected.getTimesheetId());

        // Assert
        assertTimesheetsMatch(expected, actual);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        // Arrange
        Timesheet expected = new Timesheet(4L, 2L, 2L,
                LocalDate.parse("2021-10-31"), 5.0, true, "Timesheet 4.5");

        // Act
        sut.updateTimesheet(expected);
        Timesheet actual = sut.getTimesheet(4L);

        // Assert
        assertTimesheetsMatch(expected, actual);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        // Arrange done via setup()

        // Act
        sut.deleteTimesheet(5L);
        Timesheet actual = sut.getTimesheet(5L);

        // Assert
        Assert.assertNull(actual);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        // Arrange already done via setup

        // Act
        double actual1 = sut.getBillableHours(1L, 1L);
        double actual2 = sut.getBillableHours(2L, 2L);

        // Assert
        Assert.assertEquals(2.5, actual1, 0.001);
        Assert.assertEquals(0L, actual2, 0.001);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
