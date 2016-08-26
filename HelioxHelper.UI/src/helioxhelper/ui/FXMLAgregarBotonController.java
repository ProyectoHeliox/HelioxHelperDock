/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import mx.inali.helioxhelper.entidades.clases.Boton;
import mx.inali.helioxhelper.entidades.clases.Lenguaje;
import mx.inali.helioxhelper.negocio.NegocioHeliox;

/**
 * Controla la vista para agregar un nuevo boton a un lenguaje.
 * FXML Controller class
 *
 * @author Mariana García
 */
public class FXMLAgregarBotonController implements Initializable {
    FXMLAgregarBotonController instance = null;
    File fileAudio, fileEjecutable, fileIcono;
    FileChooser fileChooser = new FileChooser();
    Lenguaje l = new Lenguaje();
    Boton b = new Boton();
    NegocioHeliox nh = new NegocioHeliox();
    
    
    @FXML private StackPane stackPane;
    
    @FXML
    private JFXDialog guardarDialog;
    
    @FXML
    private JFXTextField audio;

    @FXML
    private JFXButton btnAudio;

    @FXML
    private JFXTextField ejecutable;

    @FXML
    private JFXButton btbEjecutable;

    @FXML
    private JFXTextField icono;

    @FXML
    private JFXButton btnIcono;

    @FXML
    private JFXTextArea descripcion;

    @FXML
    private JFXButton guardar;

    @FXML
    private JFXButton cancelar;
    
    @FXML
    void handleCancelarAction(ActionEvent event) {
            cancelar.getScene().getWindow().hide();
    }
    
    
    
    @FXML
    void handleGuardarAction(ActionEvent event) throws SQLException {
            System.out.print(l.getNombre());
            b.setDescripcion(descripcion.getText());
           nh.agregarBoton(b, l.getId());
           System.out.print("Guardado");
       
    }

    @FXML
    void handleSeleccionarEjecutableAction(ActionEvent event) {
            
           
           FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
           fileChooser.getExtensionFilters().add(extFilter);
           fileEjecutable = fileChooser.showOpenDialog(ejecutable.getScene().getWindow());
           ejecutable.setText(fileEjecutable.getName());
           b.setRutaEjecutable(fileEjecutable.toString());
           System.out.println(b.getRutaEjecutable());

    }

    @FXML
    void handleSeleccionarIconoAction(ActionEvent event) throws IOException {
           FileChooser fileChooser = new FileChooser();
           fileIcono = fileChooser.showOpenDialog(icono.getScene().getWindow());
           System.out.println(fileIcono);
            icono.setText(fileIcono.getName());
            b.setRutaIcono(fileIcono.toString());
            
        
    }

    @FXML
    void handleSelecionarAudioAction(ActionEvent event) {
           FileChooser fileChooser = new FileChooser();
           fileAudio = fileChooser.showOpenDialog(audio.getScene().getWindow());
           System.out.println(fileAudio);
           audio.setText(fileAudio.getName());
           b.setRutaAudio(fileAudio.toString());
    }
    
      public void initData(Lenguaje l){
       this.l = l;
   }

    public FXMLAgregarBotonController getInstance() {
        return instance;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
      
    public void initialize(URL url, ResourceBundle rb) {
        this.initData(l);
  
  
    } 
    
 
    
   
}
