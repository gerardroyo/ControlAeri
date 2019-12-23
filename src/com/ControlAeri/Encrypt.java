package com.ControlAeri;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Encrypt {

    public static String Encrypt(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }

    public static String Decrypt(String s) throws UnsupportedEncodingException {
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, "utf-8");

    }
}
