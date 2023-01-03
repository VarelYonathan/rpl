/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.UpdateManager;
import Model.DatabaseTools;
import Model.Pengajuan;
import Model.Ruang;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class HalamanStatusPengajuan extends javax.swing.JFrame {

    /**
     * Creates new form HalamanUpdatePengajuan
     */
    
//    private String nim;
    private UpdateManager updateManager;
    private int selectedRuang;
    private int selectedPengajuan;
    public HalamanStatusPengajuan(UpdateManager updateManager) {
        this.updateManager = updateManager;
        initComponents();
        
        populateTabelStatus();
        
        ListSelectionModel modelTabelProduk = tableDaftarStatusPengajuan.getSelectionModel();
        modelTabelProduk.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!modelTabelProduk.isSelectionEmpty()) {
                    int index = modelTabelProduk.getMinSelectionIndex();
                    selectedPengajuan = Integer.parseInt(tableDaftarStatusPengajuan.getModel().getValueAt(index, 1).toString());
                    
                    String query=String.format("select * from pengajuan join peminjam on pengajuan.nim = peminjam.nim join ruang on pengajuan.idRuang = ruang.idRuang where idPengajuan = %s",selectedPengajuan);
                    
                    ArrayList<Ruang> arr = updateManager.populateTextFieldPengajuan(query);
                    int n = 0;
                    for(int i=0;i<updateManager.getDaftarPengajuan().size();i++){
                        if(updateManager.getDaftarPengajuan().get(i).getIdPengajuan()==selectedPengajuan){
                            n=i;
                            break;
                        }
                    }
                    if(arr!=null){
                        selectedRuang=arr.get(0).getIdRuang();
                        tfNamaLembaga.setText(updateManager.getDaftarPengajuan().get(n).getNamaLembaga());
                        tfNamaRuang.setText(arr.get(0).getNamaRuang());
                        tfKapasitas.setText(Integer.toString(arr.get(0).getKapasitas()));
                        tfFasilitas.setText(arr.get(0).getFasilitas());
                    }
                }
            }
        });
    }
    
    private void populateTabelStatus(){
        String query = String.format("select * from pengajuan where nim = '%s'",this.updateManager.getNim());
        ArrayList<Pengajuan> arr = updateManager.populateTabelStatus(query);
        if(arr!=null){
            DefaultTableModel tableModel = (DefaultTableModel)tableDaftarStatusPengajuan.getModel();
            tableModel.setRowCount(0);
            System.out.println(arr.size());
            int i=0;
            for(Pengajuan p : arr){
                tableModel.addRow(new Object[] {
                    ++i,
                    p.getIdPengajuan(),
                    p.getStatus(),
                    p.getTanggalWaktuPengajuan(),
                    p.getWaktuAwalPeminjaman(),
                    p.getWaktuAkhirPeminjaman()
                });
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ada error saat mengisi daftar status pengajuan");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDaftarStatusPengajuan = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNamaLembaga = new javax.swing.JTextField();
        tfNamaRuang = new javax.swing.JTextField();
        tfKapasitas = new javax.swing.JTextField();
        tfFasilitas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableDaftarStatusPengajuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nomor", "Id", "Status Pengajuan", "Tanggal", "Waktu Mulai", "Waktu Selesai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDaftarStatusPengajuan);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Lembaga");

        jLabel2.setText("Nama Ruang");

        jLabel3.setText("Kapasitas");

        jLabel4.setText("Fasilitas");

        tfNamaLembaga.setEditable(false);
        tfNamaLembaga.setText("----");
        tfNamaLembaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaLembagaActionPerformed(evt);
            }
        });

        tfNamaRuang.setEditable(false);
        tfNamaRuang.setText("----");
        tfNamaRuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaRuangActionPerformed(evt);
            }
        });

        tfKapasitas.setEditable(false);
        tfKapasitas.setText("----");

        tfFasilitas.setEditable(false);
        tfFasilitas.setText("----");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNamaLembaga)
                                    .addComponent(tfNamaRuang)
                                    .addComponent(tfKapasitas)
                                    .addComponent(tfFasilitas)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 493, Short.MAX_VALUE)
                                .addComponent(btnBack)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfNamaLembaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfNamaRuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfKapasitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addContainerGap(26, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfFasilitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        updateManager.showHalamanUtama();;
        this.hide();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfNamaLembagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaLembagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaLembagaActionPerformed

    private void tfNamaRuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaRuangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaRuangActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        String query = String.format("select (tanggalWaktuPeminjaman-CURRENT_DATE) as selisih, status from pengajuan where idPengajuan = %s",this.selectedPengajuan);
        try{
            ArrayList<String> arr = updateManager.getSelisihDanStatus(query);
            if(arr.get(1).equals("Sudah disetujui")){
                JOptionPane.showMessageDialog(null, "Pengajuan sudah disetujui");
            }else if(Integer.parseInt(arr.get(0))<1){
                JOptionPane.showMessageDialog(null, "Pengajuan tidak dapat dimodifikasi kurang dari 5 hari sebelum pelaksanaan");
            }else{
                updateManager.showHalamanUpdatePengajuan(selectedRuang,selectedPengajuan);
                this.hide();
            }
        }catch(Exception e){
            Logger.getLogger(HalamanStatusPengajuan.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Ada error saat melakukan update");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[], UpdateManager updateManager) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HalamanStatusPengajuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HalamanStatusPengajuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HalamanStatusPengajuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HalamanStatusPengajuan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HalamanStatusPengajuan(updateManager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDaftarStatusPengajuan;
    private javax.swing.JTextField tfFasilitas;
    private javax.swing.JTextField tfKapasitas;
    private javax.swing.JTextField tfNamaLembaga;
    private javax.swing.JTextField tfNamaRuang;
    // End of variables declaration//GEN-END:variables
}
