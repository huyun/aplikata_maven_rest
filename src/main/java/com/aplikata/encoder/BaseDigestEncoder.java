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

public abstract class BaseDigestEncoder extends BasePasswordEncoder {
    private boolean encodeHashAsBase64 = false;

    public void setEncodeHashAsBase64(boolean encodeHashAsBase64) {
        this.encodeHashAsBase64 = encodeHashAsBase64;
    }

    public boolean getEncodeHashAsBase64() {
        return encodeHashAsBase64;
    }
}
