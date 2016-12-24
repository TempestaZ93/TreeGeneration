/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.data.dao.fileconnector;

import app.java.exceptions.data.EmptyResultException;
import app.java.exceptions.data.NoSuchAttributeNameException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Philipp Gagel
 */
public class Reader extends AFileConnector{
    
    private BufferedReader reader;
    
    public Reader(String path) {
        super(path);
    }

    public Reader(String path, String file) throws FileNotFoundException {
        super(path, file);        
        this.readjustReader();
    }

    @Override
    public void setFile(String file) throws FileNotFoundException {
        super.setFile(file); //To change body of generated methods, choose Tools | Templates.
        this.readjustReader();
    }

    @Override
    public void setPath(String path) throws FileNotFoundException {
        super.setPath(path); //To change body of generated methods, choose Tools | Templates.
        this.readjustReader();
    }
    
    public List<String> getAll(String attributeName, String attributeValue) throws NoSuchAttributeNameException{
        List<String> lines = reader.lines().collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        for(String line : lines){
            try {
                String value = super.getAttributeFromData(attributeName, line);
                if(value.equals(attributeValue)){
                    result.add(line);
                }
            } catch (EmptyResultException ignored) {
                throw new NoSuchAttributeNameException();
            }
        }
        return result;
    }
    
    public String get(int id) throws EmptyResultException{
        List<String> lines;
        lines = reader.lines().collect(Collectors.toList());
        for(String line : lines){
            if(super.getIdFromDataString(line) == id){
                return line;
            }
        }
        throw new EmptyResultException("No such element with the given id.");
    }
    
    public List<String> getAll() throws EmptyResultException{
        return reader.lines().collect(Collectors.toList());
    }
    
    private void readjustReader() throws FileNotFoundException{
        String pathToFile = super.getPath().concat(AFileConnector.lineSeparator).concat(super.getFile());
        this.reader = new BufferedReader(new FileReader(pathToFile));        
    }
}
