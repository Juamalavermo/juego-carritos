/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int xref = 100;
    private int xre = 100;
    private final int delay = 10;
    private Timer timer;
    
  public Board() {
      timer = new Timer(this.delay, this);
      timer.start();
      
  }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.fillOval(xref+10, 90, 10, 10);
        g.fillOval(xref+30, 90, 10, 10);
        g.setColor(Color.blue);
        g.fillRect(xref, 80, 50, 10);
        int x[] ={xref+10,xref+40,xref+30,xref+20};
        int y[] ={80,80,70,70};
        g.fillPolygon(x, y, 4);
        
        g.fillOval(xre+1510, 90, 10, 10);
        g.fillOval(xre+1530, 90, 10, 10);
        g.setColor(Color.red);
        g.fillRect(xre+1500, 80, 50, 10);
        int a[] ={xre+1510,xre+1540,xre+1530,xre+1520};
        int b[] ={80,80,70,70};
        g.fillPolygon(a, b, 4);
       
        
 }

    @Override
    public void actionPerformed(ActionEvent e) {
       this.xref+=1;
       this.xre-=1;
       repaint();
    }
}