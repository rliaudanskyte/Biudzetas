package part1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
    private ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

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

        System.out.println("�veskite pajam� sum�");
        double suma = sc.nextDouble();
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
        pajamos.add(new PajamuIrasas(suma, data, kategorija, pozymisArIBanka, papildomaInfo));

        gautiPajamuSuma();
    }

    public void pridetiIslaiduIrasa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("�veskite i�laid� sum�");
        double suma = sc.nextDouble();
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
        islaidos.add( new IslaiduIrasas(suma, laikas, kategorija, atsiskaitymoBudas, papildomaInfo));

        gautiIslaiduSuma();
    }

    public PajamuIrasas gautiPajamuIrasa(int i) {
        return pajamos.get(i);
    }

    public IslaiduIrasas gautiIslaiduIrasa(int i) {
        return islaidos.get(i);
    }

    public void balansas(){
        System.out.println("Biud�eto balansas: " + (gautiPajamuSuma() - gautiIslaiduSuma()) + "Eur");
    }

    public void spausdintiPajamas() {
        for (PajamuIrasas irasai : pajamos ) {
            System.out.println(irasai.toString());
        }
    }
    public void spausdintiIslaidas() {
        for (IslaiduIrasas irasai : islaidos ) {
            System.out.println(irasai.toString());
        }
    }

    public void pasalintiPajamuIrasa(int i){
        for ( int j = 0; j < pajamos.size(); j++ ) {
            if (pajamos.get(j).getId() == i) {
                pajamos.remove(j);
                System.out.println("Pa�alintas �ra�as, kurio nr: " + i);
                break;
            }
        }
    }

    public void pasalintiIslaiduIrasa(int i){
        for (int j = 0; j < islaidos.size(); j++) {
            if (islaidos.get(j).getId() == i) {
                islaidos.remove(j);
                System.out.println("Pa�alintas �ra�as, kurio nr: " + i);
                break;
            }
        }
    }
    public ArrayList<PajamuIrasas> getPajamos() {
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> getIslaidos() {
        return islaidos;
    }
}
