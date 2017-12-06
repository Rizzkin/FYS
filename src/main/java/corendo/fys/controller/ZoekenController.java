package corendo.fys.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXTextField;
import corendo.fys.jdbcDBconnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import medewerkers.zoek_luggage;

/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class ZoekenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection conn = jdbcDBconnection.ConnectDB();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    
    @FXML
    private TableView<zoek_luggage> tblLuggage;

    @FXML
    private TableColumn<?, ?> regisNr;

    @FXML
    private TableColumn<?, ?> dateFound;

    @FXML
    private TableColumn<?, ?> timeFound;

    @FXML
    private TableColumn<?, ?> luggageType;

    @FXML
    private TableColumn<?, ?> brand;

    @FXML
    private TableColumn<?, ?> passenger;

    @FXML
    private TableColumn<?, ?> status;
    
    
    final ObservableList<zoek_luggage> data = FXCollections.observableArrayList();
    
    
    
    public void FillTable(){
        try{
            String query_luggage = "SELECT * FROM luggage INNER JOIN luggagetype ON luggage.LuggageType_id = luggagetype.LuggageType_id INNER JOIN brand ON luggage.Brand_id = brand.Brand_id INNER JOIN passenger ON luggage.Passenger_id = passenger.Passenger_id INNER JOIN status ON luggage.Status_id = status.Status_id";
            
            stmt = conn.prepareStatement(query_luggage);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                data.add(new zoek_luggage(
                        rs.getString("Luggage_id"),
                        rs.getString("DateFound"),
                        rs.getString("TimeFound"),
                        rs.getString("LuggageType"),
                        rs.getString("Brand"),
                        rs.getString("Firstname"),
                        rs.getString("Status"))
                );
                tblLuggage.setItems(data);
                regisNr.setCellValueFactory(new PropertyValueFactory("Luggage_id"));
                dateFound.setCellValueFactory(new PropertyValueFactory("DateFound"));
                timeFound.setCellValueFactory(new PropertyValueFactory("TimeFound"));
                luggageType.setCellValueFactory(new PropertyValueFactory("LuggageType"));
                brand.setCellValueFactory(new PropertyValueFactory("Brand"));
                passenger.setCellValueFactory(new PropertyValueFactory("Firstname"));
                status.setCellValueFactory(new PropertyValueFactory("Status"));
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FillTable();
    }
}
