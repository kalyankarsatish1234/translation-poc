package com.Translation_poc.app.service;

import com.ibm.icu.text.Transliterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class TranslationService {

  private static final Logger logger = LoggerFactory.getLogger(TranslationService.class);

  /**
   * Transliterates Marathi text to English.
   *
   * @param marathiText the Marathi text to transliterate
   * @return the transliterated text with diacritics removed
   */
  public static String transliterateToEnglish(String marathiText) {
    logger.info("Transliteration started for Marathi text: {}", marathiText);
    Transliterator devanagariToLatin = Transliterator.getInstance("mar-Eng");
    String transliteratedText = devanagariToLatin.transliterate(marathiText);
    logger.info("Transliteration result: {}", transliteratedText);
    String result = removeDiacritics(transliteratedText);
    logger.info("Transliteration with diacritics removed: {}", result);
    return result;
  }

  /**
   * Removes diacritics from the input string.
   *
   * @param input the input string
   * @return the string with diacritics removed
   */
  public static String removeDiacritics(String input) {
    logger.info("Removing diacritics from input: {}", input);
    String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    String result = pattern.matcher(normalized).replaceAll("");
    logger.info("Result after removing diacritics: {}", result);
    return result;
  }

  public static void main(String[] args) {
    String marathiText = "पिपळगाव तर्फं घोडा";
    logger.info("Original Marathi text: {}", marathiText);

    String transliteratedText = transliterateToEnglish(marathiText);
    logger.info("Final transliterated output: {}", transliteratedText);
  }
}

