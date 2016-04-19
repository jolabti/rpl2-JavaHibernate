package com.belajar.hibernate.configuration;

import com.belajar.hibernate.model.Mahasiswa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Since Mar 29, 2016
 * @Time 6:57:22 PM
 * @Encoding UTF-8
 * @Project Belajar-Hibernate
 * @Package com.rizki.mufrizal.belajar.hibernate.configuration
 *
 */
public class MahasiswaTableModel extends AbstractTableModel {

    private List<Mahasiswa> mahasiswas = new ArrayList<>();
    private final String[] HEADER = {"NPM", "Nama", "Kelas", "Jenis Kelamin"};

    public MahasiswaTableModel(List<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }

    @Override
    public int getRowCount() {
        return mahasiswas.size();
    }

    @Override
    public int getColumnCount() {
        return HEADER.length;
    }

    @Override
    public String getColumnName(int column) {
        return HEADER[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa mahasiswa = mahasiswas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getNpm();
            case 1:
                return mahasiswa.getNama();
            case 2:
                return mahasiswa.getKelas();
            case 3:
                return mahasiswa.getJenisKelamin();
            default:
                return null;
        }
    }

}
