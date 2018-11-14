/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;


import acceso.PrioridadFacadeLocal;
import entity.Prioridad;
import java.io.Serializable;
import java.util.ArrayList;
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
@Named(value = "frmPrioridad")
@ViewScoped
public class PrioridadBean extends BackingBean<Prioridad> implements Serializable {

    @EJB
    PrioridadFacadeLocal prioridadfacade_;
    Prioridad prioridad_;
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

    @PostConstruct
    public void init() {
        suffleImages();
        estado = EstadosCRUD.NONE;
        marca_ = new Marca();
        inicializar();
    }
*/
    /*
    metodos sobre-cargados
     */
    @Override
    protected Prioridad getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Prioridad item : (List<Prioridad>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdPrioridad().compareTo(registro) == 0) {
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
    protected Object getKey(Prioridad entity) {
        return entity.getIdPrioridad();
    }

    @Override
    protected MetodosGenericos<Prioridad> getFacadeLocal() {
        return (MetodosGenericos<Prioridad>) prioridadfacade_;
        //return estadofacade_ Original
    }

    @Override
    protected Prioridad getEntity() {
        return prioridad_;
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
        prioridad_ = (Prioridad) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        prioridad_ = new Prioridad();
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

    public Prioridad getPrioridad_() {
        return prioridad_;
    }

    public void setPrioridad_(Prioridad prioridad_) {
        this.prioridad_ = prioridad_;
    }

    public List<Prioridad> getLista() {
        return lista;
    }

    public void setLista(List<Prioridad> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Prioridad> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Prioridad> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    


}
