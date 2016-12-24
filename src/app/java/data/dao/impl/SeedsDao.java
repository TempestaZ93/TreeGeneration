/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.java.data.dao.impl;

import app.java.common.Seed;
import app.java.data.dao.intfc.IGenericDao;
import app.java.data.dao.intfc.ISeedDao;
import app.java.exceptions.data.EmptyResultException;
import java.util.Collection;

/**
 *
 * @author Philipp Gagel
 */
public class SeedsDao implements ISeedDao{

    @Override
    public boolean create(Seed t) {
        return false;
    }

    @Override
    public int update(Seed seedOld, Seed seedNew) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Seed t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Seed getSingle(Seed t) throws EmptyResultException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Seed> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
