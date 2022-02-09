package com.mycompany.projet.resistance;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Text textErreur;
    
    
    
    
     
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
        if ((couleurSelectionne.equals("Or") || couleurSelectionne.equals("Argent"))&& (boutonSelectionne.getId().equals("bandeUn") || boutonSelectionne.getId().equals("bandeDeux"))){
            textErreur.setText("La couleur "+couleurSelectionne+" n'est pas disponible pour cette anneau !!!");
        
        }else if((couleurSelectionne.equals("Orange") || couleurSelectionne.equals("Jaune")|| couleurSelectionne.equals("Noir")|| couleurSelectionne.equals("Blanc"))&& boutonSelectionne.getId().equals("bandeTol")){
            textErreur.setText("La couleur "+couleurSelectionne+" n'est pas disponible pour cette anneau !!!");
        }else{
            for(int i=0;i<color2.size();i++){
                if(couleurSelectionne.equals(color2.get(i).getName())){
                    System.out.print(color2.get(i).getcolorHex()+"\n");
                    boutonSelectionne.setFill(color2.get(i).getcolorHex());
                    textErreur.setText("");
                }
            }
        }
        calculResistance();
        
        
       
    }
    
      private void calculResistance(){
        int anneauUn=0;
        int anneauDeux=0;
        double multiplicateur=0;
        double tolerance=0;
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
                multiplicateur=color2.get(i).getMultiplicateur();
            }
        }
          for(int i=0;i<color2.size();i++){
            if(bandeTol.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                tolerance=color2.get(i).getTolerance();
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
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
     @FXML
    private void switchToThird() throws IOException {
        App.setRoot("Third");
    }
     @FXML
    private void switchTovalueToColor() throws IOException {
        App.setRoot("valueToColor");
    }
    
    @FXML
    public void helpmenu() throws IOException{
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        Desktop.getDesktop().open(new File(s+"\\src\\main\\java\\com\\mycompany\\projet\\resistance\\manuel.pdf"));
    }
/*
    private void findColor(MouseEvent event) {
        double valeurOhm= Double.valueOf(valueOhm.getText());
        System.out.print(valeurOhm+"\n");
        int[] bandValues={0,1,2,3,4,5,6,7,8,9};
        int[] multiplicateurValues={1,10,100,1000,10000,100000,1000000,10000000,100000000,1000000000};
        double valeur=0;
        for(int i=0;i<bandValues.length;i++){
            for(int j=0;j<bandValues.length;j++){
                for(int k=0;k<multiplicateurValues.length;k++){
                    valeur=(bandValues[i]*10+bandValues[j])*multiplicateurValues[k];
                    if( valeur==valeurOhm ){
                        System.out.print(" bande 1 : "+bandValues[i]+" bande 2 : "+bandValues[j]+" multiplicateur : "+multiplicateurValues[k]+"\n");
                    }
                    
                    
            
                }
            }
        }
        
       
        
        
    }*/
}


    

