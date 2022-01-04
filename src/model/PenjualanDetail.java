package model;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.kasir.PenjualanAddFrame;

public class PenjualanDetail {
    private int id;
    private Penjualan penjualan;
    private Barang barang;
    private double hargaJual;
    private int jumlah;
    
    private Database database;
    private Connection connection;
    
    public boolean create(){
        String insertSQL = "INSERT INTO detailpenjualan VALUES (NULL, ?, ?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.penjualan.getId());
            preparedStatement.setInt(2, this.barang.getId());
            preparedStatement.setDouble(3, this.hargaJual);
            preparedStatement.setInt(4, this.jumlah);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(){
        String updateSQL = "UPDATE detailpenjualan SET idpenjualan=?, idbarang=?, hargajual=?, jumlah=? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setInt(1, this.penjualan.getId());
            preparedStatement.setInt(2, this.barang.getId());
            preparedStatement.setDouble(3, this.hargaJual);
            preparedStatement.setInt(4, this.jumlah);
            preparedStatement.setInt(5, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM detailpenjualan WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean ifelse(int idPenjualan, int idPenjualan1) {
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            String query = "select id from penjualan where id = '"+idPenjualan1+"'";
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int i = idPenjualan;

            while (rs.next()) {
                if (i != rs.getInt(1)) {
                    new Penjualan().create();
                    
                    create();
                    String keywords = String.valueOf(idPenjualan);
                    PenjualanDetail penjualanDetail = new PenjualanDetail();
                    ArrayList<PenjualanDetail> list1 = penjualanDetail.read(keywords);
                    new PenjualanAddFrame().tampilkanDataPenjualanDetail(list1);

                    JOptionPane.showMessageDialog(null, "Berhasil insert data");
                    new PenjualanAddFrame().bersih();
                    break;
                } else {
                    

                    create();
                    String keywords = String.valueOf(idPenjualan);
                    PenjualanDetail penjualanDetail = new PenjualanDetail();
                    ArrayList<PenjualanDetail> list1 = penjualanDetail.read(keywords);
                    new PenjualanAddFrame().tampilkanDataPenjualanDetail(list1);



                    JOptionPane.showMessageDialog(null, "Berhasil");
                    new PenjualanAddFrame().bersih();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<PenjualanDetail> read(String keywords){
        ArrayList<PenjualanDetail> list = new ArrayList<>();
        
        String selectSQL = "SELECT D.*, P.*, B.namabarang FROM detailpenjualan D INNER JOIN penjualan P ON D.idpenjualan = p.id INNER JOIN barang B ON D.idbarang = b.id Where D.idpenjualan=?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                PenjualanDetail pd = new PenjualanDetail();
                
                pd.setId(rs.getInt("id"));
                pd.setHargaJual(rs.getDouble("hargajual"));
                pd.setJumlah(rs.getInt("jumlah"));
                
                Penjualan p = new Penjualan();
                p.setId(rs.getInt("idpenjualan"));
                p.setTanggal(rs.getString("tanggal"));
                p.setStatus(rs.getString("status"));
                
                pd.setPenjualan(p);
                
                Barang b = new Barang();
                b.setId(rs.getInt("id"));
                b.setNamaBarang(rs.getString("namabarang"));
                
                pd.setBarang(b);
                
                list.add(pd);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<PenjualanDetail> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<PenjualanDetail> list = new ArrayList<>();
        
        String selectSQL = "SELECT D.*, P.*, B.* FROM detailpenjualan D INNER JOIN penjualan P ON D.idpenjualan = p.id INNER JOIN barang B ON D.idbarang = b.id WHERE P.tanggal like ? OR B.namabarang like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                PenjualanDetail pd = new PenjualanDetail();
                
                pd.setId(rs.getInt("id"));
                pd.setHargaJual(rs.getDouble("hargajual"));
                pd.setJumlah(rs.getInt("jumlah"));
                
                Penjualan p = new Penjualan();
                p.setId(rs.getInt("idpenjualan"));
                p.setTanggal(rs.getString("tanggal"));
                p.setStatus(rs.getString("status"));
                
                pd.setPenjualan(p);
                
                Barang b = new Barang();
                b.setId(rs.getInt("id"));
                b.setNamaBarang(rs.getString("namabarang"));
                b.setHarga(rs.getDouble("harga"));
                
                pd.setBarang(b);
                
                list.add(pd);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public double getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(double hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    
}
