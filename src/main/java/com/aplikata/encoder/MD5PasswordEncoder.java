/*
 * Copyright 2007 by LongTop Corporation.
 * Softpack ChuangXin Building 15F, XiaMen, FuJian, PRC 361005
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * LongTop Corporation ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with LongTop.
 */
package com.aplikata.encoder;


import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;



public class MD5PasswordEncoder extends BaseDigestEncoder {
	public MD5PasswordEncoder() {
	}

	public static void main(String args[]) {

		MD5PasswordEncoder encoder = new MD5PasswordEncoder();
		String str = encoder.encode("a");
		System.out.println(str);

	}

	/**
	 * encode
	 * 
	 * @param password
	 *            String
	 * @return String
	 * @todo Implement PasswordEncoder
	 *       method
	 */
	public String encode(String password) {
		String input = mergePasswordAndSalt(password);
		if (!getEncodeHashAsBase64()) {
			return DigestUtils.md5Hex(input);
		}

		byte[] encoded = Base64.encodeBase64(DigestUtils.md5(input));

		return new String(encoded);
	}
}
