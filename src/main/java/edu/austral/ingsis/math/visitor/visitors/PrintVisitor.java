package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.Value;
import edu.austral.ingsis.math.visitor.visitables.Variable;
import edu.austral.ingsis.math.visitor.visitables.operand.*;

public class PrintVisitor implements Visitor<String>{
    @Override
    public String visitModule(ModuleOperand operand) {
        return "|" + operand.getF1().accept(this) + "|";
    }

    @Override
    public String visitDiv(DivOperand operand) {
        return operand.getF1().accept(this) + " / " + operand.getF2().accept(this);
    }

    @Override
    public String visitMult(MultOperand operand) {
        return operand.getF1().accept(this) + " * " + operand.getF2().accept(this);
    }

    @Override
    public String visitParenthesis(ParenthesisOperand operand) {
        return "(" + operand.getF1().accept(this) + ")";
    }

    @Override
    public String visitPow(PowOperand operand) {
        return operand.getF1().accept(this) + " ^ " + operand.getF2().accept(this);
    }

    @Override
    public String visitSubt(SubtOperand operand) {
        return operand.getF1().accept(this) + " - " + operand.getF2().accept(this);
    }

    @Override
    public String visitSum(SumOperand operand) {
        return operand.getF1().accept(this) + " + " + operand.getF2().accept(this);
    }

    @Override
    public String visitValue(Value operand) {
        double number = operand.getNumber();
        return number%1 == 0 ? "" + (int) number : "" + number;
    }

    @Override
    public String visitVariable(Variable operand) {
        return operand.getSymbol();
    }
}
