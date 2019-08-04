package com.admin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    // 对任意的明文进行Bcrypt 类型的加密，处理加密问题
   private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

   public  static  String getPasswordEncoder(String password){
       String passwordEncoder = bCryptPasswordEncoder.encode(password);
       return  passwordEncoder;
   }

    public static void main(String[] args) {
        String passwordEncoder = BCryptPasswordEncoderUtils.getPasswordEncoder("123");
        System.out.println(passwordEncoder); // $2a$10$lT2jCvttMw4wjvtVwSRc5ewh568DJe9ld.zEpdn.uIRLid5K7Xdvm
                                            //$2a$10$FM68GMmtW2hgWaCv5TGIqOWTi3pTySOixsj4TzgTQlsBDbNasMKSm
    }
}
