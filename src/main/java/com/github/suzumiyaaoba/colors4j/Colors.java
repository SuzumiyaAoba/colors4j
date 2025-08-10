package com.github.suzumiyaaoba.colors4j;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Colors class.
 *
 * <p>Provides ANSI escape sequences for text formatting.
 *
 * <p>See <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a> for more
 * information.
 */
public class Colors {

  private boolean isColorSupported;

  private @Nullable UnaryOperator<String> reset;
  private @Nullable UnaryOperator<String> bold;
  private @Nullable UnaryOperator<String> dim;
  private @Nullable UnaryOperator<String> italic;
  private @Nullable UnaryOperator<String> underline;
  private @Nullable UnaryOperator<String> inverse;
  private @Nullable UnaryOperator<String> hidden;
  private @Nullable UnaryOperator<String> strikethrough;
  private @Nullable UnaryOperator<String> black;
  private @Nullable UnaryOperator<String> red;
  private @Nullable UnaryOperator<String> green;
  private @Nullable UnaryOperator<String> yellow;
  private @Nullable UnaryOperator<String> blue;
  private @Nullable UnaryOperator<String> magenta;
  private @Nullable UnaryOperator<String> cyan;
  private @Nullable UnaryOperator<String> white;
  private @Nullable UnaryOperator<String> gray;
  private @Nullable UnaryOperator<String> bgBlack;
  private @Nullable UnaryOperator<String> bgRed;
  private @Nullable UnaryOperator<String> bgGreen;
  private @Nullable UnaryOperator<String> bgYellow;
  private @Nullable UnaryOperator<String> bgBlue;
  private @Nullable UnaryOperator<String> bgMagenta;
  private @Nullable UnaryOperator<String> bgCyan;
  private @Nullable UnaryOperator<String> bgWhite;

  /**
   * Create a new Colors instance.
   *
   * @param isColorSupported true if color is supported, false otherwise
   * @return a new Colors instance
   */
  public static @NonNull Colors createColors(boolean isColorSupported) {
    BiFunction<String, String, UnaryOperator<String>> init =
        isColorSupported
            ? (open, close) -> Utils.format(open, close, open)
            : (open, close) -> UnaryOperator.identity();

    return new Colors()
        .setColorSupported(isColorSupported)
        .setReset(init.apply("\u001B[0m", "\u001B[0m"))
        .setBold(
            isColorSupported
                ? Utils.format("\u001B[1m", "\u001B[22m", "\u001B[22m\u001B[1m")
                : UnaryOperator.identity())
        .setDim(
            isColorSupported
                ? Utils.format("\u001B[2m", "\u001B[22m", "\u001B[22m\u001B[2m")
                : UnaryOperator.identity())
        .setItalic(init.apply("\u001B[3m", "\u001B[23m"))
        .setUnderline(init.apply("\u001B[4m", "\u001B[24m"))
        .setInverse(init.apply("\u001B[7m", "\u001B[27m"))
        .setHidden(init.apply("\u001B[8m", "\u001B[28m"))
        .setStrikethrough(init.apply("\u001B[9m", "\u001B[29m"))
        .setBlack(init.apply("\u001B[30m", "\u001B[39m"))
        .setRed(init.apply("\u001B[31m", "\u001B[39m"))
        .setGreen(init.apply("\u001B[32m", "\u001B[39m"))
        .setYellow(init.apply("\u001B[33m", "\u001B[39m"))
        .setBlue(init.apply("\u001B[34m", "\u001B[39m"))
        .setMagenta(init.apply("\u001B[35m", "\u001B[39m"))
        .setCyan(init.apply("\u001B[36m", "\u001B[39m"))
        .setWhite(init.apply("\u001B[37m", "\u001B[39m"))
        .setGray(init.apply("\u001B[90m", "\u001B[39m"))
        .setBgBlack(init.apply("\u001B[40m", "\u001B[49m"))
        .setBgRed(init.apply("\u001B[41m", "\u001B[49m"))
        .setBgGreen(init.apply("\u001B[42m", "\u001B[49m"))
        .setBgYellow(init.apply("\u001B[43m", "\u001B[49m"))
        .setBgBlue(init.apply("\u001B[44m", "\u001B[49m"))
        .setBgMagenta(init.apply("\u001B[45m", "\u001B[49m"))
        .setBgCyan(init.apply("\u001B[46m", "\u001B[49m"))
        .setBgWhite(init.apply("\u001B[47m", "\u001B[49m"));
  }

