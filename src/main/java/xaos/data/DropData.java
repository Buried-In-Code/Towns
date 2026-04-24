package xaos.data;

import xaos.utils.Utils;

public class DropData {

  public static final String ITEM_RANDOM = "RANDOM";

  private String item; // ID del item (o RANDOM)
  private String PCT; // Porcentaje de que salga
  private int levelMin; // En caso de drop=RANDOM se usa el nivel para obtener un item
  private int levelMax; // En caso de drop=RANDOM se usa el nivel para obtener un item

  public String getItem() {
    return item;
  }

  public int getLevelMax() {
    return levelMax;
  }

  public int getLevelMin() {
    return levelMin;
  }

  public String getPCT() {
    return PCT;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public void setLevelMax(String sLevelMax) {
    setLevelMax(Utils.getInteger(sLevelMax, 0));
  }

  public void setLevelMax(int levelMax) {
    this.levelMax = levelMax;
  }

  public void setLevelMin(String sLevelMin) {
    setLevelMin(Utils.getInteger(sLevelMin, 0));
  }

  public void setLevelMin(int levelMin) {
    this.levelMin = levelMin;
  }

  public void setPCT(String sPCT) {
    this.PCT = sPCT;
  }
}
