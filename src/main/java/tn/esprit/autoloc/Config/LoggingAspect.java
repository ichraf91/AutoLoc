package tn.esprit.autoloc.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
//    @After("execution(* tn.esprit.autoloc.Services.VehiculeServiceImpl.*(..))")
//    public void logMethodEntry(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        log.info("In method " + " : "+ name );
//    }
//    @Around("execution(* tn.esprit.autoloc.Services.VehiculeServiceImpl.afficherVehicules(..))")
//    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object obj = pjp.proceed();
//        long elapsedTime = System.currentTimeMillis() - start;
//        log.info("Method execution time: " + elapsedTime + " milliseconds.");
//        return obj;
//    }
}
