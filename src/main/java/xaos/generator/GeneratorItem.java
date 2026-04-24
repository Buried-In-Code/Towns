package xaos.generator;

import java.util.ArrayList;

/** Contiene un nombre y una lista de GeneratorNode's */
public class GeneratorItem {

  private String id;
  private String name;
  private ArrayList<GeneratorNode> list;

  public void addNode(GeneratorNode node) {
    getList().add(node);
  }

  public String getId() {
    return id;
  }

  public ArrayList<GeneratorNode> getList() {
    if (list == null) {
      list = new ArrayList<GeneratorNode>();
    }
    return list;
  }

  public String getName() {
    return name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setList(ArrayList<GeneratorNode> list) {
    this.list = list;
  }

  public void setName(String name) {
    this.name = name;
  }
}
