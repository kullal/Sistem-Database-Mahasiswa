package DAO;

import Helper.KoneksiDB;
import Model.Mahasiswa;
import DAOInterface.InterfaceMahasiswa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMahasiswa implements InterfaceMahasiswa {
    Connection connection;
    final String insert = "INSERT INTO tblmahasiswa (nim, nama, jk, alamat) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE tblmahasiswa SET nim=?, nama=?, jk=?, alamat=? WHERE id=?;";
    final String delete = "DELETE FROM tblmahasiswa WHERE id=?;";
    final String select = "SELECT * FROM tblmahasiswa;";
    final String carinama = "SELECT * FROM tblmahasiswa WHERE nama LIKE ?;";

    public DAOMahasiswa() {
        connection = KoneksiDB.getConnection();
    }

    public void insert(Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJk());
            statement.setString(4, b.getAlamat());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }

            System.out.println("Berhasil Input");
        } catch (SQLException ex) {
            System.out.println("Gagal Input");
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menutup Statement");
                ex.printStackTrace();
            }
        }
    }

    public void update(Mahasiswa b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getNim());
            statement.setString(2, b.getNama());
            statement.setString(3, b.getJk());
            statement.setString(4, b.getAlamat());
            statement.setInt(5, b.getId());
            statement.executeUpdate();

            System.out.println("Berhasil Update");
        } catch (SQLException ex) {
            System.out.println("Gagal Update");
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menutup Statement");
                ex.printStackTrace();
            }
        }
    }

    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();

            System.out.println("Berhasil Delete");
        } catch (SQLException ex) {
            System.out.println("Gagal Delete");
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menutup Statement");
                ex.printStackTrace();
            }
        }
    }

    public List<Mahasiswa> getAll() {
        List<Mahasiswa> lb = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setJk(rs.getString("jk"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (st != null) st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lb;
    }

    public List<Mahasiswa> getCariNama(String nama) {
        List<Mahasiswa> lb = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            rs = st.executeQuery();

            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setId(rs.getInt("id"));
                b.setNim(rs.getString("nim"));
                b.setNama(rs.getString("nama"));
                b.setJk(rs.getString("jk"));
                b.setAlamat(rs.getString("alamat"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (st != null) st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAOMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lb;
    }
}
