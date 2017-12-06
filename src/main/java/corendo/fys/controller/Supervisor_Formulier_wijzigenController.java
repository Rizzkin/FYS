package corendo.fys.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import corendo.fys.AppUtilities;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Supervisor_Formulier_wijzigenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuButton formulier_wijzigen_select;

    @FXML
    private StackPane formulier_wijzigen_content;

    @FXML
    void on_manage_brand(ActionEvent event) {
        veranderContentNode("supervisor_manage_brand.fxml");
    }

    @FXML
    void on_manage_luggageType(ActionEvent event) {
        veranderContentNode("supervisor_manage_luggageType.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void veranderContentNode(String schermFileName) {
        Parent parent;
        try {
            parent = AppUtilities.loadScreen(schermFileName);
        } catch (IOException ex) {
            ex.printStackTrace();
            // TODO show error
            return;
        }
        formulier_wijzigen_content.getChildren().setAll(parent);
    }

}
