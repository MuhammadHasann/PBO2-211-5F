package model;

import db.Database;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.query.JRJdbcQueryExecuter; 
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Penjualan {
    private int id;
    private String tanggal;
    private Pengguna pengguna;
    private String status;
    
    private Database database;
    private Connection connection;
    
    Database db = new Database();
    
    public boolean create(){
        String insertSQL = "INSERT INTO penjualan VALUES (?, ?, ?, ?)";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.setString(2, this.tanggal);
            preparedStatement.setInt(3, this.pengguna.getId());
            preparedStatement.setString(4, this.status);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(){
        String updateSQL = "UPDATE penjualan SET tanggal=?, idpengguna=?, status=? WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(updateSQL);
            preparedStatement.setString(1, this.tanggal);
            preparedStatement.setInt(2, this.pengguna.getId());
            preparedStatement.setString(3, this.status);
            preparedStatement.setInt(4, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(){
        String deleteSQL = "DELETE FROM penjualan WHERE id = ?";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean delete(int idPenjualan){
        String deleteSQL = "DELETE FROM penjualan WHERE id = '"+idPenjualan+"'";
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(deleteSQL);
//            preparedStatement.setInt(1, this.id);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void tampilLaporan(String laporanFile, String SQL) {
        try {
            File file = new File(laporanFile);
            JasperDesign jasDes = JRXmlLoader.load(file);
            
            JRDesignQuery sqlQuery = new JRDesignQuery();
            sqlQuery.setText(SQL);
            jasDes.setQuery(sqlQuery);

            JasperReport JR = JasperCompileManager.compileReport(jasDes);
            JasperPrint JP = JasperFillManager.fillReport(JR,null,db.getConnection());
            JasperViewer.viewReport(JP, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }
    }
    
    public ArrayList<Penjualan> read(){
        ArrayList<Penjualan> list = new ArrayList<>();
        
        String selectSQL = "SELECT J.*, G.namalengkap FROM penjualan J INNER JOIN pengguna G ON J.idpengguna = G.id" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Penjualan j = new Penjualan();
                
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getString("tanggal"));
                j.setStatus(rs.getString("status"));
                
                Pengguna g = new Pengguna();
                g.setId(rs.getInt("idpengguna"));
                g.setNamaLengkap(rs.getString("namalengkap"));
                
                j.setPengguna(g);
                
                list.add(j);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Penjualan> read(String keywords){
        ArrayList<Penjualan> list = new ArrayList<>();
        
        String selectSQL = "SELECT J.*, G.namalengkap FROM penjualan J INNER JOIN pengguna G ON J.idpengguna = G.id WHERE status=?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Penjualan j = new Penjualan();
                
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getString("tanggal"));
                j.setStatus(rs.getString("status"));
                
                Pengguna g = new Pengguna();
                g.setId(rs.getInt("idpengguna"));
                g.setNamaLengkap(rs.getString("namalengkap"));
                
                j.setPengguna(g);
                
                list.add(j);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Penjualan> search(String keywords){
        keywords = "%" + keywords + "%";
        ArrayList<Penjualan> list = new ArrayList<>();
        
        String selectSQL = "SELECT J.*, G.namalengkap FROM penjualan J INNER JOIN pengguna G ON J.idpengguna = G.id WHERE J.tanggal like ? OR G.namalengkap like ?" ;
        
        this.database = new Database();
        this.connection = this.database.getConnection();
        
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(selectSQL);
            preparedStatement.setString(1, keywords);
            preparedStatement.setString(2, keywords);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Penjualan j = new Penjualan();
                
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getString("tanggal"));
                j.setStatus(rs.getString("status"));
                
                Pengguna g = new Pengguna();
                g.setId(rs.getInt("idpengguna"));
                g.setNamaLengkap(rs.getString("namalengkap"));
                
                j.setPengguna(g);
                
                list.add(j);
            }
            
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}