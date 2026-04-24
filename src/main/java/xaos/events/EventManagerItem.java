package xaos.events;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import xaos.data.EventData;
import xaos.data.HateData;
import xaos.generator.BezierData;
import xaos.generator.ChangeData;
import xaos.generator.Generator;
import xaos.generator.GeneratorItem;
import xaos.generator.HeightSeedData;
import xaos.generator.MapGeneratorItem;
import xaos.generator.ParentMapData;
import xaos.generator.SeedData;
import xaos.tiles.Tile;
import xaos.utils.Messages;
import xaos.utils.Utils;

/** Clase de tipo "managerItem", no es la que se ańade a la lista de eventos */
public class EventManagerItem {

  private String id;
  private String name;
  private Tile icon;
  private int order;
  private int minPopulation;
  private boolean spawnAtRandom;
  private String turns;
  private String eventCooldown;
  private ArrayList<String> afterEvents;
  private boolean shadows;
  private boolean halfShadows;
  private float red;
  private float green;
  private float blue;
  private ArrayList<String> prerequisites;
  private ArrayList<String> eventsImmune;
  private String waitPCT;
  private String walkSpeedPCT;
  private String happinessPCT;
  private boolean siege;
  private boolean siegeUnderground;
  private ArrayList<String> siegeLivings;
  private ArrayList<String> siegeSize;
  private ArrayList<String> targets;
  private HateData targetsHateData;
  private ArrayList<String> targetsPCT;
  private String targetsRandomCell;
  private boolean targetsOpenCell;
  private ArrayList<String> effects;
  private ArrayList<String> effectsAfterEat;
  private ArrayList<String> effectsAfterSleep;
  private ArrayList<String> items;
  private ArrayList<String> itemsMaxAgePCT;
  private ArrayList<String> itemsDeletePCT;
  private ArrayList<String> itemsSpawnLiving;
  private ArrayList<String> itemsSpawnLivingSize;

  private String fxBeforeCooldown;
  private String fxAfterCooldown;
  private String fxRunning;
  private int fxRunningTurns;
  private String fxFinish;

  private ArrayList<String> injectActions;

  private String useFile;
  private ArrayList<String> useFileIDs;
  private HashMap<String, ParentMapData> hmFile;

  public ArrayList<String> getAfterEvents() {
    return afterEvents;
  }

  public float getBlue() {
    return blue;
  }

  public ArrayList<String> getEffects() {
    return effects;
  }

  public ArrayList<String> getEffectsAfterEat() {
    return effectsAfterEat;
  }

  public ArrayList<String> getEffectsAfterSleep() {
    return effectsAfterSleep;
  }

  public String getEventCooldown() {
    return eventCooldown;
  }

  public EventData getEventDataInstance() {
    EventData eventData = new EventData(id);

    eventData.setOrder(getOrder());
    eventData.setTurns(Utils.launchDice(getTurns()));
    eventData.setEventCooldown(Utils.launchDice(getEventCooldown()));
    eventData.setWaitPCT(Utils.launchDice(getWaitPCT()));
    eventData.setWalkSpeedPCT(Utils.launchDice(getWalkSpeedPCT()));
    eventData.setFxRunningTurns(1);

    return eventData;
  }

  public ArrayList<String> getEventsImmune() {
    return eventsImmune;
  }

  public String getFxAfterCooldown() {
    return fxAfterCooldown;
  }

  public String getFxBeforeCooldown() {
    return fxBeforeCooldown;
  }

  public String getFxFinish() {
    return fxFinish;
  }

  public String getFxRunning() {
    return fxRunning;
  }

  public int getFxRunningTurns() {
    return fxRunningTurns;
  }

  public float getGreen() {
    return green;
  }

  public String getHappinessPCT() {
    return happinessPCT;
  }

  public Tile getIcon() {
    return icon;
  }

  public String getId() {
    return id;
  }

  public ArrayList<String> getInjectActions() {
    return injectActions;
  }

  public ArrayList<String> getItems() {
    return items;
  }

