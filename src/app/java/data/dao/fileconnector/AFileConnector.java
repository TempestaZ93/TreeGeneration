/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.data.dao.fileconnector;

import app.java.exceptions.data.EmptyResultException;
import java.io.FileNotFoundException;

/**
 *
 * @author Philipp Gagel
 */
public abstract class AFileConnector {
    protected final static String lineSeparator = System.getProperty("line.separator");
    
    private String path;
    private String file;
    
    public AFileConnector(String path){
        this.path = path;
    }
    
    public AFileConnector(String path, String file){
        this(path);
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws FileNotFoundException {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) throws FileNotFoundException {
        this.file = file;
    }
    
    protected String getAttributeFromData(String attrName, String data) throws EmptyResultException{
        String[] attrPairs = data.split(";");
        for(String attrPair : attrPairs){
            String[] attrPairArr = attrPair.split("=");
            if(attrPairArr[0].equals(attrName)){
                return attrPairArr[1];
            }
        }
        throw new EmptyResultException("No attribute with name found in data.");
    }
    
    protected int getIdFromDataString(String data){
        String idPair = data.split(";")[0];
        String idString = idPair.split("=")[1];
        Integer id = Integer.valueOf(idString);
        return id;
    }
    
}
