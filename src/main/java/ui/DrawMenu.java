
package ui;

import game.Game;
import game.GameState;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author Rados
 */
public class DrawMenu extends JLabel{
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(Game.gameState == GameState.start){
            g.setColor(new Color(35,144,35));
            g.fillRect(0, Gui.height/2-50, Gui.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pixelfont.deriveFont(14f));
            g.drawString("PRESS ENTER TO START", Gui.width/2, Gui.height/2+10);
        } else if(Game.gameState == GameState.pause){
            g.setColor(new Color(77,195,255));
            g.fillRect(0, Gui.height/2-50, Gui.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pixelfont.deriveFont(14f));
            g.drawString("PRESS ESC TO CONTINUE", Gui.width/2, Gui.height/2+10);
        } else if(Game.gameState == GameState.gameover){
            g.setColor(new Color(175,0,0));
            g.fillRect(0, Gui.height/2-50, Gui.width+200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pixelfont.deriveFont(10f));
            g.drawString("GAMEOVER!!! PRESS ENTER TO START AGAIN", Gui.width/2, Gui.height/2+10);
        }
        
        repaint();
    }
    
}
