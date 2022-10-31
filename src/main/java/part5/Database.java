package part5;

import part1.IslaiduIrasas;
import part1.PajamuIrasas;
import part3.Irasas;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private static Connection connection;
    private static PreparedStatement pStatement;

    public static ArrayList<Irasas> gautiDuomenis() {
        ArrayList<Irasas> irasai = new ArrayList<>();

        try {
            createConnection();
            pStatement = connection.prepareStatement("SELECT * FROM irasai;");
            ResultSet rs = pStatement.executeQuery();

            while (rs.next()) {
                var irasoTipas = rs.getString("line_type");
                var suma = rs.getDouble("balance");
                Timestamp dataSuLaiku = rs.getTimestamp("date");
                var kategorija = rs.getString("category");
                var tipas = rs.getString("transaction_type");
                var papildomaInfo = rs.getString("additional_info");
                switch (irasoTipas) {
                    case "P" -> {
                        irasai.add((PajamuIrasas) new PajamuIrasas(
                                suma,
                                dataSuLaiku.toLocalDateTime().toLocalDate(),
                                kategorija,
                                Boolean.parseBoolean(tipas),
                                papildomaInfo
                        ));
                    }
                    case "I" -> {
                        irasai.add((IslaiduIrasas) new IslaiduIrasas(
                                suma,
                                dataSuLaiku.toLocalDateTime(),
                                kategorija,
                                tipas,
                                papildomaInfo
                        ));
                    }
                }
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return irasai;
    }

    public static void issaugotiDuomenis(ArrayList<Irasas> sarasas) {
        createConnection();
        try {
            pStatement = connection.prepareStatement("DELETE FROM irasai;");
            pStatement.execute();
        } catch (SQLException e) {
            System.err.println("[DATABASE ERROR] Nepavyko iðtrinti duomenø" + "\n" + e);
        }
        sarasas.forEach( irasas -> {
            var irasasToCSVString = irasas.toStringToDatabase();
            try {
                pStatement = connection.prepareStatement("INSERT INTO irasai VALUES (?, ?, ?, ?, ?, ?, ?);");
                pStatement.setInt(1, irasas.getId()); //[0] id
                pStatement.setDouble(3, irasas.getSuma()); //[1] suma
                pStatement.setTimestamp(4, Timestamp.valueOf(irasasToCSVString.get(2))); //[2] data
                pStatement.setString(5, irasas.getKategorija()); //[3] kategorija
                pStatement.setString(6, irasasToCSVString.get(4)); //[4] transaction_type/or if to bank
                pStatement.setString(7, irasas.getPapildomaInfo()); //[5] papildoma info
                pStatement.setString(2, irasasToCSVString.get(6)); //[6] tipas
                pStatement.execute();
            } catch (SQLException e) {
                System.err.println("[DATABASE ERROR] Nepavyko iðsaugoti" + "\n" + e);
            }

        });

    }

    // todo: add method to writhe data to database


    public static boolean createConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/biudzetas_irasai",
                    "postgres",
                    "sfaWusb516Qs9q7h64&k8NfP2"
            );
        } catch (SQLException e) {
            System.err.println("Nepavyko prisijungti prie duomenø bazës" + "\n" + e);
            return false;
        }
        return true;
    }


}
