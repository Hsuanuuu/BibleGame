package com.company;
import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.Sprite.Moses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    public static final int CELL=50;//每一格大小的像素
    public static final int WIDTH=500;//視窗大小的寬度
    public static final int HEIGHT=500;//設窗大小的高度
    public static final int ROW=HEIGHT/CELL;
    public static final int COLUMN=WIDTH/CELL;

    Moses moses;
    public static GameView gameView;

    public Main(){
        moses=new Moses(1,1);
        gameView = new DisasterView();
        addKeyListener(this);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH,HEIGHT);//設置視窗大小
    }

    @Override
    public void paintComponent (Graphics g){
        gameView.drawView(g);//畫出gameView
        moses.draw(g);//畫出moses
        requestFocusInWindow();

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());//新增元件
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point mosesPoint = moses.getRelativePosition();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(mosesPoint.y > 1){
                    mosesPoint.y -=1;//往上走減1
                }
                break;
            case KeyEvent.VK_DOWN:
                if (mosesPoint.y < ROW){
                    mosesPoint.y +=1;
                }
                break;

            case KeyEvent.VK_RIGHT:
                    if (mosesPoint.x < COLUMN){
                        mosesPoint.x+=1;
                 }
                break;
            case KeyEvent.VK_LEFT:
                if(mosesPoint.x > 1){
                    mosesPoint.x-=1;
                }
                break;
        }
        moses.setPosition(mosesPoint);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
