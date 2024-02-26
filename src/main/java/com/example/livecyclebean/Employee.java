package com.example.livecyclebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

public class Employee {
    private String name;

    public Employee() {
        System.out.println("Construct");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @PostConstruct
    // required access modifier - private
    private void postConstruct(){
        System.out.println("Invoke post construct method");
    }

    @AroundInvoke
    // required access modifier - private
    private Object before(InvocationContext invocationContext) throws Exception {
        System.out.println("Around invoke method: " + invocationContext.getMethod().getName());
        return invocationContext.proceed();
    }

    public void doJob(){
        System.out.println("do job...");
    }
    public void doJob2(){
        System.out.println("do job2...");

    }
    @PreDestroy
    // required access modifier - private
    private void preDestroy(){
        System.out.println("Invoke pre destroy method");
    }
}
