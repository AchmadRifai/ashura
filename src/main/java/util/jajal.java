/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.ZoneId;

/**
 *
 * @author ai
 */
public class jajal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(String s:ZoneId.getAvailableZoneIds())System.out.println(s);
    }
    
}
