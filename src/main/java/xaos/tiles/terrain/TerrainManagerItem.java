package xaos.tiles.terrain;

import java.util.ArrayList;
import xaos.utils.Utils;

public class TerrainManagerItem {

  public static final int TERRAIN_AIR_ID = 0;
  public static final String TERRAIN_AIR_INIHEADER = "_AIR";

  public static int CURRENT_TERRAIN_ID = 1;

  private String iniHeader;
  private int terrainID;
  private String name;
  private int mineTurns;
  private String drop;
  private int dropPCT;
  private String ladderItem;
  private boolean canBeFilled; // Para un-dig
  private String group;
  private boolean blocky;

  private ArrayList<String> actions;

  public TerrainManagerItem(String sIniHeader, String sName) {
    iniHeader = sIniHeader;
    name = sName;

    setTerrainID(CURRENT_TERRAIN_ID);
    CURRENT_TERRAIN_ID++;
  }

  public ArrayList<String> getActions() {
    return actions;
  }

  public String getDrop() {
    return drop;
  }

  public int getDropPCT() {
    return dropPCT;
  }

  public String getGroup() {
    return group;
  }

  public String getIniHeader() {
    return iniHeader;
  }

  public String getLadderItem() {
    return ladderItem;
  }

  public int getMineTurns() {
    return mineTurns;
  }

  public String getName() {
    return name;
  }

  public Terrain getTerrain() {
    Terrain terrain = new Terrain(getIniHeader());
    terrain.setMineTurns(getMineTurns());

    return terrain;
  }

  public int getTerrainID() {
    return terrainID;
  }

  public boolean hasActions() {
    return actions != null && actions.size() > 0;
  }

  public boolean isBlocky() {
    return blocky;
  }

  public boolean isCanBeFilled() {
    return canBeFilled;
  }

  public void setActions(ArrayList<String> actions) {
    this.actions = actions;
  }

  public void setBlocky(String sBlocky) {
    if (sBlocky == null || sBlocky.trim().isEmpty()) {
      setBlocky(true);
    } else {
      setBlocky(Boolean.parseBoolean(sBlocky));
    }
  }

  public void setBlocky(boolean blocky) {
    this.blocky = blocky;
  }

  public void setCanBeFilled(String sCanBeFilled) {
    setCanBeFilled(Boolean.parseBoolean(sCanBeFilled));
  }

  public void setCanBeFilled(boolean canBeFilled) {
    this.canBeFilled = canBeFilled;
  }

  public void setDrop(String drop) {
    this.drop = drop;
  }

  public void setDropPCT(String sDropPCT) {
    setDropPCT(Utils.getInteger(sDropPCT, 0));
  }

  public void setDropPCT(int dropPCT) {
    this.dropPCT = dropPCT;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setIniHeader(String iniHeader) {
    this.iniHeader = iniHeader;
  }

  public void setLadderItem(String ladderItem) {
    this.ladderItem = ladderItem;
  }

  public void setMineTurns(String sMineTurns) {
    setMineTurns(Utils.getInteger(sMineTurns, 0));
  }

  public void setMineTurns(int mineTurns) {
    this.mineTurns = mineTurns;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTerrainID(int terrainID) {
    this.terrainID = terrainID;
  }
}
