package com.belajar.hibernate.configuration;

import com.belajar.hibernate.dao.MahasiswaDao;
import com.belajar.hibernate.dao.MahasiswaDaoImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rizki Mufrizal <mufrizalrizki@gmail.com>
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final MahasiswaDao MAHASISWA_DAO;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            MAHASISWA_DAO = new MahasiswaDaoImpl(sessionFactory);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @return the MAHASISWA_INTERFACE
     */
    public static MahasiswaDao getMahasiswaDao() {
        return MAHASISWA_DAO;
    }
}
