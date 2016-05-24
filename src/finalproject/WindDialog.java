package finalproject;


import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/*
this class aims to use for my color combox list to pick the color 
 */

/**
 *
 * @author abcd
 */
public class WindDialog extends ColorPicker {
    private ColorPicker mycolor;
    private Paint choiceColor; 
    //construct of my class that instantiate a myColor object that is a ColorPicker
    public WindDialog() {
        mycolor=new ColorPicker();
    }

    public ColorPicker getMycolor() {
        return mycolor;
    }
    // this method return the color type picked by the user i use the getValue method that return the color of paint type
    public Paint getChoiceColor() {
        choiceColor=mycolor.getValue();
        return choiceColor;
    }
    
}
