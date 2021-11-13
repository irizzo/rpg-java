package Dice;

import java.util.Random;
import java.lang.Math;

public class Dice {
  public int range;

  protected static Random rollDice = new Random();

  // constructor
  public Dice(int diceRange) {
    this.range = diceRange;
  }

  public int roll() {
    int result = rollDice.nextInt(1, this.range + 1);
    return result;
  }

  public int rollWithAdvantage() {
    int resultOne = roll();
    int resultTwo = roll();

    int greater = Math.max(resultOne, resultTwo);

    return greater;
  }

  public int rollWithDisadvantage() {
    int resultOne = roll();
    int resultTwo = roll();

    int smaller = Math.min(resultOne, resultTwo);

    return smaller;
  }
}
