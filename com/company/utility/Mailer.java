package com.company.utility;

import com.company.transaction.Token;

/**
 * Created by anhaytananun on 13.05.15.
 */
public class Mailer {
    private static Mailer sharedMailer;

    private Mailer() {

    }

    public static Mailer sharedMailer() {
        if (sharedMailer == null) {
            sharedMailer = new Mailer();
        }

        return sharedMailer;
    }

    public void sendTokens(String email, Token[] tokens) {
        System.out.println("Mail sent to " + email);
        System.out.println("Mail Content :");

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
