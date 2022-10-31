import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;
import part3.Irasas;
import part3.VartotojoSasaja;
import part4.Failas;
import part5.Database;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class Programa {
    public static String pasirinkiteVeikstmà = """
                    Pasirinkite veiksmà:
                    [1] - naujas pajamø áraðas,
                    [2] - naujas iðlaidø áraðas,
                    [3] - rasti áraðà,
                    [4] - redaguoti áraðà,
                    [5] - iðtrinti áraðà,
                    [6] - spausdinti áraðus,
                    [7] - biudþeto balansas,
                    [8] - iðsaugoti duomenis á duomenø bazæ,
                    [9] - gauti duomenis ið duomenø bazës,
                    [10] - eksportuoti duomenis á failà,
                    [11] - importuoti duomenis ið failo,
                    [0] - baigti programà""";
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();


        // laikinai pridedami duomenys testavimui
//        biudzetas.getIrasai().add(new IslaiduIrasas(45, LocalDateTime.of(2022,11,9,7,2), "pramogos", "grynais", "bilietai"));
//        biudzetas.getIrasai().add(new PajamuIrasas(155.12, LocalDate.of(2020,12,10), "atlyginimas", true, "lapkrièio atlygis" ));
//        biudzetas.getIrasai().add(new PajamuIrasas(1200, LocalDate.of(2021,8,21), "paveldejimas", true, "none" ));
//        biudzetas.getIrasai().add(new PajamuIrasas(100, LocalDate.of(2010,8,30), "vokelis", true, "ið rëmëjo" ));
//        biudzetas.getIrasai().add(new IslaiduIrasas(50.95, LocalDateTime.of(2022,9,12,21,10), "maistas", "kortele", "maistas savaitei"));
//        biudzetas.getIrasai().add(new IslaiduIrasas(21.84, LocalDateTime.of(2022,9,20,14,45), "mokesèiai", "pavedimu", "uþ rugpûtá"));
//        biudzetas.getIrasai().add(new PajamuIrasas(12.5, LocalDate.of(2022,1,1), "loterija", false, "kampai" ));
//        biudzetas.getIrasai().add(new IslaiduIrasas(120, LocalDateTime.of(2022,7,29,16,49), "kita", "kortele", "none"));


        while (true) {
            try {
                int actionChoice = Integer.parseInt(VartotojoSasaja.paprasytiString(pasirinkiteVeikstmà));

                switch (actionChoice) {
                    case 1:
                        biudzetas.pridetiPajamuIrasa();
                        break;
                    case 2:
                        biudzetas.pridetiIslaiduIrasa();
                        break;
                    case 3:
                        int index = Integer.parseInt(VartotojoSasaja.paprasytiString("Áveskite áraðo numerá"));
                        if (biudzetas.gautiIrasa(index) == null) {
                            System.out.println("Áraðo tokiu numeriu nëra");
                        } else {
                            Irasas pI1 = biudzetas.gautiIrasa(index);
                            System.out.println(pI1.toString());
                        }
                        break;
                    case 4:
                        biudzetas.spausdintiIrasus();
                        index = Integer.parseInt(VartotojoSasaja.paprasytiString("Áveskite áraðo numerá"));
                        biudzetas.redaguotiIrasa(index);
                        break;
                    case 5:
                        biudzetas.spausdintiIrasus();
                        index = Integer.parseInt(VartotojoSasaja.paprasytiString("Áveskite áraðo numerá"));
                        biudzetas.pasalintiIrasa(index);
                        break;
                    case 6:
                        biudzetas.spausdintiIrasus();
                        break;
                    case 7:
                        biudzetas.balansas();
                        break;
                    case 8:
                        Database.issaugotiDuomenis(biudzetas.getIrasai());
                        break;
                    case 9:
                        ArrayList<Irasas> naujasSarasas = Database.gautiDuomenis();
                        biudzetas.setIrasai(naujasSarasas);
                        biudzetas.spausdintiIrasus();
                        break;
                    case 10:
                        Failas.issaugotiDuomenis(biudzetas.getIrasai());
                        break;
                    case 11:
                        ArrayList<Irasas> naujasSarasasIsFailo = Failas.gautiDuomenis();
                        biudzetas.setIrasai(naujasSarasasIsFailo);
                        biudzetas.spausdintiIrasus();
                        break;
                    case 0:
                        System.out.println("Programos pabaiga");
                        System.exit(0);
                    default:
                        System.out.println("Tokio veiksmo nëra. bandykite dar kartà");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Klaida! Ávestas ne skaièius!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
