package structure_patterns.flyweight.trees;

import java.awt.*;

//Класс, использующий шаблон приспособленец. type -- объект класса-приспособленца; x,y -- переменные поля.
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw (Graphics g) {
        type.draw(g, x, y);
    }

}
