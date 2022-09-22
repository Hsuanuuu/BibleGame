package com.company.Sprite;

import com.company.Main;

import javax.swing.*;
import java.awt.*;

public abstract class Sprite {
    protected ImageIcon img;
    protected Point relativePosition;//每一個Point,x跟y的值(相對位置)
    protected Point absolutePosition;//(絕對位置)

    public void draw(Graphics g){
        //畫小精靈
        if(relativePosition!=null){//因為把小精靈殺死後會為空,就沒辦法做paintIcon
            img.paintIcon(null,g,absolutePosition.x,absolutePosition.y);
        }
    }

    public void setPosition(Point p){
        setPosition(p.x,p.y);
    }

    public void setPosition(int x,int y){
        relativePosition=new Point(x,y);
        absolutePosition=new Point((x-1)* Main.CELL,(y-1)*Main.CELL);

    }

    public void setNullPosition(){
        relativePosition=null;
        absolutePosition=null;
    }

    public Point getRelativePosition(){
        if (relativePosition==null){
            return null;
        }else {
            return new Point(relativePosition);
        }
    }

    public abstract String overlap(int x,int y);

}
