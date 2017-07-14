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

public interface PasswordEncoder {
    public String encode(String password);

    public boolean isValidPassword(String encodedPassword, String password);
}
