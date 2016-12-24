/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.data.dao.fileconnector;

/**
 *
 * @author Philipp Gagel
 */
public abstract class AFileConnector {
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

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
}
