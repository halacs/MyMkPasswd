package hu.halacs.mkpasswd;

import java.security.MessageDigest;
import org.apache.commons.codec.digest.Crypt;
import java.io.*;

public class MyMkPasswd
{
  public static void main(String[] args)
  {
    // https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
    // https://commons.apache.org/proper/commons-codec/apidocs/org/apache/commons/codec/digest/Crypt.html

    String plainPassword = "sporo";
    String salt = "4CN9XOLytKUV4SNf";
    
    /*
    The exact algorithm depends on the format of the salt string:

    SHA-512 salts start with $6$ and are up to 16 chars long.
    SHA-256 salts start with $5$ and are up to 16 chars long
    MD5 salts start with $1$ and are up to 8 chars long
    DES, the traditional UnixCrypt algorithm is used with only 2 chars
    Only the first 8 chars of the passwords are used in the DES algorithm
    */
    String hashedPassword = Crypt.crypt(plainPassword, "$5$"+salt);

    System.out.println("Our hash: " + hashedPassword);

    // Validate our password recently generated password hash with mkpasswd
    String referenceHash = "";

    try
    {
      Process p = Runtime.getRuntime().exec("mkpasswd -m sha-256 -S " + salt + " " +  plainPassword);
      p.waitFor();
      BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
      referenceHash = input.readLine();
      System.out.println("Reference Hash: " + referenceHash);
    }
    catch (Exception err)
    {
      err.printStackTrace();
    }

    if (referenceHash.equals(hashedPassword))
      System.out.println("We are good! :)");
    else
      System.out.println("Something fuckin' went wrong :'(");
  }

}
