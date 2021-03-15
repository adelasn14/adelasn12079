import java.util.Scanner;

public class kalkulatorsimple {

    public static void main(String[] args) {

    	double a, n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka pertama : ");

        /* Menggunakan tipe data double jadi user
         * bisa memasukkan interger dan juga float
         */

        a = scanner.nextDouble();
        System.out.print("Masukkan angka kedua : ");
        n = scanner.nextDouble();

        System.out.print("Masukkan operator (+, -, *, /) : ");
        char operator = scanner.next().charAt(0);

        scanner.close();
        double output;

        switch(operator)
        {
            case '+':
            	output = a + n;
                break;

            case '-':
            	output = a - n;
                break;

            case '*':
            	output = a * n;
                break;

            case '/':
            	output = a / n;
                break;

            /* Jika user memasukkan operator atau char selain
             * +, -, * dan /, perlihatkan program error ke user
             */
            
            default:
                System.out.printf("Anda telah memasukkan operator yang salah. Program tidak dapat diteruskan.");
                return;
        }

        System.out.println(a+" "+operator+" "+n+": "+output);
    }
}