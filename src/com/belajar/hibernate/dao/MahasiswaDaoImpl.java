package com.belajar.hibernate.dao;

import com.belajar.hibernate.model.Mahasiswa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 11, 2016
 * @Time 8:12:44 PM
 * @Encoding UTF-8
 * @Project Belajar-Hibernate4IA11
 * @Package com.belajar.hibernate.dao
 *
 */
public class MahasiswaDaoImpl implements MahasiswaDao {

    private SessionFactory sessionFactory;

    public MahasiswaDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Mahasiswa> getMahasiswas() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            List<Mahasiswa> mahasiswas = session.createCriteria(Mahasiswa.class).list();
            session.getTransaction().commit();
            return mahasiswas;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void SimpanMahsiswa(Mahasiswa m) {
        // new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.save(m);
            s.getTransaction().commit();

        } catch (HibernateException e) {

            s.getTransaction().rollback();
        } finally {
            s.close();
        }

    }

    @Override
    public void updateMahasiswa(Mahasiswa mahasiswa) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Session s = sessionFactory.openSession();

        try {
            s.beginTransaction();
            s.update(mahasiswa);
            s.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
            s.getTransaction().rollback();

        } finally {
            s.close();
        }

    }

}
