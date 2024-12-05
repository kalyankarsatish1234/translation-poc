package com.Translation_poc.app.Controller;

import com.Translation_poc.app.service.TranslationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/translation")
public class TranslationController {

  /**
   * Endpoint to transliterate Marathi text to English.
   *
   * @param marathiText the input Marathi text
   * @return the transliterated text
   */
  @PostMapping("/transliterate")
  public ResponseEntity<String> transliterateToEnglish(@RequestBody String marathiText) {
    String transliteratedText = TranslationService.transliterateToEnglish(marathiText);
    return ResponseEntity.ok(transliteratedText);
  }
}

