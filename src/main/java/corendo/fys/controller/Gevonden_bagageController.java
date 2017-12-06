package corendo.fys.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import corendo.fys.MyJDBC;
import corendo.fys.Record;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Gevonden_bagageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    final ObservableList<Record> data = FXCollections.observableArrayList();
    final MyJDBC dbms = new MyJDBC("testfoundluggage");
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
