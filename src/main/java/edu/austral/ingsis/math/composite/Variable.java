package edu.austral.ingsis.math.composite;

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


    public String toString(){
        return symbol;
    }
}
