/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copytolist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Ameer
 */
public class CopyToList extends Application {
    ListView listView1;
    ListView listview2;
    Button copy;
    ObservableList<String> modfyList;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Multiple Selection Lists");
        listView1 = new ListView();
        listview2 = new ListView();
        copy = new Button("Copy >>> ");
        modfyList = FXCollections.observableArrayList();
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView1.setItems(modfyList);
        modfyList.addAll("Black", "Blue", "Cyan", "Dark Geay", "Gray", "Green", "Black", "Blue", "Cyan", "Dark Geay", "Gray", "Green");
        listView1.setPrefSize(150, 120);
        listview2.setPrefSize(150, 120);
        copy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent Copy) {
                if (listView1.getSelectionModel().getSelectedItems().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "You Dont Select Any Item From First List View ", ButtonType.OK);
                    alert.show();
                } else {
                    listview2.getItems().addAll(listView1.getSelectionModel().getSelectedItems());
                    listView1.getSelectionModel().clearSelection();
                    listview2.getSelectionModel().clearSelection();
                }
            }
        });
        HBox Box = new HBox(10, listView1, copy, listview2);
        Box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(Box, 500, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
