package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.Value;
import edu.austral.ingsis.math.visitor.visitables.Variable;
import edu.austral.ingsis.math.visitor.visitables.operand.*;

import java.util.Map;

public class CalculateVisitor implements Visitor<Double>{

    private final Map<String,Double> values;

    public CalculateVisitor(Map<String, Double> values) {
        this.values = values;
    }

    @Override
    public Double visitModule(ModuleOperand operand) {
        return Math.abs(operand.getF1().accept(this));
    }

    @Override
    public Double visitDiv(DivOperand operand) {
        return operand.getF1().accept(this) / operand.getF2().accept(this);
    }

    @Override
    public Double visitMult(MultOperand operand) {
        return operand.getF1().accept(this) * operand.getF2().accept(this);
    }

    @Override
    public Double visitParenthesis(ParenthesisOperand operand) {
        return operand.getF1().accept(this);
    }

    @Override
    public Double visitPow(PowOperand operand) {
        return Math.pow(operand.getF1().accept(this),operand.getF2().accept(this));
    }

    @Override
    public Double visitSubt(SubtOperand operand) {
        return operand.getF1().accept(this) - operand.getF2().accept(this);
    }

    @Override
    public Double visitSum(SumOperand operand) {
        return operand.getF1().accept(this) + operand.getF2().accept(this);
    }

    @Override
    public Double visitValue(Value operand) {
        return operand.getNumber();
    }

    @Override
    public Double visitVariable(Variable operand) {
        return values.get(operand.getSymbol());
    }
}
