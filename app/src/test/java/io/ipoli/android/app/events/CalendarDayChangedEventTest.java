package io.ipoli.android.app.events;

import org.joda.time.LocalDate;
import org.junit.Test;

import io.ipoli.android.app.utils.Time;
import static org.junit.Assert.*;
import static junit.framework.Assert.assertEquals;
/**                                                                                                                                                                                              
 * Created by YZ on 11/7/16.                                                                                                                                                                     
 */
public class CalendarDayChangedEventTest {
    @Test
    public void testConstructor() {

    LocalDate date = new LocalDate();
    Time time = null;
    CalendarDayChangedEvent.Source source = CalendarDayChangedEvent.Source.CALENDAR;
    CalendarDayChangedEvent e1 = new CalendarDayChangedEvent(date, source);
    CalendarDayChangedEvent e2 = new CalendarDayChangedEvent(date, time, source);

    assertEquals(date,e1.date);
    assertEquals(CalendarDayChangedEvent.Source.CALENDAR, e1.source);

    assertEquals(date, e2.date);
    assertNull(e2.time);
    assertEquals(CalendarDayChangedEvent.Source.CALENDAR, e2.source);



    }




}
