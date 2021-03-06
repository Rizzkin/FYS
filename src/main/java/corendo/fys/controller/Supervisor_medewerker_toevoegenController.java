package corendo.fys.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import corendo.fys.jdbcDBconnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import supervisor.Employee;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * FXML Controller class
 *
 * @author Ilias Azagagh
 */
public class Supervisor_medewerker_toevoegenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn = jdbcDBconnection.ConnectDB();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    PreparedStatement stmt_get = null;
    ResultSet rs_get = null;

    final ObservableList<Employee> data = FXCollections.observableArrayList();

    @FXML
    private TableView<Employee> tbl_Employee;

    @FXML
    private TableColumn tblC_FirstName;

    @FXML
    private TableColumn tblC_Surname;

    @FXML
    private TableColumn tblC_Email;

    @FXML
    private TableColumn tblC_Function;

    @FXML
    private TableColumn tblC_Country;

    @FXML
    private JFXTextField txtFirstname;

    @FXML
    private JFXTextField txtSurname;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXComboBox ddlFunction;

    @FXML
    private JFXComboBox ddlCountry;

    @FXML
    private JFXButton meOption;

    @FXML
    private AnchorPane show_me_user_info;

    @FXML
    void on_Me_User(ActionEvent event) {
        if (event.getSource() == meOption) {
            show_me_user_info.setVisible(true);
        }
    }

    /**
     * Vult de table met gegevens uit de database
     */
    public void FillTable() {

        try {
            String function = "SELECT * FROM employee INNER JOIN function ON employee.Function_id = function.function_id INNER JOIN country ON employee.Country_id = country.Country_id";
            stmt = conn.prepareStatement(function);
            rs = stmt.executeQuery();

            while (rs.next()) {
                data.add(new Employee(
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Email"),
                        rs.getString("Function_name"),
                        rs.getString("Country_name")
                ));
                tbl_Employee.setItems(data);
                tblC_FirstName.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
                tblC_Surname.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
                tblC_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
                tblC_Function.setCellValueFactory(new PropertyValueFactory<>("Function_name"));
                tblC_Country.setCellValueFactory(new PropertyValueFactory("Country_name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_manage_brandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Refreshed de tableview wanneer aangeroepen
     */
    public void refreshTable() {
        data.clear();

        try {
            String function = "SELECT * FROM employee INNER JOIN function ON employee.Function_id = function.function_id INNER JOIN country ON employee.Country_id = country.Country_id";

            stmt = conn.prepareStatement(function);
            rs = stmt.executeQuery();

            while (rs.next()) {
                data.add(new Employee(
                        rs.getString("Firstname"),
                        rs.getString("Lastname"),
                        rs.getString("Email"),
                        rs.getString("Function_name"),
                        rs.getString("Country_name")
                ));
                tbl_Employee.setItems(data);
                tblC_FirstName.setCellValueFactory(new PropertyValueFactory<>("Firstname"));
                tblC_Surname.setCellValueFactory(new PropertyValueFactory<>("Lastname"));
                tblC_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
                tblC_Function.setCellValueFactory(new PropertyValueFactory<>("Function_name"));
                tblC_Country.setCellValueFactory(new PropertyValueFactory("Country_name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_manage_brandController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * om de tableview klikbaar te maken en methode "onEdit" uit te voeren
     *
     * @param event
     */
    @FXML
    void on_table_click(MouseEvent event) {
        if (event.getClickCount() > 1) {
            onEdit();
        }
    }

    /**
     * geselecteerde kolom halen en plaatsen in een tekstveld
     */
    public void onEdit() {
        if (tbl_Employee.getSelectionModel().getSelectedItem() != null) {
            Employee selectedEmployee = tbl_Employee.getSelectionModel().getSelectedItem();
            txtFirstname.setText(selectedEmployee.getFirstname());
        }
    }

    /**
     * Maakt een nieuwe medewerker aan in de database
     *
     * @param event
     */
    @FXML
    void on_Create_Employee(ActionEvent event) {
        try {

            String query = "INSERT INTO employee (Firstname,Lastname,Email,Password,"
                    + "Function_id,Country_id) VALUES(?,?,?,?,?,?)";

            stmt = conn.prepareStatement(query);
            stmt.setString(1, txtFirstname.getText());
            stmt.setString(2, txtSurname.getText());
            stmt.setString(3, txtEmail.getText());
            stmt.setString(4, randomPassword());
            stmt.setString(5, get_Function_id());
            stmt.setString(6, get_Country_id());

            stmt.execute();
            stmt.close();

            refreshTable();
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_medewerker_toevoegenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(txtFirstname.getText() + " " + txtSurname.getText()
                + "has been added to " + ddlFunction.getSelectionModel().getSelectedItem().toString());
    }

    /**
     * Verwijderd een medewerker mits alle benodigde velden zijn ingevuld
     */
    @FXML
    void on_Delete_Employee(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning");
        alert.setContentText("Are you sure you want to delete: " + txtEmail.getText() + " ? \nThis action CANNOT be undone!");

        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            try {
                String query = "DELETE FROM employee WHERE Firstname=? AND Lastname=? AND Email=?";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, txtFirstname.getText());
                stmt.setString(2, txtSurname.getText());
                stmt.setString(3, txtEmail.getText());

                stmt.executeUpdate();
                stmt.close();

                Alert confirmation = new Alert(Alert.AlertType.INFORMATION);
                confirmation.setTitle("Information");
                confirmation.setContentText(txtEmail.getText() + " is deleted!");

                confirmation.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(Supervisor_medewerker_toevoegenController.class.getName()).log(Level.SEVERE, null, ex);
            }

            refreshTable();

        } else if (action.get() == ButtonType.CANCEL) {
            Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
            cancelAlert.setTitle("Information");
            cancelAlert.setContentText(txtEmail.getText() + " is not deleted!");

            action = cancelAlert.showAndWait();
        }

    }

    @FXML
    void on_Update_Employee(ActionEvent event) {
        String query = "UPDATE employee WHERE Firstname='" + txtFirstname.getText() + "' SET Firstname=? ";

        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, txtFirstname.getText());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_medewerker_toevoegenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String get_Function_id() {
        String function = null;
        try {

            String query_get = "Select Function_id from function where Function_name ='" + ddlFunction.getSelectionModel().getSelectedItem().toString() + "'";
            stmt_get = conn.prepareStatement(query_get);
            rs_get = stmt_get.executeQuery();
            while (rs_get.next()) {
                function = rs_get.getString("Function_id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_medewerker_toevoegenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return function;
    }

    public String get_Country_id() {
        String country = null;
        try {

            String query_get = "Select Country_id from country where Country_name ='" + ddlCountry.getSelectionModel().getSelectedItem().toString() + "'";
            stmt_get = conn.prepareStatement(query_get);
            rs_get = stmt_get.executeQuery();
            while (rs_get.next()) {
                country = rs_get.getString("Country_id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Supervisor_medewerker_toevoegenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return country;
    }

    /**
     * alle waardes van Country in de database halen die waardes koppelen met
     * ddlCountry
     */
    private void populate_comboBox_Country() {
        try {
            String query = "select * from country";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //db_LuggageType.add(rs1.getString("LuggageType"));
                String l_list = rs.getString("Country_Name");
                ObservableList<String> data_lijst = FXCollections.observableArrayList(l_list);
                ddlCountry.getItems().addAll(data_lijst);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * alle waardes van Function in de database halen die waardes koppelen met
     * ddlFunction
     */
    private void populate_comboBox_Function() {
        try {
            String query = "select * from function";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                //db_LuggageType.add(rs1.getString("LuggageType"));
                String l_list = rs.getString("Function_name");
                ObservableList<String> data_lijst = FXCollections.observableArrayList(l_list);
                ddlFunction.getItems().addAll(data_lijst);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * Genereert een random wachtwoord
     *
     * @return het random wachtwoord
     */
    protected String randomPassword() {
        String passwordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        StringBuilder passwordBuilder = new StringBuilder();
        Random randomizer = new Random();
        while (passwordBuilder.length() < 10) {
            int index = (int) (randomizer.nextFloat() * passwordCharacters.length());
            passwordBuilder.append(passwordCharacters.charAt(index));
        }
        String generatedPassword = passwordBuilder.toString();
        
        byte[] hash = stringToMD5(generatedPassword);

        return generatedPassword;

    }

   public byte[] stringToMD5(String value) {
        byte[] hash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            InputStream stream = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
            DigestInputStream inputStream = new DigestInputStream(stream, md5);
            while (inputStream.read() != -1);
            hash = md5.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
        System.out.println(Arrays.toString(hash));
        
        return hash;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // get values from country database table
        populate_comboBox_Country();

        // get values from function database table
        populate_comboBox_Function();

        // Fill the table with values
        FillTable();
    }

}
