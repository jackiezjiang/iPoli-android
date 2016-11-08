package io.ipoli.android.app.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.flurry.android.FlurryAgent;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import io.ipoli.android.AnalyticsConstants;
import io.ipoli.android.BuildConfig;
import io.ipoli.android.Constants;
import io.ipoli.android.app.services.AnalyticsService;
import io.ipoli.android.app.services.FlurryAnalyticsService;
import io.ipoli.android.app.utils.LocalStorage;

import static com.flurry.android.FlurryAgent.init;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Created by YZ on 11/7/16.
 */

@RunWith(PowerMockRunner.class)

@PrepareForTest({TextUtils.class, FlurryAgent.class})



public class AnalyticsModuleTest {
    @Mock
    LocalStorage mockStorage;


    @Mock
    Context context;


    @Before
    public void setUp() {
        initMocks(this);
        mockStatic(TextUtils.class);
        PowerMockito.mockStatic(FlurryAgent.class);


            PowerMockito.when(TextUtils.isEmpty(any(CharSequence.class))).thenAnswer(new Answer<Boolean>() {

                public Boolean answer(InvocationOnMock invocation) throws Throwable {
                    CharSequence a = (CharSequence) invocation.getArguments()[0];
                    return !(a != null && a.length() > 0);
                }
            });






    }

    @Test
    public void testModule() {

        OngoingStubbing<String> player_id = when(mockStorage.readString(Constants.KEY_PLAYER_ID)).thenReturn("PLAYER_ID");


        AnalyticsModule ana = new AnalyticsModule();


        asserteNotNull(ana.provideAnalyticsService(context, mockStorage));







    }

}
