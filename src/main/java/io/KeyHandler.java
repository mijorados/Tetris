package io;

import data.Collision;
import game.Game;
import game.GameState;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Rados
 */
public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Game.gameState == GameState.start) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Game.gameState = GameState.ingame;
            }
        }

        if (Game.gameState == GameState.ingame) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    if (!Collision.colliedInRotation(Game.currentBlock)) {
                        
                        Game.currentBlock.rotate();
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                

            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game.speedup = true;

            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                try {
                    if (!Collision.colliedeWithWall(Game.currentBlock, 1)&&
                            !Collision.collideWithBlock(Game.currentBlock, 1)) {
                        
                        Game.currentBlock.setX(Game.currentBlock.getX() + 1);
                    }
                } catch (Exception e1) {
                }

            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                try {
                    if (!Collision.colliedeWithWall(Game.currentBlock, -1)&&
                            !Collision.collideWithBlock(Game.currentBlock, -1)) {
                        
                        Game.currentBlock.setX(Game.currentBlock.getX() - 1);
                    }
                } catch (Exception e1) {
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Game.gameState = GameState.pause;

            }
        } else if (Game.gameState == GameState.pause) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Game.gameState = GameState.ingame;
            }
        } else if (Game.gameState == GameState.gameover) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Game.gameState = GameState.ingame;
                Game.clear();
            }

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(Game.gameState == GameState.ingame){
        
            if(e.getKeyCode()== KeyEvent.VK_DOWN){
                Game.speedup = false;
            }
        }

    }

}
