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

public class Pengajuan{
    private int id;
    private Date tanggalWaktuPengajuan;
    private boolean status;

    public Pengajuan(int id, Date tanggalWaktuPengajuan) {
        this.id = id;
        this.tanggalWaktuPengajuan = tanggalWaktuPengajuan;
        this.status = false;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getTanggalWaktuPengajuan() {
        return tanggalWaktuPengajuan;
    }
    public void setTanggalWaktuPengajuan(Date tanggalWaktuPengajuan) {
        this.tanggalWaktuPengajuan = tanggalWaktuPengajuan;
    }
}
