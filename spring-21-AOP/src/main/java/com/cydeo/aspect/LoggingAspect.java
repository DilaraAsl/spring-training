package com.cydeo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//Logging is the process of tracking all the events that happen after a piece of code is run.
//A logging framework can be used to perform all the tasks like setting log file destinations, customizing log messages , etc.
//Spring Boot comes with SLF4J inbuilt, which is an abstraction of all these logging frameworks.
// SLF4J stands for Simple Logging Façade for Java.
// It allows users to work with any of the logging frameworks with a single dependency.
@Aspect
@Component
public class LoggingAspect {
    Logger logger= LoggerFactory.getLogger(LoggingAspect.class); //
//    The getLogger is a method of Logger Factory class that takes a string value as a name
//    and provides the logger object of the specified name .

    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))") // pointcut can be used for any CourseController method
    // is an expression language of Spring AOP that matches JoinPoints
    // A pointcut is a predicate that allows match advice to be used by an aspect at a particular JoinPoint.
    public void myPointCut(){}

    @Before("myPointCut()")
    public void log(){
        logger.info("Info log..."); // executes and displays the message on the console before the controller method is called
    }

    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))") // accepts one parameter with any type
    public void courseRepositoryFindByIdPC(){}

    @Before("courseRepositoryFindByIdPC()")
    public void beforeCourseRepositoryFindById(JoinPoint joinPoint){ // injecting a JoinPoint object
        logger.info("Before-> Method: {}, Arguments {}, Target: {}", joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
// JoinPoint is an AspectJ interface that provides reflective access to the state available at a given join point,such as method parameters, return value, or thrown exception
        //curly braces will be filled in the following order getSignature(), getArgs(), getTarget()
        // place @LoggingAnnotation to CourseController
    }
    @Pointcut("within(com.cydeo.controller..*)")
    public void anyControllerOperation(){}
    @Pointcut("@within(org.springframework.stereotype.Service)") // classes which have service annotation
    public void anyServiceOperation(){};
    @Before("anyControllerOperation()||anyServiceOperation()")
    public void beforeControllerOrServiceAdvice(JoinPoint joinPoint){
        logger.info("Before->Method: {}, Arguments {}, Target: {}", joinPoint.getSignature(),joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void anyDeleteControllerOperation(){}
    @Before("anyDeleteControllerOperation()")
    public void beforeDeleteOperation(JoinPoint joinPoint){
        logger.info("Before->Method: {}, Arguments: {}, Target: {}", joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
    public void loggingAnnotationPC(){}

    @Before("loggingAnnotationPC()")
    public void beforeLoggingAnnotationPC(JoinPoint joinPoint){
        logger.info("Before->Method: {}, Arguments: {}, Target: {}", joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());

    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping")
    public void afterReturningGetMappingAnnotation(){}

    @AfterReturning(pointcut="afterReturningGetMappingAnnotation()",returning="result")
    public void afterReturningGetMappingOperation(JoinPoint joinPoint,Object result){
        logger.info("Before->Method: {}, Arguments: {}, Target: {}", joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget(), result.toString());

    }


    @Around("loggingAnnotationPC()")
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before -> Method: {} - Parameter  {}",proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object result=null;

        try{
            result=proceedingJoinPoint.proceed();
        }
        catch(Throwable throwable){
            throwable.printStackTrace();
        }
        logger.info("After-> Method: {}-Result:{}",proceedingJoinPoint.getSignature().toShortString(),result.toString());
        return result;

    }
}
