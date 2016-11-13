
public class QuickAddActivityInstrumentTest extends ActivityInstrumentationTestCase2<QuickAddActivity> {
    private QuickAddActivity quickAddActivity;
    private Instrumentation mInstrumentation;

    public QuickAddActivityInstrumentTest() {
        super(QuickAddActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        setActivityInitialTouchMode(true);
        mInstrumentation = getInstrumentation();
        super.setUp();
        quickAddActivity = getActivity();


         Button button=  (Button) quickAddActivity.findViewById(R.id.cancel);


    }

    public void testCancel() {
        pressImeActionButton();

    }




}
