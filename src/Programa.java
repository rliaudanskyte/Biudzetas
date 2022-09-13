import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;
import part3.Irasas;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        //todo: prideti vartotojo sasajos klas� su metodais, kaip irase

        // laikinai pridedami duomenys testavimui
        biudzetas.getIrasai().add(new IslaiduIrasas(45, "2022-11-09 07:02", "pramogos", "grynais", "bilietai"));
        biudzetas.getIrasai().add(new PajamuIrasas(155.12, "2020-12-10", "atlyginimas", true, "lapkri�io atlygis" ));
        biudzetas.getIrasai().add(new PajamuIrasas(1200, "2021-08-21", "paveldejimas", true, "" ));
        biudzetas.getIrasai().add(new PajamuIrasas(100, "2010-08-30", "vokelis", true, "i� r�m�jo" ));
        biudzetas.getIrasai().add(new IslaiduIrasas(50.95, "2022-09-12 21:10", "maistas", "kortele", "maistas savaitei"));
        biudzetas.getIrasai().add(new IslaiduIrasas(21.84, "2022-09-20 14:45", "mokes�iai", "pavedimu", "u� rugp�t�"));
        biudzetas.getIrasai().add(new PajamuIrasas(12.5, "2022-01-01", "loterija", false, "kampai" ));
        biudzetas.getIrasai().add(new IslaiduIrasas(120, "2022-07-29 16:49", "kita", "kortele", ""));


        while (true) {
            System.out.println("""
                    Pasirinkite veiksm�:
                    [1] - naujas pajam� �ra�as,
                    [2] - naujas i�laid� �ra�as,
                    [3] - rasti �ra��,
                    [4] - redaguoti �ra��,
                    [5] - i�trinti �ra��,
                    [6] - spausdinti visus �ra�us,
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
                    if (biudzetas.gautiIrasa(index) == null) {
                        System.out.println("�ra�o tokiu numeriu n�ra");
                    } else {
                        Irasas pI1 = biudzetas.gautiIrasa(index);
                        System.out.println(pI1.toString());
                    }
                    break;
                case 4:
                    biudzetas.spausdintiIrasus();
                    System.out.println("�veskite �ra�o numer�");
                    index = sc.nextInt();
                    biudzetas.redaguotiIrasa(index);
                    break;
                case 5:
                    biudzetas.spausdintiIrasus();
                    System.out.println("�veskite �ra�o numer�");
                    index = sc.nextInt();
                    biudzetas.pasalintiIrasa(index);
                    break;
                case 6:
                    biudzetas.spausdintiIrasus();
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
