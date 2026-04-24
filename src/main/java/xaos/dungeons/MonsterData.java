package xaos.dungeons;

import xaos.utils.Utils;

public class MonsterData {

  public static final String ID_RANDOM = "__RANDOM__";

  private String id;
  private int number;
  private int levelMin;
  private int levelMax;

  public String getId() {
    return id;
  }

  public int getLevelMax() {
    return levelMax;
  }

  public int getLevelMin() {
    return levelMin;
  }

  public int getNumber() {
    return number;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLevelMax(String sLevelMax) {
    setLevelMax(Utils.launchDice(sLevelMax));
  }

  public void setLevelMax(int levelMax) {
    this.levelMax = levelMax;
  }

  public void setLevelMin(String sLevelMin) {
    setLevelMin(Utils.launchDice(sLevelMin));
  }

  public void setLevelMin(int levelMin) {
    this.levelMin = levelMin;
  }

  public void setNumber(String sNumber) {
    setNumber(Utils.launchDice(sNumber));
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
