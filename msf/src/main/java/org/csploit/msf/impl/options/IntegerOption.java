package org.csploit.msf.impl.options;

import org.csploit.msf.impl.Option;

/**
 * Integer option.
 */
public class IntegerOption extends Option<Long> {
  public IntegerOption(String name, boolean required, String description, Long defaultValue) {
    super(name, required, description, defaultValue);
  }

  public IntegerOption(String name, String description, Long defaultValue) {
    super(name, description, defaultValue);
  }

  @Override
  protected Long normalize(String input) {
    try {
      if (input.startsWith("0x")) {
        return Long.parseLong(input.substring(2), 16);
      } else {
        return Long.parseLong(input);
      }
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
