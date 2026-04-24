package xaos.tasks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

public final class TaskManagerItem implements Externalizable {

  private static final long serialVersionUID = -6261978696270872236L;

  private Task task;
  private ArrayList<Integer> listCitizens;

  public TaskManagerItem() {
  }

  public TaskManagerItem(Task task) {
    setTask(task);
    listCitizens = new ArrayList<Integer>();
  }

  public void addCitizen(int citizenID) {
    listCitizens.add(new Integer(citizenID));
  }

  public boolean containsCitizen(int citizenID) {
    return listCitizens.contains(new Integer(citizenID));
  }

  public ArrayList<Integer> getListCitizens() {
    return listCitizens;
  }

  public Task getTask() {
    return task;
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    task = (Task) in.readObject();
    listCitizens = (ArrayList<Integer>) in.readObject();
  }

  public void removeCitizen(int citizenID) {
    listCitizens.remove(new Integer(citizenID));
  }

  public void setListCitizens(ArrayList<Integer> listCitizens) {
    this.listCitizens = listCitizens;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer("Task\n");
    buffer.append(task.toString());
    buffer.append("\n Cits: ");
    buffer.append(listCitizens.size());
    buffer.append("\n");
    return buffer.toString();
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(task);
    out.writeObject(listCitizens);
  }
}
