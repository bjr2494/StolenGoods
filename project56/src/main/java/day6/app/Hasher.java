package day6.app;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hasher {

	private static byte[] owaspHash(
			final char[] password, 
			final byte[] salt, 
			final int iterations,
			final int keyLength) {

		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
			PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
			SecretKey key = skf.generateSecret(spec);
			byte[] res = key.getEncoded();
			return res;

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	public static String hash(String password) {
		return Base64.getEncoder().encodeToString(owaspHash(password.toCharArray(),
		         Hasher.getSalt(),
		         10000,
		         256));	
	}
	
	private static byte[] getSalt() {
		String salt = "45";
		byte[] saltBytes = salt.getBytes();
	    return saltBytes;
	}
}
