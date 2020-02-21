package com.example.frida;

public class Money {
    private String name;
    private int num;

    public  Money(int num, String name){
        this.name = name;
        this.num  = num;
    }
    public String getInfo(){
        return this.name + ":" + this.num;
    }

}
