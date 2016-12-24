/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.data.dao.fileconnector;

import app.java.exceptions.data.EmptyResultException;
import app.java.exceptions.data.ObjectAlreadyExistsException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Philipp Gagel
 */
public class Writer extends AFileConnector{

    private BufferedWriter writer;
    private Reader reader;
    
    public Writer(String path) {
        super(path);
    }
    
    public Writer(String path, String file) throws IOException {
        super(path, file);
        this.readjustWriter();
    }
    
    public void concat(String data) throws ObjectAlreadyExistsException, IOException{
        int id = super.getIdFromDataString(data);
        if(this.idExists(id)){
            throw new ObjectAlreadyExistsException("");
        }else{
            writer.append(data);
            writer.flush();
        }
    }
    
    public void overwrite(String dataOld, String dataNew) throws ObjectAlreadyExistsException, IOException{
        int idOld = super.getIdFromDataString(dataOld);
        int idNew = super.getIdFromDataString(dataNew);
        if(this.idExists(idOld)){
            if(idOld == idNew){
                try {
                    List<String> lines = this.replaceLine(idOld, dataNew);
                    lines.forEach(line -> {
                        try {
                            this.writer.append(line);
                        } catch (IOException ex) {
                            System.out.println("Error while adding lines to wirter");
                        }
                    });
                } catch (EmptyResultException ignored) {
                    System.out.println(ignored + "\nnot important");
                }
            }else{
                if(idExists(idNew)){
                    throw new ObjectAlreadyExistsException("Old and new id are different and new id alread in use");
                }else{
                    writer.append(dataNew);
                }
            }
        }else{
            writer.append(dataNew);
        }
        
    }
    
    private void readjustWriter() throws IOException{
        String pathToFile = super.getPath().concat(AFileConnector.lineSeparator).concat(super.getFile());
        this.writer = new BufferedWriter(new FileWriter(pathToFile));
    }
    
    private boolean idExists(int id){
        try {
            this.reader.get(id);
        } catch (EmptyResultException ignored) {
            return true;
        }
        return false;
    }
    
    private List<String> replaceLine(int idOld, String lineNew) throws EmptyResultException{
        List<String> lines = reader.getAll();
        lines.stream()
                .filter((line) -> 
                    (super.getIdFromDataString(line) == idOld))
                .forEachOrdered((line) -> 
                {
                    line = lineNew;
                }
        );
        return lines;
    }
}
