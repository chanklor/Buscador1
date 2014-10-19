/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package busqueda1;

import mx.com.ccplus.buscador.BuscadorInit;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

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
        
        ArrayList<String[]> lista = new ArrayList<String[]>();
        
        String[] alumno = {"13001", "Rafael Ángel Gudiño Reyes"};
        lista.add(alumno);
        alumno = new String[] {"13002", "Carlos Edoardo Melgarejo Oviedo"};
        lista.add(alumno);
        alumno = new String[] {"13003", "Alan Fernando Tinoco Jimenez"};
        lista.add(alumno);
        
        BuscadorInit bi = new BuscadorInit(root, text, lista);
        
        text.setText(bi.buscarAlumnoString());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
