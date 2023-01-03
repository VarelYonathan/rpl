/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ASUS
 */

import Model.Peminjam;
import Model.Pengajuan;
import Model.Ruang;
import View.HalamanStatusPengajuan;
import View.HalamanUpdatePengajuan;
import View.HalamanUtamaPeminjam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class UpdateManager {
    private ArrayList<Pengajuan> daftarPengajuan;
    private ArrayList<Ruang> daftarRuang;
    private int nim;

    public UpdateManager() {
        
    }
    
    public ArrayList<Pengajuan> getDaftarPengajuan() {
        return daftarPengajuan;
    }

    public void setDaftarPengajuan(ArrayList<Pengajuan> daftarPengajuan) {
        this.daftarPengajuan = daftarPengajuan;
    }
    
    public ArrayList<Ruang> getDaftarRuang() {
        return daftarRuang;
    }

    public void setDaftaRuang(ArrayList<Ruang> daftarRuang) {
        this.daftarRuang = daftarRuang;
    }
    public Pengajuan getForm(int idForm){
        Pengajuan form=null;
        for(int i = 0 ;i < this.daftarPengajuan.size();i++){
            if(this.daftarPengajuan.get(i).getIdPengajuan()==idForm){
                form=this.daftarPengajuan.get(i);
                break;
            }
        }
        return this.daftarPengajuan.get(idForm);
    }
    
    public boolean login(int nim, String password){
        String username = Integer.toString(nim);
        Peminjam p = new Peminjam(nim);
        if(p.login(username, password)!=0){
            this.nim=nim;
            return true;
        }else{
            return false;
        }
    }
    
    public void showHalamanUtama(){
        HalamanUtamaPeminjam.main(null, this);
    }
    
    public void showHalamanStatusPengajuan(){
        HalamanStatusPengajuan.main(null, this);
    }
    
    public void showHalamanUpdatePengajuan(int selectedRuang, int selectedPengajuan){
        HalamanUpdatePengajuan.main(null, this, selectedRuang, selectedPengajuan);
    }
    
    public ArrayList<Ruang> populateComboBoxRuang(String query){
        Ruang r = new Ruang();
        daftarRuang = r.getAllRuang(query);
        return daftarRuang;
    }
    
    public ArrayList<String> populateUpdatePengajuan(String query){
        return new Pengajuan().populateUpdate(query);
    }
    
    public ArrayList<Ruang> populateTextFieldUpdate(String query){
        return new Ruang().getAllRuang(query);
    }
    
    public ArrayList<String> getSelisihDanStatus(String query){
        return new Pengajuan().getSelisihDanStatus(query);
    }
    
    public void insertUpdatePengajuan(String query){
        new Pengajuan().insertUpdatePengajuan(query);
    }
    
    public ArrayList<Pengajuan> populateTabelStatus (String query){
        Pengajuan pengajuan = new Pengajuan();
        daftarPengajuan = pengajuan.getAllPengajuan(query);
        return daftarPengajuan;
    }
    
    public ArrayList<Ruang> populateTextFieldPengajuan(String query){
        Ruang ruang = new Ruang();
        return ruang.getAllRuang(query);
    }
    
    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

}
