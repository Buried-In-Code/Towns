package xaos.data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import xaos.utils.Point3DShort;

public class SiegeData implements Externalizable {

  private static final long serialVersionUID = -6205459879880044969L;

  public static final byte SIEGE_STANDARD = 1;
  public static final byte SIEGE_ROBBERY = 2;

  public static final byte STATUS_NONE = 0;
  public static final byte STATUS_LEAVING = 1;

  public static final byte MAX_DESTROY = 5;

  private byte type;
  private int count;
  private Point3DShort startingPoint;
  private byte status;
  private byte maxDestroy; // Usado en sieges destroy (petamuros)

  public SiegeData() {
  }

  public SiegeData(byte type, int count, Point3DShort startingPoint) {
    setType(type);
    setCount(count);
    setStartingPoint(startingPoint);
    setStatus(STATUS_NONE);
    setMaxDestroy(MAX_DESTROY);
  }

  public int getCount() {
    return count;
  }

  public byte getMaxDestroy() {
    return maxDestroy;
  }

  public Point3DShort getStartingPoint() {
    return startingPoint;
  }

  public byte getStatus() {
    return status;
  }

  public byte getType() {
    return type;
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    type = in.readByte();
    count = in.readInt();
    startingPoint = (Point3DShort) in.readObject();
    status = in.readByte();
    maxDestroy = in.readByte();
  }

  public void setCount(int count) {
    this.count = count;
  }

  public void setMaxDestroy(byte maxDestroy) {
    this.maxDestroy = maxDestroy;
  }

  public void setStartingPoint(Point3DShort startingPoint) {
    this.startingPoint = startingPoint;
  }

  public void setStatus(byte status) {
    this.status = status;
  }

  public void setType(byte type) {
    this.type = type;
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeByte(type);
    out.writeInt(count);
    out.writeObject(startingPoint);
    out.writeByte(status);
    out.writeByte(maxDestroy);
  }
}
