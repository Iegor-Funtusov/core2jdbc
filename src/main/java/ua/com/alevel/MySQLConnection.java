package ua.com.alevel;

import java.sql.*;

/**
 * @author Iehor Funtusov, created 11/12/2020 - 8:18 PM
 */

public class MySQLConnection {

    private Connection connection;
    private Statement statement;

    private final static String INSERT_QUERY = "insert into core2test.users values (default, ?, ?)";
    private final static String SELECT_QUERY = "select * from core2test.users";

    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.
                    getConnection(
                            "jdbc:mysql://localhost/core2test",
                            "core2test",
                            "core2test");
            this.statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            select();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create(User user) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void select() throws SQLException {
        ResultSet resultSet = this.statement.executeQuery(SELECT_QUERY);
        readResult(resultSet);
    }

    private void readResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String email = resultSet.getString("email");
            System.out.println("username: " + username);
            System.out.println("email: " + email);
        }
    }
}
