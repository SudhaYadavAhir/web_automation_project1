package com.ramognee.orangehrms.generic;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class RetryListener implements IAnnotationTransformer
{
    @Override
    public void transform(ITestAnnotation annotation, Class aClass, Constructor constructor, Method method) {
        annotation.setRetryAnalyzer(RerunFailedTC.class);
    }
}
