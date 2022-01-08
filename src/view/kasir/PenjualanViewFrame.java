package view.kasir;

import model.Barang;
import model.JenisBarang;
import model.Penjualan;
import view.admin.BarangAddFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.PenjualanDetail;

public class PenjualanViewFrame extends javax.swing.JFrame {

    public PenjualanViewFrame() {
        initComponents();
        setLocationRelativeTo(null);
        
        Penjualan penjualan = new Penjualan();
        ArrayList<Penjualan> list = penjualan.read();
        tampilkanDataPenjualan(list);
    }
    
    public void tampilkanDataPenjualan(ArrayList<Penjualan> list){
        DefaultTableModel model = (DefaultTableModel) tablePenjualan.getModel();
        model.setRowCount(0);
        
        if(list != null){   
            Object[] row = new Object[4];
            
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getTanggal();
                row[2] = list.get(i).getPengguna().getNamaLengkap();
                row[3] = list.get(i).getStatus();
                
                model.addRow(row);
            }
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualan = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cari Tanggal");

        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Data Penjualan");

        tablePenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tanggal", "Nama Kasir", "Status"
            }
        ));
        tablePenjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePenjualanMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablePenjualan);
        if (tablePenjualan.getColumnModel().getColumnCount() > 0) {
            tablePenjualan.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTutup)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTambah)
                        .addComponent(btnUbah)
                        .addComponent(btnHapus)
                        .addComponent(btnBatal)
                        .addComponent(btnCetak))
                    .addComponent(btnTutup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Penjualan penjualan = new Penjualan();
        ArrayList<Penjualan> list = penjualan.search(tfCari.getText());
        tampilkanData(list);
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        PenjualanAddFrame penjualanAddFrame = new PenjualanAddFrame();
        penjualanAddFrame.setVisible(true);
        penjualanAddFrame.kodeOtomatisPenjualan();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        TableModel model = tablePenjualan.getModel();
        int barisTerpilih = tablePenjualan.getSelectedRow();

        if(barisTerpilih >= 0){
            Penjualan penjualan = new Penjualan();
            String idTable = model.getValueAt(barisTerpilih,0).toString();
            
            int idInt = Integer.parseInt(idTable);
            penjualan.setId(idInt);
            
            PenjualanAddFrame paf = new PenjualanAddFrame();
            paf.tfAmbilid.setText(idTable);
            paf.tfIdPenjualan.setText(idTable);
            paf.tampilanTablePenjualanDetail();
            paf.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        TableModel model = tablePenjualan.getModel();
        int barisTerpilih = tablePenjualan.getSelectedRow();

        if(barisTerpilih >= 0){
            int pilihan = JOptionPane.showConfirmDialog(null,
                "Yakin hapus?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

            if(pilihan == 0){
                Penjualan penjualan = new Penjualan();
                String idTable = model.getValueAt(barisTerpilih,0).toString();
                int idInt = Integer.parseInt(idTable);
                penjualan.setId(idInt);
                penjualan.delete();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        Penjualan penjualan = new Penjualan();
        ArrayList<Penjualan> list = penjualan.read();
        tampilkanData(list);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
//        dododo
    }//GEN-LAST:event_formWindowActivated

    private void tablePenjualanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenjualanMouseReleased
        
    }//GEN-LAST:event_tablePenjualanMouseReleased

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        TableModel model = tablePenjualan.getModel();
        int barisTerpilih = tablePenjualan.getSelectedRow();
        
        if(barisTerpilih >= 0){
            Penjualan penjualan = new Penjualan();
            String idTable = model.getValueAt(barisTerpilih,0).toString();
            
            penjualan.tampilLaporan("src/laporan/LapPenjualan.jrxml", "SELECT D.*, P.*, B.namabarang FROM detailpenjualan D INNER JOIN penjualan P ON D.idpenjualan = p.id INNER JOIN barang B ON D.idbarang = b.id WHERE D.idpenjualan='"+idTable+"'");
        } else {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnCetakActionPerformed
   
    public void tampilkanData(ArrayList<Penjualan> list){
        DefaultTableModel model = (DefaultTableModel) tablePenjualan.getModel();
        model.setRowCount(0);
        
        if(list != null){   
            Object[] row = new Object[4];
            
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getTanggal();
                row[2] = list.get(i).getPengguna().getNamaLengkap();
                row[3] = list.get(i).getStatus();
                
                model.addRow(row);
            }
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(PenjualanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanViewFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanViewFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablePenjualan;
    private javax.swing.JTextField tfCari;
    // End of variables declaration//GEN-END:variables
}
