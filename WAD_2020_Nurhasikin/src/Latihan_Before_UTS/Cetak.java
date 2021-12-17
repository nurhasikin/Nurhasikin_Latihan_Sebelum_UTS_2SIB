package Latihan_Before_UTS;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.collections.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.Group;
import java.util.Random;
 
public class Cetak
{
    private Text NamaBarang = new Text(""), TotalHargaText = new Text("");
    private String jumlahBeli;
    public Cetak(Text namaBarang, String jumlah, Text TotalHarga)
    {
        NamaBarang = namaBarang;
        TotalHargaText = TotalHarga;
        jumlahBeli = jumlah;
    }
    public void showCetak()
    {
       Stage stage = new Stage();
       Scene scene = new Scene(new Group(), 500, 250);
       stage.setTitle("Nota Pembelian");
       GridPane grid = new GridPane();
       grid.setVgap(10);
       grid.setHgap(15);
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.add(new Label("PEMBELIAN BARANG TOKO CANAT"),0,0);
       grid.add(NamaBarang,0,1);
       grid.add(new Label(jumlahBeli),1,1);
       grid.add(new Label("Harga"),0,2);
       grid.add(TotalHargaText,1,2);
       Group root = (Group)scene.getRoot();
       root.getChildren().add(grid);
       stage.setScene(scene);
       stage.show();
    }
}








