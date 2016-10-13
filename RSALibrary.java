import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import javax.crypto.Cipher;


public class RSALibrary {

  // String to hold name of the encryption algorithm.
  public final String ALGORITHM = "RSA";

  //String to hold the name of the private key file.
  public final String PRIVATE_KEY_FILE = "./private.key";

  // String to hold name of the public key file.
  public final String PUBLIC_KEY_FILE = "./public.key";

  /***********************************************************************************/
   /* Generates an RSA key pair (a public and a private key) of 1024 bits length */
   /* Stores the keys in the files defined by PUBLIC_KEY_FILE and PRIVATE_KEY_FILE */
   /* Throws IOException */
  /***********************************************************************************/
  public void generateKeys() throws IOException {

    try {

      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
      keyGen.initialize(1024);
      KeyPair keyPair = keyGen.generateKeyPair();

      File privateKey = new File("pruebapriv.key");
      File publicKey = new File("pruebapub.key");

      if(privateKey.getParentFile() != null){
        privateKey.getParentFile().mkdirs();
      }
      privateKey.createNewFile();

      if(publicKey.getParentFile() != null){
        publicKey.getParentFile().mkdirs();
      }
      publicKey.createNewFile();

      ObjectOutputStream privateKeyOS = new ObjectOutputStream(
              new FileOutputStream(privateKey));
      privateKeyOS.writeObject(keyPair.getPrivate());
      privateKeyOS.close();

      ObjectOutputStream publicKeyOS = new ObjectOutputStream(
              new FileOutputStream(publicKey));
      publicKeyOS.writeObject(keyPair.getPublic());
      publicKeyOS.close();

      // TODO: solve encoding issue

	  // TO-DO: Use KeyGen to generate a public and a private key
      // ...

	  // TO-DO: store the public key in the file PUBLIC_KEY_FILE
	  // ...

	  // TO-DO: store the private key in the file PRIVATE_KEY_FILE
	  // ...

	} catch (NoSuchAlgorithmException e) {
		System.out.println("Exception: " + e.getMessage());
        e.printStackTrace();
		System.exit(-1);
	}
  }

  public static void main (String[] args) {
      RSALibrary rsa = new RSALibrary();
      try {
          rsa.generateKeys();
      } catch(IOException e) {
        System.err.println("error");
      }

  }


  /***********************************************************************************/
  /* Encrypts a plaintext using an RSA public key. */
  /* Arguments: the plaintext and the RSA public key */
  /* Returns a byte array with the ciphertext */
  /***********************************************************************************/
  public byte[] encrypt(byte[] plaintext, PublicKey key) {

    byte[] ciphertext = null;

    try {

      // Gets an RSA cipher object
      final Cipher cipher = Cipher.getInstance(ALGORITHM);

      // TO-DO: initialize the cipher object and use it to encrypt the plaintext
	  // ...

    } catch (Exception e) {
      e.printStackTrace();
    }
    return ciphertext;
  }


  /***********************************************************************************/
  /* Decrypts a ciphertext using an RSA private key. */
  /* Arguments: the ciphertext and the RSA private key */
  /* Returns a byte array with the plaintext */
  /***********************************************************************************/
  public byte[] decrypt(byte[] ciphertext, PrivateKey key) {

    byte[] plaintext = null;

    try {
      // Gets an RSA cipher object
      final Cipher cipher = Cipher.getInstance(ALGORITHM);

      // TO-DO: initialize the cipher object and use it to decrypt the ciphertext
	  // ...

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return plaintext;
  }

  /***********************************************************************************/
  /* Signs a plaintext using an RSA private key. */
  /* Arguments: the plaintext and the RSA private key */
  /* Returns a byte array with the signature */
  /***********************************************************************************/
  public byte[] sign(byte[] plaintext, PrivateKey key) {
		
    byte[] signedInfo = null;

    try {

	  // Gets a Signature object
      Signature signature = Signature.getInstance("SHA1withRSA");

	  // TO-DO: initialize the signature oject with the private key
	  // ...
	
	  // TO-DO: set plaintext as the bytes to be signed
	  // ...
	
	  // TO-DO: sign the plaintext and obtain the signature (signedInfo)
	  // ...

    } catch (Exception ex) {
      ex.printStackTrace();
    }

	return signedInfo;
  }
	
  /***********************************************************************************/
  /* Verifies a signature over a plaintext */
  /* Arguments: the plaintext, the signature to be verified (signed) 
  /* and the RSA public key */
  /* Returns TRUE if the signature was verified, false if not */
  /***********************************************************************************/
  public boolean verify(byte[] plaintext, byte[] signed, PublicKey key) {

	boolean result = false;

    try {

 	 // Gets a Signature object
     Signature signature = Signature.getInstance("SHA1withRSA");

	  // TO-DO: initialize the signature oject with the public key
	  // ...

	  // TO-DO: set plaintext as the bytes to be veryfied
	  // ...

	  // TO-DO: verify the signature (signed). Store the outcome in the boolean result
	  // ...
	
    } catch (Exception ex) {
      ex.printStackTrace();
    }

	return result;
  }
	
}


