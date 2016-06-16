/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;

/**
 *
 * @author ai
 */
public class RSA {
    private File pri,pub;

    public RSA(File pri, File pub) {
        this.pri = pri;
        this.pub = pub;
        
    }
}