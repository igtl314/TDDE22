package Lab3;

public class tentaTvång {

    public static void main(String[] args) {
        int input = 15;
        for (int i = 1; i < input + 1; i++) {
            rectMaker(i);
            System.out.println();
        }

    }

    public static void rectMaker(int n) {
        rectHor(n);
        rectVer(n);
        rectHor(n);
    }


    public static void rectHor(int n) {
        System.out.print("+");
        for (int i = 0; i < (2 * n); i++) {
            System.out.print("-");
        }
        System.out.print("+");

    }

    public static void rectVer(int n) {
       for (int ii = 0; ii < n; ii++) {
           System.out.print("\n|");
           for (int i = 0; i < (2 * n); i++) {
               System.out.print(" ");
           }
           System.out.print("|");
       }
        System.out.println();
    }

}