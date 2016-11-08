package io.ipoli.android.app.events;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YZ on 11/7/16.
 */
public class CalendarPermissionResponseEventTest {
    @Test
    public void testConstructor() {

        CalendarPermissionResponseEvent.Response response1 = CalendarPermissionResponseEvent.Response.GRANTED;
        CalendarPermissionResponseEvent.Response response2 = CalendarPermissionResponseEvent.Response.DENIED;

        EventSource source1 =  EventSource.CALENDAR;
        EventSource source2 =  EventSource.ADD_REWARD;
        CalendarPermissionResponseEvent e1 = new CalendarPermissionResponseEvent(response1, source1);
        CalendarPermissionResponseEvent e2 = new CalendarPermissionResponseEvent(response2, source2);

        assertEquals(CalendarPermissionResponseEvent.Response.GRANTED, e1.response);
        assertEquals(EventSource.CALENDAR, e1.source);

        assertEquals(CalendarPermissionResponseEvent.Response.DENIED, e2.response);
        assertEquals(EventSource.ADD_REWARD, e2.source);


    }
}
