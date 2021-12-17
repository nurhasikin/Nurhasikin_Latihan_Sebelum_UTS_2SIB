package Latihan_Before_UTS;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class createDB_Penjualan {

    // JDBC driver name dan database URL

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    //  pemberian nama user dan pass pada database
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        //Deklarasi variabel dari java.sql
        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Daftarkan JDBC driver
            Class.forName("com.mysql.jdbc.Driver"); //driver JDBC

            //STEP 3: Koneksi ke database
            System.out.println("Koneksi ke database...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/",
                    "root", "");

            //STEP 4: tambahkan ke Query
            System.out.println("Membuat database...");
            stmt = conn.createStatement();

            //STEP 5 : membuat database
            String sql = "CREATE DATABASE daftarbarangg";
            stmt.executeUpdate(sql);

            System.out.println("Database berhasil dibuat...");

                //membuat table pada database yang dibuat
            //STEP 1: mengkoneksikan database yang telah dibuat diatas
            System.out.println("Sedang koneksi ke database yang "
                    + "terpilih...");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306"
                    + "/daftarbarang", "root", "");
            System.out.println("Koneksi ke database berhasil...");

            //STEP 2: Tambahkan ke Query
            System.out.println("Membuat Table pada Database...");
            stmt = conn.createStatement();

            //STEP 3: Membuat Field-Field pada Table barang
            String tab = "CREATE TABLE barang "
                    + "(ID_Barang INTEGER not NULL, "
                    + //Field id barnang type Integer
                    " Nama_Barang VARCHAR(255), "
                    + //field nama barang type VARCHAR Lenght 255
                    " Merk VARCHAR(255), "
                    + //field merk type Varchar lenght 255
                    " Stok INTEGER, "
                    + //field stok type integez
                    " Harga INTEGER, " +//field harga type integez
                    " PRIMARY KEY ( ID_Barang ))";
//id barang sebagai Primary Key

            stmt.executeUpdate(tab);
            System.out.println("Table berhasil dibuat pada "
                    + "database yang terpilih...");

        } catch (SQLException se) {
            //Menangani kesalahan untuk JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Menangani kesalahan pada Class.forName
            e.printStackTrace();
        } finally {
            //akhir dari program yang digunakan
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Selesai");
    }
}
