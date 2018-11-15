/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import acceso.EstadoFacadeLocal;
import entity.Categoria;
import entity.Estado;
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
@Named(value = "frmEstado")
@ViewScoped
public class EstadoBean extends BackingBean<Estado> implements Serializable {

    @EJB
    EstadoFacadeLocal estadofacade_;
    Estado estado_;
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
      // suffleImages();
        estado = EstadosCRUD.NONE;
        estado_ = new Estado();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Estado getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Estado item : (List<Estado>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdEstado().compareTo(registro) == 0) {
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
    protected Object getKey(Estado entity) {
        return entity.getIdEstado();
    }

    @Override
    protected MetodosGenericos<Estado> getFacadeLocal() {
        return (MetodosGenericos<Estado>) estadofacade_;
        //return estadofacade_ Original
    }

    @Override
    protected Estado getEntity() {
        return estado_;
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
        estado_ = (Estado) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        estado_ = new Estado();
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

    public Estado getEstado_() {
        return estado_;
    }

    public void setEstado_(Estado estado_) {
        this.estado_ = estado_;
    }

    public List<Estado> getLista() {
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Estado> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Estado> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    


}
