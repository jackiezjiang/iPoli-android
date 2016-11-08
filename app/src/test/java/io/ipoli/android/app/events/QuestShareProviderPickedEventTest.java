package io.ipoli.android.app.events;

import org.junit.Test;

import io.ipoli.android.quest.data.Quest;

import static org.junit.Assert.*;

/**
 * Created by YZ on 11/7/16.
 */
public class QuestShareProviderPickedEventTest {
    @Test
    public void testConstructor() {


        Quest quest = new Quest();


        QuestShareProviderPickedEvent event = new QuestShareProviderPickedEvent("TEST", quest);

        assertEquals("TEST", event.provider);
        assertEquals(quest, event.quest);




    }



}
