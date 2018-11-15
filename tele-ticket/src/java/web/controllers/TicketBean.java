/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;





import acceso.TicketFacadeLocal;
import entity.Ticket;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;


/**
 *
 * @author Aleexis Flores
 */
@Named(value = "frmTicket")
@ViewScoped
public class TicketBean extends BackingBean<Ticket> implements Serializable {

    @EJB
    TicketFacadeLocal ticketfacade_;
    Ticket ticket_;
    private EstadosCRUD estado;

    //**** Manejo de imagenes que se desplazan en el inicio
    /*List<String> images;

    public void suffleImages() {
        images = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            images.add("imagen" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
*/
    @PostConstruct
    public void init() {
        //suffleImages();
        estado = EstadosCRUD.NONE;
        ticket_ = new Ticket();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Ticket getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Ticket item : (List<Ticket>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                
                    if (item.getIdTicket().compareTo(registro) == 0) {
                        return item;
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println("Excepcion" + e.getMessage());
            }
        }

        return null;

    }
    @Override
    protected Object getKey(Ticket entity) {
        return entity.getIdUsuario();
    }

    @Override
    protected MetodosGenericos<Ticket> getFacadeLocal() {
        return (MetodosGenericos<Ticket>) ticketfacade_;
        //return ticketfacade_ Original
    }

    @Override
    protected Ticket getEntity() {
        return ticket_;
    }

    @Override
    public void crear() {
        estado = EstadosCRUD.AGREGAR;
        super.crear();
        btncancelarHandler();
    }

    @Override
    public void modificar() {
        estado = EstadosCRUD.EDITAR;
        super.modificar();
        btncancelarHandler();
    }

    @Override
    public void eliminar() {
        estado = EstadosCRUD.ELIMINAR;
        super.eliminar();
        btncancelarHandler();

    }

    /**
     *
     * @param event para el seleccionamiento de los campos en la tabla
     */
    public void onRowSelect(SelectEvent event) {
        btncancelarHandler();
        estado = EstadosCRUD.EDITAR;
        ticket_ = (Ticket) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        ticket_ = new Ticket();
    }

    public void btnNuevoHandler() {
        estado = EstadosCRUD.NUEVO;
    }

    /*
    getters y setters
     */
    public EstadosCRUD getEstado() {
        return estado;
    }

    public Ticket getTicket_() {
        return ticket_;
    }

    public void setUsuario_(Ticket ticket_) {
        this.ticket_ = ticket_;
    }

    public List<Ticket> getLista() {
        return lista;
    }

    public void setLista(List<Ticket> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Ticket> getLazyModel() {
        return lazyModel;
    }
    

    public void setLazyModel(LazyDataModel<Ticket> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    

    

    


}
