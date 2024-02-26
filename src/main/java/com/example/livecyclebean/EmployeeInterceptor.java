package com.example.livecyclebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class EmployeeInterceptor {
    @AroundConstruct
    private Object aroundConstruct(InvocationContext invocationContext) throws Exception {
        System.out.println("Before construct...");
        return invocationContext.proceed();
    }
    @PostConstruct
    // required signature
    void afterConstruct(InvocationContext invocationContext) throws Exception {
        System.out.println("After construct...");
        invocationContext.proceed();
    }
    @AroundInvoke
    private Object beforeInvoke(InvocationContext invocationContext) throws Exception {
        System.out.println("Before methods invoke...");
        return invocationContext.proceed();
    }
    @PreDestroy
    private void beforeDestroy(){
        System.out.println("Before destroy...");
    }

}
