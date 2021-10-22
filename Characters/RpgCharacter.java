package Characters;

import Dice.Dice;

public class RpgCharacter {
  public String name = "";

  public int hp, strength, defense;

  // public String damageType;

  public boolean dead = false;

  Dice d20 = new Dice(20);

  // attributes methods
  public void setName(String charName) {
    this.name = charName;
  }

  public void setHp(int classHp) {
    this.hp = classHp;
  }

  public void setStrength(int classStrength) {
    this.strength = classStrength;
  }

  public void setDefense(int classDefense) {
    this.defense = classDefense;
  }

  /* actions */
  // iniciative
  public int rollIniciative() {
    int iniciative = d20.roll();
    return iniciative;
  }

  // evasion
  public int rollEvasion() {
    int evasion = d20.roll();
    return evasion;
  }

  // attack method
  public void attack(RpgCharacter enemy) {
    if (!enemy.dead) {
      int damage = this.strength - enemy.defense;
      enemy.hp -= damage;

      if (enemy.hp <= 0) {
        enemy.setDead(this);
      }
    } else {
      System.out.println("This enemy is already dead (" + enemy.name + ")\n");
    }
  }

  // die method
  public void setDead(RpgCharacter killer) {
    this.dead = true;
    System.out.println(this.name + " was killed by " + killer.name + '\n');
  }

  // get status
  public void getStatus() {
    if (this.dead) {
      System.out.println(this.name + " is dead.");

    } else {
      System.out.println(this.name + "'s hp is " + this.hp);
    }
  }

  // constructor
  public RpgCharacter(String charName, int charHp, int charStrength, int charDefense) {
    this.name = charName;
    this.hp = charHp;
    this.strength = charStrength;
    this.defense = charDefense;
  }
}
