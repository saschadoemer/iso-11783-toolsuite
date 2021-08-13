package de.saschadoemer.iso11783;

/**
 * Client name decoder for ISO 11783-5 encoded client names.
 */
public final class ClientNameDecoder {

    /**
     * Hide the constructor.
     */
    private ClientNameDecoder() {
    }

    /**
     * Decode a given binary representation of a client name into a more common representation.
     *
     * @param clientName -
     */
    public static void decode(byte[] clientName) {
        if (null == clientName || clientName.length == 0) {
            throw new IllegalArgumentException("The client name can not be null or empty");
        }
    }

}
