/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acceso;

import entity.Ticket;
import java.util.List;
import javax.ejb.Local;
import web.controllers.MetodosGenericos;

/**
 *
 * @author root
 */
@Local
public interface TicketFacadeLocal extends MetodosGenericos<Ticket>{

    
}
