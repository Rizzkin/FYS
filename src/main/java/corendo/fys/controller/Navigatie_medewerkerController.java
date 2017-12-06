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
public class Navigatie_medewerkerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXButton meOption;

    @FXML
    private AnchorPane show_me_user_info;

    @FXML
    private StackPane all_content;

    @FXML
    void on_Me_User(ActionEvent event) {
        if (event.getSource() == meOption) {
            show_me_user_info.setVisible(true);
        }
    }

    @FXML
    void dashbord_medewerker(MouseEvent event) {
        show_me_user_info.setVisible(false);
    }
    
    @FXML
    void on_Gevonden_bagage(ActionEvent event) {
        veranderContentNode("Gevonden_bagage.fxml");
    }

    @FXML
    void on_verloren_bagage(ActionEvent event) {
        veranderContentNode("Verloren_bagage.fxml");
    }
    
    @FXML
    void on_Zoeken(ActionEvent event) {
        veranderContentNode("Zoeken.fxml");
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
        all_content.getChildren().setAll(parent);
    }

}
