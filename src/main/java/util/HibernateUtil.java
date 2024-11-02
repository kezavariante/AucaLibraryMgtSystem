package util;

import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Person;
import model.User;
import model.Location;
import model.Membership;
import model.MembershipType;
import model.Book;
import model.Shelf;
import model.Room;
import model.Borrower;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    // Initialize the SessionFactory only once
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration conf = new Configuration();

            // Hibernate settings equivalent to hibernate.cfg.xml properties
            Properties settings = new Properties();
            settings.setProperty(Environment.DRIVER, "org.postgresql.Driver");
            settings.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/auca_library_db");
            settings.setProperty(Environment.USER, "postgres");
            settings.setProperty(Environment.PASS, "1234");
            settings.setProperty(Environment.HBM2DDL_AUTO, "update");
            settings.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            settings.setProperty(Environment.SHOW_SQL, "true");

            // Apply settings to configuration
            conf.setProperties(settings);

            // Add annotated entity classes
            conf.addAnnotatedClass(Person.class);
            conf.addAnnotatedClass(User.class);
            conf.addAnnotatedClass(Location.class);
            conf.addAnnotatedClass(Membership.class);
            conf.addAnnotatedClass(MembershipType.class);
            conf.addAnnotatedClass(Book.class);
            conf.addAnnotatedClass(Shelf.class);
            conf.addAnnotatedClass(Room.class);
            conf.addAnnotatedClass(Borrower.class);

            // Build the ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();

            // Build session factory
            return conf.buildSessionFactory(serviceRegistry);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("SessionFactory initialization failed.");
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}