public class Segitiga extends BangunDatar{
	private double alas;
	private double tinggi;
	private double sisi;

	Segitiga() {
		this(1,1,1);
	}

	public Segitiga(double alas, double tinggi,double sisi) {
		this.alas = alas;
		this.tinggi = tinggi;
		this.sisi = sisi;
	}

	public double getLuas() {
		return (alas * tinggi)/2;
	}

	public double getKeliling() {
		return 3.0 * sisi;
	}
}
