package ua.com.alevel;

import java.util.List;

/**
 * @author Iehor Funtusov, created 11/12/2020 - 8:17 PM
 */
public class Main {

    public static void main(String[] args) {

        HibernateConnection hibernateConnection = new HibernateConnection();
//        List<User> users = hibernateConnection.findAll();
//
//        users.forEach(System.out::println);

        User user = hibernateConnection.findById(5);
        System.out.println("user = " + user);
//        User user = new User();
//        user.setUserName("poutewir");
//        user.setEmail("poutewir@ff.com");
//
//        hibernateConnection.create(user);
//
//        users = hibernateConnection.findAll();
//
//        System.out.println();
//        users.forEach(System.out::println);


//        MySQLConnection mySQLConnection = new MySQLConnection();
//
//        mySQLConnection.read();
//
//        User user = new User();
//        user.setEmail("user125.gmail.com");
//        user.setUserName("TestName125");
//
//        mySQLConnection.create(user);
//
//        mySQLConnection.read();

    }
}
