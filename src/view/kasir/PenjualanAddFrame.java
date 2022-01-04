package view.kasir;

import db.Database;
import model.Barang;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Penjualan;
import model.PenjualanDetail;
import java.text.SimpleDateFormat;
import java.util.Date;
import libs.Pref;
import model.Pengguna;

public class PenjualanAddFrame extends javax.swing.JFrame {

    public PenjualanAddFrame() {        
        initComponents();
        setLocationRelativeTo(null);
        tfId.setText("NULL");
    }
    
    public void bersih() {
        tfNamaBarang.setText(null);
        tfHargaBarang.setText(null);
        tfQty.setText("0");
        tfJumlah.setText("0");
    }
    
    public String tanggal() {
        Date ys =new Date();
        SimpleDateFormat s =new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = s.format(ys);
        return tanggal;
    }
    
    public void kodeOtomatisPenjualan() {
        try {
            String SQLCode = "select * from penjualan order by id desc";
            Statement perintah = new Database().getConnection().createStatement();
            ResultSet datasetCode = perintah.executeQuery(SQLCode);
            if (datasetCode.next()) {
                String kodePrimary = datasetCode.getString("id").substring(0);
                String AN = "" + (Integer.parseInt(kodePrimary) + 1);

               tfIdPenjualan.setText(AN);
            }

        }catch(Exception e){
             System.err.println(e.toString());
        }
    }
    
    public void tampilanTablePenjualanDetail() {
        String keywords = tfAmbilid.getText();
        PenjualanDetail penjualanDetail = new PenjualanDetail();
        ArrayList<PenjualanDetail> list1 = penjualanDetail.read(keywords);
        tampilkanDataPenjualanDetail(list1);
    }
    
//    TableModel TablePenjualanDetail = this.TablePenjualanDetail;
//    this.TablePenjualanDetail = tablePenjualanDetail.getModel();

    PenjualanAddFrame(Barang barang) {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void tampilkanDataPenjualanDetail(ArrayList<PenjualanDetail> list1){
        DefaultTableModel model = (DefaultTableModel) tablePenjualanDetail.getModel();
        model.setRowCount(0);
        
        if(list1 != null){   
            Object[] row = new Object[5];
            
            for (int i = 0; i < list1.size(); i++) {
                row[0] = list1.get(i).getId();
                row[1] = list1.get(i).getBarang().getNamaBarang();
                row[2] = list1.get(i).getHargaJual();
                row[3] = list1.get(i).getJumlah();
                row[4] = list1.get(i).getHargaJual()*list1.get(i).getJumlah();
                
                model.addRow(row);
            }
            
        }
    }
    
    public void tampilkanDataBarang(ArrayList<Barang> list){
        DefaultTableModel model = (DefaultTableModel) tableBarang.getModel();
        model.setRowCount(0);
        
        if(list != null){   
            Object[] row = new Object[4];
            
            for (int i = 0; i < list.size(); i++) {
                row[0] = list.get(i).getId();
                row[1] = list.get(i).getNamaBarang();
                row[2] = list.get(i).getJenisBarang().getNamajenisbarang();
                row[3] = list.get(i).getHarga();
                
                model.addRow(row);
            }
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfHargaBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePenjualanDetail = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        tfNamaBarang = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        tfJumlah = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfAmbilid = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        tfIdPenjualan = new javax.swing.JTextField();
        tfIdBarang = new javax.swing.JTextField();
        tfId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Input Data Penjualan");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        jLabel5.setText("Nama Barang");

        tfHargaBarang.setEditable(false);
        tfHargaBarang.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfHargaBarang.setText("0");
        tfHargaBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfHargaBarangKeyTyped(evt);
            }
        });

        jLabel6.setText("Cari Barang");

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

        tablePenjualanDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Barang", "Harga", "Qty", "Jumlah"
            }
        ));
        tablePenjualanDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenjualanDetailMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePenjualanDetailMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablePenjualanDetail);
        if (tablePenjualanDetail.getColumnModel().getColumnCount() > 0) {
            tablePenjualanDetail.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Barang", "Jenis Barang", "Harga"
            }
        ));
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableBarangMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tableBarang);

        tfNamaBarang.setEditable(false);
        tfNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaBarangActionPerformed(evt);
            }
        });

        tfQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfQty.setText("0");
        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
        });

        jLabel7.setText("Harga");

        jLabel8.setText("Qty");

        btnTambah.setText("Tambahkan");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tfJumlah.setEditable(false);
        tfJumlah.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfJumlah.setText("0");
        tfJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfJumlahKeyTyped(evt);
            }
        });

        jLabel9.setText("Jumlah");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setText("Cari data dengan kata kunci");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(226, 226, 226))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTutup))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCari)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel5))
                            .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAmbilid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfAmbilid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIdPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfIdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah)
                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTutup)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        Penjualan penjualan = new Penjualan();
        JOptionPane.showMessageDialog(null, "Berhasil");
        int pilihan = JOptionPane.showConfirmDialog(null,
                "Anda ingin mencetak penjualan?",
                "Konfirmasi Cetak",
                JOptionPane.YES_NO_OPTION);

            if(pilihan == 0){
                penjualan.tampilLaporan("src/laporan/LapPenjualan.jrxml", "SELECT D.*, P.*, B.namabarang FROM detailpenjualan D INNER JOIN penjualan P ON D.idpenjualan = p.id INNER JOIN barang B ON D.idbarang = b.id WHERE D.idpenjualan='"+tfIdPenjualan.getText()+"'");
            }
        dispose();   
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void tfHargaBarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfHargaBarangKeyTyped
        char enter = evt.getKeyChar();
        if (!Character.isDigit(enter) && enter != KeyEvent.VK_PERIOD) {
            evt.consume();
        }
    }//GEN-LAST:event_tfHargaBarangKeyTyped

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        Barang barang = new Barang();
        ArrayList<Barang> list = barang.search(tfCari.getText());
        tampilkanDataBarang(list);                    
    }//GEN-LAST:event_btnCariActionPerformed

    private void tfNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaBarangActionPerformed

    private void tfQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyTyped
        char enter = evt.getKeyChar();
        if (!Character.isDigit(enter) && enter != KeyEvent.VK_PERIOD) {
            evt.consume();
        }
    }//GEN-LAST:event_tfQtyKeyTyped

    private void tfJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfJumlahKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJumlahKeyTyped

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Barang barang = new Barang();
        ArrayList<Barang> list = barang.read();
        tampilkanDataBarang(list);                    
        
        tfAmbilid.hide();
        tfIdPenjualan.hide();
        tfIdBarang.hide();
        tfId.hide();
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_formWindowActivated

    private void tableBarangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseReleased
        TableModel model = tableBarang.getModel();
        int barisTerpilih = tableBarang.getSelectedRow();

        if(barisTerpilih >= 0){
           
            String idBarang = model.getValueAt(barisTerpilih,0).toString();
            String namaBarang = model.getValueAt(barisTerpilih,1).toString();
            String hargaBarang = model.getValueAt(barisTerpilih,3).toString();
            
            tfIdBarang.setText(idBarang);
            tfNamaBarang.setText(namaBarang);
            tfHargaBarang.setText(hargaBarang);
        } 
    }//GEN-LAST:event_tableBarangMouseReleased

    private void tfQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyReleased
        double harga = Float.parseFloat(tfHargaBarang.getText());
        double qty = Float.parseFloat(tfQty.getText());
        
        double total = harga * qty;
        
        tfJumlah.setText(String.valueOf(total));
    }//GEN-LAST:event_tfQtyKeyReleased

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        Penjualan penjualan = new Penjualan();
        penjualan.setId(Integer.parseInt(tfIdPenjualan.getText()));
        
        Barang barang = new Barang();
        barang.setId(Integer.parseInt(tfIdBarang.getText()));
        
        PenjualanDetail pd = new PenjualanDetail();
        pd.setPenjualan(penjualan);
        pd.setBarang(barang);
        pd.setHargaJual(Float.parseFloat(tfHargaBarang.getText()));
        pd.setJumlah((int) Float.parseFloat(tfQty.getText())); 
        
        Pref pref = new Pref();
        Pengguna pengguna = pref.ambil();
        pengguna.getNamaLengkap();

        penjualan.setId(Integer.parseInt(tfIdPenjualan.getText()));
        penjualan.setTanggal(tanggal());
        penjualan.setPengguna(pengguna);
        penjualan.setStatus("SELESAI");
        penjualan.create();
        
        pd.create();
        String keywords = tfIdPenjualan.getText();
        PenjualanDetail penjualanDetail = new PenjualanDetail();
        ArrayList<PenjualanDetail> list1 = penjualanDetail.read(keywords);
        tampilkanDataPenjualanDetail(list1);
        JOptionPane.showMessageDialog(null, "Berhasil");
        bersih();
        
        int idPenjualan =  Integer.parseInt(tfIdPenjualan.getText()) + 1;
        penjualan.delete(idPenjualan);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        TableModel model = tablePenjualanDetail.getModel();
        int barisTerpilih = tablePenjualanDetail.getSelectedRow();

        if(barisTerpilih >= 0){
            int pilihan = JOptionPane.showConfirmDialog(null,
                "Yakin hapus?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

            if(pilihan == 0){
                PenjualanDetail penjualanDetail = new PenjualanDetail();
                String idTable = model.getValueAt(barisTerpilih,0).toString();
                int idInt = Integer.parseInt(idTable);
                penjualanDetail.setId(idInt);
                penjualanDetail.delete();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Pilih data terlebih dahulu");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tablePenjualanDetailMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenjualanDetailMouseReleased
        
    }//GEN-LAST:event_tablePenjualanDetailMouseReleased

    private void tablePenjualanDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenjualanDetailMouseClicked
        btnHapus.setEnabled(true);
    }//GEN-LAST:event_tablePenjualanDetailMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(PenjualanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanAddFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanAddFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTable tablePenjualanDetail;
    public javax.swing.JTextField tfAmbilid;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfHargaBarang;
    public javax.swing.JTextField tfId;
    public javax.swing.JTextField tfIdBarang;
    public javax.swing.JTextField tfIdPenjualan;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfNamaBarang;
    private javax.swing.JTextField tfQty;
    // End of variables declaration//GEN-END:variables
}
