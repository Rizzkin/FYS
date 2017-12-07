/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corendo.fys;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gabriel
 */
public class jdbcDBconnection {

    Connection conn = null;

    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demodb", "root", "admin");
            return conn;
        } catch (Exception e) {
            return null;
        }

    }
}
