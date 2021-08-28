import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (a, b) -> {
        if (a == b) {
            return a;
        }

        long temp = a;

        int i = 1;

        for (; a + i <= b; i++) {
            temp *= a + i;
        }

        return temp;
    };
}