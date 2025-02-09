package View;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JLabel;

public class JButton extends JLabel {

     private Shape shape;
     private int radius;

     public JButton(String text, int radius, int textSize){
        super(text);
        this.radius = radius;
        setFont(new Font("Segoe UI",Font.BOLD , textSize));
        setOpaque(false);
        setForeground(GUIconstants.white);
        setHorizontalAlignment(CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
     }

    //for rounded corners
    protected void paintComponent(Graphics g){
        g.setColor(GUIconstants.blue);
        g.fillRoundRect(0, 0, getWidth()-1,getHeight()-1, radius, radius);
        super.paintComponent(g);
    }

    //for rounded border
    protected void paintBorder(Graphics g ){
        g.setColor(GUIconstants.blue);
        g.drawRoundRect(0, 0, getWidth()-1,getHeight()-1, radius, radius);
    }

    public boolean contains(int x, int y){
        if(shape == null || shape.getBounds().equals(getBounds())){
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1,getHeight()-1, 45, 45);

        }
        return shape.contains(x,y);
    }


}
