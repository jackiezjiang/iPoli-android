package io.ipoli.android.app.services.readers;

import android.text.TextUtils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.ipoli.android.Constants;
import io.ipoli.android.app.utils.Time;
import io.ipoli.android.quest.data.Quest;
import io.ipoli.android.quest.data.SourceMapping;
import io.ipoli.android.quest.persistence.QuestPersistenceService;
import io.ipoli.android.quest.persistence.RepeatingQuestPersistenceService;
import me.everything.providers.android.calendar.Event;

/**
 * Created by Venelin Valkov <venelin@curiousily.com>
 * on 5/11/16.
 */
public class AndroidCalendarQuestListPersistenceService implements AndroidCalendarListPersistenceService<Quest> {

    @Inject
    QuestPersistenceService questPersistenceService;

    @Inject
    RepeatingQuestPersistenceService repeatingQuestPersistenceService;

    @Override
    public void save(List<Event> events) {
        for (Event e : events) {
            if (e.allDay || e.deleted) {
                continue;
            }
            Quest q = new Quest(e.title);
            questPersistenceService.findByExternalSourceMappingId(Constants.EXTERNAL_SOURCE_ANDROID_CALENDAR, String.valueOf(e.id), foundQuest -> {
                if (foundQuest != null) {
                    q.setId(foundQuest.getId());
                    q.setCreatedAt(foundQuest.getCreatedAt());
                }
                DateTimeZone timeZone = DateTimeZone.getDefault();
                if (!TextUtils.isEmpty(e.eventTimeZone)) {
                    timeZone = DateTimeZone.forID(e.eventTimeZone);
                }
                DateTime startDateTime = new DateTime(e.dTStart, timeZone);
                DateTime endDateTime = new DateTime(e.dTend, timeZone);
                q.setAllDay(e.allDay);
                q.setDuration(Minutes.minutesBetween(startDateTime, endDateTime).getMinutes());
                q.setStartMinute(startDateTime.getMinuteOfDay());
                q.setStartDateFromLocal(startDateTime.toLocalDate().toDate());
                q.setEndDateFromLocal(endDateTime.toLocalDate().toDate());
                q.setSource(Constants.SOURCE_ANDROID_CALENDAR);
                q.setSourceMapping(SourceMapping.fromGoogleCalendar(e.id));

                if (endDateTime.toLocalDate().isBefore(new LocalDate())) {
                    q.setCompletedAt(new Date(e.dTend));
                    q.setCompletedAtMinute(Time.of(q.getCompletedAt()).toMinutesAfterMidnight());
                }
                if (TextUtils.isEmpty(e.originalId)) {
                    questPersistenceService.save(q);
                    return;
                }
                repeatingQuestPersistenceService.findByExternalSourceMappingId(Constants.EXTERNAL_SOURCE_ANDROID_CALENDAR, e.originalId, rq -> {
                    q.setRepeatingQuest(rq);
                    q.setRepeatingQuestId(rq.getId());
                    questPersistenceService.save(q);
                });
            });
        }
    }

}
