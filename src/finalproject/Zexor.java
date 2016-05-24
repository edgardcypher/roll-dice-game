/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BLUE;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author abcd
 */
public class Zexor extends javafx.scene.shape.Rectangle {

    public double getLarg() {
        return larg;
    }

    public double getLg() {
        return lg;
    }

    private double larg = 80.0;
    private double lg = 80.0;
    private Paint color = BLUE;
    private Color c;
    private int healthZexrs = 100;
    private Rectangle zexor;
    private Label zexorName;
    private int numberRolled;
    private TextArea zxrRoll;
    private String zrRoll="";
    public Rectangle getZexor() {
        return this.zexor;
    }

    public Zexor(String nam, Paint p) {
        this.zexor = new Rectangle(larg, lg, p);
        this.color = p;
        this.zexor.setFill(color);
        this.zexorName = new Label(nam);
        this.zexor.setEffect(new DropShadow());
        this.zexor.setStrokeWidth(2);

    }

    public void changeSizeZexor() {
        this.larg = (this.larg * this.healthZexrs) / 100.0;
        this.lg = (this.lg * this.healthZexrs) / 100.0;
        this.zexor=new Rectangle(this.lg, this.larg, this.getColor());
        this.zexor.setFill(this.getColor());
        this.zexor.setEffect(new DropShadow());
        this.zexor.setStrokeWidth(2);
    }

    public void setColor(Paint color) {
        this.zexor.setFill(color);
    }

    public void setHealthZexor(int pointReceive) {
        this.healthZexrs = this.healthZexrs - pointReceive;
    }

    public Rectangle[] allZexor() {
        Rectangle[] all = new Zexor[3];
        for (int i = 0; i < 3; i++) {
            all[i] = this.getZexor();
        }
        return all;
    }

    public Paint getColor() {
        return color;
    }

    public int getNumberRolled() {
        return numberRolled;
    }

    public void setNumberRolled(int numberRolled) {
        this.numberRolled = numberRolled;
    }

    public Label getZexorName() {
        return zexorName;
    }

    public TextArea zxrRound() {
        this.zxrRoll = new TextArea(this.getZrRoll());
        this.zxrRoll.setEditable(false);
        this.zxrRoll.setPrefRowCount(1);
        this.zxrRoll.setPrefColumnCount(7);
        return this.zxrRoll;
    }

    public void setZexor(Rectangle zexor) {
        this.zexor = zexor;
    }
    public String replayZxrRound() {
        
        return this.getZrRoll();
    }

    public String getZrRoll() {
        return zrRoll;
    }

    public void setZrRoll(String zrRoll) {
        this.zrRoll = zrRoll;
    }

}
