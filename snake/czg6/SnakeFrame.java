package com.czg6;

import javax.swing.*;

public class SnakeFrame {
    //这是一个mian方法，程序的主要入口
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("贪吃蛇小游戏");
        jf.setBounds(200,200,800,800);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //将面板添加至窗口
        SnakePanel sp = new SnakePanel();
        jf.add(sp);

        jf.setVisible(true);

    }


}
