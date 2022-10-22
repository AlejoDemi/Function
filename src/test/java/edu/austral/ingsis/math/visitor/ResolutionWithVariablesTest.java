package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operand.*;
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
        Function f = new SumOperand(new Value(1.0),new Variable("x"));
        final Double result = f.calculate(Map.of("x",3.0));

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
        Function div = new ParenthesisOperand(new DivOperand(new Value(27.0),new Variable("a")));
        Function f = new PowOperand(div,new Variable("b"));
        final Double result = f.calculate(Map.of("a",9.0,"b",3.0));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Function exp = new ParenthesisOperand(new DivOperand(new Value(1.0),new Value(2.0)));
        Function f  = new PowOperand(new Variable("z"),exp);
        final Double result = f.calculate(Map.of("z",36.0));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Function f = new SubtOperand(new ModuleOperand(new Variable("value")),new Value(8.0));
        final Double result = f.calculate(Map.of("value",8.0));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Function subt = new ParenthesisOperand(new SubtOperand(new Value(5.0),new Variable("i")));
        Function f = new MultOperand(subt,new Value(8.0));
        final Double result = f.calculate(Map.of("i",2.0));

        assertThat(result, equalTo(24d));
    }
}
