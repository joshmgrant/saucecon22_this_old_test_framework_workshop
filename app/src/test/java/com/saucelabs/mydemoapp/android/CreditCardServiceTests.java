package com.saucelabs.mydemoapp.android;

import org.junit.Test;
import org.junit.Assert;

import okhttp3.Response;
import okhttp3.ResponseBody;

import com.saucelabs.mydemoapp.android.utils.Network;

import java.io.IOException;

public class CreditCardServiceTests {

    @Test
    public void invalidCardNumber() {
        Response resp = Network.fetch("https://rgu3pw.deta.dev/validate_number/123456");

        int actual = resp.code();
        int expected = 400;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void validCardNumber() {
        Response resp = Network.fetch("https://rgu3pw.deta.dev/validate_number/5222970036709861");

        int actual = resp.code();
        int expected = 200;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void cardTypeMessage(){
        ResponseBody resp = Network.fetchBody("https://rgu3pw.deta.dev/validate_number/52207600987654321");

        String expectedDetail = "Mastercard";
        String actualDetail = "foo";
        try {
            actualDetail = resp.string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(actualDetail);

        Assert.assertTrue(actualDetail.contains(expectedDetail));

    }
}
