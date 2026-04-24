package xaos.campaign;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import xaos.main.Game;
import xaos.panels.ImagesPanel;
import xaos.utils.UtilsIniHeaders;

public class TutorialFlow implements Externalizable {
  private static final long serialVersionUID = 8482871306171841743L;

  private int[] blinkItems;
  private ArrayList<String> blinkPiles;
  private ArrayList<String> blinkBottom;
  private ArrayList<String> blinkRight;
  private ArrayList<String> blinkProduction;
  private boolean blinkProductionRegularPlus;
  private boolean blinkProductionRegularMinus;
  private boolean blinkProductionAutomatedPlus;
  private boolean blinkProductionAutomatedMinus;
  private boolean orderedTriggers;
  private ArrayList<TutorialTrigger> triggers;
  private String title;
  private ArrayList<String> texts;
  private String image;
  private String tile;
  private ArrayList<String> startEvents;
  private String nextMission;

  private boolean blinkMiniFlat;
  private boolean blinkMiniGrid;
  private boolean blinkMiniFlatCursor;
  private boolean blinkMini3DMouse;
  private boolean blinkMiniSettings;
  private boolean blinkMiniLevelUp;
  private boolean blinkMiniLevelDown;
  private boolean blinkMiniSpeedUp;
  private boolean blinkMiniSpeedDown;
  private boolean blinkMiniPause;
  private boolean blinkMiniCitizens;
  private boolean blinkMiniSoldiers;
  private boolean blinkMiniHeroes;
  private boolean blinkMiniTrade;
  private boolean blinkMiniLivingsLivings;
  private boolean blinkMiniLivingsBody;
  private boolean blinkMiniLivingsAutoequip;
  private boolean blinkMiniLivingsConvertSoldier;
  private boolean blinkMiniLivingsJobs;
  private boolean blinkMiniLivingsGroup;
  private boolean blinkMiniLivingsConvertCivilian;
  private boolean blinkMiniLivingsRestriction;
  private boolean blinkMiniLivingsGuard;
  private boolean blinkMiniLivingsPatrol;
  private boolean blinkMiniLivingsBoss;

  public TutorialFlow() {
  }

  public static boolean currentBlinkBottom(String sID) {
    if (sID == null) {
      return false;
    }

    if (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()) {
      if (Game.getCurrentMissionData()
          .getTutorialFlows()
          .get(ImagesPanel.getCurrentFlowIndex())
          .getBlinkBottom() != null) {
        return Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkBottom()
            .contains(sID);
      }
    }

    return false;
  }

  public static boolean currentBlinkItem(String sID) {
    if (sID == null) {
      return false;
    }

    if (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()) {
      return UtilsIniHeaders.contains(
          Game.getCurrentMissionData()
              .getTutorialFlows()
              .get(ImagesPanel.getCurrentFlowIndex())
              .getBlinkItems(),
          UtilsIniHeaders.getIntIniHeader(sID));
    }

    return false;
  }

  public static boolean currentBlinkPiles(String sID) {
    if (sID == null) {
      return false;
    }

    if (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkPiles() != null) {
      return Game.getCurrentMissionData()
          .getTutorialFlows()
          .get(ImagesPanel.getCurrentFlowIndex())
          .getBlinkPiles()
          .contains(sID);
    }

    return false;
  }

  public static boolean currentBlinkProduction(String sID) {
    if (sID == null) {
      return false;
    }

    if (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()) {
      if (Game.getCurrentMissionData()
          .getTutorialFlows()
          .get(ImagesPanel.getCurrentFlowIndex())
          .getBlinkProduction() != null) {
        return Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkProduction()
            .contains(sID);
      }
    }

    return false;
  }

  public static boolean currentBlinkRight(String sID) {
    if (sID == null) {
      return false;
    }

    if (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()) {
      if (Game.getCurrentMissionData()
          .getTutorialFlows()
          .get(ImagesPanel.getCurrentFlowIndex())
          .getBlinkRight() != null) {
        return Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkRight()
            .contains(sID);
      }
    }

    return false;
  }

  /**
   * Checks if there are any blink on the bottom menu
   *
   * @return
   */
  public static boolean isBlinkBottom() {
    return (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkBottom() != null
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkBottom()
            .size() > 0);
  }

