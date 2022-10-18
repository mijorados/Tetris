package infrastructure;

import data.Collision;
import game.Block;
import game.Game;
import game.GameState;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class GameLoop extends Thread {

    private boolean running = true;

    @Override
    public void run() {
        while (running) {
            try{
                if (Game.gameState == GameState.ingame) {
                    if(!Collision.colliedeWithWall(Game.currentBlock, 0) && !Collision.collideWithBlock(Game.currentBlock, 0) ){
                        Game.currentBlock.setY(Game.currentBlock.getY()+1);
                        Collision.colliedeWithWall(Game.currentBlock, 0);
                    }
                    
                    
                    if (Game.spawnNewBlock) {
                        Collision.checkFullRow(1);
                        Game.blocks.add(Game.nextBlock);
                        Game.currentBlock = Game.nextBlock;
                        Game.nextBlock = new Block();
                        Game.spawnNewBlock = false;
                    }
                }

                if (!Game.speedup) {
                    sleep(1000);
                
            }else {
                sleep(100);
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }}
    }

}
