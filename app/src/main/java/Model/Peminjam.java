/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.HalamanUtamaPeminjam;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Peminjam {
    private int nim;
    private String nama, email;
    public Peminjam(int nim, String nama, String email ){
        this.nim=nim;
        this.nama=nama;
        this.email=email;
        
    }

    public Peminjam(int nim) {
        this.nim = nim;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int login(String username, String password){
        String query=String.format("select * from peminjam where nim= '%s' and password= '%s'",username,password);
        DatabaseTools db = new DatabaseTools();
        try {
            ResultSet rs = db.runQuery(query);
            rs.next();
            if (username.equals(rs.getString("nim")) && password.equals(rs.getString("password"))) {
                db.close();
                return nim;
            } else {
                db.close();
                return 0;
            }
        } catch (SQLException ex) {
            db.close();
            return 0;
        }
    }
}
