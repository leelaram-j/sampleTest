package com.sample.isInt;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*

Q. Write a method named isNumeric(String s) that returns true if the given string argumet is an integer, otherwise
 returns false and writes teh tests for it. For example, isNumeric("123") should return true

-- implement isNumeric(String S)
-- write test methods (using dataProvider)
-- identify test inputs

*/
public class IsIntCheck
{
    boolean isNumeric(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    @DataProvider(name="validData")
    Object[][] validData()
    {
        return new Object[][]
                {
                        {"423432"},
                        {"0945"},
                        {"-123"}
        };
    }

    @Test(dataProvider = "validData")
    public void isNumericCheck(String input)
    {
        // positive Test
        Assert.assertTrue(isNumeric(input));
    }

    @DataProvider(name="invalidData")
    Object[][] invalidData()
    {
        return new Object[][]
                {
                        {"sdfd4322"},
                        {"oi435"},
                        {""},
                        {null},
                        {"21474836479"},
                        {"123.12"}
                };
    }

    @Test(dataProvider = "invalidData")
    public void isNumericCheck1(String s)
    {
        Assert.assertFalse(isNumeric(s));
    }



}
