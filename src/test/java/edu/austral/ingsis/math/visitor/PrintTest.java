package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operand.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Function f = new SumOperand(new Value(1.0),new Value(6.0));
        final String expected = "1 + 6";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final Function f = new DivOperand(new Value(12.0),new Value(2));
        final String expected = "12 / 2";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final Function division = new DivOperand(new Value(9.0),new Value(2.0));
        final Function f = new MultOperand(new ParenthesisOperand(division),new Value(3.0));
        final String expected = "(9 / 2) * 3";
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final Function div = new ParenthesisOperand(new DivOperand(new Value(27.0),new Value(6.0)));
        final Function f = new PowOperand(div,new Value(2.0));
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final Function f = new SubtOperand(new ModuleOperand(new Variable("value")),new Value(8.0));
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        Function f = new SubtOperand(new ModuleOperand(new Variable("value")),new Value(8.0));
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        Function subt = new ParenthesisOperand(new SubtOperand(new Value(5.0),new Variable("i")));
        Function f = new MultOperand(subt,new Value(8.0));
        final String result = f.toString();

        assertThat(result, equalTo(expected));
    }
}
