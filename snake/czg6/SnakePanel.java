package com.czg6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakePanel extends JPanel {
    //定义蛇初始长度
    int length;
    //定义两个数组,专门存储蛇的坐标
    int [] snakeX = new int [200];
    int [] snakeY = new int [200];
    //定义一个变量,判断游戏是否开始
    boolean isStar;
    //定义方向变量
    String dir = "R";
    //定义一个计时器
    Timer timer;
    //定义食物的坐标
    int foodX;
    int foodY;
    //定义死亡状态判断变量
    boolean isDie;
    //定义分数变量
    int count;



    //定义一个初始化方法
    public void init(){
        //初始化小蛇长度为3
        length = 3;
        //初始化蛇头的坐标
        snakeX[0] = 200;
        snakeY[0] = 300;
        //初始化蛇身的坐标
        snakeX[1] = 180;
        snakeY[1] = 300;
        snakeX[2] = 160;
        snakeY[2] = 300;
        isStar = false;
        foodX = 700;
        foodY = 300;
        isDie = false;
        count = 0;
    }
    //构造器
    public SnakePanel(){
        init();
        //加入键位监听
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_SPACE ){
                    if(isDie){
                        init();
                        isDie = false;
                    }else{
                        isStar = !isStar;//启动游戏
                        repaint();
                    }
                }
                //监听方向键
                if(keyCode == KeyEvent.VK_RIGHT){
                    dir = "R";
                }
                if(keyCode == KeyEvent.VK_LEFT){
                    dir = "L";
                }
                if(keyCode == KeyEvent.VK_UP){
                    dir = "U";
                }
                if(keyCode == KeyEvent.VK_DOWN){
                    dir = "D";
                }
                repaint();

            }
        });
        //加入时间监听
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStar&&isDie == false){
                    //让蛇身动起来
                    for (int i = length-1; i >0 ; i--) {
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }
                    //让蛇头动起来
                    if(dir == "R"){
                        snakeX[0]+= 20;
                    }
                    if(dir == "L"){
                        snakeX[0]-= 20;
                    }
                    if(dir == "U"){
                        snakeY[0]-= 20;
                    }
                    if(dir == "D"){
                        snakeY[0]+= 20;
                    }
                    //设置超出边界后动作
                    if(snakeX[0]>780){
                        snakeX[0]=20;
                    }
                    if(snakeX[0]<0){
                        snakeX[0]=780;
                    }
                    if(snakeY[0]>780){
                        snakeY[0]=100;
                    }
                    if(snakeY[0]<100){
                        snakeY[0]=780;
                    }
                    //检测食物和蛇头碰撞
                    //吃食物
                    if(snakeX[0]==foodX && snakeY[0] == foodY){
                        //40-760--2-38
                        //140-680----0-1---7-34
                        foodX = ((int)(Math.random()*37)+2)*20;
                        foodY = ((int)(Math.random()*29)+7)*20;

                        length++;
                        count += 10;
                    }
                    //判断死亡条件
                    for (int i = 1; i < length; i++) {
                        if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                            isDie = true;
                        }
                    }
                    repaint();//重绘
                }

            }
        });
        timer.start();
    }
    //继承是自画板才是画板
    //重写画板中画笔的方法
    @Override
    protected void paintComponent(Graphics g) {


        //设置面板背景
        this.setBackground(new Color(156, 160, 146));
        //画顶部小矩形
        g.setColor(new Color(182, 190, 201));
        g.fillRect(0,0,800,100);
        //画大矩形作为游戏空间
        g.setColor(new Color(182, 190, 201));
        g.fillRect(0,100,800,700);
        //画入分数显示
        g.setColor(new Color(255, 249, 233));
        g.setFont(new Font("微软雅黑",Font.BOLD,40));
        g.drawString("score:"+count,550,50);
        g.drawString("贪吃蛇小游戏欢迎您  by czg",100,50);


        //游戏开始提示语
        if(isStar == false){
            g.setColor(new Color(103, 190, 101));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始游戏",200,400);
        }

        //画静态小蛇
        if("R".equals(dir)){
            Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("L".equals(dir)){
            Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("U".equals(dir)){
            Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if("D".equals(dir)){
            Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        //画小蛇身子,循环
        for (int i = 1; i <length; i++) {
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //画食物
            Images.foodImg.paintIcon(this,g,foodX,foodY);

        if(isDie) {
            g.setColor(new Color(190, 46, 35));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("您已阵亡,点击空格重新开始", 200, 400);
        }
    }
}
