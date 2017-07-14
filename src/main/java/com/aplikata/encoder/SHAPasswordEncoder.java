
package com.aplikata.encoder;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class SHAPasswordEncoder extends BaseDigestEncoder {
    public SHAPasswordEncoder() {
    }

    public static void main(String args[]) {

        SHAPasswordEncoder encoder = new SHAPasswordEncoder();
        String str = encoder.encode("1234");
        System.out.println(str);

    }

    /**
     * encode
     *
     * @param password String
     * @return String
     * @todo Implement this com.thtf.ezone.security.encoder.PasswordEncoder
     * method
     */
    @SuppressWarnings("deprecation")
	public String encode(String password) {
        String input = mergePasswordAndSalt(password);
        if (!getEncodeHashAsBase64()) {
            return DigestUtils.shaHex(input);
        }

        byte[] encoded = Base64.encodeBase64(DigestUtils.sha(input));

        return new String(encoded);
	}
}