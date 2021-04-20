import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class palindrome 
{
    public static void main(String[] args) 
    {
        String kata, string;
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan sebuah string : ");
        string = in.nextLine();
        kata = string.toLowerCase();
        kata = string.replaceAll(" ","");
        kata = string.replaceAll("\\W","");
 
        Queue<Character> queue = new LinkedList<>();
 
        for (int i = kata.length()-1; i >=0; i--)
        {
            queue.add(kata.charAt(i));
        }
 
        String kataBalik = "";
 
        // Pop semua karakter string satu demi satu dan buat string terbalik
        while (!queue.isEmpty())
        {
            kataBalik = kataBalik + queue.remove();
        }
 
        // Cek apakah string palindrome
        if (kata.equals(kataBalik))
        {
            System.out.println("String ini adalah sebuah palindrome.");
        }
        
        else 
        {
            System.out.println("String bukan sebuah palindrome.");
        }
    }
}
