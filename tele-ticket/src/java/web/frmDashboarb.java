/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;



import acceso.TicketFacadeLocal;
import entity.Ticket;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author root
 */
@Named(value = "frmDashboarb")
@ViewScoped
public class frmDashboarb implements Serializable {

    /**
     * Creates a new instance of frmDashboarb
     */
    @EJB
    private TicketFacadeLocal ter;
    private LazyDataModel<Ticket> modelo;
    private Ticket registro;
    private boolean btnadd = true;
    private boolean botones = false;
    private boolean seleccions =false;
    
    
    @PostConstruct
    private void inicio() {
        System.out.println(ter);
        registro = new Ticket();

        try {
            this.modelo = new LazyDataModel<Ticket>() {
               
                @Override
                public Object getRowKey(Ticket object) {
                    if (object != null) {
                        return object.getIdTicket();
                    }
                    return null;
                }

                @Override
                public Ticket getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Ticket reg : (List<Ticket>) getWrappedData()) {
                                if (reg.getIdTicket().compareTo(buscado) == 0) {
                                    return reg;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }

                @Override
                public List<Ticket> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Ticket> salida = new ArrayList();
                    try {
                        if (ter != null) {
                            this.setRowCount(ter.count());
                            salida = ter.findRange(first, pageSize);
                            
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }

            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
                 
    }

     
    public TicketFacadeLocal getTer() {
        return ter;
    }

    public void setTer(TicketFacadeLocal ter) {
        this.ter = ter;
    }

    public LazyDataModel<Ticket> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<Ticket> modelo) {
        this.modelo = modelo;
    }

    public Ticket getRegistro() {
        return registro;
    }

    public void setRegistro(Ticket registro) {
        this.registro = registro;
    }

    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public boolean isSeleccions() {
        return seleccions;
    }

    public void setSeleccions(boolean seleccions) {
        this.seleccions = seleccions;
    }


}
