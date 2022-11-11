/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */

import java.util.ArrayList;
import java.util.Date;

public class UpdateManager {
    private ArrayList<Pengajuan> daftarPengajuan;

    public UpdateManager(ArrayList<Pengajuan> daftarPengajuan) {
        this.daftarPengajuan = daftarPengajuan;
    }

    public ArrayList<Pengajuan> getDaftarPengajuan() {
        return daftarPengajuan;
    }

    public void setDaftarPengajuan(ArrayList<Pengajuan> daftarPengajuan) {
        this.daftarPengajuan = daftarPengajuan;
    }
    
    public Pengajuan getForm(int idForm){
        Pengajuan form=null;
        for(int i = 0 ;i < this.daftarPengajuan.size();i++){
            if(this.daftarPengajuan.get(i).getId()==idForm){
                form=this.daftarPengajuan.get(i);
                break;
            }
        }
        return this.daftarPengajuan.get(idForm);
    }

    public void loadUpdateForm(int idForm){

    }

    public void updatePengajuan(int idForm, String namaLembaga, Date tanggalPeminjaman, int idRuang){

    }

}
