/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busqueda1;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import mx.com.ccplus.buscador.BuscadorInit;

/**
 *
 * @author chanklor
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    Parent root;
    
    @FXML
    TextField text;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "tresct");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customer");
                    
            BuscadorInit bi = new BuscadorInit(root, text, rs);

            text.setText(bi.buscarAlumnoTabla());
            
            rs.close();
            st.close();
            con.close();
        
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }
    
    @FXML
    private void botonSig(MouseEvent event){
        
        try{
        
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "tresct");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM customer");
                    
            BuscadorInit bi = new BuscadorInit(root, text, rs);

            do{
                text.setText(bi.buscarAlumnoSiguiente());
            }while(bi.flagSigAnt);
            
            rs.close();
            st.close();
            con.close();
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("aibdskabk");
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
