package expression.binary;

import expression.AbstractBinarOper;
import expression.CommonExpression;
import expression.Oper;
import expression.binary.CheckedMultiply;
import expression.exceptions.PowArgumentsException;

import java.util.EnumSet;

public class CheckedPow extends AbstractBinarOper {
    private static final EnumSet<Oper> firstArgsToAllow = EnumSet.noneOf(Oper.class);
    private static final EnumSet<Oper> secondArgsToAllow = EnumSet.noneOf(Oper.class);

    public CheckedPow(CommonExpression first, CommonExpression second) {
        super(first, second, Oper.POW);
    }

    public int calculate(int a, int n) {
        if (a == 0 && n == 0 || n < 0) {
            throw new PowArgumentsException("");
        }
        if (a == 0 || a == 1) {
            return a;
        }
        if (a == -1) {
            return (n % 2 == 0) ? 1 : -1;
        }
        int res = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                res = new CheckedMultiply(null, null).calculate(res, a);  // overflow
                n--;
            } else {
                a = new CheckedMultiply(null, null).calculate(a, a);  // overflow
                n /= 2;
            }
        }
        return res;
    }

    public String toMiniString() {
        return super.toMiniString(firstArgsToAllow, secondArgsToAllow);
    }
}