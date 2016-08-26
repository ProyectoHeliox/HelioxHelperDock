/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helioxhelper.ui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.File;
import java.io.IOException;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mx.inali.helioxhelper.entidades.clases.Boton;
import mx.inali.helioxhelper.entidades.clases.Lenguaje;
import mx.inali.helioxhelper.negocio.NegocioHeliox;

/**
 * FXML Controller class
 *
 * @author Mariana G<arcía
 */
public class FXMLSettingsController implements Initializable {
    
    
    @FXML
    private JFXListView<Lenguaje> listaLenguajes;
    
    @FXML
    private JFXListView listaBotones;
    
    @FXML
    private JFXButton btnAgregar;
    
     
    NegocioHeliox nh = new NegocioHeliox();
    
    public void llenarLista() throws SQLException{
        for (Lenguaje l : nh.listadoLenguajes()){
            listaLenguajes.getItems().add(l);
        }
    }   
    @FXML
    void agregarBoton(ActionEvent event) throws IOException {
        
     
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AgregarBoton.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            FXMLAgregarBotonController controller = fxmlLoader.<FXMLAgregarBotonController>getController();
            controller.initData(listaLenguajes.getSelectionModel().getSelectedItem());
            stage.setTitle("Agregar Botón");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
       
    }
    
     public void llenarListaBotones(Lenguaje l) throws SQLException{
         
        for (Boton b : nh.listadoBotonesLenguaje(l.getId())){
            
            File audioFile, iconFile, ejecutableFile;
            audioFile = new File(b.getRutaAudio());
            iconFile = new File(b.getRutaIcono());
            ejecutableFile = new File(b.getRutaEjecutable());
            HBox buttonCardBox = new HBox();
            buttonCardBox.setAlignment(Pos.TOP_LEFT);
            Label audio = new Label("Audio");
            audio.setText(audioFile.getName());
            ImageView appIcon = new ImageView();
            Image image = new Image("file:"+b.getRutaIcono());
            HBox.setMargin(appIcon, new Insets(10,5,10,5));
            appIcon.setImage(image);
            appIcon.setFitWidth(60);
            appIcon.setFitHeight(60);
            VBox vbox =new VBox();
            Pane p = new Pane();
            buttonCardBox.getChildren().add(appIcon);
            buttonCardBox.getChildren().add(p);
            p.getChildren().add(vbox);
            Label descripcion = new Label(b.getDescripcion());
            Label app = new Label(ejecutableFile.getName());
            VBox.setMargin(descripcion, new Insets(0,0,0,20));  
            VBox.setMargin(audio, new Insets(0,0,0,20));  
            VBox.setMargin(app, new Insets(0,0,0,20));  
            vbox.getChildren().add(descripcion);
            vbox.getChildren().add(audio);
            vbox.getChildren().add(app); 
            HBox opciones = new HBox();
            JFXButton editar = new JFXButton();
            JFXButton borrar = new JFXButton();
            borrar.setButtonType(JFXButton.ButtonType.FLAT);
            editar.setButtonType(JFXButton.ButtonType.FLAT);
            editar.setText("EDITAR");
            borrar.setText("BORRAR");
            opciones.getChildren().add(editar);
            opciones.getChildren().add(borrar);
            vbox.getChildren().add(opciones);
            HBox.setMargin(editar, new Insets(20,0,0,200));
             HBox.setMargin(borrar, new Insets(20,0,0,0));
            VBox.setMargin(opciones, new Insets(0,0,0,20));  
            listaBotones.getItems().add(buttonCardBox);
            
            borrar.setOnMouseClicked(e->{
                try {
                    nh.eliminarBoton(b, l);
                    System.out.printf("Se ha borrado el boton "+ b.getId());
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            editar.setOnMouseClicked(e->{
                
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditarBoton.fxml"));
            Parent root = null;
                try {
                    root = (Parent) fxmlLoader.load();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            Stage stage = new Stage();
            EditarBotonController controller = fxmlLoader.<EditarBotonController>getController();
            controller.initData(l, b);
            stage.setTitle("Editar Botón.");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            });
            
            }
            
            
        }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnAgregar.setVisible(false);
        listaLenguajes.depthProperty().setValue(1);
        
        listaLenguajes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lenguaje>() {

            @Override
            public void changed(ObservableValue<? extends Lenguaje> observable, Lenguaje oldValue, Lenguaje newValue) {
                System.out.println("Selected item: " + newValue);               
                btnAgregar.setVisible(true);
                listaBotones.getItems().clear();
                try {
                    llenarListaBotones(newValue);
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        });
        
        try {
            // TODO
            llenarLista();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
}
