package Characters;

import Dice.Dice;

public class Warrior extends RpgCharacter {
  Dice d6 = new Dice(6);

  public Warrior(String warriorName, int warriorHp, int warriorStrength, int warriorDefense) {
    super(warriorName, warriorHp, warriorStrength, warriorDefense);
  };

  // special ability: rage
  public void rage(RpgCharacter enemy) {
    int damage = d6.roll() + 1;
    enemy.hp -= damage;
  }
};
