package expression.binary;

import expression.AbstractBinarOper;
import expression.CommonExpression;
import expression.Oper;
import expression.exceptions.CalculationException;
import expression.exceptions.LogArgumentsException;

import java.util.EnumSet;
import java.util.List;

public class CheckedLog extends AbstractBinarOper {
    private static final EnumSet<Oper> firstArgsToAllow = EnumSet.noneOf(Oper.class);
    private static final EnumSet<Oper> secondArgsToAllow = EnumSet.noneOf(Oper.class);

    public CheckedLog(CommonExpression first, CommonExpression second) {
        super(first, second, Oper.LOG);
    }

    public int calculate(int b, int a) {
        if (a <= 1 || b <= 0) {
            throw new LogArgumentsException("");
        }
        int res = 0;
        while(b > 1) {
            if (b < a) {
                break;
            }
            res++;
            b /= a;
        }
        return res
                ;
    }

    public String toMiniString() {
        return super.toMiniString(firstArgsToAllow, secondArgsToAllow);
    }
}