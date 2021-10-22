package Characters;

import Dice.Dice;

public class Witch extends RpgCharacter {
  Dice d6 = new Dice(6);

  public Witch(String witchName, int witchHp, int witchStrength, int witchDefense) {
    super(witchName, witchHp, witchStrength, witchDefense);
  };

  // special ability: poisioning
  public void poison(RpgCharacter enemy) {
    int damage = d6.roll() + 2;

    enemy.hp -= damage;
  };
};
