/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

public class DiceRoll {

    private int numDicEachRound;
    private int numberOfSidEachDice;
    private int numberRolled;
    //this method return the random number between 1 to 3
    public int getNumberDiceEachRound() {
        this.numDicEachRound = 1 + (int) (Math.random() * 4);//return the numbers of dice for each round
        return numDicEachRound;
    }

    public DiceRoll() {
    }
  //this method retur the even number between 4 to 20
    public int getNumberSideEachDice() {
        int randNumber;
        randNumber = 4 + (int) (Math.random() * 17);//return random number from 4 to 20
        if (randNumber % 2 != 0) {
            this.numberOfSidEachDice = randNumber + 1;
        }
        this.numberOfSidEachDice = randNumber;
        return numberOfSidEachDice;
    }
    //return the random number based on the number of sides returned
    public int getNumberRolled() {
        for (int i = 0; i < this.getNumberDiceEachRound(); i++) {
            this.numberRolled = 1 + (int) (Math.random() * this.getNumberSideEachDice());
        }
        return numberRolled;
    }
}
