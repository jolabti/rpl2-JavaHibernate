package com.belajar.hibernate.dao;

import com.belajar.hibernate.model.Mahasiswa;
import java.util.List;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 11, 2016
 * @Time 8:12:03 PM
 * @Encoding UTF-8
 * @Project Belajar-Hibernate4IA11
 * @Package com.belajar.hibernate.dao
 *
 */
public interface MahasiswaDao {

    public List<Mahasiswa> getMahasiswas();
    public void SimpanMahsiswa(Mahasiswa m);
    
    public void updateMahasiswa(Mahasiswa mahasiswa);
}
