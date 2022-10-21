package edu.austral.ingsis.math.composite;

import java.util.Map;

public class Value implements Function{

    double value;
    public Value(double value) {
        this.value=value;
    }


    @Override
    public double calculate(Map<String, Double> map) {
        return value;
    }

    @Override
    public String toString() {
        return value % 1 == 0 ? "" + (int) value : "" + value;
    }
}
