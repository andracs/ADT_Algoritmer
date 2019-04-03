import java.util.*;

public class Main {


    public static void main(String[] args) {

        //sayHello();
        //sayHelloRecursive(1);
        int resultat =  fakultetRekursivt(8000);
        System.out.println("Resultat = " + resultat);

        int gentagelser = 20;
        for (int i = 0; i < gentagelser; i++) {
            System.out.print(fibonacciRekursivt(i) + " ");
        }

    }

    private static void sayHello() {
        System.out.println("Hello World!");

    }

    private static void sayHelloRecursive(int i) {
        System.out.println("Hello Recursion World!" + i);
        if (i<100) {sayHelloRecursive(++i);}
    }

    private static int fakultetRekursivt(int n) {
        if (n == 1) { return 1; }
        else { return fakultetRekursivt(n-1) + n; }
    }


    private static int fibonacciRekursivt(int n) {
        String returnString = "";
        if (n == 0) {  return  0; }
        else if (n == 1) {  return 1; }
        else {
            int tal = fibonacciRekursivt(n-1) + fibonacciRekursivt(n-2);
            return tal;
        }
    }

}