  /**
   * Checks if color formatting is supported.
   *
   * @return true if color formatting is supported, false otherwise
   */
  public boolean isColorSupported() {
    return isColorSupported;
  }

  Colors setColorSupported(boolean colorSupported) {
    isColorSupported = colorSupported;
    return this;
  }

  /**
   * Resets all text formatting to default.
   *
   * @param input the input string to format
   * @return the formatted string with reset formatting
   */
  public @NonNull String reset(@NonNull String input) {
    return reset.apply(input);
  }

  @NonNull Colors setReset(@NonNull UnaryOperator<String> reset) {
    this.reset = reset;
    return this;
  }

  /**
   * Applies bold formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with bold styling
   */
  public @NonNull String bold(@NonNull String input) {
    return bold.apply(input);
  }

  @NonNull Colors setBold(@NonNull UnaryOperator<String> bold) {
    this.bold = bold;
    return this;
  }

  /**
   * Applies dim (faint) formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with dim styling
   */
  public @NonNull String dim(@NonNull String input) {
    return dim.apply(input);
  }

  @NonNull Colors setDim(@NonNull UnaryOperator<String> dim) {
    this.dim = dim;
    return this;
  }

  /**
   * Applies italic formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with italic styling
   */
  public @NonNull String italic(@NonNull String input) {
    return italic.apply(input);
  }

  @NonNull Colors setItalic(@NonNull UnaryOperator<String> italic) {
    this.italic = italic;
    return this;
  }

  /**
   * Applies underline formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with underline styling
   */
  public @NonNull String underline(@NonNull String input) {
    return underline.apply(input);
  }

  @NonNull Colors setUnderline(@NonNull UnaryOperator<String> underline) {
    this.underline = underline;
    return this;
  }

  /**
   * Applies inverse (reverse) formatting to the input string. This swaps the foreground and
   * background colors.
   *
   * @param input the input string to format
   * @return the formatted string with inverse styling
   */
  public @NonNull String inverse(@NonNull String input) {
    return inverse.apply(input);
  }

  @NonNull Colors setInverse(@NonNull UnaryOperator<String> inverse) {
    this.inverse = inverse;
    return this;
  }

  /**
   * Applies hidden (invisible) formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with hidden styling
   */
  public @NonNull String hidden(@NonNull String input) {
    return hidden.apply(input);
  }

  @NonNull Colors setHidden(@NonNull UnaryOperator<String> hidden) {
    this.hidden = hidden;
    return this;
  }

  /**
   * Applies strikethrough formatting to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with strikethrough styling
   */
  public @NonNull String strikethrough(@NonNull String input) {
    return strikethrough.apply(input);
  }

  @NonNull Colors setStrikethrough(@NonNull UnaryOperator<String> strikethrough) {
    this.strikethrough = strikethrough;
    return this;
  }

  /**
   * Applies black foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with black color
   */
  public @NonNull String black(@NonNull String input) {
    return black.apply(input);
  }

  @NonNull Colors setBlack(@NonNull UnaryOperator<String> black) {
    this.black = black;
    return this;
  }

  /**
   * Applies red foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with red color
   */
  public @NonNull String red(@NonNull String input) {
    return red.apply(input);
  }

  @NonNull Colors setRed(@NonNull UnaryOperator<String> red) {
    this.red = red;
    return this;
  }

  /**
   * Applies green foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with green color
   */
  public @NonNull String green(@NonNull String input) {
    return green.apply(input);
  }

  @NonNull Colors setGreen(@NonNull UnaryOperator<String> green) {
    this.green = green;
    return this;
  }

  /**
   * Applies yellow foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with yellow color
   */
  public @NonNull String yellow(@NonNull String input) {
    return yellow.apply(input);
  }

