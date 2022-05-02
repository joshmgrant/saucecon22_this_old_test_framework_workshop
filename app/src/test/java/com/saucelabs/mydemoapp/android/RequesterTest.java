package com.saucelabs.mydemoapp.android;

import org.junit.Test;
import org.junit.Assert;

import okhttp3.Response;
import com.saucelabs.mydemoapp.android.utils.Network;

import java.io.IOException;

public class RequesterTest {

    @Test
    public void test200(){
        Response resp = Network.fetch("https://http.cat/200");

        int actual = resp.code();
        int expected = 200;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMyService() {
        Response resp = Network.fetch("https://rgu3pw.deta.dev/validate_number/123456");

        int actual = resp.code();
        int expected = 400;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testMyServiceMessage(){
        Response resp = Network.fetch("https://rgu3pw.deta.dev/validate_number/123456");

        String expectedDetail = "Mastercard";
        String actualDetail = "foo";
        try {
            actualDetail = resp.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(actualDetail);

        Assert.assertTrue(actualDetail.contains(expectedDetail));

    }
}
