import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        // laikinai pridedami duomenys testavimui
        biudzetas.getPajamos().add(new PajamuIrasas(155.12, "2020-12-10", "atlyginimas", true, "lapkri�io m�nesio atlyginimas" ));
        biudzetas.getPajamos().add(new PajamuIrasas(1200, "2021-08-21", "paveldejimas", true, "" ));
        biudzetas.getPajamos().add(new PajamuIrasas(12.5, "2022-01-01", "loterija", false, "kampai" ));
        biudzetas.getPajamos().add(new PajamuIrasas(100, "2010-08-30", "vokelis", true, "i� r�m�jo" ));
        biudzetas.getIslaidos().add(new IslaiduIrasas(50.95, "2022-09-12 21:10", "maistas", "kortele", "maistas savaitei"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(21.84, "2022-09-20 14:45", "mokes�iai", "pavedimu", "u� rugp�t�"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(45, "2022-11-09 07:02", "pramogos", "grynais", "bilietai"));
        biudzetas.getIslaidos().add(new IslaiduIrasas(120, "2022-07-29 16:49", "kita", "kortele", ""));


        while (true) {
            System.out.println("""
                    Pasirinkite veiksm�:
                    [1] - naujas pajam� �ra�as,
                    [2] - naujas i�laid� �ra�as,
                    [3] - rasti pajam� �ra��,
                    [4] - rasti i�laid� �ra��,
                    [5] - i�trinti pajam� �ra��,
                    [6] - i�trinti i�laid� �ra��,
                    [7] - spausdinti visas pajamas,
                    [8] - spausdinti visas i�laidas,
                    [9] - biud�eto balansas,
                    [0] - baigti program�""");
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
                    System.out.println("�veskite �ra�o numer�");
                    int index = sc.nextInt();
                    if (biudzetas.gautiPajamuIrasa(index) == null) {
                        System.out.println("�ra�o tokiu numeriu n�ra");
                        break;
                    } else {
                        PajamuIrasas pI1 = biudzetas.gautiPajamuIrasa(index);
                        System.out.println(pI1.toString());
                    }
                    break;
                case 4:
                    System.out.println("�veskite �ra�o numer�");
                    index = sc.nextInt();
                    if (biudzetas.gautiIslaiduIrasa(index) == null) {
                        System.out.println("�ra�o tokiu numeriu n�ra");
                        break;
                    } else {
                        IslaiduIrasas pI2 = biudzetas.gautiIslaiduIrasa(index);
                        System.out.println(pI2.toString());
                    }
                    break;
                case 5:
                    biudzetas.spausdintiPajamas();
                    System.out.println("�veskite �ra�o numer�");
                    index = sc.nextInt();
                    biudzetas.pasalintiPajamuIrasa(index);
                    break;
                case 6:
                    biudzetas.spausdintiIslaidas();
                    System.out.println("�veskite �ra�o numer�");
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
                    System.out.println("Tokio veiksmo n�ra. bandykite dar kart�");
                    break;
            }
        }
    }
}
