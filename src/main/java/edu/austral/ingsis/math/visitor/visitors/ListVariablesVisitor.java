package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.visitables.Value;
import edu.austral.ingsis.math.visitor.visitables.Variable;
import edu.austral.ingsis.math.visitor.visitables.operand.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariablesVisitor implements Visitor <List<String>>{

    public ListVariablesVisitor() {

    }

    @Override
    public List<String> visitModule(ModuleOperand operand) {
        return (operand.getF1().accept(this));
    }

    @Override
    public List<String> visitDiv(DivOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitMult(MultOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitParenthesis(ParenthesisOperand operand) {
        return (operand.getF1().accept(this));
    }

    @Override
    public List<String> visitPow(PowOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSubt(SubtOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitSum(SumOperand operand) {
        return Stream.concat(operand.getF1().accept(this).stream(), operand.getF2().accept(this).stream()).collect(Collectors.toList());
    }

    @Override
    public List<String> visitValue(Value operand) {
        return List.of();
    }

    @Override
    public List<String> visitVariable(Variable operand) {
        return List.of(operand.getSymbol());
    }
}
