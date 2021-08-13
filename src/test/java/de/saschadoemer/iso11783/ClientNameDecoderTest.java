package de.saschadoemer.iso11783;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientNameDecoderTest {

    @Test
    void givenNullValueWhenDecodingTheClientNameThenTheDecoderShouldThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode(null));
    }

    @Test
    void givenEmptyValueWhenDecodingTheClientNameThenTheDecoderShouldThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode(new byte[0]));
    }

    @Test
    void givenInvalidHexValueWhenDecodingTheClientNameThenTheDecoderShouldDecodeAllFieldsCorrectly() {
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3F".getBytes(StandardCharsets.UTF_8))); // Less digits
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3FFF".getBytes(StandardCharsets.UTF_8))); // Too much digits
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameThenTheDecoderShouldDecodeAllFieldsCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
    }

}