import java.util.Random;

public class Game {
  public static void main(String[] args) {
    Witch player1 = new Witch("9Diamantes", 60, 5, 2);
    Warrior player2 = new Warrior("Comedor", 80, 7, 5);

    Random d6 = new Random();

    int turns = 20;
    int i;

    // turnos do jogo
    for (i = 0; i < turns; i++) {
      int diceValue = d6.nextInt(1, 6);

      if (diceValue >= 3) {
        player1.attack(player2);
      } else {
        player2.attack(player1);
      }

      player1.getStatus();
      player2.getStatus();
    }

    System.out.println(player1.getClass());
  }
}
