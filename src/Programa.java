import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;
import part3.Irasas;
import part3.VartotojoSasaja;
import part4.Failas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
                    [8] - iðsaugoti duomenis á failà,
                    [9] - gauti duomenis ið failo,
                    [0] - baigti programà""";
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        //todo: prideti vartotojo sasajos klasæ su metodais, kaip irase

        // laikinai pridedami duomenys testavimui
        biudzetas.getIrasai().add(new IslaiduIrasas(45, "2022-11-09 07:02", "pramogos", "grynais", "bilietai"));
        biudzetas.getIrasai().add(new PajamuIrasas(155.12, "2020-12-10", "atlyginimas", true, "lapkrièio atlygis" ));
        biudzetas.getIrasai().add(new PajamuIrasas(1200, "2021-08-21", "paveldejimas", true, "none" ));
        biudzetas.getIrasai().add(new PajamuIrasas(100, "2010-08-30", "vokelis", true, "ið rëmëjo" ));
        biudzetas.getIrasai().add(new IslaiduIrasas(50.95, "2022-09-12 21:10", "maistas", "kortele", "maistas savaitei"));
        biudzetas.getIrasai().add(new IslaiduIrasas(21.84, "2022-09-20 14:45", "mokesèiai", "pavedimu", "uþ rugpûtá"));
        biudzetas.getIrasai().add(new PajamuIrasas(12.5, "2022-01-01", "loterija", false, "kampai" ));
        biudzetas.getIrasai().add(new IslaiduIrasas(120, "2022-07-29 16:49", "kita", "kortele", "none"));


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
                        Failas.issaugotiDuomenis(biudzetas.getIrasai());
                        break;
                    case 9:
                        ArrayList<Irasas> naujasSarasas = Failas.gautiDuomenis();
                        biudzetas.setIrasai(naujasSarasas);
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
