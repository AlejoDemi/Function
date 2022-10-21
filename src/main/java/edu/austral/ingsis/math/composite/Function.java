package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {

    String toString();

    double calculate(Map<String, Double> map);

    List<String> listVariables();
}
