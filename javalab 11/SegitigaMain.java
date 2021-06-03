public class SegitigaMain extends Segitiga
{
    public static void main(String args[])
    {
        double alas = 5, tinggi = 6, sisi = 4;
        Segitiga segi3 = new Segitiga(alas,tinggi,sisi);
        
        System.out.println("Luas Segitiga : " + segi3.getLuas());
        System.out.println("Keliling Segitiga : " + segi3.getKeliling());
    }
}