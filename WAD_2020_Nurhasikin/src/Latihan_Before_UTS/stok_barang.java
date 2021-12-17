package Latihan_Before_UTS;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class stok_barang extends javax.swing.JFrame {
        private Connection con;
        private Statement stat;
        private ResultSet res;
   
        public stok_barang()
        {
            setTitle("DAFTAR BARANG PENJUALAN MINIMARKET"); //Title pada aplikasi
         
            //membuat layout tampil di tengah pada saat di tampilkan
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = getSize();
            setLocation(
            (screenSize.width - frameSize.width) / 2,
            (screenSize.height - frameSize.height) / 2);
           
            Tampilan(); //memanggil public void Tampilan();
            koneksi();//memanggil public void Koneksi();
            tabel();//memanggil public void Tabel();
        }
       
        public void koneksi() //mengkoneksikan aplikasi dengan database barang
        {
           try {
               Class.forName("com.mysql.jdbc.Driver");//driver JDBC
               con=DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/daftarbarang", "root", "");
                //Lokasi dari database
               stat=con.createStatement();
            }
            catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
   
        private void kosongkan() 
//variabel kosongkan untuk menghapus data yang diinput pada :
        {
            id.setText(""); //JTextField id barang
            nama.setText(""); //JTextField Nama
            merk.setText(""); //JTextField merk
            stok.setText(""); //JTextField stok
            hrg.setText(""); //JTextField harga
            id.requestFocus(); //kursor kembali ke JTextField ID Barang
        }
     
        public void tabel(){
            DefaultTableModel tb = new DefaultTableModel ();
            tb.addColumn("ID Barang"); //tambahkan ID Barang pada kolom tabel
            tb.addColumn("Nama Barang"); //tambahkan Nama pada kolom tabel
            tb.addColumn("Merk"); //tambahkan Merk pada kolom tabel
            tb.addColumn("Stok"); //tambahkan stok pada kolom tabel
            tb.addColumn("Harga"); //tambahkan harga pada kolom tabel
            //tambahkan Stok pada kolom tabel
            tbl.setModel(tb);
           
            try { res=stat.executeQuery("select * from barang");
                while (res.next()) {
                    tb.addRow(new Object[]{ res.getString("ID_Barang"),
                        res.getString("Nama_Barang"),
                        res.getString("Merk"),
                        res.getString("Stok"),
                        res.getString("Harga")
                    }  );
                }
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
                               
        private void Tampilan()
        {
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            id= new javax.swing.JTextField();
            nama= new javax.swing.JTextField();
            merk= new javax.swing.JTextField();
            stok= new javax.swing.JTextField();
            hrg= new javax.swing.JTextField();
            Cari = new javax.swing.JButton();
            Reset = new javax.swing.JButton();
            Simpan = new javax.swing.JButton();
            Hapus = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tbl = new javax.swing.JTable();
            Ganti = new javax.swing.JButton();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
           
 
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
            jLabel1.setText("ID Barang");
            jLabel2.setText("Nama Barang");
            jLabel3.setText("Merk");
            jLabel4.setText("Stok");
            jLabel8.setText("Harga");
           
            Cari.setText("Cari");
            Cari.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariActionPerformed(evt);
            }
        }
        );
 
            Reset.setText("Reset");
            Reset.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        }
        );
 
            Simpan.setText("Simpan");
            Simpan.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt){
                SimpanActionPerformed(evt);
            }
        }
        );
 
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        }
        );
 
        tbl.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbl);
 
        Ganti.setText("Ganti");
        Ganti.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GantiActionPerformed(evt);
            }
        }
        );
 
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("APLIKASI DESKTOP MINIMARKET");
 
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("DAFTAR STOK BARANG");
 
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("WAD / 2020");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.
                    LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                    layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.
                        Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.
                            DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, 
                            layout.createParallelGroup(javax.swing.
                                    GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Simpan)
                            .addPreferredGap(javax.swing.LayoutStyle.
                                    ComponentPlacement.UNRELATED)
                            .addComponent(Ganti)
                            .addGap(14, 14, 14)
                            .addComponent(Hapus))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.
                                    GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, javax.swing.GroupLayout.
                                                DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, javax.swing.GroupLayout.
                                                DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, javax.swing.GroupLayout.
                                                DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, 43, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.
                                    GroupLayout.Alignment.LEADING, false)
                                .addComponent(id, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(nama)
                                .addComponent(merk)
                                .addComponent(stok)
                                .addComponent(hrg))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.
                                    GroupLayout.Alignment.LEADING, false)
                                .addComponent(Reset, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, javax.swing.GroupLayout.
                                                DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cari, javax.swing.GroupLayout.
                                        DEFAULT_SIZE, javax.swing.GroupLayout.
                                                DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.
                                    GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.
                                        PREFERRED_SIZE, 276, javax.swing.
                                                GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.
                                        PREFERRED_SIZE, 276, javax.swing.
                                                GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.
                                        PREFERRED_SIZE, 276, javax.swing.
                                                GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.
                    LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.
                        Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.
                                    GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cari)
                    .addComponent(jLabel5, javax.swing.GroupLayout.
                            PREFERRED_SIZE, 23, javax.swing.GroupLayout.
                                    PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.
                        RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.
                        Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.
                                GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nama, javax.swing.GroupLayout.
                                    PREFERRED_SIZE, javax.swing.GroupLayout.
                                            DEFAULT_SIZE, javax.swing.
                                                    GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reset))
                        .addPreferredGap(javax.swing.LayoutStyle.
                                ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.
                                GroupLayout.Alignment.BASELINE)
                        //    
                        .addComponent(jLabel3)
                            .addComponent(merk, javax.swing.GroupLayout.
                                    PREFERRED_SIZE, javax.swing.GroupLayout.
                                            DEFAULT_SIZE, javax.swing.
                                                    GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.
                                ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.
                                GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                            .addComponent(stok, javax.swing.GroupLayout.
                                    PREFERRED_SIZE, javax.swing.GroupLayout.
                                            DEFAULT_SIZE, javax.swing.
                                                    GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.
                                    ComponentPlacement.UNRELATED)
                          .addGroup(layout.createParallelGroup(javax.swing.
                                  GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                            .addComponent(hrg, javax.swing.GroupLayout.
                                    PREFERRED_SIZE, javax.swing.GroupLayout.
                                            DEFAULT_SIZE, javax.swing.
                                                    GroupLayout.PREFERRED_SIZE))
                            )
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.
                                PREFERRED_SIZE, 22, javax.swing.GroupLayout.
                                        PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.
                                ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
     
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.
                        UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.
                        Alignment.BASELINE)
                    .addComponent(Simpan)
                    .addComponent(Hapus)
                    .addComponent(Ganti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.
                        UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.
                        PREFERRED_SIZE, 229, javax.swing.GroupLayout.
                                PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
 
        pack();
    }                        
 
    private void CariActionPerformed(java.awt.event.ActionEvent evt) {                                    
      try {
          koneksi();
          res = stat.executeQuery("select * from barang where "+ 
                  "ID_Barang='"+id.getText()+"'" );
          if (res.next())
          {
              nama.setText(res.getString("Nama_Barang"));  
              merk.setText(res.getString("Merk"));
              stok.setText(res.getString("Stok"));
              hrg.setText(res.getString("Harga"));
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }       // TODO add your handling code here:
    }                                    
 
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {                                      
        kosongkan();        // TODO add your handling code here:
    }                                    
 
    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {                                      
        koneksi();
        try {
            stat.executeUpdate("insert into barang values ("
            + "'" + id.getText()+"',"
            + "'" + nama.getText()+"',"
            + "'" + merk.getText()+"',"
            + "'" + stok.getText()+ "',"
            + "'" + hrg.getText()+ "')" );
            kosongkan();
            tabel();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
        }
 
       catch (SQLException | HeadlessException e) {
          JOptionPane.showMessageDialog(null, "Data Belum Lengkap");
       }
    }                                      
 
    private void GantiActionPerformed(java.awt.event.ActionEvent evt)
    {                                      
        koneksi();
        try {
            stat.executeUpdate("update barang set"
            +" ID_Barang='"+id.getText()+"',"
            +" Nama_Barang='"+nama.getText()+"',"
            +" Merk='"+merk.getText()+"',"
            + "Stok='"+stok.getText()+"',"
            + "Harga='"+hrg.getText()+"'"
            + " where " + "ID_Barang='"+id.getText()+"'" );
            kosongkan();
            tabel();
            JOptionPane.showMessageDialog(null, "Berhasil Mengupdate Data");
        }catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Data Belum Lengkap : "+e);
        }               // TODO add your handling code here:        
    }                                    
 
    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {                                      
       koneksi();
       try {
            stat.executeUpdate("delete from barang where "
                + "ID_Barang='"+id.getText()
                +"'" );
            kosongkan();
            tabel();
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Dihapus/Koneksi "
                    + "Terputus "+e);
        }      // TODO add your handling code here:
    }                                    
 
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.
                    UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stok_barang.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new stok_barang().setVisible(true);
            }
        });
    }
 
    // Variables declaration                    
    private javax.swing.JButton Cari;
    private javax.swing.JButton Ganti;
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField id;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField merk;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField stok;  
     private javax.swing.JTextField hrg;
}








