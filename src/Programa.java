import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        // laikinai pridedami duomenys testavimui
        biudzetas.getPajamos().add(new PajamuIrasas(155.12, "2020-12-10", "atlyginimas", true, "lapkrièio mënesio atlyginimas" ));
        biudzetas.getPajamos().add(new PajamuIrasas(1200, "2021-08-21", "paveldejimas", true, "" ));
        biudzetas.getPajamos().add(new PajamuIrasas(12.5, "2022-01-01", "loterija", false, "kampai" ));
        biudzetas.getPajamos().add(new PajamuIrasas(100, "2010-08-30", "vokelis", true, "ið rëmëjo" ));
        biudzetas.getIslaidos().add(new IslaiduIrasas(50.95, "2022-09-12 21:10", "maistas", "kortele", "maistas savaitei"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(21.84, "2022-09-20 14:45", "mokesèiai", "pavedimu", "uþ rugpûtá"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(45, "2022-11-09 07:02", "pramogos", "grynais", "bilietai"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(120, "2022-07-29 16:49", "kita", "kortele", ""));


        while (true) {
            System.out.println("""
                    Pasirinkite veiksmà:
                    [1] - naujas pajamø áraðas,
                    [2] - naujas iðlaidø áraðas,
                    [3] - rasti pajamø áraðà,
                    [4] - rasti iðlaidø áraðà,
                    [5] - iðtrinti pajamø áraðà,
                    [6] - iðtrinti iðlaidø áraðà,
                    [7] - spausdinti visas pajamas,
                    [8] - spausdinti visas iðlaidas,
                    [9] - biudþeto balansas,
                    [0] - baigti programà""");
            Scanner sc = new Scanner(System.in);
            int actionChoice = sc.nextInt();
            switch (actionChoice) {
                case 1:
                    biudzetas.pridetiPajamuIrasa();
                    break;
                case 2:
                    biudzetas.pridetiIslaiduIrasa();
                    break;
                case 3:
                    System.out.println("Áveskite áraðo numerá");
                    int index = sc.nextInt();
                    if (biudzetas.gautiPajamuIrasa(index) == null) {
                        System.out.println("Áraðo tokiu numeriu nëra");
                        break;
                    } else {
                        PajamuIrasas pI1 = biudzetas.gautiPajamuIrasa(index);
                        System.out.println(pI1.toString());
                    }
                    break;
                case 4:
                    System.out.println("Áveskite áraðo numerá");
                    index = sc.nextInt();
                    if (biudzetas.gautiIslaiduIrasa(index) == null) {
                        System.out.println("Áraðo tokiu numeriu nëra");
                        break;
                    } else {
                        IslaiduIrasas pI2 = biudzetas.gautiIslaiduIrasa(index);
                        System.out.println(pI2.toString());
                    }
                    break;
                case 5:
                    biudzetas.spausdintiPajamas();
                    System.out.println("Áveskite áraðo numerá");
                    index = sc.nextInt();
                    biudzetas.pasalintiPajamuIrasa(index);
                    break;
                case 6:
                    biudzetas.spausdintiIslaidas();
                    System.out.println("Áveskite áraðo numerá");
                    index = sc.nextInt();
                    biudzetas.pasalintiIslaiduIrasa(index);
                    break;
                case 7:
                    biudzetas.spausdintiPajamas();
                    biudzetas.gautiPajamuSuma();
                    break;
                case 8:
                    biudzetas.spausdintiIslaidas();
                    biudzetas.gautiIslaiduSuma();
                    break;
                case 9:
                    biudzetas.balansas();
                    break;
                case 0:
                    System.out.println("Programos pabaiga");
                    System.exit(0);
                default:
                    System.out.println("Tokio veiksmo nëra. bandykite dar kartà");
                    break;
            }
        }
    }
}
