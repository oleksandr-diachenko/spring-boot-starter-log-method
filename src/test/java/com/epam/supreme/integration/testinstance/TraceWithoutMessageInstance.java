package com.epam.supreme.integration.testinstance;

import com.epam.supreme.annotation.LogTrace;
import org.springframework.stereotype.Component;

@Component
public class TraceWithoutMessageInstance extends AbstractInstance {

    @LogTrace
    @Override
    public void print(int a, int b) {
        super.print(a, b);
    }

    @LogTrace
    @Override
    public int getExchangeRate() {
        return super.getExchangeRate();
    }

    @LogTrace
    @Override
    public int sum(int a, int b) {
        return super.sum(a, b);
    }
}
