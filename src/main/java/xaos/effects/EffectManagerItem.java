package xaos.effects;

import java.util.ArrayList;
import xaos.data.EffectData;
import xaos.data.HateData;
import xaos.skills.SkillManagerItem;
import xaos.tiles.Tile;
import xaos.utils.Messages;
import xaos.utils.Utils;

/** Clase de tipo "managerItem", no es la que se ańade a las livings. */
public class EffectManagerItem {

  private String id;
  private String name;
  private Tile icon;
  private String damagePCT;
  private String defensePCT;
  private String attackPCT;
  private String attackSpeedPCT;
  private String DOT;
  private String healthPointsPCT;
  private String LOSPCT;
  private String speedPCT;
  private String lasts;
  private boolean attackAllies;
  private boolean removeTarget;
  private boolean flee;
  private String graphicChange;
  private String raiseDead;
  private String maxRaised;

  private String onHitPCT;
  private ArrayList<String> onHitEffects;
  private String onRangedHitPCT;
  private ArrayList<String> onRangedHitEffects;

  private ArrayList<String> afterEffects;

  private ArrayList<String> castEffects;
  private String castCooldown;
  private int castTrigger;
  private String castTargets;

  private ArrayList<String> effectsImmune;
  private ArrayList<String> effectsPrerequisite;

  private boolean messageWhenGain;
  private boolean messageWhenVanish;

  private String happy;

  public ArrayList<String> getAfterEffects() {
    return afterEffects;
  }

  public String getAttackPCT() {
    return attackPCT;
  }

  public String getAttackSpeedPCT() {
    return attackSpeedPCT;
  }

  public String getCastCooldown() {
    return castCooldown;
  }

  public ArrayList<String> getCastEffects() {
    return castEffects;
  }

  public String getCastTargets() {
    return castTargets;
  }

  public int getCastTrigger() {
    return castTrigger;
  }

  public String getDOT() {
    return DOT;
  }

  public String getDamagePCT() {
    return damagePCT;
  }

  public String getDefensePCT() {
    return defensePCT;
  }

  public EffectData getEffectDataInstance() {
    EffectData effectData = new EffectData(id);

    effectData.setDamagePCT(Utils.launchDice(getDamagePCT()));
    effectData.setDefensePCT(Utils.launchDice(getDefensePCT()));
    effectData.setAttackPCT(Utils.launchDice(getAttackPCT()));
    effectData.setAttackSpeedPCT(Utils.launchDice(getAttackSpeedPCT()));
    effectData.setDOT(Utils.launchDice(getDOT()));
    effectData.setHealthPointsPCT(Utils.launchDice(getHealthPointsPCT()));
    effectData.setLOSPCT(Utils.launchDice(getLOSPCT()));
    effectData.setSpeedPCT(Utils.launchDice(getSpeedPCT()));
    effectData.setLasts(Utils.launchDice(getLasts()));
    effectData.setAttackAllies(isAttackAllies());
    effectData.setRemoveTarget(isRemoveTarget());
    effectData.setFlee(isFlee());
    effectData.setOnHitPCT(Utils.launchDice(getOnHitPCT()));
    effectData.setOnRangedHitPCT(Utils.launchDice(getOnRangedHitPCT()));
    if (getGraphicChange() != null) {
      effectData.setGraphicChange(new String(getGraphicChange()));
    }
    effectData.setCastCooldownMAX(Utils.launchDice(getCastCooldown()));
    effectData.setCastCooldown(0);
    effectData.setCastTrigger(getCastTrigger());
    effectData.setCastTargets(new HateData(getCastTargets()));
    effectData.setHappy(Utils.launchDice(getHappy()));

    return effectData;
  }

  public ArrayList<String> getEffectsImmune() {
    return effectsImmune;
  }

  public ArrayList<String> getEffectsPrerequisite() {
    return effectsPrerequisite;
  }

  public String getGraphicChange() {
    return graphicChange;
  }

  public String getHappy() {
    return happy;
  }

  public String getHealthPointsPCT() {
    return healthPointsPCT;
  }

  public Tile getIcon() {
    return icon;
  }

  public String getId() {
    return id;
  }

  public String getLOSPCT() {
    return LOSPCT;
  }

  public String getLasts() {
    return lasts;
  }

  public String getMaxRaised() {
    return maxRaised;
  }

  public String getName() {
    return name;
  }

  public ArrayList<String> getOnHitEffects() {
    return onHitEffects;
  }

