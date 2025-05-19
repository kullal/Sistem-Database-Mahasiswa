/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;

import DAO.DAOMahasiswa;
import DAOInterface.InterfaceMahasiswa;
import Model.Mahasiswa;
import Model.TabelModelMahasiswa;
import View.FormMahasiswa;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMahasiswa {
    FormMahasiswa frame;
    InterfaceMahasiswa implMahasiswa;
    List<Mahasiswa> lb;

    public ControllerMahasiswa(FormMahasiswa frame) {
        this.frame = frame;
        implMahasiswa = new DAOMahasiswa();
        lb = implMahasiswa.getAll();
    }

    // mengosongkan field
    public void reset() {
        frame.getTxtID().setText("");
        frame.getTxtNim().setText("");
        frame.getTxtNama().setText("");
        frame.getSetJK().setSelectedItem("");
        frame.getTxtAlamat().setText("");
    }

    // menampilkan data ke dalam tabel
    public void isiTable() {
        lb = implMahasiswa.getAll();
        TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }

    // merupakan fungsi untuk menampilkan data yang dipilih
    public void isiField(int row) {
        if (row >= 0 && row < lb.size()) {
            Mahasiswa mhs = lb.get(row);
            frame.getTxtID().setText(mhs.getId().toString());
            frame.getTxtNim().setText(mhs.getNim());
            frame.getTxtNama().setText(mhs.getNama());
            frame.getSetJK().setSelectedItem(mhs.getJk());
            frame.getTxtAlamat().setText(mhs.getAlamat());
    }
    }

    // merupakan fungsi untuk insert data berdasarkan inputan user dari textfield di frame
    public void insert() {
        if (!frame.getTxtNim().getText().trim().isEmpty() && 
            !frame.getTxtNama().getText().trim().isEmpty()) {
            
            Mahasiswa b = new Mahasiswa();
            b.setNim(frame.getTxtNim().getText());
            b.setNama(frame.getTxtNama().getText());
            b.setJk(frame.getSetJK().getSelectedItem().toString());
            b.setAlamat(frame.getTxtAlamat().getText());
            
            implMahasiswa.insert(b);
            JOptionPane.showMessageDialog(null, "Simpan Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }

    // berfungsi untuk update data berdasarkan inputan user dari textfield di frame
    public void update() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            Mahasiswa b = new Mahasiswa();
            b.setNim(frame.getTxtNim().getText());
            b.setNama(frame.getTxtNama().getText());
            b.setJk(frame.getSetJK().getSelectedItem().toString());
            b.setAlamat(frame.getTxtAlamat().getText());
            b.setId(Integer.parseInt(frame.getTxtID().getText()));
            
            implMahasiswa.update(b);
            JOptionPane.showMessageDialog(null, "Update Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }

    // berfungsi menghapus data yang dipilih
    public void delete() {
        if (!frame.getTxtID().getText().trim().isEmpty()) {
            int id = Integer.parseInt(frame.getTxtID().getText());
            implMahasiswa.delete(id);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }

    public void isiTableCariNama() {
        lb = implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
        TabelModelMahasiswa tmb = new TabelModelMahasiswa(lb);
        frame.getTabelData().setModel(tmb);
    }

    public void carinama() {
        if (!frame.getTxtCariNama().getText().trim().isEmpty()) {
            implMahasiswa.getCariNama(frame.getTxtCariNama().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}