  /**
   * Checks if there are any blink items
   *
   * @return
   */
  public static boolean isBlinkItems() {
    return (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkItems() != null
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkItems().length > 0);
  }

  /**
   * Checks if there are any blink piles
   *
   * @return
   */
  public static boolean isBlinkPiles() {
    return (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkPiles() != null
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkPiles()
            .size() > 0);
  }

  /**
   * Checks if there are any blink on the production menu
   *
   * @return
   */
  public static boolean isBlinkProduction() {
    return (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkProduction() != null
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkProduction()
            .size() > 0);
  }

  /**
   * Checks if there are any blink on the right menu
   *
   * @return
   */
  public static boolean isBlinkRight() {
    return (Game.getCurrentMissionData() != null
        && ImagesPanel.getCurrentFlowIndex() >= 0
        && ImagesPanel.getCurrentFlowIndex() < Game.getCurrentMissionData().getTutorialFlows().size()
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkRight() != null
        && Game.getCurrentMissionData()
            .getTutorialFlows()
            .get(ImagesPanel.getCurrentFlowIndex())
            .getBlinkRight()
            .size() > 0);
  }

  public ArrayList<String> getBlinkBottom() {
    return blinkBottom;
  }

  public int[] getBlinkItems() {
    return blinkItems;
  }

  public ArrayList<String> getBlinkPiles() {
    return blinkPiles;
  }

  public ArrayList<String> getBlinkProduction() {
    return blinkProduction;
  }

  public ArrayList<String> getBlinkRight() {
    return blinkRight;
  }

  public String getImage() {
    return image;
  }

  public String getNextMission() {
    return nextMission;
  }

  public ArrayList<String> getStartEvents() {
    return startEvents;
  }

  public ArrayList<String> getTexts() {
    return texts;
  }

  public String getTile() {
    return tile;
  }

  public String getTitle() {
    return title;
  }

  public ArrayList<TutorialTrigger> getTriggers() {
    return triggers;
  }

  public boolean isBlinkMini3DMouse() {
    return blinkMini3DMouse;
  }

  public boolean isBlinkMiniCitizens() {
    return blinkMiniCitizens;
  }

  public boolean isBlinkMiniFlat() {
    return blinkMiniFlat;
  }

  public boolean isBlinkMiniFlatCursor() {
    return blinkMiniFlatCursor;
  }

  public boolean isBlinkMiniGrid() {
    return blinkMiniGrid;
  }

  public boolean isBlinkMiniHeroes() {
    return blinkMiniHeroes;
  }

  public boolean isBlinkMiniLevelDown() {
    return blinkMiniLevelDown;
  }

  public boolean isBlinkMiniLevelUp() {
    return blinkMiniLevelUp;
  }

  public boolean isBlinkMiniLivingsAutoequip() {
    return blinkMiniLivingsAutoequip;
  }

  public boolean isBlinkMiniLivingsBody() {
    return blinkMiniLivingsBody;
  }

  public boolean isBlinkMiniLivingsBoss() {
    return blinkMiniLivingsBoss;
  }

  public boolean isBlinkMiniLivingsConvertCivilian() {
    return blinkMiniLivingsConvertCivilian;
  }

  public boolean isBlinkMiniLivingsConvertSoldier() {
    return blinkMiniLivingsConvertSoldier;
  }

  public boolean isBlinkMiniLivingsGroup() {
    return blinkMiniLivingsGroup;
  }

  public boolean isBlinkMiniLivingsGuard() {
    return blinkMiniLivingsGuard;
  }

  public boolean isBlinkMiniLivingsJobs() {
    return blinkMiniLivingsJobs;
  }

  public boolean isBlinkMiniLivingsLivings() {
    return blinkMiniLivingsLivings;
  }

  public boolean isBlinkMiniLivingsPatrol() {
    return blinkMiniLivingsPatrol;
  }

  public boolean isBlinkMiniLivingsRestriction() {
    return blinkMiniLivingsRestriction;
  }

  public boolean isBlinkMiniPause() {
    return blinkMiniPause;
  }

  public boolean isBlinkMiniSettings() {
    return blinkMiniSettings;
  }

