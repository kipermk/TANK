package Tanks;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class PlayerTank {


    private int speed;
    private int speedBack;

    private double x;
    private double y;
    private double angl;


    // public static boolean up;
    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;

    //Панель игрока позиции
    public static boolean leftPosition;
    public static boolean rightPosition;


    //Image img = new ImageIcon("C:\\Tests\\fon.jpg").getImage();
    Image img; //= new ImageIcon("image/pl1.png").getImage();

    public PlayerTank(){
        up    = false;
        down  = false;
        left  = false;
        right = false;

        speed = 3;
        //x=500;
        //y=100;

        angl = 0;
        //System.out.println(angl);
    }

    public void update() {

        double gradus = Math.toDegrees(angl);
        if (gradus > 360) angl = 0;
        if (gradus < 0) angl = 6.20;



        if (up){

//           y = y+speed * Math.acos(Math.toRadians(gradus));
//           x = x-speed * Math.asin(Math.toRadians(gradus));

//            x = x+speed * Math.asin(angl);
//            y = y-speed * Math.acos(angl);
            //x = x+speed * Math.asin(angl);

            System.out.println("------------------------------------------------");
            System.out.println("Gradus = "+gradus);
            System.out.println("angle = "+angl);
            System.out.println("Y = "+y);
            System.out.println("X = "+x);
            //System.out.println("REZ = "+(speed * Math.asin(angl)));
            //System.out.println(Math.toRadians(gradus));
            System.out.println("SIN = "+Math.asin(angl));
            System.out.println("COS = "+Math.acos(angl));

            System.out.println("atan = "+Math.atan(angl));
            //System.out.println("COS = "+Math.a(angl));


            if (gradus>23 && gradus<67)   {x = x-speed; y = y+speed;}
            if (gradus>68 && gradus<112)  x = x-speed;
            if (gradus>113 && gradus<157) {x = x-speed; y = y-speed;}
            if (gradus>158 && gradus<202) y = y-speed;
            if (gradus>203 && gradus<247) {x = x+speed; y = y-speed;}
            if (gradus>248 && gradus<292) x = x+speed;
            if (gradus>293 && gradus<337) {x = x+speed; y = y+speed;}
            if (gradus>338 && gradus<361||gradus>=0 && gradus<22) y = y+speed;


        }
        if (down){

            speedBack = (speed*-1)+2;

            if (gradus>23 && gradus<67)   {x = x-speedBack; y = y+speedBack;}
            if (gradus>68 && gradus<112)  x = x-speedBack;
            if (gradus>113 && gradus<157) {x = x-speedBack; y = y-speedBack;}
            if (gradus>158 && gradus<202) y = y-speedBack;
            if (gradus>203 && gradus<247) {x = x+speedBack; y = y-speedBack;}
            if (gradus>248 && gradus<292) x = x+speedBack;
            if (gradus>293 && gradus<337) {x = x+speedBack; y = y+speedBack;}
            if (gradus>338 && gradus<361||gradus>0 && gradus<22) y = y+speedBack;

        }

        //Развороты
        if (left){
            angl = angl - 0.05;
        }
        if (right){
            angl = angl + 0.05;
        }

        //Запрет выезда за пределы
        if (x<0) x = 0;
        if (x>Panel.WIDTH-50) x = Panel.WIDTH-50;
        if (y<0) y = 0;
        if (y>Panel.HEIGHT-80) y = Panel.HEIGHT-80;


    }

    public void draw(Graphics2D g){

        //public static boolean rightPosition;

        int xPos=0;
        if (leftPosition) {
            xPos = 0;
//            yPos =
        }
        if (rightPosition) {
            xPos = Panel.WIDTH - 100;
//            int yPos =
        }

        g.setColor(Color.DARK_GRAY);
        g.fillRect(xPos ,10,xPos+100,80);

        g.setColor(Color.GRAY);
        g.setFont(new Font("Arial", Font.ITALIC,14));
        ((Graphics2D) g).drawString("X = "+x,xPos + 15,25);
        ((Graphics2D) g).drawString("Y = "+y,xPos + 15,50);
        ((Graphics2D) g).drawString("Angle = "+angl,xPos + 15,75);


        //System.out.println("Gradus = "+gradus);
//        System.out.println("angle = "+angl);
//        System.out.println("Y = "+y);
//        System.out.println("X = "+x);


        //Вращение
        AffineTransform origXform;
        origXform = g.getTransform();
        AffineTransform newXform = (AffineTransform)(origXform.clone());
        newXform.rotate(angl,x+23,y+60);
        g.setTransform(newXform);
        g.drawImage(img,(int)x,(int)y,null); //paint
        g.setTransform(origXform);
        //g.setBackground(Color.BLUE);
    }
    //ГЕТЕРЫ
    public double getX() {return x; }
    public double getY() {return y; }

    //СЕТЕРЫ
    public static void setControl(boolean up,boolean down, boolean left, boolean right) {
        PlayerTank.up       = up;
        PlayerTank.down     = down;
        PlayerTank.left     = left;
        PlayerTank.right    = right;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setXYAngle(double x, double y, double angl ){
        this.x = x;
        this.y = y;
        this.angl = angl;

    }

}
