package com.exam.nxt.common;

import com.exam.nxt.entity.Product;

import java.text.SimpleDateFormat;

public class GenerateId {
    //生成userid
    public static String getUserid() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "u" + format.format(System.currentTimeMillis());
    }
    //生成ProductId
    public static String getProductId() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "p" + format.format(System.currentTimeMillis());
    }
    //生成cartId
    public static String getCartId() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "c" + format.format(System.currentTimeMillis());
    }
    //生成shoppingId
    public static String getShoppingId() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "si" + format.format(System.currentTimeMillis());
    }
    //生成OrdersId
    public static String getOrdersId() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "o" + format.format(System.currentTimeMillis());
    }
    //生成oderItemsId
    public static String getOItemId() {
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "oi" + format.format(System.currentTimeMillis());
    }
    //生成payId
    public static String payId(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "pi" + format.format(System.currentTimeMillis());
    }
    //生成collectionId
    public static String collectionId(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "coll" + format.format(System.currentTimeMillis());
    }
    //生成AddressId
    public static String addressId(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "a" + format.format(System.currentTimeMillis());
    }
    //生成commentId
    public static String commentId(){
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return "c" + format.format(System.currentTimeMillis());
    }
}