  public boolean isBlinkMiniSoldiers() {
    return blinkMiniSoldiers;
  }

  public boolean isBlinkMiniSpeedDown() {
    return blinkMiniSpeedDown;
  }

  public boolean isBlinkMiniSpeedUp() {
    return blinkMiniSpeedUp;
  }

  public boolean isBlinkMiniTrade() {
    return blinkMiniTrade;
  }

  public boolean isBlinkProductionAutomatedMinus() {
    return blinkProductionAutomatedMinus;
  }

  public boolean isBlinkProductionAutomatedPlus() {
    return blinkProductionAutomatedPlus;
  }

  public boolean isBlinkProductionRegularMinus() {
    return blinkProductionRegularMinus;
  }

  public boolean isBlinkProductionRegularPlus() {
    return blinkProductionRegularPlus;
  }

  public boolean isOrderedTriggers() {
    return orderedTriggers;
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    blinkItems = (int[]) in.readObject();
    blinkPiles = (ArrayList<String>) in.readObject();
    blinkBottom = (ArrayList<String>) in.readObject();
    blinkRight = (ArrayList<String>) in.readObject();
    blinkProduction = (ArrayList<String>) in.readObject();

    blinkProductionRegularPlus = in.readBoolean();
    blinkProductionRegularMinus = in.readBoolean();
    blinkProductionAutomatedPlus = in.readBoolean();
    blinkProductionAutomatedMinus = in.readBoolean();
    orderedTriggers = in.readBoolean();

    triggers = (ArrayList<TutorialTrigger>) in.readObject();
    title = (String) in.readObject();
    texts = (ArrayList<String>) in.readObject();
    startEvents = (ArrayList<String>) in.readObject();
    image = (String) in.readObject();

    blinkMiniFlat = in.readBoolean();
    blinkMiniGrid = in.readBoolean();
    blinkMiniFlatCursor = in.readBoolean();
    blinkMini3DMouse = in.readBoolean();
    blinkMiniSettings = in.readBoolean();
    blinkMiniLevelUp = in.readBoolean();
    blinkMiniLevelDown = in.readBoolean();
    blinkMiniSpeedUp = in.readBoolean();
    blinkMiniSpeedDown = in.readBoolean();
    blinkMiniPause = in.readBoolean();
  }

  public void setBlinkBottom(ArrayList<String> blinkBottom) {
    this.blinkBottom = blinkBottom;
  }

  public void setBlinkItems(String sBlinkItems) {
    this.blinkItems = UtilsIniHeaders.getIntsArray(sBlinkItems);
  }

  public void setBlinkMini3DMouse(boolean blinkMini3DMouse) {
    this.blinkMini3DMouse = blinkMini3DMouse;
  }

  public void setBlinkMiniCitizens(boolean blinkMiniCitizens) {
    this.blinkMiniCitizens = blinkMiniCitizens;
  }

  public void setBlinkMiniFlat(boolean blinkMiniFlat) {
    this.blinkMiniFlat = blinkMiniFlat;
  }

  public void setBlinkMiniFlatCursor(boolean blinkMiniFlatCursor) {
    this.blinkMiniFlatCursor = blinkMiniFlatCursor;
  }

  public void setBlinkMiniGrid(boolean blinkMiniGrid) {
    this.blinkMiniGrid = blinkMiniGrid;
  }

  public void setBlinkMiniHeroes(boolean blinkMiniHeroes) {
    this.blinkMiniHeroes = blinkMiniHeroes;
  }

  public void setBlinkMiniLevelDown(boolean blinkMiniLevelDown) {
    this.blinkMiniLevelDown = blinkMiniLevelDown;
  }

  public void setBlinkMiniLevelUp(boolean blinkMiniLevelUp) {
    this.blinkMiniLevelUp = blinkMiniLevelUp;
  }

  public void setBlinkMiniLivingsAutoequip(boolean blinkMiniLivingsAutoequip) {
    this.blinkMiniLivingsAutoequip = blinkMiniLivingsAutoequip;
  }

  public void setBlinkMiniLivingsBody(boolean blinkMiniLivingsBody) {
    this.blinkMiniLivingsBody = blinkMiniLivingsBody;
  }

