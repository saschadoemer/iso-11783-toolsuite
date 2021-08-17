package de.saschadoemer.iso11783;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

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
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3F".getBytes(StandardCharsets.UTF_8))); // Less digits.
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3FFF".getBytes(StandardCharsets.UTF_8))); // Too much digits.
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3F=".getBytes(StandardCharsets.UTF_8))); // Invalid characters.
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3F+".getBytes(StandardCharsets.UTF_8))); // Invalid characters.
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3FG".getBytes(StandardCharsets.UTF_8))); // Invalid characters.
        assertThrows(IllegalArgumentException.class, () -> ClientNameDecoder.decode("A01284000DE0C3FZ".getBytes(StandardCharsets.UTF_8))); // Invalid characters.
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameThenTheDecoderShouldDecodeAllFieldsCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final ClientName clientName = ClientNameDecoder.decode(hexValue.getBytes(StandardCharsets.UTF_8));
        assertTrue(clientName.isSelfConfigurableAddress());
        assertEquals(2, clientName.getIndustryGroup());
        assertEquals(0, clientName.getDeviceClassInstance());
        assertEquals(9, clientName.getDeviceClass());
        assertEquals(132, clientName.getFunction());
        assertEquals(0, clientName.getFunctionInstance());
        assertEquals(0, clientName.getEcuInstance());
        assertEquals(111, clientName.getManufacturerCode());
        assertEquals(50175, clientName.getIdentityNumber());
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheSelfConfigurableAddressThenTheDecoderShouldDecodeTheSelfConfigurableAddressCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final boolean selfConfigurableAddress = ClientNameDecoder.getSelfConfigurableAddress(hexValue.getBytes(StandardCharsets.UTF_8));
        assertTrue(selfConfigurableAddress);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheIndustryGroupThenTheDecoderShouldDecodeTheIndustryGroupCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int industryGroup = ClientNameDecoder.getIndustryGroup(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(2, industryGroup);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheDeviceClassInstanceThenTheDecoderShouldDecodeTheDeviceClassInstanceCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int deviceClassInstance = ClientNameDecoder.getDeviceClassInstance(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(0, deviceClassInstance);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheDeviceClassThenTheDecoderShouldDecodeTheDeviceClassCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int deviceClass = ClientNameDecoder.getDeviceClass(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(9, deviceClass);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheFunctionThenTheDecoderShouldDecodeTheFunctionCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final long function = ClientNameDecoder.getFunction(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(132, function);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheFunctionInstanceThenTheDecoderShouldDecodeTheFunctionInstanceCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int functionInstance = ClientNameDecoder.getFunctionInstance(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(0, functionInstance);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheECUInstanceThenTheDecoderShouldDecodeTheECUInstanceCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int ecuInstance = ClientNameDecoder.getEcuInstance(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(0, ecuInstance);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheManufacturerCodeThenTheDecoderShouldDecodeTheManufacturerCodeCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int manufacturerCode = ClientNameDecoder.getManufacturerCode(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(111, manufacturerCode);
    }

    @Test
    void givenValidHexValueWhenDecodingTheClientNameAndReadingTheIdentityNumberThenTheDecoderShouldDecodeTheIdentityNumberCorrectly() {
        final String hexValue = "A01284000DE0C3FF";
        final int identityNumber = ClientNameDecoder.getIdentityNumber(hexValue.getBytes(StandardCharsets.UTF_8));
        assertEquals(50175, identityNumber);
    }

}