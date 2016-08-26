/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.inali.helioxhelper.entidades.clases.Boton;
import mx.inali.helioxhelper.entidades.clases.Lenguaje;
import mx.inali.helioxhelper.negocio.NegocioHeliox;

/**
 *  
 * @author Mariana García
 */
public class FXMLDocumentController implements Initializable {
    
    private NegocioHeliox nh = new NegocioHeliox();
     @FXML
    private HBox hboxBotones;
    @FXML
    private JFXComboBox<Lenguaje> combobox = new JFXComboBox<Lenguaje>();
    
    @FXML
    private JFXButton button;
    
    @FXML
    void handleButtonAction(ActionEvent event)  {
        
        System.out.print("YOU ROCK!");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Configuración");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e){
             System.out.print("no carga");
        }
       

    }
    private void obtenerLenguajes() throws SQLException{
          for (Lenguaje l : nh.listadoLenguajes()){
          combobox.getItems().add(l);
          }  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            button.setText(null);
            obtenerLenguajes();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            combobox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lenguaje>() {
            @Override
            public void changed(ObservableValue<? extends Lenguaje> observable, Lenguaje oldValue, Lenguaje newValue) {
                System.out.println("Nuevo " + newValue);
                 System.out.println("Viejo " + oldValue);
                hboxBotones.getChildren().clear();
                try {
                    llenarPanelBotones(newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
        });
        
    }
    
    public void llenarPanelBotones(Lenguaje l) throws SQLException{
        
        for (Boton b : nh.listadoBotonesLenguaje(l.getId())){
        
            
            
             Pane p = new Pane();
            Label audio = new Label("Audio");
            ImageView appIcon = new ImageView();
            Image image = new Image("file:"+b.getRutaIcono());
            HBox.setMargin(appIcon, new Insets(20,20,20,20));
            HBox caja = new HBox();
            appIcon.setImage(image);
            appIcon.setFitWidth(48);
            appIcon.setFitHeight(48);
            p.getChildren().add(caja);
            caja.getChildren().add(appIcon);
            hboxBotones.getChildren().add(p);
        
        }
        
    }
    
}
