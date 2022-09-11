package part1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas {
    private int suma;
    private LocalDateTime dataSuLaiku;
    private String kategorija;
    private String atsiskaitymoBudas;
    private String papildomaInfo;
    private DateTimeFormatter formaterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public IslaiduIrasas() {
        this.suma = 125;
        this.dataSuLaiku = LocalDateTime.parse("2022-12-24 23:50", formaterWithTime);
        this.kategorija = "Maistas";
        this.atsiskaitymoBudas = "kortele";
        this.papildomaInfo = "Sveèiams";
    }

    public IslaiduIrasas(int suma, String dataSuLaiku, String kategorija, String atsiskaitymoBudas, String papildomaInfo) {
        this.suma = suma;
        this.dataSuLaiku = LocalDateTime.parse(dataSuLaiku, formaterWithTime);
        this.kategorija = kategorija;
        this.atsiskaitymoBudas = atsiskaitymoBudas;
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString(){
        return String.format("Iðlaidø áraðas%n|Suma:%15d Eur |Data: %20s |Kategorija: %15s " +
                        "|Atsiskaitymo bûdas: %b |Papildoma informacija: %s",
                suma,
                dataSuLaiku.format(formaterWithTime),
                kategorija,
                atsiskaitymoBudas,
                papildomaInfo
        );
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public void setDataSuLaiku(LocalDateTime dataSuLaiku) {
        this.dataSuLaiku = dataSuLaiku;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    public DateTimeFormatter getFormaterWithTime() {
        return formaterWithTime;
    }

    public void setFormaterWithTime(DateTimeFormatter formaterWithTime) {
        this.formaterWithTime = formaterWithTime;
    }
}
