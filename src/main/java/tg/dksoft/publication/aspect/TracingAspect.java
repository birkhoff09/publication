/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tg.dksoft.publication.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Birkhoff
 */
@Component
@Aspect
public class TracingAspect {
    
    Logger logger = LoggerFactory.getLogger(getClass());

//    @Before("execution(* tg.dksoft.publication.service.*.*(..))")
//    public void entering(JoinPoint joinPoint) {
//        logger.trace("Entering method - " + joinPoint.getStaticPart().getSignature().getName() + "");
//        for (Object arg : joinPoint.getArgs()) {
//            logger.trace("arg : " + arg);
//        }
//    }
//
//    @After("execution(* tg.dksoft.publication.service.*.*(..))")
//    public void exiting(JoinPoint joinPoint) {
//        logger.trace("Exiting method - " + joinPoint.getStaticPart().getSignature().getName() + "");
//    }
//    @AfterThrowing(pointcut = "execution(* tg.dksoft.publication.service.*.*(..))", throwing = "runtimeException")
//    public void logException(JoinPoint joinPoint, RuntimeException runtimeException) {
//        logger.error("Method {} throws exception {} ", joinPoint.getStaticPart().getSignature().getName(), runtimeException.getMessage());
//    }
//
//    @AfterReturning(pointcut = "execution(* tg.dksoft.publication.service.*.*(..))", returning = "returns")
//    public void logResult(JoinPoint joinPoint, String returns) {
//        logger.error("Method {} finished execution. Returns value {} ", joinPoint.getStaticPart().getSignature().getName(), returns);
//    }
    @Around("execution(* tg.dksoft.publication.service.*.*(..))")
    public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.trace("Entering method - " + proceedingJoinPoint.getStaticPart().getSignature().getName() + "");
        try {
            for (Object arg : proceedingJoinPoint.getArgs()) {
                logger.trace("Method {} is called with theses params :{}", proceedingJoinPoint.getStaticPart().getSignature().getName(), arg.toString());
            }
            return proceedingJoinPoint.proceed();
        } catch (Throwable ex) {
            logger.error("Method {} throws exception {} ", proceedingJoinPoint.getStaticPart().getSignature().getName(), ex.getMessage());
            throw ex;
        } finally {
            logger.trace("Exiting method - " + proceedingJoinPoint.getStaticPart().getSignature().getName() + "");
        }
    }
}
