package corendo.fys.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import corendo.fys.AppUtilities;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Navigatie_supervisorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane show_me_user_info;

    @FXML
    private JFXButton meOption;

    @FXML
    private StackPane all_content_supervisor;
    
    @FXML
    private JFXButton formulier_wijziging;

    @FXML
    void dashbord_medewerker(MouseEvent event) {

    }
    
    @FXML
    void on_formulier_wijzig(ActionEvent event) {
        veranderContentNode("Supervisor_Formulier_wijzigen.fxml");
    }
    @FXML
    void on_medewerker_toevoegen(ActionEvent event) {
        veranderContentNode("Supervisor_medewerker_toevoegen.fxml");
    }

    @FXML
    void on_Me_User(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        all_content_supervisor.getChildren().setAll(parent);
    }

}