  public ArrayList<String> getItemsDeletePCT() {
    return itemsDeletePCT;
  }

  public ArrayList<String> getItemsMaxAgePCT() {
    return itemsMaxAgePCT;
  }

  public ArrayList<String> getItemsSpawnLiving() {
    return itemsSpawnLiving;
  }

  public ArrayList<String> getItemsSpawnLivingSize() {
    return itemsSpawnLivingSize;
  }

  public int getMinPopulation() {
    return minPopulation;
  }

  public String getName() {
    return name;
  }

  public int getOrder() {
    return order;
  }

  public ParentMapData getParentMapData(String sID) {
    if (hmFile == null || sID == null) {
      return null;
    }

    return hmFile.get(sID);
  }

  public ArrayList<String> getPrerequisites() {
    return prerequisites;
  }

  public float getRed() {
    return red;
  }

  public ArrayList<String> getSiegeLivings() {
    return siegeLivings;
  }

  public ArrayList<String> getSiegeSize() {
    return siegeSize;
  }

  public ArrayList<String> getTargets() {
    return targets;
  }

  public HateData getTargetsHateData() {
    return targetsHateData;
  }

  public ArrayList<String> getTargetsPCT() {
    return targetsPCT;
  }

  public String getTargetsRandomCell() {
    return targetsRandomCell;
  }

  public String getTurns() {
    return turns;
  }

  public String getUseFile() {
    return useFile;
  }

  public ArrayList<String> getUseFileIDs() {
    return useFileIDs;
  }

  public String getWaitPCT() {
    return waitPCT;
  }

  public String getWalkSpeedPCT() {
    return walkSpeedPCT;
  }

  public boolean isHalfShadows() {
    return halfShadows;
  }

  public boolean isShadows() {
    return shadows;
  }

  public boolean isSiege() {
    return siege;
  }

  public boolean isSiegeUnderground() {
    return siegeUnderground;
  }

  public boolean isSpawnAtRandom() {
    return spawnAtRandom;
  }

  public boolean isTargetsOpenCell() {
    return targetsOpenCell;
  }

