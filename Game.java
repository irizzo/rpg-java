
import Characters.Warrior;
import Characters.Witch;
import Dice.Dice;

public class Game {
  public static void main(String[] args) {
    Witch player1 = new Witch("9Diamantes", 60, 5, 2);
    Warrior player2 = new Warrior("DarkKnigth", 80, 7, 5);

    Dice d6 = new Dice(6);

    int turns = 20;
    int i;

    System.out.println("[Game] turns = " + turns);

    // turnos do jogo
    for (i = 1; i <= turns; i++) {
      System.out.println("[Game] turn = " + i);

      int player1Iniciative = player1.rollIniciative();
      int player2Iniciative = player2.rollIniciative();

      if (player1Iniciative > player2Iniciative) {
        // player1's iniciative is greater
        System.out.println(player1.name + " attacks first!");

        player1.attack(player2);
        player2.attack(player1);

      } else if (player2Iniciative > player1Iniciative) {
        // player2's iniciative is greater
        System.out.println(player2.name + " attacks first!");

        player2.attack(player1);
        player1.attack(player2);

      } else {
        // same iniciatives
        int luck = d6.roll();

        if (luck >= 3) {
          System.out.println(player1.name + "'s luck!");
          player1.attack(player2);

        } else {
          System.out.println(player2.name + "'s luck!");
          player2.attack(player1);
        }
      }

      // check if any player is dead
      if (player1.dead) {
        System.out.println("[Game] " + player1.name + " is dead. Winner: " + player2.name);
        break;

      } else if (player2.dead) {
        System.out.println("[Game] " + player2.name + " is dead. Winner: " + player1.name);
        break;

      } else {
        if (player1Iniciative > 15) {
          System.out.println(player1.name + " uses their special ability!");

          player1.poison(player2);
        }

        if (player2Iniciative > 15) {
          System.out.println(player2.name + " uses their special ability!");

          player2.rage(player1);
        }

        // game is still on
        player1.getStatus();
        player2.getStatus();
        System.out.println("\n \n");
      }
    }
  }
}