  public void setBlinkMiniLivingsBoss(boolean blinkMiniLivingsBoss) {
    this.blinkMiniLivingsBoss = blinkMiniLivingsBoss;
  }

  public void setBlinkMiniLivingsConvertCivilian(boolean blinkMiniLivingsConvertCivilian) {
    this.blinkMiniLivingsConvertCivilian = blinkMiniLivingsConvertCivilian;
  }

  public void setBlinkMiniLivingsConvertSoldier(boolean blinkMiniLivingsConvertSoldier) {
    this.blinkMiniLivingsConvertSoldier = blinkMiniLivingsConvertSoldier;
  }

  public void setBlinkMiniLivingsGroup(boolean blinkMiniLivingsGroup) {
    this.blinkMiniLivingsGroup = blinkMiniLivingsGroup;
  }

  public void setBlinkMiniLivingsGuard(boolean blinkMiniLivingsGuard) {
    this.blinkMiniLivingsGuard = blinkMiniLivingsGuard;
  }

  public void setBlinkMiniLivingsJobs(boolean blinkMiniLivingsJobs) {
    this.blinkMiniLivingsJobs = blinkMiniLivingsJobs;
  }

  public void setBlinkMiniLivingsLivings(boolean blinkMiniLivingsLivings) {
    this.blinkMiniLivingsLivings = blinkMiniLivingsLivings;
  }

  public void setBlinkMiniLivingsPatrol(boolean blinkMiniLivingsPatrol) {
    this.blinkMiniLivingsPatrol = blinkMiniLivingsPatrol;
  }

  public void setBlinkMiniLivingsRestriction(boolean blinkMiniLivingsRestriction) {
    this.blinkMiniLivingsRestriction = blinkMiniLivingsRestriction;
  }

  public void setBlinkMiniPause(boolean blinkMiniPause) {
    this.blinkMiniPause = blinkMiniPause;
  }

  public void setBlinkMiniSettings(boolean blinkMiniSettings) {
    this.blinkMiniSettings = blinkMiniSettings;
  }

  public void setBlinkMiniSoldiers(boolean blinkMiniSoldiers) {
    this.blinkMiniSoldiers = blinkMiniSoldiers;
  }

  public void setBlinkMiniSpeedDown(boolean blinkMiniSpeedDown) {
    this.blinkMiniSpeedDown = blinkMiniSpeedDown;
  }

  public void setBlinkMiniSpeedUp(boolean blinkMiniSpeedUp) {
    this.blinkMiniSpeedUp = blinkMiniSpeedUp;
  }

  public void setBlinkMiniTrade(boolean blinkMiniTrade) {
    this.blinkMiniTrade = blinkMiniTrade;
  }