  public String getOnHitPCT() {
    return onHitPCT;
  }

  public ArrayList<String> getOnRangedHitEffects() {
    return onRangedHitEffects;
  }

  public String getOnRangedHitPCT() {
    return onRangedHitPCT;
  }

  public String getRaiseDead() {
    return raiseDead;
  }

  public String getSpeedPCT() {
    return speedPCT;
  }

  public boolean isAttackAllies() {
    return attackAllies;
  }

  public boolean isFlee() {
    return flee;
  }

  public boolean isMessageWhenGain() {
    return messageWhenGain;
  }

  public boolean isMessageWhenVanish() {
    return messageWhenVanish;
  }

  public boolean isRemoveTarget() {
    return removeTarget;
  }

  public void setAfterEffects(ArrayList<String> afterEffects) {
    this.afterEffects = afterEffects;
  }

  public void setAfterEffects(String sAfterEffects) {
    setAfterEffects(Utils.getArray(sAfterEffects));
  }

  public void setAttackAllies(String sAttackAllies) {
    setAttackAllies(Boolean.parseBoolean(sAttackAllies));
  }

  public void setAttackAllies(boolean attackAllies) {
    this.attackAllies = attackAllies;
  }

  public void setAttackPCT(String attackPCT) {
    if (attackPCT == null || attackPCT.trim().isEmpty()) {
      this.attackPCT = "100"; // $NON-NLS-1$
    } else {
      this.attackPCT = attackPCT;
    }
  }

  public void setAttackSpeedPCT(String attackSpeedPCT) {
    if (attackSpeedPCT == null || attackSpeedPCT.trim().isEmpty()) {
      this.attackSpeedPCT = "100"; // $NON-NLS-1$
    } else {
      this.attackSpeedPCT = attackSpeedPCT;
    }
  }

  public void setCastCooldown(String castCooldown) {
    this.castCooldown = castCooldown;
  }

  public void setCastEffects(ArrayList<String> castEffects) {
    this.castEffects = castEffects;
  }

  public void setCastEffects(String sCastEffects) {
    setCastEffects(Utils.getArray(sCastEffects));
  }

  public void setCastTargets(String sCastTargets) {
    this.castTargets = sCastTargets;
  }

  public void setCastTrigger(String sCastTrigger) throws Exception {
    if (sCastTrigger == null || sCastTrigger.isEmpty()) {
      setCastTrigger(SkillManagerItem.USE_UNKNOWN);
    } else {
      if (sCastTrigger.equalsIgnoreCase(SkillManagerItem.USE_STR_ALWAYS)) {
        setCastTrigger(SkillManagerItem.USE_ALWAYS);
      } else if (sCastTrigger.equalsIgnoreCase(SkillManagerItem.USE_STR_HITTED)) {
        setCastTrigger(SkillManagerItem.USE_HITTED);
      } else if (sCastTrigger.equalsIgnoreCase(SkillManagerItem.USE_STR_ENEMIES_IN_LOS)) {
        setCastTrigger(SkillManagerItem.USE_ENEMIES_IN_LOS);
      } else if (sCastTrigger.equalsIgnoreCase(SkillManagerItem.USE_STR_NEAR_DEATH)) {
        setCastTrigger(SkillManagerItem.USE_NEAR_DEATH);
      } else if (sCastTrigger.equalsIgnoreCase(SkillManagerItem.USE_STR_NOT_MAX_HP)) {
        setCastTrigger(SkillManagerItem.USE_NOT_MAX_HP);
      } else {
        throw new Exception(
            Messages.getString("EffectManager.6")
                + sCastTrigger
                + "]"); //$NON-NLS-1$ //$NON-NLS-2$
      }
    }
  }

  public void setCastTrigger(int iCastTrigger) {
    this.castTrigger = iCastTrigger;
  }

  public void setDOT(String sDOT) {
    this.DOT = sDOT;
  }

  public void setDamagePCT(String damagePCT) {
    if (damagePCT == null || damagePCT.trim().isEmpty()) {
      this.damagePCT = "100"; // $NON-NLS-1$
    } else {
      this.damagePCT = damagePCT;
    }
  }

  public void setDefensePCT(String defensePCT) {
    if (defensePCT == null || defensePCT.trim().isEmpty()) {
      this.defensePCT = "100"; // $NON-NLS-1$
    } else {
      this.defensePCT = defensePCT;
    }
  }

