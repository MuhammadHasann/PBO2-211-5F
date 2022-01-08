package pbo2.pkg5f;

import db.Database;
import libs.Pref;
import model.Barang;
import model.JenisBarang;
import model.Pengguna;
import view.LoginFrame;
import view.MainPublic;
import view.admin.BarangViewFrame;
import view.admin.JenisBarangViewFrame;
import view.admin.MainAdminFrame;
import view.kasir.MainKasirFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PenjualanDetail;
import view.kasir.PenjualanAddFrame;

public class Main {
    public static void main(String[] args) throws SQLException {
        
        Pref pref = new Pref();
        Pengguna pengguna = pref.ambil();
        
        if(pengguna.getId() == 0){
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        } else {
            if(pengguna.isIsAdmin()){
                MainAdminFrame mainAdminFrame = new MainAdminFrame();
                mainAdminFrame.setVisible(true);
            } else {
                MainKasirFrame mainKasirFrame = new MainKasirFrame();
                mainKasirFrame.setVisible(true);
            }
        }

//        BarangViewFrame barangViewFrame = new BarangViewFrame();
//        barangViewFrame.setVisible(true);       
    }
}
