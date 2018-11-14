/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import java.util.List;

/**
 *
 * 
 */
public interface MetodosGenericos<T> {
   
    
    void create( T entity);

    void edit(T entity);

    void remove(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int inicio,int pagesize);

    int count();
    
    
}
