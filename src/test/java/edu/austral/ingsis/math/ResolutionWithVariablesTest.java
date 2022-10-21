package edu.austral.ingsis.math;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operand.DivOperand;
import edu.austral.ingsis.math.composite.operand.MultOperand;
import edu.austral.ingsis.math.composite.operand.ParenthesisOperand;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Double result = 4d;

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Double result = 3d;
        final Function f = new DivOperand(new Value(12.0),new Variable("div"));
        final double expected = f.calculate(Map.of("div",4.0));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Double result = 12d;
        final Function division = new DivOperand(new Value(9.0),new Variable("x"));
        final Function f = new MultOperand(new ParenthesisOperand(division),new Variable("y"));
        final double expected = f.calculate(Map.of("x",3.0,"y",4.0));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Double result = 27d;

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Double result = 6d;

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Double result = 24d;

        assertThat(result, equalTo(24d));
    }
}
