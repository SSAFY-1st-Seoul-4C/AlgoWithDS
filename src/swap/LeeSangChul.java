package swap;

public class LeeSangChul {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a + ", " + b);
    }
}