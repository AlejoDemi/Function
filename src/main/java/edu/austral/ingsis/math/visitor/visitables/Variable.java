package edu.austral.ingsis.math.visitor.visitables;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class Variable implements Function,Visitable {

    private final String symbol;

    public Variable(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitVariable(this);
    }
}