  /**
   * Carga en memoria los datos de un gen_events.
   *
   * @param sXMLName
   *            Ruta al gen_events. El fichero debe estar en la misma carpeta
   */
  public void loadUseFile(String sXMLName) throws Exception {
    if (this.useFile != null
        && this.useFile.length() > 0
        && this.useFileIDs != null
        && this.useFileIDs.size() > 0) {
      File fEvents = new File(sXMLName);
      File fEventsParent = fEvents.getParentFile();
      if (fEventsParent == null) {
        throw new Exception(Messages.getString("EventManagerItem.8")); // $NON-NLS-1$
      }

      File fGenEvents = new File(fEventsParent.getAbsolutePath() + File.separator + this.useFile);
      if (!fGenEvents.exists()) {
        throw new Exception(Messages.getString("EventManagerItem.10")); // $NON-NLS-1$
      }
      if (fGenEvents.isDirectory()) {
        throw new Exception(Messages.getString("EventManagerItem.11")); // $NON-NLS-1$
      }

      // Todo ok, cargamos
      hmFile = new HashMap<String, ParentMapData>();
      Generator generator = new Generator();
      Generator.read(fGenEvents.getAbsolutePath(), generator, true);

      GeneratorItem item;
      for (int i = 0; i < generator.getList().size(); i++) {
        item = generator.getList().get(i);
        if (item.getName() == MapGeneratorItem.ITEM_SEED) {
          hmFile.put(item.getId(), new SeedData(item));
        } else if (item.getName() == MapGeneratorItem.ITEM_HEIGHTSEED) {
          hmFile.put(item.getId(), new HeightSeedData(item));
        } else if (item.getName() == MapGeneratorItem.ITEM_BEZIER) {
          hmFile.put(item.getId(), new BezierData(item));
        } else if (item.getName() == MapGeneratorItem.ITEM_CHANGE) {
          hmFile.put(item.getId(), new ChangeData(item));
        } else {
          throw new Exception(
              Messages.getString("MapGenerator.0")
                  + item.getName()
                  + Messages.getString("MapGenerator.1")
                  + fGenEvents.getAbsolutePath()
                  + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
      }
    }
  }

  public void setAfterEvents(ArrayList<String> afterEvents) {
    this.afterEvents = afterEvents;
  }

  public void setBlue(String blue) throws Exception {
    if (blue == null || blue.isEmpty()) {
      setBlue(0);
    } else {
      try {
        setBlue(Float.parseFloat(blue));
      } catch (NumberFormatException nfe) {
        throw new Exception(
            Messages.getString("EventManagerItem.23")
                + " ["
                + blue
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
  }

  public void setBlue(float blue) {
    this.blue = blue;
  }

  public void setEffects(ArrayList<String> effects) {
    this.effects = effects;
  }

  public void setEffectsAfterEat(ArrayList<String> effectsAfterEat) {
    this.effectsAfterEat = effectsAfterEat;
  }

  public void setEffectsAfterSleep(ArrayList<String> effectsAfterSleep) {
    this.effectsAfterSleep = effectsAfterSleep;
  }

  public void setEventCooldown(String eventCooldown) {
    this.eventCooldown = eventCooldown;
  }

  public void setEventsImmune(ArrayList<String> eventsImmune) {
    this.eventsImmune = eventsImmune;
  }

  public void setFxAfterCooldown(String fxAfterCooldown) {
    this.fxAfterCooldown = fxAfterCooldown;
  }

  public void setFxBeforeCooldown(String fxBeforeCooldown) {
    this.fxBeforeCooldown = fxBeforeCooldown;
  }

  public void setFxFinish(String fxFinish) {
    this.fxFinish = fxFinish;
  }

  public void setFxRunning(String fxRunning) {
    this.fxRunning = fxRunning;
  }

  public void setFxRunningTurns(String sFxRunningTurns) throws Exception {
    if (sFxRunningTurns == null || sFxRunningTurns.trim().isEmpty()) {
      setFxRunningTurns(0);
    } else {
      try {
        setFxRunningTurns(Integer.parseInt(sFxRunningTurns));
      } catch (Exception e) {
        throw new Exception(
            Messages.getString("EventManagerItem.7")
                + " ["
                + sFxRunningTurns
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
  }

  public void setFxRunningTurns(int fxRunningTurns) {
    this.fxRunningTurns = fxRunningTurns;
  }

  public void setGreen(String green) throws Exception {
    if (green == null || green.isEmpty()) {
      setGreen(0);
    } else {
      try {
        setGreen(Float.parseFloat(green));
      } catch (NumberFormatException nfe) {
        throw new Exception(
            Messages.getString("EventManagerItem.20")
                + " ["
                + green
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
  }

  public void setGreen(float green) {
    this.green = green;
  }

  public void setHalfShadows(String sHalfShadows) {
    setHalfShadows(Boolean.parseBoolean(sHalfShadows));
  }

  public void setHalfShadows(boolean halfShadows) {
    this.halfShadows = halfShadows;
  }

  public void setHappinessPCT(String happinessPCT) {
    this.happinessPCT = happinessPCT;
  }

  public void setIcon(String sIcon) {
    if (sIcon != null) {
      this.icon = new Tile(sIcon);
    }
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setInjectActions(ArrayList<String> injectActions) {
    this.injectActions = injectActions;
  }

  public void setItems(ArrayList<String> items) {
    this.items = items;
  }

  public void setItemsDeletePCT(ArrayList<String> itemsDeletePCT) throws Exception {
    this.itemsDeletePCT = itemsDeletePCT;

    if (itemsDeletePCT != null && itemsDeletePCT.size() > 0) {
      // Tiene que tener el mismo número de elementos que items
      if (items == null || items.size() != itemsDeletePCT.size()) {
        throw new Exception(Messages.getString("EventManagerItem.2")); // $NON-NLS-1$
      }
    }
  }

  public void setItemsMaxAgePCT(ArrayList<String> itemsMaxAgePCT) throws Exception {
    this.itemsMaxAgePCT = itemsMaxAgePCT;

    if (itemsMaxAgePCT != null && itemsMaxAgePCT.size() > 0) {
      // Tiene que tener el mismo número de elementos que items
      if (items == null || items.size() != itemsMaxAgePCT.size()) {
        throw new Exception(Messages.getString("EventManagerItem.1")); // $NON-NLS-1$
      }
    }
  }

  public void setItemsSpawnLiving(ArrayList<String> itemsSpawnLiving) throws Exception {
    this.itemsSpawnLiving = itemsSpawnLiving;

    if (itemsSpawnLiving != null && itemsSpawnLiving.size() > 0) {
      // Tiene que tener el mismo número de elementos que items
      if (items == null || items.size() != itemsSpawnLiving.size()) {
        throw new Exception(Messages.getString("EventManagerItem.4")); // $NON-NLS-1$
      }
    }
  }

  public void setItemsSpawnLivingSize(ArrayList<String> itemsSpawnLivingSize) throws Exception {
    this.itemsSpawnLivingSize = itemsSpawnLivingSize;

    if (itemsSpawnLivingSize != null && itemsSpawnLivingSize.size() > 0) {
      // Tiene que tener el mismo número de elementos que items
      if (items == null || items.size() != itemsSpawnLivingSize.size()) {
        throw new Exception(Messages.getString("EventManagerItem.5")); // $NON-NLS-1$
      }
    }
  }

  public void setMinPopulation(String sMinPopulation) throws Exception {
    if (sMinPopulation == null || sMinPopulation.trim().isEmpty()) {
      setMinPopulation(0);
    } else {
      try {
        setMinPopulation(Integer.parseInt(sMinPopulation));
      } catch (Exception e) {
        throw new Exception(
            Messages.getString("EventManagerItem.13")
                + " ["
                + sMinPopulation
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
  }

  public void setMinPopulation(int minPopulation) {
    this.minPopulation = minPopulation;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOrder(String sOrder) throws Exception {
    try {
      setOrder(Integer.parseInt(sOrder));
    } catch (Exception e) {
      throw new Exception(
          Messages.getString("EventManagerItem.3")
              + " ["
              + sOrder
              + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public void setPrerequisites(ArrayList<String> prerequisites) {
    this.prerequisites = prerequisites;
  }

  public void setRed(String red) throws Exception {
    if (red == null || red.isEmpty()) {
      setRed(0);
    } else {
      try {
        setRed(Float.parseFloat(red));
      } catch (NumberFormatException nfe) {
        throw new Exception(
            Messages.getString("EventManagerItem.17")
                + " ["
                + red
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
      }
    }
  }

  public void setRed(float red) {
    this.red = red;
  }

  public void setShadows(String sShadows) {
    setShadows(Boolean.parseBoolean(sShadows));
  }

  public void setShadows(boolean shadows) {
    this.shadows = shadows;
  }

  public void setSiege(String sSiege) {
    setSiege(Boolean.parseBoolean(sSiege));
  }

  public void setSiege(boolean siege) {
    this.siege = siege;
  }

  public void setSiegeLivings(ArrayList<String> siegeLivings) {
    this.siegeLivings = siegeLivings;
  }

  public void setSiegeSize(ArrayList<String> siegeSize) throws Exception {
    this.siegeSize = siegeSize;

    if (siegeSize == null) {
      if (siegeLivings != null && siegeLivings.size() > 0) {
        throw new Exception(Messages.getString("EventManagerItem.0")); // $NON-NLS-1$
      }
    } else {
      if (siegeSize.size() > 0) {
        // Tiene que tener el mismo número de elementos que siegeLivings
        if (siegeLivings == null || siegeLivings.size() != siegeSize.size()) {
          throw new Exception(Messages.getString("EventManagerItem.0")); // $NON-NLS-1$
        }
      } else {
        if (siegeLivings != null && siegeLivings.size() > 0) {
          throw new Exception(Messages.getString("EventManagerItem.0")); // $NON-NLS-1$
        }
      }
    }
  }

  public void setSiegeUnderground(String sSiegeUnderground) {
    setSiegeUnderground(Boolean.parseBoolean(sSiegeUnderground));
  }

  public void setSiegeUnderground(boolean siegeUnderground) {
    this.siegeUnderground = siegeUnderground;
  }

  public void setSpawnAtRandom(String sSpawnAtRandom) {
    if (sSpawnAtRandom == null || sSpawnAtRandom.trim().isEmpty()) {
      setSpawnAtRandom(true);
    } else {
      if (sSpawnAtRandom.equalsIgnoreCase("FALSE")) { // $NON-NLS-1$
        setSpawnAtRandom(false);
      } else {
        setSpawnAtRandom(true);
      }
    }
  }

  public void setSpawnAtRandom(boolean spawnAtRandom) {
    this.spawnAtRandom = spawnAtRandom;
  }

  public void setTargets(String targets) {
    this.targets = Utils.getArray(targets);

    if (this.targets != null && this.targets.size() > 0) {
      this.targetsHateData = new HateData(targets);
    } else {
      this.targetsHateData = null;
    }
  }

  public void setTargetsHateData(HateData targetsHateData) {
    this.targetsHateData = targetsHateData;
  }

  public void setTargetsOpenCell(String sTargetsOpenCell) {
    setTargetsOpenCell(Boolean.parseBoolean(sTargetsOpenCell));
  }

  public void setTargetsOpenCell(boolean targetsOpenCell) {
    this.targetsOpenCell = targetsOpenCell;
  }

  public void setTargetsPCT(ArrayList<String> targetsPCT) throws Exception {
    this.targetsPCT = targetsPCT;

    if (targetsPCT == null) {
      if (targets != null && targets.size() > 0) {
        throw new Exception(Messages.getString("EventManagerItem.9")); // $NON-NLS-1$
      }
    } else {
      if (targetsPCT.size() > 0) {
        // Tiene que tener el mismo número de elementos que siegeLivings
        if (targets == null || targets.size() != targetsPCT.size()) {
          throw new Exception(Messages.getString("EventManagerItem.9")); // $NON-NLS-1$
        }
      } else {
        if (targets != null && targets.size() > 0) {
          throw new Exception(Messages.getString("EventManagerItem.9")); // $NON-NLS-1$
        }
      }
    }
  }

  public void setTargetsRandomCell(String targetsRandomCell) {
    this.targetsRandomCell = targetsRandomCell;
  }

  public void setTurns(String turns) {
    this.turns = turns;
  }

  public void setUseFile(String useFile) {
    this.useFile = useFile;
  }

  public void setUseFileIDs(ArrayList<String> useFileIDs) throws Exception {
    this.useFileIDs = useFileIDs;

    if (this.useFileIDs == null || this.useFileIDs.isEmpty()) {
      if (this.useFile != null && this.useFile.length() > 0) {
        throw new Exception(Messages.getString("EventManagerItem.12")); // $NON-NLS-1$
      }
    } else {
      if (this.useFile == null || this.useFile.isEmpty()) {
        throw new Exception(Messages.getString("EventManagerItem.6")); // $NON-NLS-1$
      }
    }
  }

  public void setWaitPCT(String waitPCT) {
    if (waitPCT == null || waitPCT.trim().isEmpty()) {
      this.waitPCT = "100"; // $NON-NLS-1$
    } else {
      this.waitPCT = waitPCT;
    }
  }

  public void setWalkSpeedPCT(String walkSpeedPCT) {
    if (walkSpeedPCT == null || walkSpeedPCT.trim().isEmpty()) {
      this.walkSpeedPCT = "100"; // $NON-NLS-1$
    } else {
      this.walkSpeedPCT = walkSpeedPCT;
    }
  }
}
