/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import entity.Categoria;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import acceso.CategoriaFacadeLocal;

/**
 *
 * @author Aleexis Flores
 */
@Named(value = "frmCategoria")
@ViewScoped
public class CategoriaBean extends BackingBean<Categoria> implements Serializable {

    @EJB
    CategoriaFacadeLocal categoriafacade_;
    Categoria categoria_;
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
    protected Categoria getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Categoria item : (List<Categoria>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdCategoria().compareTo(registro) == 0) {
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
    protected Object getKey(Categoria entity) {
        return entity.getIdCategoria();
    }

    @Override
    protected MetodosGenericos<Categoria> getFacadeLocal() {
        return (MetodosGenericos<Categoria>) categoriafacade_;
        //return categoriafacade_ Original
    }

    @Override
    protected Categoria getEntity() {
        return categoria_;
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
        categoria_ = (Categoria) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        categoria_ = new Categoria();
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

    public Categoria getCategoria_() {
        return categoria_;
    }

    public void setCategoria_(Categoria categoria_) {
        this.categoria_ = categoria_;
    }

    public List<Categoria> getLista() {
        return lista;
    }

    public void setLista(List<Categoria> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Categoria> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Categoria> lazyModel) {
        this.lazyModel = lazyModel;
    }

    


}
