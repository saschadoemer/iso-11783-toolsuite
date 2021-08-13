package de.saschadoemer.iso11783;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ClientNameDecoderTest {

    @Test
    void givenNullValueWhenDecodingTheClientNameThenTheDecoderShouldThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode(null));
    }

    @Test
    @SuppressWarnings("ObviousNullCheck")
    void givenEmptyValueWhenDecodingTheClientNameThenTheDecoderShouldThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode(new byte[0]));
    }

}