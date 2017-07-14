
package com.aplikata.encoder;

public class PlaintextPasswordEncoder extends BasePasswordEncoder {
    public PlaintextPasswordEncoder() {
    }

    /**
     * encode
     *
     * @param password String
     * @return String
     * @todo Implement this com.thtf.ezone.security.encoder.PasswordEncoder
     * method
     */
    public String encode(String password) {
        return mergePasswordAndSalt(password);
    }

}