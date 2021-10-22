import Dice.Dice;

public class Game {
  public static void main(String[] args) {
    Witch player1 = new Witch("9Diamantes", 60, 5, 2);
    Warrior player2 = new Warrior("Comedor", 80, 7, 5);

    Dice d6 = new Dice(6);
    Dice d20 = new Dice(20);

    int turns = d20.roll();
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

      player1.getStatus();
      player2.getStatus();
      System.out.println("\n \n");
    }
  }
}
