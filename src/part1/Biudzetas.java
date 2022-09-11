package part1;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Biudzetas {
    private PajamuIrasas[] pajamos = new PajamuIrasas[100];
    private IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

    public int gautiPajamuSuma() {
        int suma = 0;
        for (PajamuIrasas irasas : pajamos) {
            if (irasas != null) {
                suma += irasas.getSuma();
            } else {
                break;
            }
        }
        System.out.printf("Sukauptos pajamos: %dEur%n", suma);
        return suma;
    }

    public int gautiIslaiduSuma() {
        int suma = 0;
        for (IslaiduIrasas irasas : islaidos) {
            if (irasas != null) {
                suma += irasas.getSuma();
            } else {
                break;
            }
        }
        System.out.printf("Visos i�laidos: %dEur%n", suma);
        return suma;
    }

    public void pridetiPajamuIrasa() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < pajamos.length; i++) {
            if (pajamos[i] == null) {
                System.out.println("�veskite pajam� sum�");
                int suma = sc.nextInt();
//                System.out.println("�veskite dat� (yyyy-MM-dd)");
//                String data = sc.next();
                String data = "2022-12-12";
                System.out.println("""
                    Pasirinkite pajam� kategorij�:
                    [1] - atlyginimas,
                    [2] - dovana,
                    [3] - loterija,
                    [4] - paveld�jimas,
                    [5] - ky�is,
                    [6] - kita""");
                int kategorijaInput = sc.nextInt();
                String kategorija = "";
                switch (kategorijaInput) {
                    case 1:
                        kategorija = "atlyginimas";
                        break;
                    case 2:
                        kategorija = "dovana";
                        break;
                    case 3:
                        kategorija = "loterija";
                        break;
                    case 4:
                        kategorija = "paveld�jimas";
                        break;
                    case 5:
                        kategorija = "ky�is";
                        break;
                    case 6:
                        kategorija = "kita";
                        break;
                }
//                String kategorija = "katEgory";
//                System.out.println("At tai banko �na�as?");
//                boolean pozymisArIBanka = sc.nextBoolean();
                boolean pozymisArIBanka = true;
//                System.out.println("Papildoma informacija");
//                String papildomaInfo = sc.next();
                String papildomaInfo = "Nesi Mates tokios info";
                pajamos[i] = new PajamuIrasas(suma, data, kategorija, pozymisArIBanka, papildomaInfo);
                break;
            }
        }
        gautiPajamuSuma();
    }

    public void pridetiIslaiduIrasa() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < islaidos.length; i++) {
            if (islaidos[i] == null) {
                System.out.println("�veskite i�laid� sum�");
                int suma = sc.nextInt();
                sc.nextLine();
//                System.out.println("�veskite dat� ir laik� formatu yyyy, MM, dd, HH:mm");
//                String laikas = sc.nextLine();
                String laikas = "2022-08-08 15:45";
                System.out.println("Pasirinkite i�laid� kategorij�");
                System.out.println("""
                    Pasirinkite veiksm�:
                    [1] - mokes�iai,
                    [2] - nuoma,
                    [3] - maistas,
                    [4] - pramogos,
                    [5] - dovanos,
                    [6] - kita""");

                int kategorijaInput = sc.nextInt();
                String kategorija = "";
                switch (kategorijaInput) {
                    case 1:
                        kategorija = "mokes�iai";
                        break;
                    case 2:
                        kategorija = "nuoma";
                        break;
                    case 3:
                        kategorija = "maistas";
                        break;
                    case 4:
                        kategorija = "pramogos";
                        break;
                    case 5:
                        kategorija = "dovanos";
                        break;
                    case 6:
                        kategorija = "kita";
                        break;
                }
//                String kategorija = "kategorija";
//                System.out.println("�veskite atsiskaitymo b�d�(grynieji, kortele, pavedimas)");
//                String atsiskaitymoBudas = sc.next();
                String atsiskaitymoBudas = "budas";
//                System.out.println("Papildoma informacija");
//                String papildomaInfo = sc.next();
                String papildomaInfo = "info";
                islaidos[i] = new IslaiduIrasas(suma, laikas, kategorija, atsiskaitymoBudas, papildomaInfo);
                break;
            }
        }
        gautiIslaiduSuma();
    }

    public PajamuIrasas gautiPajamuIrasa(int i) {
        return pajamos[i];
    }

    public IslaiduIrasas gautiIslaiduIrasa(int i) {
        return islaidos[i];
    }

    public void balansas(){
        System.out.println("Biud�eto balansas: " + (gautiPajamuSuma() - gautiIslaiduSuma()) + "Eur");
    }

    public PajamuIrasas[] getPajamos() {
        return pajamos;
    }

    public IslaiduIrasas[] getIslaidos() {
        return islaidos;
    }
}
