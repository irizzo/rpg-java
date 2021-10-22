import Dice.Dice;

public class RpgCharacter {
  protected String name = "";

  protected int hp, strength, defense;

  protected boolean dead = false;

  Dice d20 = new Dice(20);

  // attributes methods
  protected void setName(String className) {
    this.name = className;
  }

  protected void setHp(int classHp) {
    this.hp = classHp;
  }

  protected void setStrength(int classStrength) {
    this.strength = classStrength;
  }

  protected void setDefense(int classDefense) {
    this.defense = classDefense;
  }

  /* actions */
  // iniciative
  protected int rollIniciative() {
    int iniciative = d20.roll();
    return iniciative;
  }

  // evasion
  protected int rollEvasion() {
    int evasion = d20.roll();
    return evasion;
  }

  // attack method
  protected void attack(RpgCharacter enemy) {
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
  protected void setDead(RpgCharacter killer) {
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
