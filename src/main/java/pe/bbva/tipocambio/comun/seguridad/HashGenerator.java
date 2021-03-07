package pe.bbva.tipocambio.comun.seguridad;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

public class HashGenerator {

    /**
     * Generar contraseña con SHA512 con salt
     *
     * @param password
     * @param salt
     * @return byte array with encode passphrase
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static byte[] getHash(String password, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.update(salt.getBytes());
        return digest.digest(password.getBytes("UTF-8"));
    }

    /**
     * Genera el Salt requerido para el cálculo del HASH
     *
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString();
    }

    /**
     * Compara dos Hash
     *
     * @param hashOrigen
     * @param hashDestino
     * @return
     */
    public static boolean isEqualHash(byte[] hashOrigen, byte[] hashDestino) {
        return Arrays.equals(hashOrigen, hashDestino);
    }
}
