package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Unit tests for the Event class
 */
public class EventTest {
	private Event e;
	private Date d;
    private String description = "Sensor open at door";
	
	//NOTE: these tests might fail if time at which line (2) below is executed
	//is different from time that line (1) is executed.  Lines (1) and (2) must
	//run in same millisecond for this test to make sense and pass.
	
	@BeforeEach
	public void runBefore() {
		e = new Event(description);   // (1)
		d = Calendar.getInstance().getTime();   // (2)
	}
	
	@Test
	public void testEvent() {
		assertEquals("Sensor open at door", e.getDescription());
		assertEquals(d, e.getDate());
	}

	@Test
	public void testToString() {
		assertEquals(d.toString() + "\n" + "Sensor open at door", e.toString());
	}

    @Test
    public void testEqualsNull() {
        assertFalse(e.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        assertFalse(e.equals(new ArrayList<Double>()));
    }

    @Test
    public void testHashCode() {
        assertEquals(13 * d.hashCode() + description.hashCode(), e.hashCode());
    }
}
