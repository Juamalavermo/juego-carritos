/*
PLANTILLA BASE PARA CREACION DE ESCENARIOS.
 */
package Ejercicio0;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private int xref = 100;
    private int xre = 1024;
    private int xGato;
    private int numImage;
    private final int delay = 10;
    private Timer timer;
    
  public Board() {
      timer = new Timer(this.delay, this);
      timer.start();
      this.xGato = 0;
      this.numImage = 0;
  }
  
  public Image loadImage(String imageName){
      ImageIcon ii = new ImageIcon(imageName);
      Image image = ii.getImage();
      return image;
  }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Image fondo =loadImage("fondo.png");
        g.drawImage(fondo, 0, 0, null);
      
        
        g.fillOval(xref+10, 440, 10, 10);
        g.fillOval(xref+30, 440, 10, 10);
        g.setColor(Color.blue);
        g.fillRect(xref, 430, 50, 10);
        int x[] ={xref+10,xref+40,xref+30,xref+20};
        int y[] ={430,430,420,420};
        g.fillPolygon(x, y, 4);
        
        //g.drawRect(xref, 70, 50, 30);
        
        g.fillOval(xre+10, 440, 10, 10);
        g.fillOval(xre+30, 440, 10, 10);
        g.setColor(Color.red);
        g.fillRect(xre, 430, 50, 10);
        int a[] ={xre+10,xre+40,xre+30,xre+20};
        int b[] ={430,430,420,420};
        g.fillPolygon(a, b, 4);
       
        //g.drawRect(xre, 70, 50, 30);
        
        Rectangle carro1 = new Rectangle(this.xref, 420, 50, 30);
        Rectangle carro2 = new Rectangle(this.xre, 420, 50, 30);
        
          Image gato = loadImage("cats.gif");
        g.drawImage(gato, (this.xGato), (360), (this.xGato+132), (360+80), (this.numImage*132), 0, (this.numImage*132+132), 80, this);
       
        
        if (carro1.intersects(carro2)) {
            //this.timer.stop();
            g.drawString("GAME OVER", 780, 120);
        }
        
 }

    @Override
    public void actionPerformed(ActionEvent e) {
       this.xref+=1;
       this.xGato+=5;
       this.xre-=1;
       this.numImage+=1;
      if (this.numImage == 5){
          this.numImage = 0;
      } else{
          this.numImage++;
      }
          
       repaint();
    }
}