package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;
import edu.austral.ingsis.math.composite.Variable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParenthesisOperand implements Function {

    private final Function f1;

    public ParenthesisOperand(Function f1) {
        this.f1 = f1;
    }

    @Override
    public double calculate(Map<String, Double> map) {
        return f1.calculate(map);
    }

    @Override
    public String toString() {
        return "(" + f1.toString() + ")";
    }

    @Override
    public List<String> listVariables() {
        List<String> toReturn = new ArrayList<>(f1.listVariables());
        return toReturn;
    }
}
