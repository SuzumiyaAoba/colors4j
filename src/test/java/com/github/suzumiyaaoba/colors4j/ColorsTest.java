package com.github.suzumiyaaoba.colors4j;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Test class for Colors functionality. */
@ExtendWith(SoftAssertionsExtension.class)
public class ColorsTest {

  @InjectSoftAssertions private SoftAssertions softly;

  @Test
  void display() {
    final var sut = Colors.createColors(true);

    final var escaped =
        List.of(
            sut.reset("reset"),
            sut.bold("bold"),
            sut.dim("dim"),
            sut.italic("italic"),
            sut.underline("underline"),
            sut.inverse("inverse"),
            sut.hidden("hidden"),
            sut.strikethrough("strikethrough"),
            sut.black("black"),
            sut.red("red"),
            sut.green("green"),
            sut.yellow("yellow"),
            sut.blue("blue"),
            sut.magenta("magenta"),
            sut.cyan("cyan"),
            sut.white("white"),
            sut.gray("gray"),
            sut.bgBlack("bgBlack"),
            sut.bgRed("bgRed"),
            sut.bgGreen("bgGreen"),
            sut.bgYellow("bgYellow"),
            sut.bgBlue("bgBlue"),
            sut.bgMagenta("bgMagenta"),
            sut.bgCyan("bgCyan"),
            sut.bgWhite("bgWhite"));

    escaped.forEach(System.out::println);
  }

  @ParameterizedTest
  @MethodSource("provider_escaped")
  void escape(String escaped, String expected) {
    softly.assertThat(escaped).isEqualTo(expected);
  }

  static List<Arguments> provider_escaped() {
    final var sut = Colors.createColors(true);

    return List.of(
        arguments(sut.reset("reset"), "\u001B[0mreset\u001B[0m"),
        arguments(sut.bold("bold"), "\u001B[1mbold\u001B[22m"),
        arguments(sut.dim("dim"), "\u001B[2mdim\u001B[22m"),
        arguments(sut.italic("italic"), "\u001B[3mitalic\u001B[23m"),
        arguments(sut.underline("underline"), "\u001B[4munderline\u001B[24m"),
        arguments(sut.inverse("inverse"), "\u001B[7minverse\u001B[27m"),
        arguments(sut.hidden("hidden"), "\u001B[8mhidden\u001B[28m"),
        arguments(sut.strikethrough("strikethrough"), "\u001B[9mstrikethrough\u001B[29m"),
        arguments(sut.black("black"), "\u001B[30mblack\u001B[39m"),
        arguments(sut.red("red"), "\u001B[31mred\u001B[39m"),
        arguments(sut.green("green"), "\u001B[32mgreen\u001B[39m"),
        arguments(sut.yellow("yellow"), "\u001B[33myellow\u001B[39m"),
        arguments(sut.blue("blue"), "\u001B[34mblue\u001B[39m"),
        arguments(sut.magenta("magenta"), "\u001B[35mmagenta\u001B[39m"),
        arguments(sut.cyan("cyan"), "\u001B[36mcyan\u001B[39m"),
        arguments(sut.white("white"), "\u001B[37mwhite\u001B[39m"),
        arguments(sut.gray("gray"), "\u001B[90mgray\u001B[39m"),
        arguments(sut.bgBlack("bgBlack"), "\u001B[40mbgBlack\u001B[49m"),
        arguments(sut.bgRed("bgRed"), "\u001B[41mbgRed\u001B[49m"),
        arguments(sut.bgGreen("bgGreen"), "\u001B[42mbgGreen\u001B[49m"),
        arguments(sut.bgYellow("bgYellow"), "\u001B[43mbgYellow\u001B[49m"),
        arguments(sut.bgBlue("bgBlue"), "\u001B[44mbgBlue\u001B[49m"),
        arguments(sut.bgMagenta("bgMagenta"), "\u001B[45mbgMagenta\u001B[49m"),
        arguments(sut.bgCyan("bgCyan"), "\u001B[46mbgCyan\u001B[49m"),
        arguments(sut.bgWhite("bgWhite"), "\u001B[47mbgWhite\u001B[49m"));
  }

  @ParameterizedTest
  @MethodSource("provider_unescaped")
  void unescape(String unescaped, String expected) {
    softly.assertThat(unescaped).isEqualTo(expected);
  }

  static List<Arguments> provider_unescaped() {
    final var sut = Colors.createColors(false);

    return List.of(
        arguments(sut.reset("reset"), "reset"),
        arguments(sut.bold("bold"), "bold"),
        arguments(sut.dim("dim"), "dim"),
        arguments(sut.italic("italic"), "italic"),
        arguments(sut.underline("underline"), "underline"),
        arguments(sut.inverse("inverse"), "inverse"),
        arguments(sut.hidden("hidden"), "hidden"),
        arguments(sut.strikethrough("strikethrough"), "strikethrough"),
        arguments(sut.black("black"), "black"),
        arguments(sut.red("red"), "red"),
        arguments(sut.green("green"), "green"),
        arguments(sut.yellow("yellow"), "yellow"),
        arguments(sut.blue("blue"), "blue"),
        arguments(sut.magenta("magenta"), "magenta"),
        arguments(sut.cyan("cyan"), "cyan"),
        arguments(sut.white("white"), "white"),
        arguments(sut.gray("gray"), "gray"),
        arguments(sut.bgBlack("bgBlack"), "bgBlack"),
        arguments(sut.bgRed("bgRed"), "bgRed"),
        arguments(sut.bgGreen("bgGreen"), "bgGreen"),
        arguments(sut.bgYellow("bgYellow"), "bgYellow"),
        arguments(sut.bgBlue("bgBlue"), "bgBlue"),
        arguments(sut.bgMagenta("bgMagenta"), "bgMagenta"),
        arguments(sut.bgCyan("bgCyan"), "bgCyan"),
        arguments(sut.bgWhite("bgWhite"), "bgWhite"));
  }
}
