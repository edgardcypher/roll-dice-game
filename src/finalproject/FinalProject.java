/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.ORANGE;
import static javafx.scene.paint.Color.PURPLE;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author abcd
 */
public class FinalProject extends Application {

    private int hydronsSize = 700;
    private int zeronSize = 25;
    private Paint ed = Color.AQUA;
    private File saveFile = new File("Score.dat");
    private int numbDice, numSides, attaker, defender;
    private GameRound game;
    private DiceRoll nwRound;
    private Hydron edgard, paul, cathy;
    private Zexor MARK, FANNY, ERIC;
    private FlowPane flPane, batZone;
    private MenuBar myBar;
    private HBox boxZexors, boxHydrons;
    private VBox hydB, zeXB,myH;
    private TextArea txt;
    private Menu menu;
    private Menu replay;
    private MenuItem start, save, exit;
    private MenuItem replayGame;
    private DataOutputStream output = null;
    private ObjectInputStream inputFile = null;
    private TextArea t,t2;
    private Polygon h;
    private Rectangle z;
    private String finalR="";
    @Override
    public void start(Stage primaryStage) {
        
        game = new GameRound();
        nwRound = new DiceRoll();
        numbDice = nwRound.getNumberDiceEachRound();
        numSides = nwRound.getNumberSideEachDice();
        edgard = new Hydron("Edgard", ed);
        paul = new Hydron("PAUL", YELLOW);
        cathy = new Hydron("CATHY", PURPLE);
        MARK = new Zexor("MARK", ORANGE);
        FANNY = new Zexor("FANNY", GREEN);
        ERIC = new Zexor("ERIC", WHITE);
        Hydron[] allHydrons = {edgard, paul, cathy};
        Zexor[] allZxors = {MARK, FANNY, ERIC};
        attaker = (int) (Math.random() * 3);
        defender = (int) (Math.random() * 3);
        /*by calling the round method */
         String result=game.round(nwRound, allHydrons[attaker], allZxors[defender]);
        flPane = new FlowPane();
        flPane.setOrientation(Orientation.VERTICAL);
        flPane.setVgap(30);
        myBar = new MenuBar();
        boxZexors = new HBox(10);
        boxHydrons = new HBox(10);
        hydB = new VBox(10);//vertical box for hydron
        zeXB = new VBox(10);//vertical box for zexors
        hydB.setPadding(new Insets(11, 10, 10, 10));
        zeXB.setPadding(new Insets(11, 10, 10, 10));
        batZone = new FlowPane();
        batZone.setPadding(new Insets(15, 15, 15, 15));
        batZone.setHgap(100);
        boxZexors.setPadding(new Insets(15, 15, 15, 15));
        boxHydrons.setPadding(new Insets(15, 15, 15, 15));
        boxZexors.getChildren().addAll(MARK.getZexor(), MARK.getZexorName(), FANNY.getZexor(), FANNY.getZexorName(), ERIC.getZexor(), ERIC.getZexorName());
        boxHydrons.getChildren().addAll(edgard.getHydron(), edgard.getName(), paul.getHydron(), paul.getName(), cathy.getHydron(), cathy.getName());
        t2=allZxors[defender].zxrRound();
        t=allHydrons[attaker].hydRound();
        //t=new TextArea(allHydrons[attaker].getRoll());
        h=allHydrons[attaker].getHydron();
        z=allZxors[defender].getZexor();
        hydB.getChildren().addAll(h, allHydrons[attaker].getName(), t);
        zeXB.getChildren().addAll(z, allZxors[defender].getZexorName(),t2);
        System.out.println(allZxors[defender].getLg());
        System.out.println(allZxors[defender].getLarg());
        batZone.getChildren().addAll(hydB, zeXB);
        txt=new TextArea();
        txt.setText(result);
        txt.setPrefRowCount(4);
        txt.setPrefColumnCount(14);
        txt.setEditable(false);
        flPane.setAlignment(Pos.CENTER);
        flPane.getChildren().addAll(boxZexors, batZone, txt, boxHydrons);
        menu = new Menu("File");
        replay = new Menu("Replay");
        replay.setVisible(false);
        start = new MenuItem("Start Game");
        save = new MenuItem("Save File");
        exit = new MenuItem("Exit");
        MenuItem recap = new MenuItem("Recap the games");
        replayGame = new MenuItem("Replay Game");
        menu.getItems().addAll(start, recap, save, exit);
        replay.getItems().add(replayGame);
        myBar.getMenus().addAll(menu,replay);
        BorderPane myBorder = new BorderPane();
        myBorder.setTop(myBar);// put the menu bar on the top of pane
        start.setOnAction((ActionEvent event) -> {
            start.setVisible(false);
            //myBorder.setCenter(flPane);
            HBox all = new HBox(30);
            VBox allHy = new VBox(5);
            allHy.setPadding(new Insets(20, 20, 20, 20));
            HBox h = new HBox(10);
            HBox h2 = new HBox(10);
            HBox h3 = new HBox(10);
            WindDialog dg = new WindDialog();
            WindDialog dg2 = new WindDialog();
            WindDialog dg3 = new WindDialog();
            h.getChildren().addAll(new Label("edgard:"), dg);
            h2.getChildren().addAll(new Label("paul:"), dg2);
            h3.getChildren().addAll(new Label("cathy:"), dg3);
            allHy.getChildren().addAll(new Label("The Hydrons"), h, h2, h3);
            VBox allZx = new VBox(5);
            allZx.setPadding(new Insets(20, 20, 20, 20));
            HBox z = new HBox(10);
            HBox z2 = new HBox(10);
            HBox z3 = new HBox(10);
            WindDialog zdg = new WindDialog();
            WindDialog zdg2 = new WindDialog();
            WindDialog zdg3 = new WindDialog();
            z.getChildren().addAll(new Label("Mark:"), zdg);
            z2.getChildren().addAll(new Label("Fanny:"), zdg2);
            z3.getChildren().addAll(new Label("Eric:"), zdg3);
            allZx.getChildren().addAll(new Label("The Zexors"), z, z2, z3);
            all.getChildren().addAll(allHy, allZx);
            Dialog<WindDialog> dialog = new Dialog<>();
            dialog.setResizable(true);
            dialog.setHeaderText("My players");
            dialog.setTitle("My players");
            DialogPane dgPane = new DialogPane();
            dgPane.setContent(all);
            dialog.setDialogPane(dgPane);
            ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
            dg.setOnAction((ActionEvent evt) -> {
                edgard.setColor(dg.getValue());
            });
            dg2.setOnAction((ActionEvent evt) -> {
                paul.setColor(dg2.getValue());
            });
            dg3.setOnAction((ActionEvent evt) -> {
                cathy.setColor(dg3.getValue());
            });
            zdg.setOnAction((ActionEvent evt) -> {
                MARK.setColor(zdg.getValue());
            });
            zdg2.setOnAction((ActionEvent evt) -> {
                FANNY.setColor(zdg2.getValue());
            });
            zdg3.setOnAction((ActionEvent evt) -> {
                ERIC.setColor(zdg3.getValue());
            });

            Optional<WindDialog> resultat = dialog.showAndWait();
            if (resultat.isPresent()) {
                myBorder.setCenter(flPane);
                
                replay.setVisible(true);

            }
        });
        //event to replay the game
        replayGame.setOnAction((ActionEvent et) -> {
            numbDice = nwRound.getNumberDiceEachRound();//call th method to generate the random dice
            numSides = nwRound.getNumberSideEachDice();
            String thisResult=game.round(nwRound, allHydrons[attaker], allZxors[defender]);
            t.setText(allHydrons[attaker].repHydRound());
            t2.setText(allZxors[defender].replayZxrRound());
            allHydrons[attaker].newPolyGon();
            h=new Polygon(allHydrons[attaker].getX1(),
            allHydrons[attaker].getY1(),allHydrons[attaker].getX2(),
            allHydrons[attaker].getY2(),allHydrons[attaker].getX3(),allHydrons[attaker].getY3());//i build the new polygone with the new size
            z.setWidth(allZxors[defender].getLarg());//i change the width size of zexors
            z.setHeight(allZxors[defender].getLarg());
            finalR=result+thisResult;
            txt.setText(finalR);
            
        });
        save.setOnAction((ActionEvent event) -> {

            try {
                output = new DataOutputStream(new FileOutputStream(saveFile, true));

            } catch (FileNotFoundException ex) {
                Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                output.writeUTF(finalR);

            } catch (IOException ex) {
                Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
            }

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information File");
            alert.setHeaderText(null);
            alert.setContentText("Great File saved");

            alert.showAndWait();
        });
        recap.setOnAction((ActionEvent event) -> {
            if (saveFile.exists()) {
                try (DataInputStream inputFile = new DataInputStream(new FileInputStream(saveFile))) {
                    try {
                        while (true) {
                            System.out.println(inputFile.readUTF());
                        }
                    } catch (EOFException ex) {
                        System.out.print("End of File");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(!saveFile.exists()){
               Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information File");
            alert.setHeaderText(null);
            alert.setContentText("No file found but it will be created");
            alert.showAndWait(); 
                try {
                    FileOutputStream fil=new FileOutputStream(saveFile,true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FinalProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        exit.setOnAction((ActionEvent event) -> {
            System.exit(0);
        });
        Scene scene = new Scene(myBorder, 800, 750);
        primaryStage.setTitle("Battle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
