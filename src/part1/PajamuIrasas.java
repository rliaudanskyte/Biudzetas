package part1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PajamuIrasas {
    private int suma;
    private LocalDate data;
    private String kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PajamuIrasas(){
        this.suma = 1000;
        this.data = LocalDate.parse("2022-12-25", dateFormater);
        this.kategorija = "dovana";
        this.pozymisArIBanka = true;
        this.papildomaInfo = "bonusas";
    };
    public PajamuIrasas(int suma,String data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.suma = suma;
        this.data = LocalDate.parse(data, dateFormater);
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString(){
        return String.format("Pajamø áraðas%n|Suma:%15d Eur |Data: %20s |Kategorija: %15s " +
                "|Pajamos á bankà: %b |Papildoma informacija: %s",
                suma,
                data.format(dateFormater),
                kategorija,
                pozymisArIBanka,
                papildomaInfo
        );
    }
    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    public DateTimeFormatter getDateFormater() {
        return dateFormater;
    }

    public void setDateFormater(DateTimeFormatter dateFormater) {
        this.dateFormater = dateFormater;
    }
}
