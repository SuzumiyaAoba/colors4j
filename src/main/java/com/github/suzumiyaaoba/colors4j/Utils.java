package com.github.suzumiyaaoba.colors4j;

import java.util.function.UnaryOperator;
import org.jspecify.annotations.NonNull;

/**
 * Utility class for ANSI escape sequence formatting.
 */
class Utils {

  /**
   * Private constructor to prevent instantiation.
   */
  private Utils() {}

  /**
   * Creates a formatting function that wraps text with ANSI escape sequences.
   * If the close sequence is found within the input, it replaces it with the replace sequence
   * to maintain proper nesting of formatting.
   *
   * @param open the opening ANSI escape sequence
   * @param close the closing ANSI escape sequence
   * @param replace the replacement sequence for nested close sequences
   * @return a UnaryOperator that applies the formatting to input strings
   */
  static @NonNull UnaryOperator<String> format(
      @NonNull String open, @NonNull String close, @NonNull String replace) {
    return (String input) -> {
      final int index = input.indexOf(close, open.length());

      return index == -1
          ? open + input + close
          : open + replaceClose(input, close, replace, index) + close;
    };
  }

  /**
   * Replaces all occurrences of the close sequence with the replace sequence in the given string.
   * This is used to handle nested formatting by replacing close sequences that would
   * prematurely terminate the formatting.
   *
   * @param string the input string to process
   * @param close the close sequence to replace
   * @param replace the replacement sequence
   * @param index the starting index where the first close sequence was found
   * @return the string with all close sequences replaced
   */
  static @NonNull String replaceClose(
      @NonNull String string, @NonNull String close, @NonNull String replace, int index) {
    final StringBuilder result = new StringBuilder();
    int cursor = 0;

    do {
      result.append(string, cursor, index).append(replace);
      cursor = index + close.length();
      index = string.indexOf(close, cursor);
    } while (index != -1);

    return result.append(string.substring(cursor)).toString();
  }
}
