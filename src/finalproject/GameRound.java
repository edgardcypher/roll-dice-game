/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import javafx.scene.control.TextArea;

/**
 *
 * @author abcd
 */
public class GameRound {

    private int myZexorDiceRolled = 0;
    private int myHydronDiceRolled = 0;
    private TextArea narrate;
    
    private String result = "";
    private String otherResult = "";
    private String finalResult = "";
    private String myresult = "";

    public String myResult() {
        //String s=this.getNar()+this.getResult()+"\n";
        return this.myresult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public GameRound() {
    }
/* this methode compute the the number of side of each round and also the random
    number for each Zexor and hydron,and also the total result.moreover it display these randon
    number and the result for each round*/
    public String round(DiceRoll mydice, Hydron myHydron, Zexor myZexor) {
        String hdRoll = "Rolls: ";
        String xrsRoll = "Rolls: ";
        int hdResult = 0;
        int xrResult = 0;
        String nar = "";
        
        for (int j = 0; j < 3; j++) {
            String narr = "Round ";
            //int numbDice = mydice.getNumberDiceEachRound();
            int numbSide = mydice.getNumberSideEachDice();
            
            int zxr = 0;
            int hdr = 0;
      //this loop compute the total of numbers of dice thrown by zexor and hydrons
            for (int i = 0; i < 1; i++) {
                zxr += 1 + (int) (Math.random() * numbSide+1);
                xrsRoll += "," + zxr;
                xrResult += zxr;
                hdr += 1 + (int) (Math.random() * numbSide+1);
                hdRoll += "," + hdr;
                hdResult += hdr;
            }
            this.myZexorDiceRolled = zxr;
            this.myHydronDiceRolled = hdr;
            if (this.getMyZexorDiceRolled() > this.getMyHydronDiceRolled()) {
                narr+= j + 1 + " Zexor " + myZexor.getZexorName().getText() + " throws a " + this.getMyZexorDiceRolled() + ",and Hydron " + myHydron.getName().getText() + " defends by throwing a "
                        + this.getMyHydronDiceRolled() + " so Zexor " + myZexor.getZexorName().getText() + " wins this Round.\n";
                myHydron.setHealth(this.getMyZexorDiceRolled() - this.getMyHydronDiceRolled());
                myHydron.newPolyGon();
            }
            if (this.getMyZexorDiceRolled() < this.getMyHydronDiceRolled()) {
                narr+= j + 1 + " Zexor " + myZexor.getZexorName().getText() + " throws a " + this.getMyZexorDiceRolled() + " and Hydron " + myHydron.getName().getText() + " defends by throwing a "
                        + this.getMyHydronDiceRolled() + " so Hydron " + myHydron.getName().getText() + " wins this Round.\n";
                myZexor.setHealthZexor(this.getMyHydronDiceRolled() - this.getMyZexorDiceRolled());
                myZexor.changeSizeZexor();
            }
            if (this.getMyZexorDiceRolled() == this.getMyHydronDiceRolled()) {
                narr+= j + 1 + " Draw game.\n";
            }
            nar += narr;
        }
        if (xrResult > hdResult) {
            this.result = "Final Score: " + myZexor.getZexorName().getText() + " has " + xrResult + " and " + myHydron.getName().getText() + " has " + hdResult + " ,so " + myZexor.getZexorName().getText() + " is the final winner\n";
        } else {
            this.result = "Final Score : " + myHydron.getName().getText() + " has " + hdResult + " and " + myZexor.getZexorName().getText() + " has " + xrResult + " ,so " + myHydron.getName().getText() + " is the final winner\n";
        }
        myHydron.setRoll(hdRoll);//i set the string of each random number generated for hydron
        myZexor.setZrRoll(xrsRoll);//i set the string for each random number generated for Zexor
        return nar + this.result;// message for the TextArea that narrate each game
    }

    public String getResult() {
        return result;
    }

    public int getMyZexorDiceRolled() {
        return myZexorDiceRolled;
    }

    public int getMyHydronDiceRolled() {
        return myHydronDiceRolled;
    }


}
