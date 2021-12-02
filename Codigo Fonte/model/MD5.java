package model;


import java.security.*;
import java.math.*;

public class MD5 {
    
	public String geraHash(String s) throws NoSuchAlgorithmException{
       MessageDigest m = MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       return new BigInteger(1,m.digest()).toString(16);
    }
}

