package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Variable implements Function {

    private final String symbol;

    public Variable(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public double calculate(Map<String, Double> map) {
        return map.get(symbol);
    }

    @Override
    public List<String> listVariables() {
        return List.of(symbol);
    }


    public String toString(){
        return symbol;
    }
}
