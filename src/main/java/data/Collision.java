package data;

import game.Block;
import game.Game;
import game.GameState;
import io.DataHandler;

/**
 *
 * @author Rados
 */
public class Collision {

    public static boolean collideWithBlock(Block b, int direction) {

        switch (direction) {
            case -1:
                if (b.getY() > 0) {
                    if (b.getX() > 0) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (Game.map[b.getX() + i - 1][b.getY() + j] >= 1) {
                                        return true;

                                    }
                                }

                            }

                        }
                    }
                }
                break;

            case 0:
                if (b.getY() + b.getSize() > 1) {
                    if (b.getY() - b.getSize() < 17) {
                        try {
                            for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                                for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                    if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                        if (Game.map[b.getX() + i][b.getY() + j + 1] >= 1) {
                                            Game.spawnNewBlock = true;
                                            fillBlock(b);
                                            return true;

                                        }
                                    }

                                }

                            }
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    }
                }
                break;

            case 1:
                if (b.getY() > 0) {
                    if (b.getX() < 10) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
                                        return true;

                                    }
                                }

                            }

                        }
                    }
                }

        }

        return false;
    }

    public static boolean colliedInRotation(Block b) {
        int rotation = b.getRotation() + 1;
        if (rotation == 4) {
            rotation = 0;
        }

        Block block = new Block();
        block.setRotation(rotation);
        block.setBounds(b.getBounds());
        block.setSize(b.getSize());
        block.setX(b.getX() - 1);
        block.setY(b.getY());

        if (colliedeWithWall(block, 1)) {
            return true;
        }
        block.setX(b.getX() + 2);
        if (colliedeWithWall(block, -1)) {
            return true;
        }
        if (b.getY() > 0) {
            try {
                for (int i = 0; i < b.getBounds()[rotation].length; i++) {
                    for (int j = 0; j < b.getBounds()[rotation][i].length; j++) {
                        if (b.getBounds()[rotation][i][j] == 1) {
                            if (Game.map[b.getX() + i + 1][b.getY() + j] >= 1) {
                                return true;

                            }
                        }

                    }

                }
            } catch (Exception e) {

                return true;
            }
        }

        return false;
    }

    public static boolean colliedeWithWall(Block b, int direction) {

        switch (direction) {
            case -1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + i == 0) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 0:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getY() + j == 17) {
                                Game.spawnNewBlock = true;
                                fillBlock(b);
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + i + 2 >= 11) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }

        return false;
    }

    private static void fillBlock(Block b) {
        try {
            for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                    if (b.getBounds()[b.getRotation()][i][j] == 1) {

                        Game.map[b.getX() + i][b.getY() + j] = b.getTypeValue();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        checkLoose();

    }

    public static void checkFullRow(int multiplier) {
        int blocksInRow = 0;

        for (int y = Game.map[0].length - 1; y > 0; y--) {
            for (int x = 0; x < Game.map.length; x++) {
                if (Game.map[x][y] > 0) {
                    blocksInRow++;
                }
            }
            if (blocksInRow == 10) {
                Game.scoreToAdd += (10 * multiplier);
                delRow(y, multiplier);
                break;
            } else {
                blocksInRow = 0;
            }
        }
        Game.score+= Game.scoreToAdd;
        Game.scoreToAdd=0;
        
        if(Game.score>Game.highscore){
            Game.highscore = Game.score;
            DataHandler.save();
        }
    }

    private static void delRow(int row, int multiplier) {
        for (int i = 0; i < Game.map.length; i++) {
            Game.map[i][row]=0;
        }
        
        for (int y = row; y > 1; y--) {
            for (int x = 0; x < Game.map.length; x++) {
                Game.map[x][y]=Game.map[x][y-1];
            }
        }
        
        checkFullRow(multiplier+1);

    }

    private static void checkLoose() {
        for (int i = 0; i < Game.map.length; i++) {
            if (Game.map[i][0] > 0) {
                Game.gameState = GameState.gameover;
            }

        }

    }

}
