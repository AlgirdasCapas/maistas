package org.example.maitinimoIstaiga.meniu;

import org.example.maitinimoIstaiga.MaitinimoIstaiga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ValgiarastisDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/maistas";
    public static void kurti(Valgiarastis valgiarastis){

        String query = "INSERT INTO valgiarasciai(`valgiarascioid`, `pavadinimas`) " +        "VALUES(?,?,?)";


        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, valgiarastis.getIstaigosId());
            preparedStatement.setString(2, valgiarastis.getPavadinimas());


            preparedStatement.executeUpdate();

            System.out.println("Pavyko įterpti naują įrašą į duomenų bazę.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {

            System.out.println("Įvyko klaida kuriant naują įrašą duomenų bazėje. Plačiau: " + throwables.getMessage());
        }
    }
}
