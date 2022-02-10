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
    @FXML
    private Rectangle bandeTrois;
    @FXML
    private Rectangle bandePPM;
    @FXML
    private Button switchUn;
    @FXML
    private Button switchDeux;
    @FXML
    private Button switchTrois;
    @FXML
    private Text textResultPPM;
    
    
    /**************************
     Initialisation du tableau color2 avec les différents objets
     Initialisation de la choice Box avec les noms des couleurs
     
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
       
       
       color = FXCollections.observableArrayList(noir.getName(),marron.getName(),rouge.getName(),orange.getName(),jaune.getName(),vert.getName(),bleu.getName(),violet.getName(),gris.getName(),blanc.getName(),or.getName(),argent.getName()); 
       color2 = FXCollections.observableArrayList(noir,marron,rouge,orange,jaune,vert,bleu,violet,gris,blanc,or,argent); 

       choicevalue.setItems(color);
       choicevalue.setValue(noir.getName());
       textResultPPM.setVisible(false);
       bandeUn.setVisible(false);
       bandePPM.setVisible(false);
       bandeTol.setFill(marron.getcolorHex());
       calculResistance();
    }   
    
    
    
    /**************************
      
     Récupération de la bande selectionné 
     Récupération du nom de la couleur sélectionné
     Vérification de la compatibilité des valeurs
     Changement de couleur de la bande
     Appel de la fonction permettant de calculer la valeur de la résistance
     
     **************************/

    @FXML
    private void resistanceClick(MouseEvent event) {
        Rectangle boutonSelectionne =(Rectangle) event.getSource();
        String couleurSelectionne=choicevalue.getValue();
        System.out.print(couleurSelectionne+"\n");
        if ((couleurSelectionne.equals("Or") || couleurSelectionne.equals("Argent"))&& (boutonSelectionne.getId().equals("bandeUn") || boutonSelectionne.getId().equals("bandeDeux") || boutonSelectionne.getId().equals("bandeTrois"))){
            textErreur.setText("La couleur "+couleurSelectionne+" n'est pas disponible pour cette anneau !!!");
        
        }else if((couleurSelectionne.equals("Orange") || couleurSelectionne.equals("Jaune")|| couleurSelectionne.equals("Noir")|| couleurSelectionne.equals("Blanc"))&& boutonSelectionne.getId().equals("bandeTol")){
            textErreur.setText("La couleur "+couleurSelectionne+" n'est pas disponible pour cette anneau !!!");
        }else if((couleurSelectionne.equals("Vert") || couleurSelectionne.equals("Or")|| couleurSelectionne.equals("Noir")|| couleurSelectionne.equals("Blanc")|| couleurSelectionne.equals("Argent")|| couleurSelectionne.equals("Gris"))&& boutonSelectionne.getId().equals("bandePPM")){
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
        
     /**************************
      
     Récupération de la valeurs des bandes en fonctions de leurs couleurs
     Calcule de la valeur de la résistance
     Affichage des résulats
     
    
     
     **************************/
        
        
       
    }
    
      private void calculResistance(){
        int anneauUn=0;
        int anneauDeux=0;
        int anneauTrois=0;
        int ppm=0;
        double multiplicateur=0;
        double tolerance=0;
        double result;
        
        for(int i=0;i<color2.size();i++){
            if(bandeUn.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                anneauUn=color2.get(i).getValue();
            }
        
            if(bandeDeux.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                anneauDeux=color2.get(i).getValue();
            }
            if(bandeTrois.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                anneauTrois=color2.get(i).getValue();
            }
       
            if(bandeMulti.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                multiplicateur=color2.get(i).getMultiplicateur();
            }
        
            if(bandeTol.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                tolerance=color2.get(i).getTolerance();
            }
            if(bandePPM.getFill().equals(color2.get(i).getcolorHex())){
                System.out.print("bande 1 :"+color2.get(i).getName()+"\n");
                ppm=color2.get(i).getPPM();
            }
        }
        System.out.print("bande 1:"+anneauUn+"\n");
        System.out.print("bande 2:"+anneauDeux+"\n");
        System.out.print("multiplicateur:"+multiplicateur+"\n");
        System.out.print("tolerance:"+tolerance+"%"+"\n");
        result=((100*anneauUn)+(10*anneauDeux)+anneauTrois)*multiplicateur;
        System.out.print("resultat:"+result+"\n");
        textResult.setText("Valeur de la résistance : "+String.valueOf(result)+" Ohm") ;
        textTol.setText("Tolérance : "+String.valueOf(tolerance)+" %");
        textResultPPM.setText("PPM : "+String.valueOf(ppm));
        
        
    }
      
      /**************************
      
     Redirection vers le calcul des couleurs en fonction de la valeur
     
     **************************/
  
    @FXML
    private void switchTovalueToColor() throws IOException {
        App.setRoot("valueToColor");
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


    /**************************
      
     gestion du nombre de bandes et de leurs valeurs
     
     **************************/
    @FXML
    private void switchTo5(MouseEvent event) {
       textResultPPM.setVisible(false);
       bandeUn.setVisible(true);
       bandePPM.setVisible(false);
       calculResistance();
    }

    @FXML
    private void switchTo6(MouseEvent event) {
       textResultPPM.setVisible(true);
       bandeUn.setVisible(true);
       bandePPM.setVisible(true);
       calculResistance();
    }

    @FXML
    private void switchTo4(MouseEvent event) {
       textResultPPM.setVisible(false);
       bandeUn.setVisible(false);
       bandeUn.setFill(Color.BLACK);
       bandePPM.setVisible(false);
       calculResistance();
    }
}


    

