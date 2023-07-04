package demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectOne {


    @Pointcut("execution(* demo.controller.*.*(..))")
    public void point() {

    }

    @Before("point()") // 所有controller包下面的所有方法的所有参数
    public void beforeMethod(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String argsText = jp.getArgs() == null ? "" : Arrays.toString(jp.getArgs());
        System.out.println("【前置增强】the method 【" + methodName + "】 before with " + argsText);
    }

    @After("point()")
    public void after(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String argsText = jp.getArgs() == null ? "" : Arrays.toString(jp.getArgs());
        System.out.println("【后置增强】the method 【" + methodName + "】 after with " + argsText);
    }

    @AfterReturning(value = "point()", returning = "result")
    public void returnResult(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        System.out.println("【返回增强】the method 【" + methodName + "】 return with 【" + result + "】");

    }

    @Around(value = "point()")
    public Object aroundMethod(ProceedingJoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Object result = null;
        try {
            System.out.println("【环绕增强中的--->前置增强】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
            //执行目标方法
            result = jp.proceed();
            System.out.println("【环绕增强中的--->返回增强】：the method 【" + methodName + "】 ends with " + result);
        } catch (Throwable e) {
            result = "error";
            System.out.println("【环绕增强中的--->异常增强】：the method 【" + methodName + "】 occurs exception " + e);
        }
        System.out.println("【环绕增强中的--->后置增强】：-----------------end.----------------------");
        return result;
    }

//    @AfterThrowing(value = "pointcut()", throwing = "e")
//    public void afterThrowing(JoinPoint joinPoint, Exception e) {
//        System.out.printf("%s : %s \n", joinPoint, e.getMessage());
//    }
}
