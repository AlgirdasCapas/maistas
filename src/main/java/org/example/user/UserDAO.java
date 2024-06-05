package org.example.user;

import org.example.maitinimoIstaiga.utils.BCrypt;
import org.example.maitinimoIstaiga.utils.BCryptPassword;

import java.sql.*;

public class UserDAO {
    public static final String URL = "jdbc:mysql://localhost:3306/maistas";
    private static String query;

    public static void kurti(User user){

        String query = "INSERT INTO users(`username`, `password`, `email`, `role`) " + "VALUES(?,?,?,?)";


        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            String encryptedBCryptPassword = BCryptPassword.hashPassword(user.getPassword());

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, encryptedBCryptPassword);
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getRole());


            preparedStatement.executeUpdate();

            System.out.println("Pavyko įterpti naują įrašą į DB.");

            preparedStatement.close();
            connection.close();

        } catch (SQLException throwables) {

            System.out.println("Įvyko klaida kuriant naują įrašą DB-ėje. Plačiau: " + throwables.getMessage());
        }
    }
    public static String getBCryptPassword(String username) {
        query = "SELECT password FROM users WHERE username = ?;";

        String passwordBCrypt = "";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                passwordBCrypt = resultSet.getString("password");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("There was an error searching for data. More: " +
                    e.getMessage());
        }
        return passwordBCrypt;
    }
}
