package org.csploit.msf.api.module;

/**
 * A module rank
 */
public enum Rank {
  MANUAL(0, "manual"),
  LOW(100, "low"),
  AVERAGE(200, "average"),
  NORMAL(300, "normal"),
  GOOD(400, "good"),
  GREAT(500, "great"),
  EXCELLENT(600, "excellent")
  ;

  private String name;
  private int value;

  Rank(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return name;
  }

  public static Rank fromName(String name) {
    name = name.trim();
    name = name.toLowerCase();
    for (Rank r : values()) {
      if (r.name.toLowerCase().equals(name)) {
        return r;
      }
    }
    return null;
  }

  public static Rank fromValue(int value) {
    Rank result = Rank.MANUAL;
    for (Rank r : values()) {
      if (r.value <= value && r.value > result.value) {
        result = r;
      }
    }
    return result;
  }
}
