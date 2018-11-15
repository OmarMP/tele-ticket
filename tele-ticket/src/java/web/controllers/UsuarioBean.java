/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;



import acceso.RolFacadeLocal;
import acceso.UsuarioFacadeLocal;
import entity.Rol;
import entity.Usuario;
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
@Named(value = "frmUsuario")
@ViewScoped
public class UsuarioBean extends BackingBean<Usuario> implements Serializable {

    @EJB
    UsuarioFacadeLocal usuariofacade_;
    Usuario usuario_;
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
        usuario_ = new Usuario();
        inicializar();
    }

    /*
    metodos sobre-cargados
     */
    @Override
    protected Usuario getrowD(String rowkey) {

        if (rowkey != null && !rowkey.isEmpty() && this.getLazyModel().getWrappedData() != null) {
            try {

                for (Usuario item : (List<Usuario>) this.getLazyModel().getWrappedData()) {
                    Integer registro = new Integer(rowkey);
                    // debido a que el id de usuario esta definido en la base de datos como una cadena de texto,
                    //este metodo muy probablemente no funcione
                    if (item.getIdUsuario().compareTo(registro+"") == 0) {
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
    protected Object getKey(Usuario entity) {
        return entity.getIdUsuario();
    }

    @Override
    protected MetodosGenericos<Usuario> getFacadeLocal() {
        return (MetodosGenericos<Usuario>) usuariofacade_;
        //return estadofacade_ Original
    }

    @Override
    protected Usuario getEntity() {
        return usuario_;
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
        usuario_ = (Usuario) event.getObject();
    }

    public void btncancelarHandler() {
        estado = EstadosCRUD.NONE;
        usuario_ = new Usuario();
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

    public Usuario getUsuario_() {
        return usuario_;
    }

    public void setUsuario_(Usuario usuario_) {
        this.usuario_ = usuario_;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public LazyDataModel<Usuario> getLazyModel() {
        return lazyModel;
    }
    

    public void setLazyModel(LazyDataModel<Usuario> lazyModel) {
        this.lazyModel = lazyModel;
    }

    

    

    

    


}
