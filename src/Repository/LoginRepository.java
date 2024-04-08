/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class LoginRepository {

    private ArrayList<login> list;
    private Connection conn;
    private Statement stm;
    private PreparedStatement psm;

    public LoginRepository() {
        list = new ArrayList<>();
        conn = DBConnect.getConnection();

    }

    public ArrayList<login> getList() {
        return list;
    }

    public void setList(ArrayList<login> list) {
        this.list = list;
    }

    public boolean authenticateUser(String username, String password) {
        try {
            String query = "SELECT * FROM login WHERE tai_khoan = ? AND mat_khau = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // If a row is returned, authentication is successful
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
