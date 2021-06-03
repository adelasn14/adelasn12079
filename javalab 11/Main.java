public class Main extends Kotak
{
    public static void main(String args[])
    {
        double panjang = 4, lebar = 5;
        Kotak segi4 = new Kotak(panjang,lebar);
        
        System.out.println("Luas kotak : " + segi4.getLuas());
        System.out.println("Keliling kotak : " + segi4.getKeliling());

        double panjang = 8, lebar = 10;
        Kotak segi42 = new Kotak(panjang,lebar);
        
        System.out.println("Luas kotak 2x : " + segi42.getLuas());
        System.out.println("Keliling kotak 2x : " + segi42.getKeliling());
    }
}