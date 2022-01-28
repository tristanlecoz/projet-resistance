package com.mycompany.projet.resistance;

import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PrimaryController {

    @FXML
    private HBox resistance;
    @FXML
    private ChoiceBox<?> choicevalue;
    
    private static Map<String,String> tabcolor;
    
     public static void main(String[] args) {
       tabcolor = new HashMap<>(); 

       tabcolor.put("Bleu", "#3222ee");
       tabcolor.put("Vert", "#13ca14");
       tabcolor.put("Rouge", "#ee2222");

       // Affiche les clés du map
       System.out.println("Clés: " + tabcolor.keySet());

       // Affiche les valeurs du map
       System.out.println("Values: " + tabcolor.values());

       // Affiche les entrées du map
       System.out.println("Entrées: " + tabcolor.entrySet());
    }

    @FXML
    private void test(MouseEvent event) {
    }


    
}
