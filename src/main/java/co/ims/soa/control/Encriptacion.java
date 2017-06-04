/* 
 * Copyright (C) 2017 Luis Hurtado <lhh9499@gmail.com> 
 * ---------------------------------------------------------------------------- 
 * "THE BEER-WARE LICENSE" (Revision 1.0): 
 *  <lhh9499@gmail.com> wrote this file. As long as you retain this notice you 
 *  can do whatever you want with this stuff. If we meet some day, and you think 
 *  this stuff is worth it, you can buy me a beer in return 
 *  ---------------------------------------------------------------------------- 
 */ 
 
package co.ims.soa.control;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Luis Hernan Hurtado Montenegro <lhh9499@gmail.com>
 * @date 4/06/2017
 */
public class Encriptacion {
    
    public static String SHA1 = "SHA-1";
    
    private static String toHexadecimal(byte[] digest) {

        String hash = "";
        for (byte aux : digest) {

            int b = aux & 0xff;

            if (Integer.toHexString(b).length() == 1) {
                hash += "0";
            }

            hash += Integer.toHexString(b);

        }

        return hash;

    }
    
    public static String getStringMessageDigest(String message, String algorithm) {

        byte[] digest = null;

        byte[] buffer = message.getBytes();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            messageDigest.reset();

            messageDigest.update(buffer);

            digest = messageDigest.digest();

        } catch (NoSuchAlgorithmException ex) {

            System.out.println("Error creando Digest" + ex);

        }

        return toHexadecimal(digest);

    }

}
