/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Ruang {
    private int idRuang, kapasitas;
    private String namaRuang, fasilitas;

    public Ruang(int idRuang, int kapasitas, String namaRuang, String fasilitas){
        this.idRuang = idRuang;
        this.kapasitas=kapasitas;
        this.namaRuang=namaRuang;
        this.fasilitas=fasilitas;
    }

    public Ruang() {
        
    }
    public int getIdRuang() {
        return idRuang;
    }
    public void setIdRuang(int idRuang) {
        this.idRuang = idRuang;
    }
    public int getKapasitas() {
        return kapasitas;
    }
    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
    public String getNamaRuang() {
        return namaRuang;
    }
    public void setNamaRuang(String namaRuang) {
        this.namaRuang = namaRuang;
    }
    public String getFasilitas() {
        return fasilitas;
    }
    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }
    
    public ArrayList<Ruang> getAllRuang(String query){
        DatabaseTools db = new DatabaseTools();
        ArrayList arr = new ArrayList<Ruang>();
        try {
            ResultSet rs = db.runQuery(query);
            while (rs.next()) {
                int selectedRuang=rs.getInt("idRuang");
                String nama =rs.getString("namaRuang");
                int kapasitas = rs.getInt("kapasitas");
                String fasilitas = rs.getString("fasilitas");
                arr.add(new Ruang(selectedRuang, kapasitas, nama, fasilitas));
            }
            db.close();
            return arr;

        } catch (Exception e) {
            db.close();
            return null;
        }
    }
}
