
package infrastructure;

import game.Block;
import game.Game;
import io.DataHandler;
import java.awt.FontFormatException;
import java.io.IOException;
import ui.Gui;

/**
 *
 * @author Rados
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DataHandler.load();
        
        Game.currentBlock = new Block();
        Game.blocks.add(Game.currentBlock);
        Game.nextBlock = new Block();
        
        Gui g = new Gui();
        try {
            g.creat();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        
        startLoop();
    }
    
    public static void startLoop(){
        GameLoop loop = new GameLoop();
        loop.start();
    
    }
    
}
