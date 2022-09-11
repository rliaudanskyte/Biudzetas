import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        while (true) {
            System.out.println("""
                    Pasirinkite veiksm�:
                    [1] - naujas pajam� �ra�as,
                    [2] - naujas i�laid� �ra�as,
                    [3] - rasti pajam� �ra��,
                    [4] - rasti i�laid� �ra��,
                    [5] - biud�eto balansas,
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
