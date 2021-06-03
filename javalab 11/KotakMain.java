public class KotakMain extends Kotak
{
    public static void main(String args[])
    {
        double panjang = 3, lebar = 4;
        Kotak segi4 = new Kotak(panjang,lebar);
        
        System.out.println("Luas kotak : " + segi4.getLuas());
        System.out.println("Keliling kotak : " + segi4.getKeliling());

    }
}