  @NonNull Colors setYellow(@NonNull UnaryOperator<String> yellow) {
    this.yellow = yellow;
    return this;
  }

  /**
   * Applies blue foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with blue color
   */
  public @NonNull String blue(@NonNull String input) {
    return blue.apply(input);
  }

  @NonNull Colors setBlue(@NonNull UnaryOperator<String> blue) {
    this.blue = blue;
    return this;
  }

  /**
   * Applies magenta foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with magenta color
   */
  public @NonNull String magenta(@NonNull String input) {
    return magenta.apply(input);
  }

  @NonNull Colors setMagenta(@NonNull UnaryOperator<String> magenta) {
    this.magenta = magenta;
    return this;
  }

  /**
   * Applies cyan foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with cyan color
   */
  public @NonNull String cyan(@NonNull String input) {
    return cyan.apply(input);
  }

  @NonNull Colors setCyan(@NonNull UnaryOperator<String> cyan) {
    this.cyan = cyan;
    return this;
  }

  /**
   * Applies white foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with white color
   */
  public @NonNull String white(@NonNull String input) {
    return white.apply(input);
  }

  @NonNull Colors setWhite(@NonNull UnaryOperator<String> white) {
    this.white = white;
    return this;
  }

  /**
   * Applies gray foreground color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with gray color
   */
  public @NonNull String gray(@NonNull String input) {
    return gray.apply(input);
  }

  @NonNull Colors setGray(@NonNull UnaryOperator<String> gray) {
    this.gray = gray;
    return this;
  }

  /**
   * Applies black background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with black background
   */
  public @NonNull String bgBlack(@NonNull String input) {
    return bgBlack.apply(input);
  }

  @NonNull Colors setBgBlack(@NonNull UnaryOperator<String> bgBlack) {
    this.bgBlack = bgBlack;
    return this;
  }

  /**
   * Applies red background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with red background
   */
  public @NonNull String bgRed(@NonNull String input) {
    return bgRed.apply(input);
  }

  @NonNull Colors setBgRed(@NonNull UnaryOperator<String> bgRed) {
    this.bgRed = bgRed;
    return this;
  }

  /**
   * Applies green background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with green background
   */
  public @NonNull String bgGreen(@NonNull String input) {
    return bgGreen.apply(input);
  }

  @NonNull Colors setBgGreen(@NonNull UnaryOperator<String> bgGreen) {
    this.bgGreen = bgGreen;
    return this;
  }

  /**
   * Applies yellow background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with yellow background
   */
  public @NonNull String bgYellow(@NonNull String input) {
    return bgYellow.apply(input);
  }

  @NonNull Colors setBgYellow(@NonNull UnaryOperator<String> bgYellow) {
    this.bgYellow = bgYellow;
    return this;
  }

  /**
   * Applies blue background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with blue background
   */
  public @NonNull String bgBlue(@NonNull String input) {
    return bgBlue.apply(input);
  }

  @NonNull Colors setBgBlue(@NonNull UnaryOperator<String> bgBlue) {
    this.bgBlue = bgBlue;
    return this;
  }

  /**
   * Applies magenta background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with magenta background
   */
  public @NonNull String bgMagenta(@NonNull String input) {
    return bgMagenta.apply(input);
  }

  @NonNull Colors setBgMagenta(@NonNull UnaryOperator<String> bgMagenta) {
    this.bgMagenta = bgMagenta;
    return this;
  }

  /**
   * Applies cyan background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with cyan background
   */
  public @NonNull String bgCyan(@NonNull String input) {
    return bgCyan.apply(input);
  }

  @NonNull Colors setBgCyan(@NonNull UnaryOperator<String> bgCyan) {
    this.bgCyan = bgCyan;
    return this;
  }

  /**
   * Applies white background color to the input string.
   *
   * @param input the input string to format
   * @return the formatted string with white background
   */
  public @NonNull String bgWhite(@NonNull String input) {
    return bgWhite.apply(input);
  }

  @NonNull Colors setBgWhite(@NonNull UnaryOperator<String> bgWhite) {
    this.bgWhite = bgWhite;
    return this;
  }
}
