package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Value;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operand.*;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Function f = new SumOperand(new Value(1.0),new Value(6.0));
        final List<String> result = f.listVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function f = new DivOperand(new Value(12.0),new Variable("div"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function division = new DivOperand(new Value(9.0),new Variable("x"));
        final Function f = new MultOperand(new ParenthesisOperand(division),new Variable("y"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Function div = new ParenthesisOperand(new DivOperand(new Value(27.0),new Variable("a")));
        Function f = new PowOperand(div,new Variable("b"));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Function exp = new ParenthesisOperand(new DivOperand(new Value(1.0),new Value(2.0)));
        Function f  = new PowOperand(new Variable("z"),exp);
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Function f = new SubtOperand(new ModuleOperand(new Variable("value")),new Value(8.0));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Function subt = new ParenthesisOperand(new SubtOperand(new Value(5.0),new Variable("i")));
        Function f = new MultOperand(subt,new Value(8.0));
        final List<String> result = f.listVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
