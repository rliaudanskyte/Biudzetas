package part4;

import part1.IslaiduIrasas;
import part1.PajamuIrasas;
import part3.Irasas;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Failas {
    public static void issaugotiDuomenis(ArrayList<Irasas> sarasas) throws IOException {
        var writer = new BufferedWriter(new FileWriter("./src/part4/duomenys/duomenys.csv"));
        sarasas.forEach(line -> {
            try {
                writer.write(line.toStringToCsv());
            } catch (IOException e) {
                throw new RuntimeException("Neásiraðo: " + e);
            }
        });
        writer.flush();
        writer.close();
        System.out.println("Duomenys iðsaugoti");
    }

    public static ArrayList<Irasas> gautiDuomenis() {
        ArrayList<Irasas> gautiIrasai = new ArrayList<>();
        List<String> lines;
        try {
            var reader = new BufferedReader(new FileReader("./src/part4/duomenys/duomenys.csv"));
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        lines.forEach(line -> {
            System.out.println(line);
            List<String> dalys = Arrays.asList(line.split(","));
                if (dalys.get(0) == "P") {
                    gautiIrasai.add(new PajamuIrasas(
                            Double.parseDouble(dalys.get(2)), //double suma
                            dalys.get(3), //string data
                            dalys.get(4), // string kategorija
                            Boolean.parseBoolean(dalys.get(5)), //boolean pozymisArIBanka
                            dalys.get(6) //String papildomaInfo
                    ));

                } else if (dalys.get(0) == "I") {
                    gautiIrasai.add(new IslaiduIrasas(
                            Double.parseDouble(dalys.get(2)), //double suma
                            dalys.get(3), //string dataSuLaiku
                            dalys.get(4), // string kategorija
                            dalys.get(5), // Sting Atsiskaitymo budas
                            dalys.get(6) //String papildomaInfo
                    ));
                }

        });
        return gautiIrasai;
    }
}
