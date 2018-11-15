/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;



import acceso.IncidenciaFacadeLocal;
import entity.Incidencia;
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
@Named(value = "frmIncidencia")
@ViewScoped
public class IncidenciaBean extends BackingBean<Incidencia> implements Serializable {

    @EJB
    IncidenciaFacadeLocal incidenciafacade_;
    Incidencia incidencia_;
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
        incidencia_ = new Incidencia();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Incidencia getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Incidencia item : (List<Incidencia>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdIncidencia().compareTo(registro) == 0) {
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
    protected Object getKey(Incidencia entity) {
        return entity.getIdIncidencia();
    }

    @Override
    protected MetodosGenericos<Incidencia> getFacadeLocal() {
        return (MetodosGenericos<Incidencia>) incidenciafacade_;
        //return estadofacade_ Original
    }

    @Override
    protected Incidencia getEntity() {
        return incidencia_;
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
        incidencia_ = (Incidencia) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        incidencia_ = new Incidencia();
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

    public Incidencia getIncidencia_() {
        return incidencia_;
    }

    public void setIncidencia_(Incidencia incidencia_) {
        this.incidencia_ = incidencia_;
    }

    public List<Incidencia> getLista() {
        return lista;
    }

    public void setLista(List<Incidencia> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Incidencia> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Incidencia> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    

    

    


}
