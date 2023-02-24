package com.epam.supreme.utils.formatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MapWithoutBracketsStringFormatterTest {

    @InjectMocks
    private MapWithoutBracketsStringFormatter<Integer, String> formatter;

    @Test
    void shouldFormatStringMapToString() {
        String result = formatter.format(Map.of(1, "One"));

        assertThat(result).isEqualTo("1=One");
    }

    @Test
    void shouldReturnEmptyStringWhenMapIsEmpty() {
        String result = formatter.format(Map.of());

        assertThat(result).isEmpty();
    }
}