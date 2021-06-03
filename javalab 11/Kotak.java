public class Kotak extends BangunDatar implements Resizeable
{
		private double panjang;
		private double lebar;

    	Kotak() {
			this(1,1);
		}

		public Kotak(double panjang, double lebar) {
			this.panjang = panjang;
			this.lebar = lebar;
		}

		public double getLuas() {
		  	return panjang * lebar;
		}

		public double getKeliling() {
		  	return 2.0 * (panjang + lebar);
		}

		public abstract void resize();
    }
