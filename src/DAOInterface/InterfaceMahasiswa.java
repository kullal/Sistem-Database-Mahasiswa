/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOInterface;
import java.util.List;
import Model.Mahasiswa;
/**
 *
 * @author EVA-01
 */
public interface InterfaceMahasiswa {
    public void insert(Mahasiswa b);
    public void update(Mahasiswa b);
    public void delete(int id);
    public List<Mahasiswa> getAll();
    public List<Mahasiswa> getCariNama(String nama);
}  
