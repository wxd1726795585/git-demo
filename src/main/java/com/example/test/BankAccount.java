package com.example.test;

import java.sql.*;

/**
 * \* Created with WXD.
 * \* Date:  2023/9/12
 * \* Description:
 * \* @author 王祥栋
 */
public class BankAccount {
    private int id;
    private int balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    public synchronized void withdraw(int amount) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "user";
        String password = "password";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(
                "SELECT balance FROM accounts WHERE id = ? FOR UPDATE");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int currentBalance = resultSet.getInt("balance");

        if (currentBalance >= amount) {
            statement = connection.prepareStatement(
                    "UPDATE accounts SET balance = ? WHERE id = ?");
            statement.setInt(1, currentBalance - amount);
            statement.setInt(2, id);

            statement.executeUpdate();
            balance -= amount;
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
