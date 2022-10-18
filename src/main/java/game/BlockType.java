/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Rados
 */
public enum BlockType {
    I,O,T,L,J,Z,S;
    
    public static BlockType random(){
        return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
    }
    
}
