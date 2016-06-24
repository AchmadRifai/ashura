/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 *
 * @author ai
 */
public class RSA {
    private File pri,pub;

    public RSA(File pri, File pub) throws GeneralSecurityException, IOException {
        this.pri = pri;
        this.pub = pub;
        if(!pri.exists()&&!pub.exists())createInit();
    }

    public byte[]encrypt(String k)throws GeneralSecurityException, IOException, ClassNotFoundException{
        javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("RSA");
        PublicKey p=loadPub();
        c.init(javax.crypto.Cipher.ENCRYPT_MODE, p);
        return c.doFinal(k.getBytes());
    }

    public String decrypt(byte[]b)throws GeneralSecurityException, IOException, ClassNotFoundException{
        javax.crypto.Cipher c=javax.crypto.Cipher.getInstance("RSA");
        PrivateKey p=loadPri();
        c.init(javax.crypto.Cipher.DECRYPT_MODE, p);
        return new String(c.doFinal(b));
    }

    private void createInit() throws GeneralSecurityException, IOException{
        java.security.KeyPairGenerator kpg=java.security.KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2101);
        java.security.KeyPair kp=kpg.genKeyPair();
        savePri(kp.getPrivate());
        savePub(kp.getPublic());
    }

    private void savePri(PrivateKey k) throws IOException {
        if(!pri.getParentFile().exists())pri.getParentFile().mkdirs();
        java.io.ObjectOutputStream o=new java.io.ObjectOutputStream(new java.io.FileOutputStream(pri));
        o.writeObject(k);
        o.close();
    }

    private void savePub(PublicKey k) throws IOException {
        if(!pub.getParentFile().exists())pub.getParentFile().mkdirs();
        java.io.ObjectOutputStream o=new java.io.ObjectOutputStream(new java.io.FileOutputStream(pub));
        o.writeObject(k);
        o.close();
    }

    private PublicKey loadPub() throws IOException, ClassNotFoundException {
        java.io.ObjectInputStream i=new java.io.ObjectInputStream(new java.io.FileInputStream(pub));
        PublicKey p=(PublicKey) i.readObject();
        i.close();
        return p;
    }

    private PrivateKey loadPri() throws IOException, ClassNotFoundException {
        java.io.ObjectInputStream i=new java.io.ObjectInputStream(new java.io.FileInputStream(pri));
        PrivateKey p=(PrivateKey) i.readObject();
        i.close();
        return p;
    }
}