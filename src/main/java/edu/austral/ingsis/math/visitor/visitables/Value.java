package edu.austral.ingsis.math.visitor.visitables;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Value implements Visitable, Function {

    private final Double number;

    public Value(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitValue(this);
    }
}
