public class Sepeda extends Kendaraan {
    private boolean isAuto;

    public void jenis()
    {
        boolean isAuto = true;
        if (isAuto == true) {
            System.out.println("Sepeda Otomatis.");
        }
        else {
            System.out.println("Sepeda Kayuh.");
        }
    }
}