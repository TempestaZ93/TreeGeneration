/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.app.data.dao.intfc;

import java.app.exceptions.data.EmptyResultException;
import java.util.Collection;

/**
 *
 * @author Philipp
 */
public interface IGenericDao<T> {
    /**
     * This method writes the given object to the 
     * data storage if it is not yet present.
     * 
     * @param t The object that will be added.
     * @return If the creation was successful (<code>true</code>) or not (<code>false</code>).
     */
    boolean create(T t);
    
    /**
     * This method updates the first object, if present, 
     * with the data from the second object.
     * 
     * @param tOld Object that will be updated.
     * @param tNew Object that contains the new data
     * @return if the update was successful (<code>true</code>) or not (<code>false</code>).
     */
    int update(T tOld, T tNew);
    
    /**
     * This method delets the given object from 
     * the data storage if it is present.
     * 
     * @param t the object that will be deleted
     * @return if the deletion was successful (<code>true</code>) or not (<code>false</code>).
     */
    boolean delete(T t);
    
    /**
     * This method returns a single object specified 
     * by the data possessed by the given object.
     * 
     * @param t This object holds all necessary data to specify a single object.
     * @return The found object if there was one.
     * @throws java.app.exceptions.data.EmptyResultException if there was no 
     * Object with the given data
     */
    T getSingle(T t) throws EmptyResultException;
    
    /**
     * This method returns all data sets if there ware any.
     * 
     * @return A complete collection of all data sets.
     */
    Collection<T> getAll();
}
