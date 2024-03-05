package com.example.lab1;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    @FXML
    private TableView<Tourist> tableView;
    @FXML
    private TableColumn<Tourist,Integer > id;
    @FXML
    private TableColumn<Tourist, String> Name;
    @FXML
    private TableColumn<Tourist,Integer> age;
    @FXML
    private TableColumn<Tourist,String>Nationality;
    ObservableList<Tourist> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Tourist,Integer>("id"));
        Name.setCellValueFactory(new
                PropertyValueFactory<Tourist,String>("Name"));
        age.setCellValueFactory(new
                PropertyValueFactory<Tourist,Integer>("age"));
        Nationality.setCellValueFactory(new
                PropertyValueFactory<Tourist,String>("Nationality"));
        tableView.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/lab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_tourist";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                int age = resultSet.getInt("age");
                String Nationality = resultSet.getString("Nationality");
                tableView.getItems().add(new Tourist(id, Name, age, Nationality));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

