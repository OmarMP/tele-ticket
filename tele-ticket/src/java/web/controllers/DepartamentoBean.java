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
import acceso.DepartamentoFacadeLocal;
import entity.Departamento;

/**
 *
 * @author Aleexis Flores
 */
@Named(value = "frmDepartamento")
@ViewScoped
public class DepartamentoBean extends BackingBean<Departamento> implements Serializable {

    @EJB
    DepartamentoFacadeLocal deptofacade_;
    Departamento depto_;
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
        depto_ = new Departamento();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Departamento getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Departamento item : (List<Departamento>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdDepartamento().compareTo(registro) == 0) {
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
    protected Object getKey(Departamento entity) {
        return entity.getIdDepartamento();
    }

    @Override
    protected MetodosGenericos<Departamento> getFacadeLocal() {
        return (MetodosGenericos<Departamento>) deptofacade_;
        //return deptofacade_ Original
    }

    @Override
    protected Departamento getEntity() {
        return depto_;
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
        depto_ = (Departamento) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        depto_ = new Departamento();
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

    public Departamento getDepartamento_() {
        return depto_;
    }

    public void setCategoria_(Departamento depto_) {
        this.depto_ = depto_;
    }

    public List<Departamento> getLista() {
        return lista;
    }

    public void setLista(List<Departamento> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Departamento> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Departamento> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    


}
