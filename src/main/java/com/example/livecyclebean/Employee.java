package com.example.livecyclebean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.ExcludeClassInterceptors;
import jakarta.interceptor.Interceptors;
import jakarta.interceptor.InvocationContext;


@Interceptors(EmployeeInterceptor.class)
@RequestScoped
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

//    @Interceptors(EmployeeInterceptor.class)
    public void doJob(){
        System.out.println("do job...");
    }
    @ExcludeClassInterceptors
    // interceptors don't work before this method
    public void doJob2(){
        System.out.println("do job2...");

    }

}
