package entity;

import entity.Categoria;
import entity.Ticket;
import entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T16:02:10")
@StaticMetamodel(Incidencia.class)
public class Incidencia_ { 

    public static volatile SingularAttribute<Incidencia, String> descripcion;
    public static volatile SingularAttribute<Incidencia, Integer> idIncidencia;
    public static volatile ListAttribute<Incidencia, Ticket> ticketList;
    public static volatile SingularAttribute<Incidencia, Date> fechacreo;
    public static volatile SingularAttribute<Incidencia, Usuario> idUsuario;
    public static volatile SingularAttribute<Incidencia, String> titulo;
    public static volatile SingularAttribute<Incidencia, String> usuariomodifico;
    public static volatile SingularAttribute<Incidencia, Date> fechamodifico;
    public static volatile SingularAttribute<Incidencia, Categoria> idCategoria;
    public static volatile SingularAttribute<Incidencia, Boolean> status;

}