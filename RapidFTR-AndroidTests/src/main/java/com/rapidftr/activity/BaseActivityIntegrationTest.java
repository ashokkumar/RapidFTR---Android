package com.rapidftr.activity;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;
import com.rapidftr.activity.pages.LoginPage;
import com.rapidftr.activity.pages.RegisterChildPage;
import com.rapidftr.activity.pages.ViewAllChildrenPage;

public abstract class BaseActivityIntegrationTest<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

    public Solo solo;
    public LoginPage loginPage;
    public RegisterChildPage registerChildPage;
    public ViewAllChildrenPage viewAllChildrenPage;

    public BaseActivityIntegrationTest(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
        loginPage = new LoginPage(solo);
        registerChildPage = new RegisterChildPage(solo);
        viewAllChildrenPage = new ViewAllChildrenPage(solo);
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
