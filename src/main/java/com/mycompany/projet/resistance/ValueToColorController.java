/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.projet.resistance;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;

/**
 * FXML Controller class
 *
 * @author 33643
 */
public class ValueToColorController {

    
    @FXML
    private Rectangle bandeUn;
    @FXML
    private Rectangle bandeTrois;
    @FXML
    private Rectangle bandeMulti;
    @FXML
    private Rectangle bandeTol;
    @FXML
    private Rectangle bandeDeux;
    
    private ObservableList<colorValue> color2;
    private ObservableList<Double> valeurs;
    double[] multiplicateurValues={1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
    @FXML
    private ComboBox<Double> valeurBox;

    /**
     * Initializes the controller class.
     */
    /**************************
     Initialisation du tableau color2 avec les différents objets
     Initialisation de la comboBox avec les valeurs des résistances
     
     **************************/
    public void initialize() {
       colorValue noir=new colorValue("Noir",Color.BLACK,0,1,0.0,0);
       colorValue marron=new colorValue("Marron",Color.BROWN,1,10,1,100);
       colorValue rouge=new colorValue("Rouge",Color.RED,2,100,2,50);
       colorValue orange=new colorValue("Orange",Color.ORANGE,3,1000,0.0,15);
       colorValue jaune=new colorValue("Jaune",Color.YELLOW,4,10000,0.0,25);
       colorValue vert=new colorValue("Vert",Color.GREEN,5,100000,0.5,0);
       colorValue bleu=new colorValue("Bleu",Color.BLUE,6,1000000,0.25,10);
       colorValue violet=new colorValue("Violet",Color.PURPLE,7,10000000,0.1,5);
       colorValue gris=new colorValue("Gris",Color.GREY,8,100000000,0.05,0);
       colorValue blanc=new colorValue("Blanc",Color.WHITE,9,1000000000,0.0,0);
       colorValue or=new colorValue("Or",Color.GOLD,0,0.1,5,0);
       colorValue argent=new colorValue("Argent",Color.SILVER,0,0.01,10,0);
        color2 = FXCollections.observableArrayList(noir,marron,rouge,orange,jaune,vert,bleu,violet,gris,blanc,or,argent); 
       valeurs=FXCollections.observableArrayList();
       double[] bandValues={0,1,2,3,4,5,6,7,8,9};
       double valeur=0;
        for(int i=0;i<bandValues.length;i++){
            for(int j=0;j<bandValues.length;j++){
                for(int l=0;l<bandValues.length;l++){
                    for(int k=0;k<multiplicateurValues.length;k++){
                        valeur=((bandValues[i]*100)+(bandValues[j]*10)+bandValues[l])*multiplicateurValues[k];
                        System.out.print(valeur+"\n");
                        valeurs.add(valeur);
                    }
                }
            }
        }
        
        Collections.sort(valeurs);
        bandeTol.setFill(marron.getcolorHex());
        valeurBox.setItems(valeurs);
       
    }    

   /**************************
    
     Récupération de la valeur
     Détermination des différentes couleurs
     Applications des couleurs
     
     
     **************************/

    @FXML
    private void calculer(MouseEvent event) {
        double valeurchoisie=valeurBox.getValue();
        double bandeun=0,bandedeux=0,bandetrois=0;
        double multiplicateur=0;
        
        int[] valeurChoisieArray = String.valueOf(valeurchoisie)
                      .chars()
                      .map(Character::getNumericValue)
                      .toArray();
        
        if (valeurChoisieArray[3]==14){
            bandeUn.setVisible(false);
            bandedeux=valeurChoisieArray[0];
            bandetrois=valeurChoisieArray[2];
            
        }else if(valeurChoisieArray[4]==14){
            bandeUn.setVisible(true);
            bandeun=valeurChoisieArray[0];
            bandedeux=valeurChoisieArray[2];
            bandetrois=valeurChoisieArray[3];
        }else{
            if (valeurChoisieArray[2]==0){
                bandeUn.setVisible(false);
                bandedeux=valeurChoisieArray[0];
                bandetrois=valeurChoisieArray[1];
            }else{
                bandeUn.setVisible(true);
                bandeun=valeurChoisieArray[0];
                bandedeux=valeurChoisieArray[1];
                bandetrois=valeurChoisieArray[2];
            }
        }
        
        
        int compteur=1;
        double test=((100*bandeun)+(10*bandedeux)+bandetrois)*multiplicateurValues[0];
        
        while(valeurchoisie!=test){
            test=((100*bandeun)+(10*bandedeux)+bandetrois)*multiplicateurValues[compteur];
            compteur++;
        }
        
        compteur--;
        multiplicateur=multiplicateurValues[compteur];
        
        for(int i=0;i<color2.size();i++){
            if(color2.get(i).getValue()==bandeun){
                bandeUn.setFill(color2.get(i).getcolorHex());
            }
            if(color2.get(i).getValue()==bandedeux){
                bandeDeux.setFill(color2.get(i).getcolorHex());
            }
            if(color2.get(i).getValue()==bandetrois){
                bandeTrois.setFill(color2.get(i).getcolorHex());
            }
            if(color2.get(i).getMultiplicateur()==multiplicateur){
                bandeMulti.setFill(color2.get(i).getcolorHex());
            }
        }  
        
    }
    
    /**************************
      
     Redirection vers le calcul de la valeur en fonction des couleurs
     
     **************************/
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
   
     /**************************
      
     Redirection vers le mode d'emploi
     
     **************************/
    @FXML
      public void helpmenu() throws IOException{
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        Desktop.getDesktop().open(new File(s+"\\src\\main\\java\\com\\mycompany\\projet\\resistance\\manuel.pdf"));
    }
    
}
