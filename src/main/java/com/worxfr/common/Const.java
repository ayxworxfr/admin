package com.worxfr.common;

public class Const {

    public static final String CURRENT_USER = "currentUser";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";


    public interface RoleCode{
        public static String ROLE_ADMIN = "rc000001";        // 超级管理员
        public static String ROLE_ADMIN2 = "rc000002";       // 普通管理员
        public static String ROLE_MANAGE = "rc000003";
        public static String ROLE_MANAGE2 = "rc000004";
        public static String ROLE_CLERK= "rc000005";
        public static String ROLE_USER = "rc000006";
    }
}
