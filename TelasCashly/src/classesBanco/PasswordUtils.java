package classesBanco;
	
	import javax.crypto.SecretKeyFactory;
	import javax.crypto.spec.PBEKeySpec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
	import java.util.Base64;

	public class PasswordUtils {
		
		public static String md5(String input) {
		    try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] messageDigest = md.digest(input.getBytes());
		        StringBuilder sb = new StringBuilder();
		        for (byte b : messageDigest) {
		            sb.append(String.format("%02x", b));
		        }
		        return sb.toString();
		    } catch (NoSuchAlgorithmException e) {
		        throw new RuntimeException(e);
		    }
		}

	    public static String gerarHash(String senha) throws Exception {
	        SecureRandom sr = new SecureRandom();
	        byte[] salt = new byte[16];
	        sr.nextBytes(salt);

	        PBEKeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, 65536, 128);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

	        byte[] hash = skf.generateSecret(spec).getEncoded();

	        return Base64.getEncoder().encodeToString(salt) + ":" +
	               Base64.getEncoder().encodeToString(hash);
	    }

	    
	    public static boolean validarSenha(String senha, String hashArmazenado) throws Exception {
	        String[] partes = hashArmazenado.split(":");
	        byte[] salt = Base64.getDecoder().decode(partes[0]);
	        byte[] hashEsperado = Base64.getDecoder().decode(partes[1]);

	        PBEKeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, 65536, 128);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	        byte[] hashGerado = skf.generateSecret(spec).getEncoded();

	        if (hashGerado.length != hashEsperado.length) return false;
	        for (int i = 0; i < hashGerado.length; i++) {
	            if (hashGerado[i] != hashEsperado[i]) return false;
	        }
	        return true;
	    }
	}



