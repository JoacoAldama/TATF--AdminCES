package com.tatf.tests.Base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static IBrowser browser;
    protected static final String URL = "http://cestore.ces.com.uy/adminces/";

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
        browser.interaction().navigateTo(URL);
        browser.find().css("input[type='password']").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }
}