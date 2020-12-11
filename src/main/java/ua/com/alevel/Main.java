package ua.com.alevel;

/**
 * @author Iehor Funtusov, created 11/12/2020 - 8:17 PM
 */
public class Main {

    public static void main(String[] args) {

        MySQLConnection mySQLConnection = new MySQLConnection();

        mySQLConnection.read();

        User user = new User();
        user.setEmail("user125.gmail.com");
        user.setUserName("TestName125");

        mySQLConnection.create(user);

        mySQLConnection.read();

    }
}
