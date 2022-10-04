package StepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static Utilities.DriverFactory.cleanupDriver;
import static Utilities.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setup(){
        getDriver();
    }

    @After
    public void tearDown(){
        cleanupDriver();
    }
}
