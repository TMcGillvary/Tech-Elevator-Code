package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        // Arrange already done via spring and set up method

        // Act
        Park park = sut.getPark(1); // filled in from above

        // Assert that park ID equals 1
        // use helper method from below and expected is the static final above that we know is correct
        assertParksMatch(PARK_1, park);

    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        // Arrange already done

        // Act
        // give fake value
        Park park = sut.getPark(-1);

        // assert that park returns null
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        // Act
        List<Park> parks = sut.getParksByState("AA");
        // should be 2 parks in this state
        Assert.assertEquals(2, parks.size());
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_3, parks.get(1));

        // repeat for 2nd state

    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parks = sut.getParksByState("XX");
        // should be 2 parks in this state
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        // Arrange by creating park
        Park expected = new Park(4, "Park 4", LocalDate.parse("2021-10-21"), 100.0, true);

        // Act
        Park actual = sut.createPark(expected);

        // Assert
        assertParksMatch(expected, actual);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Park expected = new Park(4, "Park 4", LocalDate.parse("2021-10-21"), 100.0, true);
        sut.createPark(expected);
        Park actual = sut.getPark(expected.getParkId()); // or getPark(4) since we know it's 4

        assertParksMatch(expected, actual);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park updatedPark = new Park(1, "Daveville", LocalDate.parse("2021-10-21"), 100.1, true);
        sut.updatePark(updatedPark);
        Park actual = sut.getPark(1);

        assertParksMatch(updatedPark, actual);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deletePark(1);
        Park actual = sut.getPark(1);
        Assert.assertNull(actual);
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.addParkToState(2, "AA");

        List<Park> parks = sut.getParksByState("AA");

        boolean foundId = false;
        for (Park park : parks) {
            if (park.getParkId() == 2) {
                foundId = true;
            }
        }

        Assert.assertTrue("getParksByState did not return 2", foundId);

        // could also call park size and do add and then assert new size + 1
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
