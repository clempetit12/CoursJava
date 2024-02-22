package com.example.demo_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {

    //com.example.demo_aop.service.*.*()) => la totalité des classes dans le package service avec zero argument
    //com.example.demo_aop.service.*.*(..)) => la totalité des classes dans le package service avec n'importe quel type d'argument
//    @Before("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addAction() {
//        System.out.println("Action executed by Aspect");
//    }

//    @After("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfter() {
//        System.out.println("Action executed after by Aspect");
//    }
//
//    @AfterReturning("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfterReturning() {
//        System.out.println("Action executed afterReturning by Aspect");
//    }
//
//    @AfterThrowing("execution(* com.example.demo_aop.service.*.*(..))")
//    public void addActionAfterThrowing() {
//        System.out.println("Action executed afterThrowing exception by Aspect");
//    }

    @Around("execution(* com.example.demo_aop.service.*.*(..))")
    public void addActionAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {

            //Avant
            System.out.println("Start Around");
            //execute
            //récupérer les arguments
            Object[] args = proceedingJoinPoint.getArgs();
            //Utiliser les arguments de la méthode
            proceedingJoinPoint.proceed();
        }catch (Exception ex) {
            //Après
            System.out.println("Add around");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    @Pointcut("@annotation(CustomAnnotation)")
    public void customAnnotationPointCut(){

    }

    @Before("customAnnotationPointCut()")
    public void methodAspectWithAnnotation() {
        System.out.println("Aspect run before methode with annotation");
    }
}
