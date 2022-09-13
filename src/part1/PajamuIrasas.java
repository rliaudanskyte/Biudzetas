package part1;

import part3.Irasas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PajamuIrasas extends Irasas {
    private LocalDate data;
    private boolean pozymisArIBanka;
    private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PajamuIrasas(double suma,String data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        super.id = super.counter++;
        super.suma = suma;
        this.data = LocalDate.parse(data, dateFormater);
        super.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        super.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString(){
        return String.format("Pajamø áraðas nr.:%4d | Suma:%10.2f Eur | Data: %16s | Kategorija: %15s " +
                "| Pajamos á bankà: %13b | Papildoma informacija: %-20s |",
                id,
                suma,
                data.format(dateFormater),
                kategorija,
                pozymisArIBanka,
                papildomaInfo
        );
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(String data) {
        this.data = LocalDate.parse(data, dateFormater);
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }

    public DateTimeFormatter getDateFormater() {
        return dateFormater;
    }

    public void setDateFormater(DateTimeFormatter dateFormater) {
        this.dateFormater = dateFormater;
    }
}
