package edu.austral.ingsis.math.visitor.visitables.operand;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.visitables.Visitable;
import edu.austral.ingsis.math.visitor.visitors.Visitor;

public class ModuleOperand implements Function, Visitable {

    private final Function f1;

    public ModuleOperand(Function f1) {
        this.f1 = f1;
    }

    public Function getF1() {
        return f1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visitModule(this);
    }
}
