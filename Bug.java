package com.company.Sprite.DisasterViewSprite;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class Bug extends Sprite {

    public Bug(int x,int y){
        setPosition(x,y);//繼承Sprite，設定相對位置和絕對位置
        img = new ImageIcon("bug.png");
    }
    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
