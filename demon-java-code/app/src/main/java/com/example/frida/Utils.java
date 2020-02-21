package com.example.frida;

public class Utils {
    public static int getCalc(int a,int b){
        return  a + b;
    }
    public static int _getCalc(int a,int b,int c){
        return (a + b) + c;
    }
    public  static  Money getMoney(){
        return new Money(100,"RMB");
    }
    public static String test(){
        return "QAX: No1";
    }
    public static String test(int num){
        return "QAX" + num;
    }

}
