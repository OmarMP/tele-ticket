/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;



import acceso.RolFacadeLocal;
import entity.Rol;
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
@Named(value = "frmRol")
@ViewScoped
public class RolBean extends BackingBean<Rol> implements Serializable {

    @EJB
    RolFacadeLocal rolfacade_;
    Rol rol_;
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
        rol_ = new Rol();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Rol getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Rol item : (List<Rol>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    if (item.getIdRol().compareTo(registro) == 0) {
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
    protected Object getKey(Rol entity) {
        return entity.getIdRol();
    }

    @Override
    protected MetodosGenericos<Rol> getFacadeLocal() {
        return (MetodosGenericos<Rol>) rolfacade_;
        //return estadofacade_ Original
    }

    @Override
    protected Rol getEntity() {
        return rol_;
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
        rol_ = (Rol) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        rol_ = new Rol();
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

    public Rol getRol_() {
        return rol_;
    }

    public void setRol_(Rol rol_) {
        this.rol_ = rol_;
    }

    public List<Rol> getLista() {
        return lista;
    }

    public void setLista(List<Rol> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Rol> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Rol> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    

    

    


}
