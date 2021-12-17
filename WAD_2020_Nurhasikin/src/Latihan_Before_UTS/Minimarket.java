//package Latihan_Before_UTS;
//
//import LatihanModul03.ContohLayoutAll2;
//import javafx.application.Application;
//import static javafx.application.Application.launch;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.geometry.VPos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.TilePane;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.paint.CycleMethod;
//import javafx.scene.paint.LinearGradient;
//import javafx.scene.paint.Stop;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class Minimarket extends Application {
//    
//    
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage stage) {
//        BorderPane border = new BorderPane();
//
//        HBox hbox = addHBox();
//        border.setTop(hbox);
//        border.setLeft(addVBox());
//        addStackPane(hbox);
//        border.setRight(addFlowPane());
//        border.setCenter(addAnchorPane(addGridPane()));
//
//        Scene scene = new Scene(border);
//        stage.setScene(scene);
//        stage.setTitle("Contoh Layout");
//        stage.show();
//    }
//
//    private HBox addHBox() {
//        HBox hbox = new HBox();
//        hbox.setPadding(new Insets(15, 12, 15, 12));
//        hbox.setSpacing(10);
//        hbox.setStyle("-fx-background-color: #336699;");
//
//        Button btn1 = new Button("Penjualan Barang");
//        btn1.setPrefSize(150, 20);
//
//        
//        Button btn2 = new Button("Pembelian Barang");
//        btn2.setPrefSize(150, 20);
//
//        Button btn3 = new Button("Stok Barang");
//        btn3.setPrefSize(150, 20);
//
//        
//        hbox.getChildren().addAll(btn1, btn2, btn3);
//
//        return hbox;
//    }
//
//    private VBox addVBox() {
//        VBox vbox = new VBox();
//        vbox.setPadding(new Insets(10));
//        vbox.setSpacing(8);
//
//        
//        Text title = new Text("Daftar Mata Kuliah:");
//        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//        vbox.getChildren().add(title);
//
//        Hyperlink options[] = new Hyperlink[]{
//            new Hyperlink("Pemograman Berorientasi Objek"),
//            new Hyperlink("Struktur Data"),
//            new Hyperlink("Workshop Aplikasi Desktop"),
//            new Hyperlink("Database")
//        };
//
//        for (int i = 0; i < 4; i++) {
//            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
//            vbox.getChildren().add(options[i]);
//        }  
//        return vbox;
//    }
//
//    private void addStackPane(HBox hb) {
//        
//        StackPane stack = new StackPane();
//        Rectangle helpIcon = new Rectangle(30.0, 25.0);
//        helpIcon.setFill(new LinearGradient
//        (0, 0, 0, 1, true, CycleMethod.NO_CYCLE, new Stop[]{
//            new Stop(0, Color.web("#4977A3")),
//            new Stop(0.5, Color.web("#B0C6DA")),
//            new Stop(1, Color.web("#9CB6CF")),}));
//        helpIcon.setStroke(Color.web("D0E6FA"));
//        helpIcon.setArcHeight(3.5);
//        helpIcon.setArcWidth(3.5);
//
//        Text helpText = new Text("?");
//        helpText.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
//        helpText.setFill(Color.WHITE);
//        helpText.setStroke(Color.web("#7080A0"));
//
//        stack.getChildren().addAll(helpIcon, helpText);
//        stack.setAlignment(Pos.CENTER_RIGHT);
//        StackPane.setMargin(helpText, new Insets(0, 10, 0, 0));
//
//        hb.getChildren().add(stack);
//        HBox.setHgrow(stack, Priority.ALWAYS);
//    }
//    
//
//    private FlowPane addFlowPane() {
//        FlowPane flow = new FlowPane();
//        flow.setPadding(new Insets(5, 0, 5, 0));
//        flow.setVgap(4);
//        flow.setHgap(4);
//        flow.setPrefWrapLength(170);
//        flow.setStyle("-fx-background-color: DAE6F3;");
//
//        ImageView pages[] = new ImageView[8];
//        for (int i = 0; i < 8; i++) {
//            pages[i] = new ImageView(
//                    new Image(ContohLayoutAll2.class.getResourceAsStream
//        ("/graphics/chart_" + (i + 1) + ".png"))
//            );
//            flow.getChildren().add(pages[i]);
//        }
//        return flow;
//    }
//
//    private AnchorPane addAnchorPane(GridPane grid) {
//        AnchorPane anchorpane = new AnchorPane();
//
//        Button buttonSave = new Button("Save");
//        Button buttonCancel = new Button("Cancel");
//
//        HBox hb = new HBox();
//        hb.setPadding(new Insets(0, 10, 10, 10));
//        hb.setSpacing(10);
//        hb.getChildren().addAll(buttonSave, buttonCancel);
//
//        anchorpane.getChildren().addAll(grid, hb);
//        AnchorPane.setBottomAnchor(hb, 8.0);
//        AnchorPane.setRightAnchor(hb, 5.0);
//        AnchorPane.setTopAnchor(grid, 10.0);
//
//        return anchorpane;
//    }
//
//    private GridPane addGridPane() {
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(0, 10, 0, 10));
//
//        Text category = new Text("Dosen Pengampu:");
//        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        grid.add(category, 1, 0);
//
//        Text chartTitle = new Text("Syefrida Yulina, S.T., M.Sc");
//        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        grid.add(chartTitle, 2, 0);
//
//        Text chartSubtitle = new Text("Prodi: Sistem Informasi");
//        grid.add(chartSubtitle, 1, 1, 2, 1);
//
//        ImageView imageHouse = new ImageView(
//                new Image(ContohLayoutAll2.class.
//                        getResourceAsStream("/graphics/house.png")));
//        grid.add(imageHouse, 0, 0, 1, 2);
//
//        Text goodsPercent = new Text("Goods\n80%");
//        GridPane.setValignment(goodsPercent, VPos.BOTTOM);
//        grid.add(goodsPercent, 0, 2);
//
//        ImageView imageChart = new ImageView(
//                new Image(ContohLayoutAll2.class.
//                        getResourceAsStream("/graphics/piechart.png")));
//        grid.add(imageChart, 1, 2, 2, 1);
//
//        Text servicesPercent = new Text("Service\n20%");
//        GridPane.setValignment(servicesPercent, VPos.TOP);
//        grid.add(servicesPercent, 3, 2);
//
//        return grid;
//    }
//
//    private TilePane addTilePane() {
//
//        TilePane tile = new TilePane();
//        tile.setPadding(new Insets(5, 0, 5, 0));
//        tile.setVgap(4);
//        tile.setHgap(4);
//        tile.setPrefColumns(2);
//        tile.setStyle("-fx-background-color: DAE6F3");
//
//        ImageView pages[] = new ImageView[8];
//        for (int i = 0; i < 8; i++) {
//            pages[i] = new ImageView(
//                    new Image(ContohLayoutAll2.class.
//                            getResourceAsStream
//                            ("/graphics/chart_" + (i + 1) + ".png"))
//            );
//            tile.getChildren().add(pages[i]);
//        }
//        return tile;
//    }
//    
//}
