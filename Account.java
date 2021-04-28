package com.omerkagandanaci.projecttrial.Model;
/**
 * Account Class
 * @author Kerem Karzaoğlu
 * @version 18.04.2021 değişiklik yapıldı
 */
public class Account {
    //Variables
    private String email;
    private String password;
    private boolean isPasswordForgotten;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //Methods
    public boolean verifyLogin() {
        return true;
    }

    public boolean updatePassword() {
        return true;
    }
}
