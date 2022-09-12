package part1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PajamuIrasas {
    private static int counter;
    private int id;
    private double suma;
    private LocalDate data;
    private String kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PajamuIrasas(){
        this.id = counter++;
        this.suma = 1000;
        this.data = LocalDate.parse("2022-12-25", dateFormater);
        this.kategorija = "dovana";
        this.pozymisArIBanka = true;
        this.papildomaInfo = "bonusas";
    };
    public PajamuIrasas(double suma,String data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.id = counter++;
        this.suma = suma;
        this.data = LocalDate.parse(data, dateFormater);
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString(){
        return String.format("Pajamø áraðas nr.:%3d | Suma:%10.2f Eur | Data: %10s | Kategorija: %15s " +
                "| Pajamos á bankà: %6b | Papildoma informacija: %-30s |",
                id,
                suma,
                data.format(dateFormater),
                kategorija,
                pozymisArIBanka,
                papildomaInfo
        );
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
