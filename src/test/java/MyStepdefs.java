package test.java;

import org.junit.Assert;

public class MyStepdefs {
    int result;
    @io.cucumber.java.en.Given("^I have a calculator$")
    public void iHaveACalculator() {
    }

    @io.cucumber.java.en.When("^I add (\\d+) and (\\d+)$")
    public void iAddAnd(int arg0, int arg1) {
        result =arg0+arg1;
    }

    @io.cucumber.java.en.Then("^The result should be (\\d+)$")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(arg0,result);
    }
}
