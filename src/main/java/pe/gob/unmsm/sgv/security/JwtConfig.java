/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.unmsm.sgv.security;

/**
 *
 * @author linoa
 */
public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n"
            + "MIIEpAIBAAKCAQEAsp2PrZhATwxQU3EIwbLCrMEhGqSS91134lz7BtuzeAyh2gY1\n"
            + "kHWpXKWZaZh75cx+h0ewpevFSm78Uew8B8fpVUMOCz1ChBP5Gh06LvKKAIJSEFyb\n"
            + "5AKfwce+TkHcXwkKt9eJRoBeYH9kos/gS30OdsxX3+kl2Zoi2JJcyqc8sZa6PVkJ\n"
            + "xyEuZwMvZowqiPEM7H+dOo9OC8p4DbR3TgXSMF5hrDUv7Efrk8ZpU765BDZKYgGm\n"
            + "OEAFgIOLRiZuhCdrWe71tR6Bb1u8rwknXY9DZycRQpaQm5Asp2XLKOBWSOI6oYRV\n"
            + "+IW/y9tcjlKdyZGK+0yLy9AlFXodKVmOezHK6wIDAQABAoIBAQCasn4zMq9YB2k2\n"
            + "q6qS4LldGDQMuEcVeV2Qr0k3Cmeo7P/tLf2MbWvO8xoo68k7IV7g2cV0HvyT2AYv\n"
            + "CfSAJLPBhb8PGvKWJBpWdMPkz2mYwUZEJ4FY/LDTC6WWb9JmeRVQXpvldN7Iou1N\n"
            + "Wc+AcgJp/9eH9Y0zpxzRCArX9fpKL7fFGjb/UWNf6JOcClDtVG0r9rP0QcN+9+3L\n"
            + "TH/sG/CACBU2bj3cehro9ytWlycvEAZKljmf5iHGEFMf7PgL4rRH/TdJKaB4I/ny\n"
            + "yjnpeWgh7E6gcXNVA6TOlqZmYuEVRqFsUSjd6x6v7ya5xzxxju1OsaCarztfaRFQ\n"
            + "9c5uHnXBAoGBAN8pq9yZn7kyj07wmUpHAejEqvv2kTKSy3G2+lHl/35pz4e+rd4o\n"
            + "UK22TEkLyDoBRCF1qYw1XS06TXxCVQ6riOGTFRww9rl5RttwZLRPZII1gr0hIUnD\n"
            + "0AlNGMZJp5gbrEGsnofAAWvpXOweec9hNv06wM+5rCbScA98Adww80xhAoGBAMzl\n"
            + "1eJxPeJBE6VpRWTGq6K+kasUcGCXe5mykNY1xyMwIhsxFqMDLPAIihz4xGKPgguT\n"
            + "1uBLYhhpfTEUMHLA2ht7keu1W11+937zp/EOcyBJ6LMqOuA+eTwpdofIeKPx518D\n"
            + "JaeePj8USDTRVEeDyq92blc6LYcCylS2MN8UnnrLAoGBAI1YEm9dqemd2WDRSPXf\n"
            + "tZjdf8Kor9xNV6gFkdRvjXxevkAnCG6uMDNmRDj7ymzawnFC2glg/0wXIl6ykLcC\n"
            + "9GaTRwqdBJgC9Vsle9MseedyxwTNSA01hb1uZGOq4QiZdmf+UkZ+2SelHeK7hsFP\n"
            + "vIl1PgwTeLL6FFnqXC8/ncnhAoGATIHZblcoa04vXslDDxEbz4Xm8IGOQJLvpQFH\n"
            + "EaU8+UekxJB8yluKMQqPP6gn9EFvppEKX+/l7gWdqHDIcmDOUArA/slWF0Ase+vR\n"
            + "HrJtjHXsfNHc8BSDwlIdHzBc06Kk6RZMvhzZU0Zoe8hZ9uYgDYpkQw/HJi2FjUIG\n"
            + "V5XkYycCgYB2MPkJ/evNK+wukJcuQ09HW8Vpbac9ORBYfXcrxxvA4y30dBE0qDl8\n"
            + "tSYN5SyAukOwniz4bn7y/tz1bEv2sPzhdMQOcc45JCrN2+Kipx5XrXK7fc6ZIoe6\n"
            + "IGVpJea5JWuIHRkPTSihuNkhhOkAkXLmVCudQ0Ca0hgubJnN5cF3cg==\n"
            + "-----END RSA PRIVATE KEY-----";

    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n"
            + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsp2PrZhATwxQU3EIwbLC\n"
            + "rMEhGqSS91134lz7BtuzeAyh2gY1kHWpXKWZaZh75cx+h0ewpevFSm78Uew8B8fp\n"
            + "VUMOCz1ChBP5Gh06LvKKAIJSEFyb5AKfwce+TkHcXwkKt9eJRoBeYH9kos/gS30O\n"
            + "dsxX3+kl2Zoi2JJcyqc8sZa6PVkJxyEuZwMvZowqiPEM7H+dOo9OC8p4DbR3TgXS\n"
            + "MF5hrDUv7Efrk8ZpU765BDZKYgGmOEAFgIOLRiZuhCdrWe71tR6Bb1u8rwknXY9D\n"
            + "ZycRQpaQm5Asp2XLKOBWSOI6oYRV+IW/y9tcjlKdyZGK+0yLy9AlFXodKVmOezHK\n"
            + "6wIDAQAB\n"
            + "-----END PUBLIC KEY-----";
}
