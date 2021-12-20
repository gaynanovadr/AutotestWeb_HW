package Lesson4;

public class Function {

    public static boolean correctValues(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;
    }

    public static boolean existenceOfTriangle(int a, int b, int c) {
        return (((a + b) > c) && ((b + c) > a) && ((a + c) > b));
    }

    public static int triangleSquare(int a, int b, int c) {
        int p;
        p = (a + b + c) / 2;
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
