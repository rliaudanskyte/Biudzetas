package part1;

import part3.Irasas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private ArrayList<Irasas> irasai = new ArrayList<>();

    String optionsForEdit = "[1] - redaguoti\n[2] - toliau";

    public double gautiPajamuSuma() {
        double suma = 0;
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) {
                suma += irasas.getSuma();
            }
        }
        System.out.printf("Sukauptos pajamos: %.2fEur%n", suma);
        return suma;
    }

    public double gautiIslaiduSuma() {
        double suma = 0;
        for (Irasas irasas : irasai) {
            if (irasas instanceof IslaiduIrasas) {
                suma += irasas.getSuma();
            }
        }
        System.out.printf("Visos iðlaidos: %.2fEur%n", suma);
        return suma;
    }

    public void pridetiPajamuIrasa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Áveskite pajamø sumà");
        double suma = sc.nextDouble();
//                System.out.println("Áveskite datà (yyyy-MM-dd)");
//                String data = sc.next();
        String data = "2022-12-12";
        System.out.println("""
                Pasirinkite pajamø kategorijà:
                [1] - atlyginimas,
                [2] - dovana,
                [3] - loterija,
                [4] - paveldëjimas,
                [5] - kyðis,
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
                kategorija = "paveldëjimas";
                break;
            case 5:
                kategorija = "kyðis";
                break;
            case 6:
                kategorija = "kita";
                break;
        }
//                String kategorija = "katEgory";
//                System.out.println("At tai banko ánaðas?");
//                boolean pozymisArIBanka = sc.nextBoolean();
        boolean pozymisArIBanka = true;
//                System.out.println("Papildoma informacija");
//                String papildomaInfo = sc.next();
        String papildomaInfo = "Nesi Mates tokios info";
        irasai.add(new PajamuIrasas(suma, data, kategorija, pozymisArIBanka, papildomaInfo));

        gautiPajamuSuma();
    }

    public void pridetiIslaiduIrasa() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Áveskite iðlaidø sumà");
        double suma = sc.nextDouble();
        sc.nextLine();
//                System.out.println("Áveskite datà ir laikà formatu yyyy, MM, dd, HH:mm");
//                String laikas = sc.nextLine();
        String laikas = "2022-08-08 15:45";
        System.out.println("Pasirinkite iðlaidø kategorijà");
        System.out.println("""
                Pasirinkite veiksmà:
                [1] - mokesèiai,
                [2] - nuoma,
                [3] - maistas,
                [4] - pramogos,
                [5] - dovanos,
                [6] - kita""");

        int kategorijaInput = sc.nextInt();
        String kategorija = "";
        switch (kategorijaInput) {
            case 1:
                kategorija = "mokesèiai";
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
//                System.out.println("Áveskite atsiskaitymo bûdà(grynieji, kortele, pavedimas)");
//                String atsiskaitymoBudas = sc.next();
        String atsiskaitymoBudas = "budas";
//                System.out.println("Papildoma informacija");
//                String papildomaInfo = sc.next();
        String papildomaInfo = "info";
        irasai.add(new IslaiduIrasas(suma, laikas, kategorija, atsiskaitymoBudas, papildomaInfo));

        gautiIslaiduSuma();
    }

    public Irasas gautiIrasa(int i) {
        return irasai.get(i);
    }

    public void balansas() {
        System.out.printf("Biudþeto balansas: %.2fEur%n", (gautiPajamuSuma()) - (gautiIslaiduSuma()));
    }

    public void spausdintiIrasus() {
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) {
                System.out.println(((PajamuIrasas) irasas).toString());
            } else if (irasas instanceof IslaiduIrasas) {
                System.out.println(((IslaiduIrasas) irasas).toString());
            } else {
                continue;
            }
        }
    }

    public void spausdintiPajamas() {
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) {
                System.out.println(((PajamuIrasas) irasas).toString());
            }
        }
    }

    public void spausdintiIslaidas() {
        for (Irasas irasas : irasai) {
            if (irasas instanceof IslaiduIrasas) {
                System.out.println(((IslaiduIrasas) irasas).toString());
            }
        }
    }

    public ArrayList<Irasas> getIrasai() {
        return irasai;
    }

    public void redaguotiIrasa(int i) {
        Irasas redaguotinasIrasas = new Irasas();
        for (Irasas element : irasai) {
            if (element.getId() == i) {
                redaguotinasIrasas = element;
            }
        }
        Scanner sc = new Scanner(System.in);
        int inputNum = 0;

        if (redaguotinasIrasas instanceof PajamuIrasas) {
            System.out.println((((PajamuIrasas) redaguotinasIrasas).toString()));

            System.out.println("Suma: " + redaguotinasIrasas.getSuma() + "Eur");
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Nauja suma:");
                redaguotinasIrasas.setSuma(sc.nextDouble());
            }

            // todo: neveikia datos paëmimas
            System.out.println("Data: " + ((PajamuIrasas) redaguotinasIrasas).getData().format(((PajamuIrasas) redaguotinasIrasas).getDateFormater()));
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Nauja data:");
                ((PajamuIrasas) redaguotinasIrasas).setData(sc.next());
//                sc.nextLine();
            }

            System.out.println("Kategorija: " + redaguotinasIrasas.getKategorija());
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                String kategorija = "";
                System.out.println("Nauja kategorija:");
                System.out.println("""
                        [1] - atlyginimas,
                        [2] - dovana,
                        [3] - loterija,
                        [4] - paveldëjimas,
                        [5] - kyðis,
                        [6] - kita""");
                switch (sc.nextInt()) {
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
                        kategorija = "paveldëjimas";
                        break;
                    case 5:
                        kategorija = "kyðis";
                        break;
                    case 6:
                        kategorija = "kita";
                        break;
                }
                sc.nextLine();
                redaguotinasIrasas.setKategorija(kategorija);
            }

            System.out.println("Ar pajamos gautos á bankà: " +
                    (((PajamuIrasas) redaguotinasIrasas).isPozymisArIBanka() == true ? "taip" : "ne"));
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Ar pajamos gautos á bankà?");
                ((PajamuIrasas) redaguotinasIrasas).setPozymisArIBanka(sc.nextBoolean());
            }

            System.out.println("Papildoma informacija: " + redaguotinasIrasas.getPapildomaInfo());
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Nauja informacija:");
                redaguotinasIrasas.setPapildomaInfo(sc.nextLine());
            }


        } else {
            System.out.println((((IslaiduIrasas) redaguotinasIrasas).toString()));

            System.out.println("Suma: " + redaguotinasIrasas.getSuma() + "Eur");
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Nauja suma:");
                redaguotinasIrasas.setSuma(sc.nextDouble());
            }

            // todo: neveikia datos paëmimas
            System.out.println("Data: " + ((IslaiduIrasas) redaguotinasIrasas).getDataSuLaiku().format(((IslaiduIrasas) redaguotinasIrasas).getFormaterWithTime()));
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                sc.nextLine();
                System.out.println("Nauja data su laiku:");
                ((IslaiduIrasas) redaguotinasIrasas).setDataSuLaiku(sc.nextLine());
//                sc.nextLine();
            }

            System.out.println("Kategorija: " + redaguotinasIrasas.getKategorija());
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                String kategorija = "";
                System.out.println("Nauja kategorija:");
                System.out.println("""
                        [1] - mokesèiai,
                        [2] - nuoma,
                        [3] - maistas,
                        [4] - pramogos,
                        [5] - dovanos,
                        [6] - kita""");
                switch (sc.nextInt()) {
                    case 1:
                        kategorija = "mokesèiai";
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
                sc.nextLine();
                redaguotinasIrasas.setKategorija(kategorija);
            }

            System.out.println("Atsiskaitymo bûdas: " + (((IslaiduIrasas) redaguotinasIrasas).getAtsiskaitymoBudas()));
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("""
                        Atsiskaitymo bûdas:
                        [1]""");
                ((IslaiduIrasas) redaguotinasIrasas).setAtsiskaitymoBudas(sc.nextLine());
                sc.nextLine();
            }

            System.out.println("Papildoma informacija: " + redaguotinasIrasas.getPapildomaInfo());
            System.out.println(optionsForEdit);
            inputNum = sc.nextInt();
            if (inputNum == 1) {
                System.out.println("Nauja informacija:");
                redaguotinasIrasas.setPapildomaInfo(sc.nextLine());
            }
        }
    }

    public void pasalintiIrasa(int id){
        String printText = "";
        for (int j = 0; j < irasai.size(); j++) {
            if (irasai.get(j).getId() == id) {
                irasai.remove(j);
                printText = "Paðalintas áraðas, kurio nr: " + id;
                break;
            }
        }
        if (printText == "") {
            printText = "Tokio áraðo nëra";
        }
        System.out.println(printText);
    }
}
