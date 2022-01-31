package com.mycompany.projet.resistance;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import static javafx.print.PrintColor.COLOR;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private ChoiceBox<String> choicevalue;
    private ObservableList<String> color;
    private ObservableList<colorValue> color2;
    @FXML
    private Rectangle bandeUn;
    @FXML
    private Rectangle bandeDeux;
    @FXML
    private Rectangle bandeMulti;
    @FXML
    private Rectangle bandeTol;
    @FXML
    private Text textResult;
    @FXML
    private Text textTol;
    
    
    
     
    public void initialize() {
       
       colorValue noir=new colorValue("Noir",Color.BLACK,0,1,0.0);
       colorValue marron=new colorValue("Marron",Color.BROWN,1,10,1);
       colorValue rouge=new colorValue("Rouge",Color.RED,2,100,2);
       colorValue orange=new colorValue("Orange",Color.ORANGE,3,1000,0.0);
       colorValue jaune=new colorValue("Jaune",Color.YELLOW,4,10000,0.0);
       colorValue vert=new colorValue("Vert",Color.GREEN,5,100000,0.5);
       colorValue bleu=new colorValue("Bleu",Color.BLUE,6,1000000,0.25);
       colorValue violet=new colorValue("Violet",Color.PURPLE,7,10000000,0.1);
       colorValue gris=new colorValue("Gris",Color.GREY,8,100000000,0.05);
       colorValue blanc=new colorValue("Blanc",Color.WHITE,9,1000000000,0.0);
       colorValue or=new colorValue("Or",Color.GOLD,0,0.1,5);
       colorValue argent=new colorValue("Argent",Color.SILVER,0,0.01,10);
       
       
       color = FXCollections.observableArrayList(noir.getName(),marron.getName(),rouge.getName(),orange.getName(),jaune.getName(),vert.getName(),bleu.getName(),violet.getName(),gris.getName(),blanc.getName(),or.getName(),argent.getName()); 
       color2 = FXCollections.observableArrayList(noir,marron,rouge,orange,jaune,vert,bleu,violet,gris,blanc,or,argent); 

       choicevalue.setItems(color);
       choicevalue.setValue(noir.getName());
       
    }   

    @FXML
    private void resistanceClick(MouseEvent event) {
        Rectangle boutonSelectionne =(Rectangle) event.getSource();
        String couleurSelectionne=choicevalue.getValue();
        System.out.print(couleurSelectionne+"\n");
        for(int i=0;i<color2.size();i++){
            if(couleurSelectionne.equals(color2.get(i).getName())){
                System.out.print(color2.get(i).getcolorHex()+"\n");
                boutonSelectionne.setFill(color2.get(i).getcolorHex());
            }
        }
        calculResistance();
        
        
       
    }
    
    private void calculResistance(){
        int anneauUn=0;
        int anneauDeux=0;
        int multiplicateur=0;
        int tolerance=0;
        double result=0;
        
        for(int i=0;i<color2.size();i++){
            if(bandeUn.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                anneauUn=color2.get(i).getValue();
            }
        }
        for(int i=0;i<color2.size();i++){
            if(bandeDeux.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                anneauDeux=color2.get(i).getValue();
            }
        }
         for(int i=0;i<color2.size();i++){
            if(bandeMulti.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                multiplicateur=color2.get(i).getValue();
            }
        }
          for(int i=0;i<color2.size();i++){
            if(bandeTol.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                tolerance=color2.get(i).getValue();
            }
        }
        System.out.print("bande 1:"+anneauUn+"\n");
        System.out.print("bande 2:"+anneauDeux+"\n");
        System.out.print("multiplicateur:"+multiplicateur+"\n");
        System.out.print("tolerance:"+tolerance+"%"+"\n");
        result=((10*anneauUn)+anneauDeux)*multiplicateur;
        System.out.print("resultat:"+result+"\n");
        textResult.setText("Résultat :"+String.valueOf(result));
        textTol.setText("Tolérance :"+String.valueOf(tolerance));
        
        
    }


    
}
