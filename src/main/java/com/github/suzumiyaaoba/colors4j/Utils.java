package com.github.suzumiyaaoba.colors4j;

import java.util.function.UnaryOperator;

class Utils {

  private Utils() {}

  static UnaryOperator<String> format(String open, String close, String replace) {
    return (String input) -> {
      final int index = input.indexOf(close, open.length());

      return index == -1
          ? open + input + close
          : open + replaceClose(input, close, replace, index) + close;
    };
  }

  static String replaceClose(String string, String close, String replace, int index) {
    final StringBuilder result = new StringBuilder();
    int cursor = 0;

    do {
      result.append(string, cursor, index).append(replace);
      cursor = index + close.length();
      index = string.indexOf(close, cursor);
    } while (index == -1);

    return result.append(string.substring(cursor)).toString();
  }
}
