package com.company.GameView;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import com.company.Sprite.*;

public abstract class GameView {

    protected ArrayList<Sprite> elements;
    protected Door door;//每一個View都有一個門可以繼續往下走(GameView繼承Door)
    protected ImageIcon img;//每個背景

    public void drawView(Graphics g){
        //畫出所有在Sprite裡的Icon
        img.paintIcon(null,g,0,0);
        for (Sprite s:elements){
            s.draw(g);
        }
    }
}