  public void setBlinkMinis(ArrayList<String> alMinis) {
    if (alMinis != null) {
      String sAux;
      for (int i = 0; i < alMinis.size(); i++) {
        sAux = alMinis.get(i);
        if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_FLAT)) {
          setBlinkMiniFlat(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_GRID)) {
          setBlinkMiniGrid(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_FLATCURSOR)) {
          setBlinkMiniFlatCursor(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_3DMOUSE)) {
          setBlinkMini3DMouse(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_SETTINGS)) {
          setBlinkMiniSettings(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LEVELUP)) {
          setBlinkMiniLevelUp(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LEVELDOWN)) {
          setBlinkMiniLevelDown(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_SPEEDUP)) {
          setBlinkMiniSpeedUp(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_SPEEDDOWN)) {
          setBlinkMiniSpeedDown(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_PAUSE)) {
          setBlinkMiniPause(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_REGULAR_PLUS)) {
          setBlinkProductionRegularPlus(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_REGULAR_MINUS)) {
          setBlinkProductionRegularMinus(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_AUTOMATED_PLUS)) {
          setBlinkProductionAutomatedPlus(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_AUTOMATED_MINUS)) {
          setBlinkProductionAutomatedMinus(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_CITIZENS)) {
          setBlinkMiniCitizens(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_SOLDIERS)) {
          setBlinkMiniSoldiers(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_HEROES)) {
          setBlinkMiniHeroes(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_TRADE)) {
          setBlinkMiniTrade(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_LIVINGS)) {
          setBlinkMiniLivingsLivings(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_BODY)) {
          setBlinkMiniLivingsBody(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_AUTOEQUIP)) {
          setBlinkMiniLivingsAutoequip(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_CONVERTSOLDIER)) {
          setBlinkMiniLivingsConvertSoldier(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_JOBS)) {
          setBlinkMiniLivingsJobs(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_GROUPS)) {
          setBlinkMiniLivingsGroup(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_CONVERTCIVILIAN)) {
          setBlinkMiniLivingsConvertCivilian(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_RESTRICTION)) {
          setBlinkMiniLivingsRestriction(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_GUARD)) {
          setBlinkMiniLivingsGuard(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_PATROL)) {
          setBlinkMiniLivingsPatrol(true);
        } else if (sAux.equalsIgnoreCase(TutorialTrigger.ICON_LIVINGS_BOSS)) {
          setBlinkMiniLivingsBoss(true);
        }
      }
    }
  }

  public void setBlinkPiles(ArrayList<String> blinkPiles) {
    this.blinkPiles = blinkPiles;
  }

  public void setBlinkProduction(ArrayList<String> blinkProduction) {
    this.blinkProduction = blinkProduction;
  }

  public void setBlinkProductionAutomatedMinus(boolean blinkProductionAutomatedMinus) {
    this.blinkProductionAutomatedMinus = blinkProductionAutomatedMinus;
  }

  public void setBlinkProductionAutomatedPlus(boolean blinkProductionAutomatedPlus) {
    this.blinkProductionAutomatedPlus = blinkProductionAutomatedPlus;
  }

  public void setBlinkProductionRegularMinus(boolean blinkProductionRegularMinus) {
    this.blinkProductionRegularMinus = blinkProductionRegularMinus;
  }

  public void setBlinkProductionRegularPlus(boolean blinkProductionRegularPlus) {
    this.blinkProductionRegularPlus = blinkProductionRegularPlus;
  }

  public void setBlinkRight(ArrayList<String> blinkRight) {
    this.blinkRight = blinkRight;
  }

  public void setImage(String image) {
    if (image != null && image.trim().isEmpty()) {
      this.image = null;
    } else {
      this.image = image;
    }
  }

  public void setNextMission(String nextMission) {
    this.nextMission = nextMission;
  }

  public void setOrderedTriggers(String sOrderedTriggers) {
    this.orderedTriggers = Boolean.parseBoolean(sOrderedTriggers);
  }

  public void setOrderedTriggers(boolean orderedTriggers) {
    this.orderedTriggers = orderedTriggers;
  }

  public void setStartEvents(ArrayList<String> startEvents) {
    this.startEvents = startEvents;
  }

  public void setTexts(ArrayList<String> texts) {
    this.texts = texts;
  }

  public void setTile(String tile) {
    if (tile != null && tile.trim().isEmpty()) {
      this.tile = null;
    } else {
      this.tile = tile;
    }
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTriggers(ArrayList<TutorialTrigger> triggers) {
    this.triggers = triggers;
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(blinkItems);
    out.writeObject(blinkPiles);
    out.writeObject(blinkBottom);
    out.writeObject(blinkRight);
    out.writeObject(blinkProduction);

    out.writeBoolean(blinkProductionRegularPlus);
    out.writeBoolean(blinkProductionRegularMinus);
    out.writeBoolean(blinkProductionAutomatedPlus);
    out.writeBoolean(blinkProductionAutomatedMinus);
    out.writeBoolean(orderedTriggers);

    out.writeObject(triggers);
    out.writeObject(title);
    out.writeObject(texts);
    out.writeObject(startEvents);
    out.writeObject(image);

    out.writeBoolean(blinkMiniFlat);
    out.writeBoolean(blinkMiniGrid);
    out.writeBoolean(blinkMiniFlatCursor);
    out.writeBoolean(blinkMini3DMouse);
    out.writeBoolean(blinkMiniSettings);
    out.writeBoolean(blinkMiniLevelUp);
    out.writeBoolean(blinkMiniLevelDown);
    out.writeBoolean(blinkMiniSpeedUp);
    out.writeBoolean(blinkMiniSpeedDown);
    out.writeBoolean(blinkMiniPause);
  }
}
