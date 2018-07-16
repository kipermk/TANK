package Tanks;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {

    public static boolean presskeyUp1;
    public static boolean presskeyDown1;
    public static boolean presskeyLeft1;
    public static boolean presskeyRight1;

    public static boolean presskeyUp2;
    public static boolean presskeyDown2;
    public static boolean presskeyLeft2;
    public static boolean presskeyRight2;

    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static enum STATES{MENUE,PLAY}
    public static STATES state = STATES.PLAY;

    private BufferedImage image;
    private Graphics2D g;


    Timer mainTimer = new Timer(30,this);

    Back back = new Back();
    PlayerTank tank1 = new PlayerTank();
    PlayerTank tank2 = new PlayerTank();


    //Временно
//    PlayerTank tank3 = new PlayerTank();
//    PlayerTank tank4 = new PlayerTank();
//    PlayerTank tank5 = new PlayerTank();
//    PlayerTank tank6 = new PlayerTank();
//    PlayerTank tank7 = new PlayerTank();


    public Panel() {
        super();
        setFocusable(true);
        requestFocus();
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) image.getGraphics();

        addKeyListener(new Listener());

        mainTimer.start();
        System.out.println("Timer START");

        tank1.setImg(new ImageIcon("image/pl2.png").getImage());
        tank1.setXYAngle(800,250,1.60);

        tank2.setImg(new ImageIcon("image/pl1.png").getImage());
        tank2.setXYAngle(100,50,4.75);

        //Временно
//        tank3.setImg(new ImageIcon("image/pl1.png").getImage());
//        tank3.setXYAngle(100,50,4.75);
//        tank4.setImg(new ImageIcon("image/pl1.png").getImage());
//        tank4.setXYAngle(100,150,4.75);
//        tank5.setImg(new ImageIcon("image/pl1.png").getImage());
//        tank5.setXYAngle(100,250,4.75);
//
//        tank6.setImg(new ImageIcon("image/pl1.png").getImage());
//        tank6.setXYAngle(250,100,4.75);
//        tank7.setImg(new ImageIcon("image/pl1.png").getImage());
//        tank7.setXYAngle(250,200,4.75);
    }

    public void actionPerformed(ActionEvent e) {
        if(state.equals(STATES.MENUE)){
            //System.out.println("MENUE");

        }
        if(state.equals(STATES.PLAY)){
            //System.out.println("PLAY  ");
            gameUpdate();
            gameRender();
            gameDraw();

        }
    }

    private void gameUpdate() {

        WIDTH   = getBounds().width;
        HEIGHT  = getBounds().height;
//        Panel.getDefaultLocale().

        //System.out.println("-------------"+);

//        tank1.up = presskeyUp1;
//        tank1.down = presskeyDown1;
//        tank1.left = presskeyLeft1;
//        tank1.right = presskeyRight1;
        tank1.setControl(presskeyUp1,presskeyDown1,presskeyLeft1,presskeyRight1);
        tank1.update();

        tank2.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
        tank2.update();


        //Временно
//        tank3.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
//        tank3.update();
//        tank4.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
//        tank4.update();
//        tank5.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
//        tank5.update();
//        tank6.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
//        tank6.update();
//        tank7.setControl(presskeyUp2,presskeyDown2,presskeyLeft2,presskeyRight2);
//        tank7.update();



    }

    private void gameRender() {
        back.draw(g);

        tank1.leftPosition = true;
        tank1.draw(g);
        tank2.draw(g);


        //Временно
//        tank3.draw(g);
//        tank4.draw(g);
//        tank5.draw(g);
//        tank6.draw(g);
//        tank1.rightPosition = true;
//        tank7.draw(g);


        Image imge = new ImageIcon("image/krisha.jpg").getImage();
        g.drawImage(imge,10,HEIGHT-400,null);


    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image ,0,0,null);
        g2.dispose();
    }
}
