package com.belajar.hibernate.controller;

import com.belajar.hibernate.configuration.HibernateUtil;
import com.belajar.hibernate.dao.MahasiswaDao;
import com.belajar.hibernate.view.MahasiswaView;
import com.belajar.hibernate.configuration.MahasiswaTableModel;
import com.belajar.hibernate.model.JenisKelamin;
import com.belajar.hibernate.model.Mahasiswa;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Apr 11, 2016
 * @Time 8:14:28 PM
 * @Encoding UTF-8
 * @Project Belajar-Hibernate4IA11
 * @Package com.belajar.hibernate.controller
 *
 */
public class MahasiswaController {

    private MahasiswaView mahasiswaView;
    private MahasiswaTableModel mahasiswaTableModel;
    private MahasiswaDao mahasiswaDao = HibernateUtil.getMahasiswaDao();

    public MahasiswaController(MahasiswaView mahasiswaView) {
        this.mahasiswaView = mahasiswaView;
    }

    public void tampilMahasiswa() {
        mahasiswaTableModel = new MahasiswaTableModel(mahasiswaDao.getMahasiswas());
        this.mahasiswaView.getTabelMahasiswa().setModel(mahasiswaTableModel);
    }

    public void SimpanMhs() {

        Mahasiswa m = new Mahasiswa();

        m.setNpm(this.mahasiswaView.getNpm().getText());
        m.setNama(this.mahasiswaView.getNama().getText());
        m.setKelas(this.mahasiswaView.getKelas().getText());
        m.setJenisKelamin(JenisKelamin.valueOf(this.mahasiswaView.getJenisKelamin().getSelectedItem().toString()));

        mahasiswaDao.SimpanMahsiswa(m);
        tampilMahasiswa();

    }

    public void detailMahasiswa() {

        int index = this.mahasiswaView.getTabelMahasiswa().getSelectedRow();
        this.mahasiswaView.getNpm().setText((String) this.mahasiswaView.getTabelMahasiswa().getValueAt(index, 0));
        this.mahasiswaView.getNama().setText((String) this.mahasiswaView.getTabelMahasiswa().getValueAt(index, 1));
        this.mahasiswaView.getKelas().setText((String) this.mahasiswaView.getTabelMahasiswa().getValueAt(index, 2));

        this.mahasiswaView.getJenisKelamin().setSelectedItem(this.mahasiswaView.getTabelMahasiswa().getValueAt(index, 3));

    }

    public void updateMahasiswa() {

        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setNpm(this.mahasiswaView.getNpm().getText());
        mahasiswa.setNama(this.mahasiswaView.getNama().getText());
        mahasiswa.setKelas(this.mahasiswaView.getKelas().getText());
        mahasiswa.setJenisKelamin(JenisKelamin.valueOf(this.mahasiswaView.getJenisKelamin().getSelectedItem().toString()));
        mahasiswaDao.updateMahasiswa(mahasiswa);
        tampilMahasiswa();

    }
    
    public void deleteMahasiswa(){
         
        String npm= this.mahasiswaView.getNpm().getText();
        
        Mahasiswa m = mahasiswaDao.getMahasiswa(npm);
        
        if (m!=null)
        {
            mahasiswaDao.hapusMahasiswa(m);
            tampilMahasiswa();
        }
       
        
        tampilMahasiswa();
    
    }

    public void clearForm() {

        this.mahasiswaView.getNpm().setText("");
        this.mahasiswaView.getNama().setText("");
        //this.mahasiswaView.getJenisBarang().setText("");
        this.mahasiswaView.getKelas().setText("");

    }
}
