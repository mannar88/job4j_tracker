package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CountingAFunctionInARangeTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountingAFunctionInARange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenLinearFunctionThenQuad() {
        List<Double> result = CountingAFunctionInARange.diapason(5, 8, x -> 1*(x*x) +2 *x +1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFunctionThen() {
        List<Double> result = CountingAFunctionInARange.diapason(1, 3, x ->  2 * Math.pow(2, x));
        List<Double> expected = Arrays.asList( 4D, 8D);
        assertThat(result, is(expected));
    }


}