package ua.com.alevel;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Iehor Funtusov, created 15/12/2020 - 8:05 PM
 */

public class HibernateConnection {

    private Session session;
    private SessionFactory sessionFactory;

    public HibernateConnection() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.configure().buildSessionFactory();
    }

    public List<User> findAll() {
        Transaction transaction = null;
        try {
            this.session = this.sessionFactory.getCurrentSession();
            transaction = this.session.beginTransaction();
            String query = "FROM User";
            List<User> users = this.session.createQuery(query).list();
            transaction.commit();
            return users;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        } finally {
            this.session.close();
        }

        return null;
    }

    public List<User> findAll(int start, int max) {
        Transaction transaction = null;
        try {
            this.session = this.sessionFactory.getCurrentSession();
            transaction = this.session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.setFirstResult(start);
            criteria.setMaxResults(max);
            criteria.addOrder(Order.desc("id"));
            List<User> users = criteria.list();
            transaction.commit();
            return users;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        } finally {
            this.session.close();
        }
        return null;
    }

    public User findById(Integer id) {
        Transaction transaction = null;
        try {
            this.session = this.sessionFactory.getCurrentSession();
            transaction = this.session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            return user;
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        } finally {
            this.session.close();
        }
        return null;
    }

    public void create(User user) {
        Transaction transaction = null;
        try {
            this.session = this.sessionFactory.getCurrentSession();
            transaction = this.session.beginTransaction();
            this.session.save(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
        } finally {
            this.session.close();
        }
    }
}
