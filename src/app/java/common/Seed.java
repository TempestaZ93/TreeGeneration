/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.common;

/**
 *
 * @author Philipp Gagel
 */
public class Seed {
    private byte[] seedBinary;
    private int wordSize;

    public Seed(byte[] seedBinary, int wordSize) {
        this.seedBinary = seedBinary;
        this.wordSize = wordSize;
    }

    public Seed(byte[] seedBinary) {
        this(seedBinary, 8);
    }

    public byte[] getSeedBinary() {
        return seedBinary;
    }

    public void setSeedBinary(byte[] seedBinary) {
        this.seedBinary = seedBinary;
    }

    public int getWordSize() {
        return wordSize;
    }

    public void setWordSize(int wordSize) {
        this.wordSize = wordSize;
    }
    
    public String getSeedAsString(){
        return String.valueOf(this.seedBinary);
    }
    
    public int[] getSeedAsWords(){
        int size = this.seedBinary.length/this.wordSize;
        int[] words = new int[size];
        int word = 0;
        
        for(int i = 0; i<size; i++){
            word = 0;
            for(int j = 0; j<this.wordSize; j++){
                word += (j+1) * 8 * this.seedBinary[i * wordSize + j];
            }
            words[i] = word;
        }
        
        return words;
    }
    
    
}
