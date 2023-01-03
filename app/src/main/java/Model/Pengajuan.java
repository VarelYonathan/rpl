/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pengajuan{
    private int idPengajuan, waktuAwalPeminjaman, waktuAkhirPeminjaman, ruang;
    private Date tanggalWaktuPengajuan;
    private String status, namaLembaga;

    public Pengajuan(int idPengajuan, int idRuang,String namaLembaga, Date tanggalWaktuPengajuan,int waktuAwalPeminjaman, int waktuAkhirPeminjaman, String status){
        this.idPengajuan=idPengajuan;
        this.ruang = idRuang;
        this.tanggalWaktuPengajuan=tanggalWaktuPengajuan;
        this.waktuAkhirPeminjaman=waktuAkhirPeminjaman;
        this.waktuAwalPeminjaman= waktuAwalPeminjaman;
        this.namaLembaga=namaLembaga;
        this.status = status;
    }

    public Pengajuan() {
        
    }
    
    public int getIdPengajuan() {
        return idPengajuan;
    }

    public int getWaktuAwalPeminjaman() {
        return waktuAwalPeminjaman;
    }

    public int getWaktuAkhirPeminjaman() {
        return waktuAkhirPeminjaman;
    }

    public Date getTanggalWaktuPengajuan() {
        return tanggalWaktuPengajuan;
    }

    public String getStatus() {
        return status;
    }

    public void setIdPengajuan(int idPengajuan) {
        this.idPengajuan = idPengajuan;
    }

    public void setWaktuAwalPeminjaman(int waktuAwalPeminjaman) {
        this.waktuAwalPeminjaman = waktuAwalPeminjaman;
    }

    public void setWaktuAkhirPeminjaman(int waktuAkhirPeminjaman) {
        this.waktuAkhirPeminjaman = waktuAkhirPeminjaman;
    }

    public void setTanggalWaktuPengajuan(Date tanggalWaktuPengajuan) {
        this.tanggalWaktuPengajuan = tanggalWaktuPengajuan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNamaLembaga() {
        return namaLembaga;
    }

    public void setNamaLembaga(String namaLembaga) {
        this.namaLembaga = namaLembaga;
    }
    
    public ArrayList<Pengajuan> getAllPengajuan(String query){
        DatabaseTools db = new DatabaseTools();
        ArrayList arr = new ArrayList<Pengajuan>();
        try {
            ResultSet rs = db.runQuery(query);
            while (rs.next()) {
                Pengajuan p = new Pengajuan(rs.getInt("idPengajuan"), rs.getInt("idRuang"), 
                        rs.getString("namaLembaga"), rs.getDate("tanggalWaktuPeminjaman"), 
                        rs.getInt("waktuAwalPeminjaman"), rs.getInt("waktuAkhirPeminjaman"), 
                        rs.getString("Status"));
                arr.add(p);
            }
            db.close();
            return arr;

        } catch (Exception e) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
            db.close();
            return null;
        }
    }
    
    public ArrayList<String> getSelisihDanStatus(String query){
        DatabaseTools db = new DatabaseTools();
        ArrayList arr = new ArrayList();
        try {
            ResultSet rs = db.runQuery(query);
            rs.next();
            arr.add(rs.getString("selisih"));
            arr.add(rs.getString("status"));
            db.close();
            return arr;

        } catch (SQLException e) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
            db.close();
            return null;
        }
    }
    
    public ArrayList<String> populateUpdate(String query){
        DatabaseTools db = new DatabaseTools();
        ArrayList arr = new ArrayList<String>();
        try {
            ResultSet rs = db.runQuery(query);
            rs.next();
            arr.add(rs.getString("namaLembaga"));
            arr.add(rs.getString("fasilitas"));
            arr.add(rs.getString("kapasitas"));
            arr.add(rs.getString("tanggalWaktuPeminjaman"));
            arr.add(rs.getString("waktuAwalPeminjaman"));
            arr.add(rs.getString("waktuAkhirPeminjaman"));
            arr.add(rs.getString("namaRuang"));
            db.close();
            return arr;
        } catch (SQLException e) {
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
            db.close();
            return null;
        }
    }
    
    public void insertUpdatePengajuan(String query){
        DatabaseTools db = new DatabaseTools();
        try{
            db.runUpdateQuery(query);
            db.close();
        }catch(Exception e){
            Logger.getLogger(Pengajuan.class.getName()).log(Level.SEVERE, null, e);
            db.close();
        }
    }
}

