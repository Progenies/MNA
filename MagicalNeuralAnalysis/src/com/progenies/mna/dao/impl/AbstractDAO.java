package com.progenies.mna.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDAO
{
	
	
	 protected EntityManager em = null;
	 
	 
	 /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}
