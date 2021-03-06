package lk.elevenzcode.healthcare.authapi.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by හShaන් සNදීප on 3/9/2020 5:20 PM
 */
public class DefaultPasswordEncoderFactories {
    public static PasswordEncoder createDelegatingPasswordEncoder() {
        String encodingId = "bcrypt";
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(encodingId, new BCryptPasswordEncoder());
        encoders.put("ldap",
            new org.springframework.security.crypto.password.LdapShaPasswordEncoder());
        encoders.put("MD4", new org.springframework.security.crypto.password.Md4PasswordEncoder());
        encoders.put("MD5",
            new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("MD5"));
        encoders.put("noop",
            org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("SHA-1",
            new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-1"));
        encoders.put("SHA-256",
            new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA" +
                "-256"));
        encoders.put("sha256",
            new org.springframework.security.crypto.password.StandardPasswordEncoder());

        DelegatingPasswordEncoder delegatingPasswordEncoder =
            new DelegatingPasswordEncoder(encodingId, encoders);
        delegatingPasswordEncoder.setDefaultPasswordEncoderForMatches(new BCryptPasswordEncoder());
        return delegatingPasswordEncoder;
    }

    public static void main(String[] args) {

        System.out.println("hospital-api - " + createDelegatingPasswordEncoder().encode(
            "Jr6q6PusG6nYNayB"));
        System.out.println("doctor-api - " + createDelegatingPasswordEncoder().encode(
            "Rc3HpCfYjuxCMQ9y"));
        System.out.println("patient-api - " + createDelegatingPasswordEncoder().encode(
            "fF5MvZFRrkm6qqCB"));
        System.out.println("payment-api - " + createDelegatingPasswordEncoder().encode(
            "r2VdbR2GCN3yMm66"));
        System.out.println("client - " + createDelegatingPasswordEncoder().encode(
            "k3PLhS7fnSZ64xyS"));
    }
}
