package com.object;

import com.object.controller.AccountController;

public class BankApplication {

    private BankApplication() {}

    public static void main(String[] args) {
        AccountController controller = new AccountController();
        controller.run();
    }
}
