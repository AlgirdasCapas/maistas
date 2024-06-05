package org.example.maitinimoIstaiga;

import java.sql.*;
import java.util.ArrayList;

public class MaitinimoIstaigaDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/maistas";
    private static String query;

    public static void kurti(MaitinimoIstaiga istaiga){

        String query = "INSERT INTO maitinimoistaigos(`pavadinimas`, `kodas`, `adresas`) " +        "VALUES(?,?,?)";


        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, istaiga.getPavadinimas());
            preparedStatement.setString(2, istaiga.getKodas());
            preparedStatement.setString(3, istaiga.getAdresas());


            preparedStatement.executeUpdate();

            System.out.println("Pavyko įterpti naują įrašą į duomenų bazę.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {

            System.out.println("Įvyko klaida kuriant naują įrašą duomenų bazėje. Plačiau: " + throwables.getMessage());
        }
    }



    public static void ieskotiIstaigos(String miestas) {
        String uzklausa = "SELECT * FROM `maitinimoistaigos` WHERE `adresas` LIKE '%" + miestas + "%'";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(uzklausa);

            ResultSet resultSet = preparedStatement.executeQuery(uzklausa);

            ArrayList<MaitinimoIstaiga> istaigos = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pavadinimas = resultSet.getString("pavadinimas");
                String kodas = resultSet.getString("kodas");
                String adresas = resultSet.getString("adresas");

                istaigos.add(new MaitinimoIstaiga(id, pavadinimas, kodas, adresas));
            }

            if (istaigos.isEmpty()) {
                System.out.println("Įstaigų iš šio miesto: " + miestas + " DB-ėje rasti nepavyko.");
            } else {
                System.out.println("Rastos tokios įstaigos: \n");
                System.out.println(istaigos);
            }
            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
        public static void delete (int id) {
            query = "DELETE FROM maitinimoistaigos WHERE id = ?;";
            try {
                Connection connection = DriverManager.getConnection(URL, "root", "");
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                System.out.println("Sėkmigai ištrinta maitinimo įstaiga.");
            } catch (SQLException e) {
                System.out.println("Nepavyko ištrinti įrašo!"
                        + e.getMessage());
            }
        }
    }


