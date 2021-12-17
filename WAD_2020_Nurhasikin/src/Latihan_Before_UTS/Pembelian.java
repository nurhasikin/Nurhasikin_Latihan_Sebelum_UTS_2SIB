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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pembelian extends Application {

    Text textDaftar = new Text("Daftar Penjualan Minimarket");
    Text textKasir = new Text("User :");
    Text KodeBarang = new Text("");
    Text textHarga = new Text("");
    Text textJumlah = new Text("");
    Text textTotalBayar = new Text("");
    Text NamaBarang = new Text("");
    Text HargaBarang = new Text("");
    Text TotalHargaText = new Text("");
    TextField textFieldJumlah = new TextField();
    ObservableList<String> optionsKasir = FXCollections.observableArrayList(
            "Nurhasikin"
    );
    final ComboBox comboBoxKasir = new ComboBox(optionsKasir);
    ObservableList<String> optionsBarang = FXCollections.observableArrayList(
            "101",
            "102",
            "103"
    );
    final ComboBox comboBoxBarang = new ComboBox(optionsBarang);

    private int TotalHarga;
    private int harga;

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(new Group(), 350, 300);
        stage.setTitle("PEMBELIAN BARANG MINIMARKET");
        textDaftar.setFont(Font.font("SanSerif", 18));

        textKasir.setFont(Font.font("SanSerif", 18));
        KodeBarang.setFont(Font.font("SanSerif", 18));
        textHarga.setFont(Font.font("SanSerif", 18));
        textJumlah.setFont(Font.font("SanSerif", 18));
        textTotalBayar.setFont(Font.font("SanSerif", 18));

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        grid.add(new Label("Daftar Barang Jual Minimarket: "), 0, 0);
        Button buttong = new Button("Klik disini!");
        grid.add(buttong, 1, 0);

        buttong.setOnAction(this::buttonClicks);

        grid.add(new Label("User: "), 0, 1);

        grid.add(comboBoxKasir, 1, 1);
        grid.add(new Label("ID Barang: "), 0, 2);
        grid.add(comboBoxBarang, 1, 2);

        EventHandler<ActionEvent> event
                = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        if (comboBoxBarang.getValue() == "101") {
                            NamaBarang.setText("Milo");
                            HargaBarang.setText("Rp3400");
                            harga = 3400;
                        } else if (comboBoxBarang.getValue() == "102") {
                            NamaBarang.setText("Ice Cream Vienetta");
                            HargaBarang.setText("Rp50000");
                            harga = 50000;
                        } else if (comboBoxBarang.getValue() == "103") {
                            NamaBarang.setText("Kopi");
                            HargaBarang.setText("Rp5000");
                            harga = 5000;
                        }

                    }
                };

        comboBoxBarang.setOnAction(event);

        grid.add(new Label("Keterangan Barang: "), 0, 3);
        grid.add(NamaBarang, 1, 3);
        grid.add(new Label("Harga Barang: "), 0, 4);
        grid.add(HargaBarang, 1, 4);
        grid.add(new Label("Jumlah Barang: "), 0, 5);

        grid.add(textFieldJumlah, 1, 5);

        EventHandler<ActionEvent> eventJumlah = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                TotalHarga = Integer.parseInt(textFieldJumlah.getText()) * 
                        harga;
                TotalHargaText.setText("Rp" + Integer.toString(TotalHarga));
            }
        };

        textFieldJumlah.setOnAction(eventJumlah);

        grid.add(new Label("Total Bayar: "), 0, 6);
        grid.add(TotalHargaText, 1, 6);

        Text title = new Text("Hello" + optionsKasir);
        title.setFont(Font.font("SanSerif", 36));
        Button buttons = new Button("Cetak");
        grid.add(buttons, 1, 7);
        buttons.setOnAction(this::buttonClick);

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();

        buttong.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ee) {
                stok_barang p = new stok_barang();
                p.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private void buttonClicks(ActionEvent ee) {
        stok_barang p = new stok_barang();
        //p.Tampilan();
    }

    private void buttonClick(ActionEvent event) {
        Cetak c = new Cetak(NamaBarang, textFieldJumlah.getText(), TotalHargaText);
        c.showCetak();
    }
}
