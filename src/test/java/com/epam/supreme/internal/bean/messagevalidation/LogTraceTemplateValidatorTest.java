package com.epam.supreme.internal.bean.messagevalidation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LogTraceTemplateValidatorTest {

    @InjectMocks
    private LogTraceTemplateValidator validator;

    @Mock
    private TemplateValidator templateValidator;

    @Test
    void shouldCallTemplateValidatorWhenMethodAnnotatedWithLogTrace() throws NoSuchMethodException {
        TestInstance instance = new TestInstance();
        Method method = instance.getClass().getDeclaredMethod("doSomething");

        validator.validate(method);

        verify(templateValidator).checkMessage(method, "Message form LogTrace");
    }

    @Test
    void shouldNotCallTemplateValidatorWhenMethodIsNotAnnotatedWithLogTrace() throws NoSuchMethodException {
        Object instance = new Object();
        Method method = instance.getClass().getDeclaredMethod("toString");

        validator.validate(method);

        verify(templateValidator, never()).checkMessage(any(), anyString());
    }
}