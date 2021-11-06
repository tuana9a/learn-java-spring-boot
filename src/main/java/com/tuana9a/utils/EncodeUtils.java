package com.tuana9a.utils;

import java.security.MessageDigest;

public class EncodeUtils {

    public static String getSHA256(String password) {
        String result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            result = bytesToHex(messageDigest.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return result.toString();
    }

}
