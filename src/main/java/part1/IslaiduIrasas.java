package part1;

import part3.Irasas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class IslaiduIrasas extends Irasas {
    private LocalDateTime dataSuLaiku;
    private String atsiskaitymoBudas;
    private DateTimeFormatter formaterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public IslaiduIrasas(double suma,
                         LocalDateTime dataSuLaiku,
                         String kategorija,
                         String atsiskaitymoBudas,
                         String papildomaInfo) {
        super.id = super.counter++;
        super.suma = suma;
        this.dataSuLaiku = dataSuLaiku;
        super.kategorija = kategorija;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        super.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return String.format("%s Data: %16s | Kategorija: %15s " +
                        "| Atsiskaitymo b?das: %10s | Papildoma informacija: %-20s |",
                super.toString(),
                dataSuLaiku.format(formaterWithTime),
                kategorija,
                atsiskaitymoBudas,
                papildomaInfo
        );
    }

    @Override
    public String toStringToCsv() {
        return String.format("%s,%s,%s,%s,%s,%s%n",
                "I",
                super.toStringToCsv(),
                dataSuLaiku.format(formaterWithTime),
                kategorija,
                atsiskaitymoBudas,
                papildomaInfo);
    }

    @Override
    public ArrayList<String> toStringToDatabase() {
        var result = new ArrayList<>(super.toStringToDatabase());
        result.add(dataSuLaiku.format(formaterWithTime) + ":00");
        result.add(kategorija);
        result.add(atsiskaitymoBudas);
        result.add(papildomaInfo);
        result.add("I");
        return result;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public void setDataSuLaiku(String dataSuLaiku) {
        this.dataSuLaiku = LocalDateTime.parse(dataSuLaiku, formaterWithTime);
    }
    //LocalDateTime.parse(dataSuLaiku, formaterWithTime);

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public DateTimeFormatter getFormaterWithTime() {
        return formaterWithTime;
    }

    public void setFormaterWithTime(DateTimeFormatter formaterWithTime) {
        this.formaterWithTime = formaterWithTime;
    }
}
