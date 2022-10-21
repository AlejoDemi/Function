package edu.austral.ingsis.math.composite.operand;

import edu.austral.ingsis.math.composite.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModuleOperand implements  Function{

    private final Function f1;


    public ModuleOperand(Function f1) {
        this.f1 = f1;
    }

    @Override
    public double calculate(Map<String, Double> map) {
        return Math.abs(f1.calculate(map));
    }

    public String toString(){
        return "|"+f1.toString()+"|";
    }

    @Override
    public List<String> listVariables() {
        return new ArrayList<>(f1.listVariables());
    }
}
