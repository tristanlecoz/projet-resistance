/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projet.resistance;

import javafx.scene.paint.Paint;

/**
 *
 * @author 33643
 */
class colorValue {
    private String Name;
    private Paint colorHex;
    private int value;
    private double multiplicateur;
    private double tolerance;
    private int ppm;
    
    public colorValue(String Name,Paint colorHex,int value,double multiplicateur,double tolerance,int ppm){
        this.Name=Name;
        this.colorHex=colorHex;
        this.value=value;
        this.multiplicateur=multiplicateur;
        this.tolerance=tolerance;
        this.ppm=ppm;
    }
    
    public String getName(){
        return this.Name;
    }
    
    public Paint getcolorHex(){
        return this.colorHex;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public double getMultiplicateur(){
        return this.multiplicateur;
    }
    
    public double getTolerance(){
        return this.tolerance;
    }
    public int  getPPM(){
        return this.ppm;
    }
    
}
