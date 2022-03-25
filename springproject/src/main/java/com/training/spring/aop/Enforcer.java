package com.training.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Enforcer {

    @Around("@annotation(deltaParam)")
    public Object aroundEx(final ProceedingJoinPoint jp,
                           final Delta deltaParam) {
        try {
            long delta = System.currentTimeMillis();
            Object proceedLoc = jp.proceed();
            System.out.println("Method : " + jp.getSignature() + " delta : " + (System.currentTimeMillis() - delta));
            return proceedLoc;
        } catch (Throwable eLoc) {
            return null;
        }
    }

    @Around("execution(* com.training.spring.aop.SecondBean.*(..))")
    public Object around(final ProceedingJoinPoint jp) {
        System.out.println("////////////////00000000/////////////////");
        try {
            System.out.println("Method Call : " + jp.getSignature() + " args : " + jp.getArgs()[0]);
            String inputLoc = (String) jp.getArgs()[0];
            Object[] objnew = new Object[1];
            objnew[0] = inputLoc + " input değişti";
            long delta = System.currentTimeMillis();
            String proceedLoc = (String) jp.proceed(objnew);
            System.out.println("Delta : " + (System.currentTimeMillis() - delta));
            return proceedLoc + " intercepted";
        } catch (Throwable eLoc) {
            return null;
        }
    }

    //    @Before("execution(* com.training.spring.aop.SecondBean.*(..)) && args(str)")
    //    public void before(final JoinPoint jp,
    //                       final String str) {
    //        System.out.println("////////////////00000000/////////////////");
    //        System.out.println("Second bean çağrılıyor : " + str + " jp : " + jp.toLongString());
    //    }
    //
    //    @After("execution(* com.training.spring.aop.SecondBean.*(..)) && args(str)")
    //    public void after(final JoinPoint jp,
    //                      final String str) {
    //        System.out.println("////////////////11111111/////////////////");
    //        System.out.println("Second bean çağrıldı : " + str + " jp : " + jp.toLongString());
    //    }
    //
    //    @AfterReturning(value = "execution(* com.training.spring.aop.SecondBean.*(..)) && args(str)", returning = "retVal")
    //    public void after(final JoinPoint jp,
    //                      final String str,
    //                      final String retVal) {
    //        System.out.println("////////////////11111111/////////////////");
    //        System.out.println("Second bean afterReturning  : "
    //                           + str
    //                           + " retVal : "
    //                           + retVal
    //                           + " jp : "
    //                           + jp.toLongString());
    //    }


}