  public void setEffectsImmune(ArrayList<String> effectsImmune) {
    this.effectsImmune = effectsImmune;
  }

  public void setEffectsImmune(String sEffectsImmune) throws Exception {
    setEffectsImmune(Utils.getArray(sEffectsImmune));
  }

  public void setEffectsPrerequisite(ArrayList<String> effectsPrerequisite) {
    this.effectsPrerequisite = effectsPrerequisite;
  }

  public void setEffectsPrerequisite(String sEffectsPrerequisite) throws Exception {
    setEffectsPrerequisite(Utils.getArray(sEffectsPrerequisite));
  }

  public void setFlee(String sFlee) {
    setFlee(Boolean.parseBoolean(sFlee));
  }

  public void setFlee(boolean flee) {
    this.flee = flee;
  }

  public void setGraphicChange(String graphicChange) {
    this.graphicChange = graphicChange;
  }

  public void setHappy(String happy) {
    this.happy = happy;
  }

  public void setHealthPointsPCT(String healthPointsPCT) {
    if (healthPointsPCT == null || healthPointsPCT.trim().isEmpty()) {
      this.healthPointsPCT = "100"; // $NON-NLS-1$
    } else {
      this.healthPointsPCT = healthPointsPCT;
    }
  }

  public void setIcon(String icon) {
    if (icon != null) {
      setIcon(new Tile(icon));
    }
  }

  public void setIcon(Tile icon) {
    this.icon = icon;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLOSPCT(String lOSPCT) {
    if (lOSPCT == null || lOSPCT.trim().isEmpty()) {
      this.LOSPCT = "100"; // $NON-NLS-1$
    } else {
      this.LOSPCT = lOSPCT;
    }
  }

  public void setLasts(String lasts) {
    this.lasts = lasts;
  }

  public void setMaxRaised(String maxRaised) {
    this.maxRaised = maxRaised;
  }

  public void setMessageWhenGain(String sMessageWhenGain) {
    if (sMessageWhenGain != null && sMessageWhenGain.equals("false")) {
      setMessageWhenGain(false);
    } else {
      setMessageWhenGain(true);
    }
  }

  public void setMessageWhenGain(boolean messageWhenGain) {
    this.messageWhenGain = messageWhenGain;
  }

  public void setMessageWhenVanish(String sMessageWhenVanish) {
    if (sMessageWhenVanish != null && sMessageWhenVanish.equals("false")) {
      setMessageWhenVanish(false);
    } else {
      setMessageWhenVanish(true);
    }
  }

  public void setMessageWhenVanish(boolean messageWhenVanish) {
    this.messageWhenVanish = messageWhenVanish;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setOnHitEffects(ArrayList<String> onHitEffects) {
    this.onHitEffects = onHitEffects;
  }

  public void setOnHitEffects(String sOnHitEffects) {
    setOnHitEffects(Utils.getArray(sOnHitEffects));
  }

  public void setOnHitPCT(String onHitPCT) {
    if (onHitPCT == null || onHitPCT.trim().isEmpty()) {
      this.onHitPCT = "0"; // $NON-NLS-1$
    } else {
      this.onHitPCT = onHitPCT;
    }
  }

  public void setOnRangedHitEffects(ArrayList<String> onRangedHitEffects) {
    this.onRangedHitEffects = onRangedHitEffects;
  }

  public void setOnRangedHitEffects(String sOnRangedHitEffects) {
    setOnRangedHitEffects(Utils.getArray(sOnRangedHitEffects));
  }

  public void setOnRangedHitPCT(String onRangedHitPCT) {
    if (onRangedHitPCT == null || onRangedHitPCT.trim().isEmpty()) {
      this.onRangedHitPCT = "0"; // $NON-NLS-1$
    } else {
      this.onRangedHitPCT = onRangedHitPCT;
    }
  }

  public void setRaiseDead(String raiseDead) {
    this.raiseDead = raiseDead;
  }

  public void setRemoveTarget(String sRemoveTarget) {
    setRemoveTarget(Boolean.parseBoolean(sRemoveTarget));
  }

  public void setRemoveTarget(boolean removeTarget) {
    this.removeTarget = removeTarget;
  }

  public void setSpeedPCT(String speedPCT) {
    if (speedPCT == null || speedPCT.trim().isEmpty()) {
      this.speedPCT = "100"; // $NON-NLS-1$
    } else {
      this.speedPCT = speedPCT;
    }
  }
}
