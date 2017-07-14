/*
 * Copyright 2007 by LongTop Corporation.
 * Softpack ChuangXin Building 15F, XiaMen, FuJian, PRC 361005
 *
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * LongTop Corporation ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with LongTop.
 * 
 */
package com.aplikata.encoder;

public abstract class BasePasswordEncoder implements PasswordEncoder {
    protected final static String SEPERATOR = "$";
    private String salt;

    public BasePasswordEncoder() {
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    protected boolean isEmptySalt() {
        return salt == null || "".equals(salt);
    }

    protected String mergePasswordAndSalt(String password) {
        //empty password
        if (password == null) {
            password = "";
        }
        //empty salt
        if (isEmptySalt()) {
            return password;
        }
        StringBuffer buffer = new StringBuffer(password);
        buffer.append(SEPERATOR);
        buffer.append(salt);
        return buffer.toString();
    }

    public boolean isValidPassword(String encodedPassword, String password) {
        return encode(password).equals(encodedPassword);
    }

//    protected String[] demergePasswordAndSalt(String mergedString){
//        int index = mergedString.lastIndexOf(SEPERATOR);
//
//        //empty salt
//        if (index == -1){
//            return new String[]{mergedString,""};
//        }else{
//            String password = mergedString.substring(0,index);
//            String salt = mergedString.substring(index+1);
//            return new String[]{password,salt};
//        }
//    }
}
