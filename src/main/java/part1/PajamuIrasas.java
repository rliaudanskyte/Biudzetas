package part1;

import part3.Irasas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PajamuIrasas extends Irasas {
    private LocalDate data;
    private boolean pozymisArIBanka;
    private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PajamuIrasas(double suma,
                        LocalDate data,
                        String kategorija,
                        boolean pozymisArIBanka,
                        String papildomaInfo) {
        super.id = super.counter++;
        super.suma = suma;
        this.data = data;
        super.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        super.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return String.format("%s Data: %16s | Kategorija: %15s " +
                        "| Pajamos á bankà: %13b | Papildoma informacija: %-20s |",
                super.toString(),
                data.format(dateFormater),
                kategorija,
                pozymisArIBanka,
                papildomaInfo
        );
    }

    @Override
    public String toStringToCsv() {
        return String.format("%s,%s,%s,%s,%b,%s%n",
                "P",
                super.toStringToCsv(),
                data.format(dateFormater),
                kategorija,
                pozymisArIBanka,
                papildomaInfo);
    }

    @Override
    public ArrayList<String> toStringToDatabase() {
        var result = new ArrayList<>(super.toStringToDatabase());
        result.add(data.format(dateFormater) + " 00:00:000");
        result.add(kategorija);
        result.add(String.valueOf(pozymisArIBanka));
        result.add(papildomaInfo);
        result.add("P");
        return result;
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
