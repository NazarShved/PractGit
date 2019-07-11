package seleniumFrameworks;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day3 {
    static String str;
    @Test
    public void tst(){
        System.out.println("day3 1" + str);
    }

    @Test
    public void atst2(){
        System.out.println("day3 2" + str);
    }

    @BeforeTest
    public void bfr(){
        str = "day 3 str";
        System.out.println("Before from day1" + str);
    }

    @BeforeSuite
    public void abfrs(){
        System.out.println("Before suite Day 3");
    }
}
