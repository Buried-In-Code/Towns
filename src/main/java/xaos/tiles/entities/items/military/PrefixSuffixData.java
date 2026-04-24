package xaos.tiles.entities.items.military;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PrefixSuffixData implements Externalizable {

  private static final long serialVersionUID = 9140176356071939443L;

  public static final String TYPE_PREFIX = "prefix"; // $NON-NLS-1$
  public static final String TYPE_SUFFIX = "suffix"; // $NON-NLS-1$

  private String name;
  private int attack;
  private int attackSpeed;
  private int defense;
  private int healthPoints;
  private int damage;
  private int LOS;
  private int movePCT;
  private int walkSpeed;

  public PrefixSuffixData() {
  }

  public int getAttack() {
    return attack;
  }

  public int getAttackSpeed() {
    return attackSpeed;
  }

  public int getDamage() {
    return damage;
  }

  public int getDefense() {
    return defense;
  }

  public int getHealthPoints() {
    return healthPoints;
  }

  public int getLOS() {
    return LOS;
  }

  public int getMovePCT() {
    return movePCT;
  }

  public String getName() {
    return name;
  }

  public int getWalkSpeed() {
    return walkSpeed;
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    name = (String) in.readObject();
    attack = in.readInt();
    attackSpeed = in.readInt();
    defense = in.readInt();
    healthPoints = in.readInt();
    damage = in.readInt();
    LOS = in.readInt();
    movePCT = in.readInt();
    walkSpeed = in.readInt();
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public void setAttackSpeed(int attackSpeed) {
    this.attackSpeed = attackSpeed;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public void setLOS(int lOS) {
    LOS = lOS;
  }

  public void setMovePCT(int movePCT) {
    this.movePCT = movePCT;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWalkSpeed(int walkSpeed) {
    this.walkSpeed = walkSpeed;
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(name);
    out.writeInt(attack);
    out.writeInt(attackSpeed);
    out.writeInt(defense);
    out.writeInt(healthPoints);
    out.writeInt(damage);
    out.writeInt(LOS);
    out.writeInt(movePCT);
    out.writeInt(walkSpeed);
  }
}
