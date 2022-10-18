
package game;

import java.util.ArrayList;

/**
 *
 * @author Rados
 */
public class Game {
    
    public static int score= 0, highscore = 0, scoreToAdd = 0;
    public static boolean spawnNewBlock = false, speedup = false;
    
    public static ArrayList<Block> blocks = new ArrayList<Block>();
    public static Block currentBlock, nextBlock;
    
    public static int [][] map = new int [10][18];
    
    public static GameState gameState = GameState.start;
    
    public static void clear(){
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] =0;
            }
        }
        score = 0;
    }
    
}
