package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;

import java.util.Map;

public class SubtOperand implements Function{

    private final Function f1;
    private final Function f2;


    public SubtOperand(Function f1, Function f2) {
        this.f1 = f1;
        this.f2 = f2;

    }
    public String toString(){
        return f1.toString() +" - "+f2.toString();
    }

    @Override
    public double calculate(Map<String, Double> map) {
        return f1.calculate(map)-f2.calculate(map);
    }
}