/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import entity.Departamento;
import javax.ejb.Local;
import web.controllers.MetodosGenericos;

/**
 *
 * @author root
 */
@Local
public interface DepartamentoFacadeLocal extends MetodosGenericos<Departamento> {

    
}
