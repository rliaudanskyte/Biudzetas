package part3;

import java.util.ArrayList;

public class Irasas {
    protected static int counter;
    protected int id;
    protected double suma;
    protected String kategorija;
    protected String papildomaInfo;

    @Override
    public String toString(){
        return String.format("Iðlaidø áraðas nr.:%3d | Suma:%10.2f Eur |",
                id,
                suma);
    }

    public String toStringToCsv(){
        return String.format("%d,%.2f",
                id,
                suma);
    }

    public ArrayList<String> toStringToDatabase(){
        var result = new ArrayList<String>();
        result.add(String.valueOf(id));
        result.add(String.valueOf(suma));
        return result;
    }

    public int getId() {
        return id;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }
}
