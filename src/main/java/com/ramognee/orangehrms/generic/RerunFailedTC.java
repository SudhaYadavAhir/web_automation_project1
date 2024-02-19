package com.ramognee.orangehrms.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTC implements IRetryAnalyzer
{
    int retryCount = 0;
    int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {

        if(retryCount<maxRetryCount)
        {
            retryCount++;
            return true;
        }
        return false;
    }

}
