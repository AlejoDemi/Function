package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.visitables.Value;
import edu.austral.ingsis.math.visitor.visitables.operand.*;
import edu.austral.ingsis.math.visitor.visitors.CalculateVisitor;
import edu.austral.ingsis.math.visitor.visitors.Visitor;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    final Visitor<Double> visitor=new CalculateVisitor(Map.of());

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Function f = new SumOperand(new Value(1.0),new Value(6.0));

        final Double result = f.accept(visitor);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function f = new DivOperand(new Value(12.0),new Value(2.0));

        final Double result =f.accept(visitor);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function division = new DivOperand(new Value(9.0),new Value(2.0));
        final Function f = new MultOperand(new ParenthesisOperand(division),new Value(3.0));
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Function div = new ParenthesisOperand(new DivOperand(new Value(27.0),new Value(6.0)));
        Function f = new PowOperand(div,new Value(2.0));
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Function div = new ParenthesisOperand(new DivOperand(new Value(1.0),new Value(2.0)));
        Function f = new PowOperand(new Value(36.0),div);
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Function f = new ModuleOperand(new Value(136.0));
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Function f = new ModuleOperand(new Value(-136.0));
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Function subt = new ParenthesisOperand(new SubtOperand(new Value(5.0),new Value(5.0)));
        Function f = new MultOperand(subt,new Value(8.0));
        final Double result =f.accept(visitor);

        assertThat(result, equalTo(0d));
    }
}
