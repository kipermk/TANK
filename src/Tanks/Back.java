package Tanks;

import javax.swing.*;
import java.awt.*;

public class Back{

    //Image img = new ImageIcon("C:\\Tests\\fon.jpg").getImage();
    Image img = new ImageIcon("image/fon.jpg").getImage();

    public void draw(Graphics2D g){
        g.drawImage(img,0,0,null);
        //g.setBackground(Color.BLUE);

    }
}
