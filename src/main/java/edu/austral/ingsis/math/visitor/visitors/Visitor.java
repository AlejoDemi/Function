package edu.austral.ingsis.math.visitor.visitors;



import edu.austral.ingsis.math.visitor.visitables.Value;
import edu.austral.ingsis.math.visitor.visitables.Variable;
import edu.austral.ingsis.math.visitor.visitables.operand.*;

public interface Visitor<T> {
    T visitModule(ModuleOperand operand);
    T visitDiv(DivOperand operand);
    T visitMult(MultOperand operand);
    T visitParenthesis(ParenthesisOperand operand);
    T visitPow(PowOperand operand);
    T visitSubt(SubtOperand operand);
    T visitSum(SumOperand operand);
    T visitValue(Value operand);
    T visitVariable(Variable operand);

}
