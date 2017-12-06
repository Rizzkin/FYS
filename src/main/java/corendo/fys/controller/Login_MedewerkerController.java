package corendo.fys.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import corendo.fys.jdbcDBconnection;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class Login_MedewerkerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn = jdbcDBconnection.ConnectDB();
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private Label lblMessage;

    private ResourceBundle resources;
    private Boolean notification = true;

    @FXML
    void on_Login_medewerker(ActionEvent event) throws IOException {

        String sql = "Select * from employee where Email=? and Password=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtEmail.getText());
            pstmt.setString(2, txtPassword.getText());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                if (function_id() == 1) {
                    Parent parent1 = FXMLLoader.load(getClass().getResource("/corendo/fys/Navigatie_medewerker.fxml"));
                    Scene scene = new Scene(parent1);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                } else if (function_id() == 2) {
                    Parent parent1 = FXMLLoader.load(getClass().getResource("/corendo/fys/Navigatie_supervisor.fxml"));
                    Scene scene = new Scene(parent1);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.setScene(scene);
                    app_stage.show();
                }
            } else {
                lblMessage.setVisible(true);
                lblMessage.setText("Email of wachtwoord klopt niet!");
            }
        } catch (IOException | SQLException e) {
            e.getMessage();
        }

    }

    public int function_id() {
        int id = 0;
        try {
            String query = "select Function_id from employee where Email='" + txtEmail.getText() + "'";
            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                id = rs.getInt("Function_id");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return id;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
