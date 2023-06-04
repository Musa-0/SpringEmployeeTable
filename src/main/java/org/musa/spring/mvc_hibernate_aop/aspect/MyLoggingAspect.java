package org.musa.spring.mvc_hibernate_aop.aspect;
//будет делать логирование для всех методов Dao класса

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect//указываем этот класс как аспект класс
public class MyLoggingAspect {
    @Around("execution(* org.musa.spring.mvc_hibernate_aop.dao.*.*(..))")//создаем адвайс для всех классов dao и для
    // всех методов этих классов, с любым возращаемым значением и модификатором доступа, с любым количеством параметров
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//берем данные о вызываемом методе
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();//берем сам метод


        System.out.println("Запуск метода " + methodSignature.getName());//выводим имя метода, который отработал

        Object result = proceedingJoinPoint.proceed();//запускаем сам метод

        System.out.println("Метод " + methodSignature.getName() + " завершился");//выводим что он завершился

        return result;//возвращаем результат

    }
}
