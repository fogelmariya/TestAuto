package Homework.Homework2;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 {
    @DataProvider
    public Object[][] dp(){
        return new Object[][]{
                {1, "string1"},
                {2, "string 2"}
        };
    }

    @Test(dataProvider = "dp", groups = {"Regression", "Smoke"})
    public void SmokeRegression3(int i, String s){

        System.out.println("int: " + i + " " + "string: " + s);
    }

    @Test(groups = {"Regression", "Smoke"})
    public void Smoke1(){
        Assert.assertEquals(1 + 5, 6);
    }

    @Test(groups = {"Regression", "Smoke"})
    public void Smoke2(){
        Assert.assertEquals(7 + 3, 10);
    }
}
