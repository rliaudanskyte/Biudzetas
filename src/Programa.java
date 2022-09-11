import part1.Biudzetas;
import part1.IslaiduIrasas;
import part1.PajamuIrasas;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();

        while (true) {
            System.out.println("""
                    Pasirinkite veiksmà:
                    [1] - naujas pajamø áraðas,
                    [2] - naujas iðlaidø áraðas,
                    [3] - rasti pajamø áraðà,
                    [4] - rasti iðlaidø áraðà,
                    [5] - biudþeto balansas,
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
