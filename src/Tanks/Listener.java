package Tanks;

import java.awt.event.*;

public class Listener implements MouseListener, KeyListener,MouseMotionListener {



    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==KeyEvent.VK_UP)    Panel.presskeyUp1    = true;
        if (key==KeyEvent.VK_DOWN)  Panel.presskeyDown1  = true;
        if (key==KeyEvent.VK_LEFT)  Panel.presskeyLeft1  = true;
        if (key==KeyEvent.VK_RIGHT) Panel.presskeyRight1 = true;

        if (key==KeyEvent.VK_W)     Panel.presskeyUp2    = true;
        if (key==KeyEvent.VK_S)     Panel.presskeyDown2  = true;
        if (key==KeyEvent.VK_A)     Panel.presskeyLeft2  = true;
        if (key==KeyEvent.VK_D)     Panel.presskeyRight2 = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key==KeyEvent.VK_UP)    Panel.presskeyUp1    = false;
        if (key==KeyEvent.VK_DOWN)  Panel.presskeyDown1  = false;
        if (key==KeyEvent.VK_LEFT)  Panel.presskeyLeft1  = false;
        if (key==KeyEvent.VK_RIGHT) Panel.presskeyRight1 = false;

        if (key==KeyEvent.VK_W)     Panel.presskeyUp2    = false;
        if (key==KeyEvent.VK_S)     Panel.presskeyDown2  = false;
        if (key==KeyEvent.VK_A)     Panel.presskeyLeft2  = false;
        if (key==KeyEvent.VK_D)     Panel.presskeyRight2 = false;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
