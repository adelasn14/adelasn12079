public abstract class BangunDatar {
    private int sisi;
    private double luas;
    private double keliling;
	
    BangunDatar() {}

	public BangunDatar(int sisi)
    {
        this.sisi = sisi;
    }

    public int getJumlahSisi()
    {
        return sisi;
    }
    
    public double getLuas()
    {
        return luas;
    }

    public void setLuas(int luas)
    {
        this.luas = luas;
    }

    public double getKeliling()
    {
        return keliling;
    }

    public void setKeliling(int keliling)
    {
        this.keliling = keliling;
    }
}