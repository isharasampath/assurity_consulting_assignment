package com.assurity.assignment.framework.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class TestBase {

    protected SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void beforeClassParent() {

    }

    @AfterClass
    public void afterClassParent() {

    }
}
