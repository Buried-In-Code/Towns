package xaos.utils;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class Date implements Externalizable {

  private static final long serialVersionUID = -7460035278067931338L;

  public static final int DAYS_PER_MONTH = 30;
  public static final int MONTHS_PER_YEAR = 12;

  private String sDate;

  private int day;
  private int month;
  private int year;

  public Date() {
    setDay(1);
    setMonth(1);
    setYear(1);
    sDate = getString();
  }

  public void addDay() {
    day++;
    if (day > DAYS_PER_MONTH) {
      day = 1;
      month++;
      if (month > MONTHS_PER_YEAR) {
        month = 1;
        year++;
      }
    }

    sDate = getString();
  }

  public int getDay() {
    return day;
  }

  public int getMonth() {
    return month;
  }

  public String getString() {
    return day + " / " + month + " / " + year; // $NON-NLS-1$ //$NON-NLS-2$
  }

  public int getYear() {
    return year;
  }

  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    day = in.readInt();
    month = in.readInt();
    year = in.readInt();

    sDate = getString();
  }

  public void setDay(int day) {
    this.day = day;
    sDate = getString();
  }

  public void setMonth(int month) {
    this.month = month;

    sDate = getString();
  }

  public void setYear(int year) {
    this.year = year;

    sDate = getString();
  }

  public String toString() {
    if (sDate == null) {
      sDate = getString();
    }

    return sDate;
  }

  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(day);
    out.writeInt(month);
    out.writeInt(year);
  }
}
