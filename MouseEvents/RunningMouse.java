package MouseEvents;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class RunningMouse implements MouseListener {

    JFrame f;
    JButton b;

    public RunningMouse() {
        f = new JFrame("Usain Bolt ain't shit");
        b = new JButton("I ain't Yo Bitch");
        b.setBounds(20, 20, 150, 20);
        b.addMouseListener(this);
        f.add(b);
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        Random r = new Random();
        int x = r.nextInt(450);
        int y = r.nextInt(580);
        b.setBounds(x, y, 150, 20);
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public static void main(String[] args) {
        new RunningMouse();
    }
}