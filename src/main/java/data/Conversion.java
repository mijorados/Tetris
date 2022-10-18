/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Rados
 */
public class Conversion {
    
    public static int cellToCoord(int cell){
        return cell *32;
    }
    public static int coordToCell(int cord){
        return cord /32;
    }
    
}
