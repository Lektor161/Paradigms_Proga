package expression;

import java.util.EnumSet;
import java.util.List;

public abstract class AbstractUnarOper implements CommonExpression {
    protected CommonExpression arg;
    private Oper me;

    public AbstractUnarOper(CommonExpression arg, Oper me) {
        this.arg = arg;
        this.me = me;
    }

    public void setArg(CommonExpression newArg) {
        arg = newArg;
    }

    public CommonExpression getArg() {
        return arg;
    }

    public Oper getOper() {
        return me;
    }

    public String toString() {
        return me +
                arg.toString();
    }

    public String toMiniString() {
        return me +
                arg.toMiniString();
    }

    public abstract int calculate(int a);

    public int evaluate(int x, int y, int z) {
        return calculate(arg.evaluate(x, y, z));
    }

    public String checkString(EnumSet<Oper> allowed) {
        return toMiniString();
    }

    public boolean equals(Object object) {
        if (object != null && object.getClass() == getClass()) {
            AbstractUnarOper exp = (AbstractUnarOper)object;
            return me.equals(exp.getOper()) && arg.equals(exp.getArg());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return toString().hashCode();
    }
}