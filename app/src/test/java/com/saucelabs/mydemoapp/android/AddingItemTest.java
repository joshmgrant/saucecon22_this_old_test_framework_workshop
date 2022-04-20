package com.saucelabs.mydemoapp.android;

import com.saucelabs.mydemoapp.android.model.ProductModel;
import com.saucelabs.mydemoapp.android.view.fragments.ProductDetailFragment;

import org.junit.Assert;
import org.junit.Test;

public class AddingItemTest {

    @Test
    public void addOneItemToCart(){

        ProductModel productModel = new ProductModel();
        productModel.setTitle("item");
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();

        int expected = 1;
        int actual = productDetailFragment.countItemsInCart(productModel, 1);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addBoltTShirt(){
        ProductModel productModel = new ProductModel();
        productModel.setTitle("Sauce Lab Bolt T-Shirt");
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();

        int expected = 1;
        int actual = productDetailFragment.countItemsInCart(productModel, 1);

        Assert.assertEquals(expected, actual);
    }

}
