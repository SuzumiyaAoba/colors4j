package com.github.suzumiyaaoba.colors4j;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

/**
 * Colors class.
 *
 * <p>Provides ANSI escape sequences for text formatting.
 * <p>See <a href="https://en.wikipedia.org/wiki/ANSI_escape_code">ANSI escape code</a> for more information.
 */
public class Colors {

  private boolean isColorSupported;

  private UnaryOperator<String> reset;
  private UnaryOperator<String> bold;
  private UnaryOperator<String> dim;
  private UnaryOperator<String> italic;
  private UnaryOperator<String> underline;
  private UnaryOperator<String> inverse;
  private UnaryOperator<String> hidden;
  private UnaryOperator<String> strikethrough;
  private UnaryOperator<String> black;
  private UnaryOperator<String> red;
  private UnaryOperator<String> green;
  private UnaryOperator<String> yellow;
  private UnaryOperator<String> blue;
  private UnaryOperator<String> magenta;
  private UnaryOperator<String> cyan;
  private UnaryOperator<String> white;
  private UnaryOperator<String> gray;
  private UnaryOperator<String> bgBlack;
  private UnaryOperator<String> bgRed;
  private UnaryOperator<String> bgGreen;
  private UnaryOperator<String> bgYellow;
  private UnaryOperator<String> bgBlue;
  private UnaryOperator<String> bgMagenta;
  private UnaryOperator<String> bgCyan;
  private UnaryOperator<String> bgWhite;

  /**
   * Create a new Colors instance.
   *
   * @param isColorSupported true if color is supported, false otherwise
   * @return a new Colors instance
   */
  public static Colors createColors(boolean isColorSupported) {
    BiFunction<String, String, UnaryOperator<String>> init =
        (open, close) -> Utils.format(open, close, open);

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

  public boolean isColorSupported() {
    return isColorSupported;
  }

  Colors setColorSupported(boolean colorSupported) {
    isColorSupported = colorSupported;
    return this;
  }

  public String reset(String input) {
    return reset.apply(input);
  }

  Colors setReset(UnaryOperator<String> reset) {
    this.reset = reset;
    return this;
  }

  public String bold(String input) {
    return bold.apply(input);
  }

  Colors setBold(UnaryOperator<String> bold) {
    this.bold = bold;
    return this;
  }

  public String dim(String input) {
    return dim.apply(input);
  }

  Colors setDim(UnaryOperator<String> dim) {
    this.dim = dim;
    return this;
  }

  public String italic(String input) {
    return italic.apply(input);
  }

  Colors setItalic(UnaryOperator<String> italic) {
    this.italic = italic;
    return this;
  }

  public String underline(String input) {
    return underline.apply(input);
  }

  Colors setUnderline(UnaryOperator<String> underline) {
    this.underline = underline;
    return this;
  }

  public String inverse(String input) {
    return inverse.apply(input);
  }

  Colors setInverse(UnaryOperator<String> inverse) {
    this.inverse = inverse;
    return this;
  }

  public String hidden(String input) {
    return hidden.apply(input);
  }

  Colors setHidden(UnaryOperator<String> hidden) {
    this.hidden = hidden;
    return this;
  }

  public String strikethrough(String input) {
    return strikethrough.apply(input);
  }

  Colors setStrikethrough(UnaryOperator<String> strikethrough) {
    this.strikethrough = strikethrough;
    return this;
  }

  public String black(String input) {
    return black.apply(input);
  }

  Colors setBlack(UnaryOperator<String> black) {
    this.black = black;
    return this;
  }

  public String red(String input) {
    return red.apply(input);
  }

  Colors setRed(UnaryOperator<String> red) {
    this.red = red;
    return this;
  }

  public String green(String input) {
    return green.apply(input);
  }

  Colors setGreen(UnaryOperator<String> green) {
    this.green = green;
    return this;
  }

  public String yellow(String input) {
    return yellow.apply(input);
  }

  Colors setYellow(UnaryOperator<String> yellow) {
    this.yellow = yellow;
    return this;
  }

  public String blue(String input) {
    return blue.apply(input);
  }

  Colors setBlue(UnaryOperator<String> blue) {
    this.blue = blue;
    return this;
  }

  public String magenta(String input) {
    return magenta.apply(input);
  }

  Colors setMagenta(UnaryOperator<String> magenta) {
    this.magenta = magenta;
    return this;
  }

  public String cyan(String input) {
    return cyan.apply(input);
  }

  Colors setCyan(UnaryOperator<String> cyan) {
    this.cyan = cyan;
    return this;
  }

  public String white(String input) {
    return white.apply(input);
  }

  Colors setWhite(UnaryOperator<String> white) {
    this.white = white;
    return this;
  }

  public String gray(String input) {
    return gray.apply(input);
  }

  Colors setGray(UnaryOperator<String> gray) {
    this.gray = gray;
    return this;
  }

  public String bgBlack(String input) {
    return bgBlack.apply(input);
  }

  Colors setBgBlack(UnaryOperator<String> bgBlack) {
    this.bgBlack = bgBlack;
    return this;
  }

  public String bgRed(String input) {
    return bgRed.apply(input);
  }

  Colors setBgRed(UnaryOperator<String> bgRed) {
    this.bgRed = bgRed;
    return this;
  }

  public String bgGreen(String input) {
    return bgGreen.apply(input);
  }

  Colors setBgGreen(UnaryOperator<String> bgGreen) {
    this.bgGreen = bgGreen;
    return this;
  }

  public String bgYellow(String input) {
    return bgYellow.apply(input);
  }

  Colors setBgYellow(UnaryOperator<String> bgYellow) {
    this.bgYellow = bgYellow;
    return this;
  }

  public String bgBlue(String input) {
    return bgBlue.apply(input);
  }

  Colors setBgBlue(UnaryOperator<String> bgBlue) {
    this.bgBlue = bgBlue;
    return this;
  }

  public String bgMagenta(String input) {
    return bgMagenta.apply(input);
  }

  Colors setBgMagenta(UnaryOperator<String> bgMagenta) {
    this.bgMagenta = bgMagenta;
    return this;
  }

  public String bgCyan(String input) {
    return bgCyan.apply(input);
  }

  Colors setBgCyan(UnaryOperator<String> bgCyan) {
    this.bgCyan = bgCyan;
    return this;
  }

  public String bgWhite(String input) {
    return bgWhite.apply(input);
  }

  Colors setBgWhite(UnaryOperator<String> bgWhite) {
    this.bgWhite = bgWhite;
    return this;
  }
}
