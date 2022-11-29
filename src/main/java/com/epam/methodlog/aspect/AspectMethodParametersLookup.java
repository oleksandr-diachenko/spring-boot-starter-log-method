package com.epam.methodlog.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class AspectMethodParametersLookup {

    private final AspectMethodLookup aspectMethodLookup;

    public Map<String, Object> lookup(JoinPoint jp) {
        Method method = aspectMethodLookup.lookup(jp);
        Parameter[] parameters = method.getParameters();
        Object[] args = jp.getArgs();
        Map<String, Object> result = new HashMap<>();
        for (int i = 0; i < parameters.length; i++) {
            String name = parameters[i].getName();
            Object value = args[i];
            result.put(name, value);
        }
        return result;
    }
}