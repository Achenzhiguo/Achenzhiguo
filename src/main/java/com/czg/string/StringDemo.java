package com.czg.string;

public class StringDemo {
    //这是一个mian方法，程序的主要入口
    public static void main(String[] args) {
        String s = "abc" ;
        s.concat("def");
        s.substring(0);
        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefg");
        System.out.println(sb);

    }
}
