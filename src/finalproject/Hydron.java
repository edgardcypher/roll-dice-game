/*
 * This class represents the Hydron shape like the triangle
 */
package finalproject;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class Hydron extends javafx.scene.shape.Polygon {

    private double x1 = 150.0, y1 = 200.0, x2 = 200.0, y2 = 150.0, x3 = 250.0, y3 = 200.0;
    Polygon hydron;
    private Paint color;
    private Label name;
    private int health = 100;
    private TextArea hydRoll;
    private String roll;
    //Constructor of my class that constructs a triangle with some style
    public Hydron(String n, Paint p) {
        this.hydron = new Polygon(x1, y1, x2, y2, x3, y3);
        this.color = p;
        this.name = new Label(n);
        this.hydron.setFill(color);
        this.hydron.setEffect(new DropShadow());
        this.hydron.setStrokeWidth(2);
    }
    //this method method affect the size of my hydrons every time the health changes
    public void newPolyGon() {
        this.setX1(this.x1 * this.health / 100.0);
        this.setX2(this.x2 * this.health / 100.0);
        this.setX3(this.x3 * this.health / 100.0);
        this.setY1(this.y1 * this.health / 100.0);
        this.setY2(this.y2 * this.health / 100.0);
        this.setY3(this.y3 * this.health / 100.0);
        this.hydron = new Polygon(this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
        this.hydron.setFill(this.getColor());
        this.hydron.setEffect(new DropShadow());
        this.hydron.setStrokeWidth(2);
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setHydron(Polygon hydron) {
        this.hydron = hydron;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int lstPoint) {
        this.health = health - lstPoint;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.hydron.setFill(color);
    }

    public Polygon getHydron() {
        return hydron;
    }

    public Label getName() {
        return name;
    }
// this method return a textArea control object whose the text contain the random number
    //generate by a Hydron From setRoll method initialize in GameRound
    public TextArea hydRound() {
        this.hydRoll = new TextArea(this.getRoll());//i construct a textArea method with a string returned from getRoll 
        this.hydRoll.setPrefRowCount(1);
        this.hydRoll.setPrefColumnCount(7);
        this.hydRoll.setEditable(false);
        return this.hydRoll;
    }
    public String repHydRound() {
   
        return this.getRoll();
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }
    
}
