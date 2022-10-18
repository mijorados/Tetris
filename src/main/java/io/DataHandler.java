package io;

import game.Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rados
 */
public class DataHandler {

    public static void load() {
        File file = new File("rsc/data/save.txt");

        try {
            Scanner scanner = new Scanner(file);
            Game.highscore = scanner.nextInt();
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void save() {
        File file = new File("rsc/data/save.txt");

        try {
            OutputStream stream = new FileOutputStream(file);
            try {
                stream.write(Integer.toString(Game.highscore).getBytes());
                stream.close();

            } catch (IOException ex) {
                Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
