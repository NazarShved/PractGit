package seleniumFrameworks;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
    static  String str;
    @Test
    public void tst(){
        System.out.println("Day2 1" +str);
    }

    public void atst2(){
        System.out.println("Day2 2" + str);
    }

    @BeforeTest
    public void bfr(){
        str = "day 2 str";
        System.out.println("Before from day1" + str);
    }

    @BeforeSuite
    public void abfrs(){
        System.out.println("Before suite Day 2");
    }
}
