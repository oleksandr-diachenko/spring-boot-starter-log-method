package com.epam.supreme.internal.bean.messagevalidation;

import com.epam.supreme.annotation.LogError;
import com.epam.supreme.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@RequiredArgsConstructor
public class LogErrorTemplateValidator implements Validator<Method> {

    private final TemplateValidator templateValidator;

    @Override
    public void validate(Method method) {
        if (method.isAnnotationPresent(LogError.class)) {
            LogError annotation = method.getAnnotation(LogError.class);
            templateValidator.checkMessage(method, annotation.message());
        }
    }
}
