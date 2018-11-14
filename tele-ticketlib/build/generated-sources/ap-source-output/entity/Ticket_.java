package entity;

import entity.Estado;
import entity.Incidencia;
import entity.Prioridad;
import entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-13T23:28:06")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Integer> idTicket;
    public static volatile SingularAttribute<Ticket, Incidencia> idIncidencia;
    public static volatile SingularAttribute<Ticket, Estado> idEstado;
    public static volatile SingularAttribute<Ticket, Date> fechaInicio;
    public static volatile SingularAttribute<Ticket, Usuario> idUsuario;
    public static volatile SingularAttribute<Ticket, Date> fechaFinal;
    public static volatile SingularAttribute<Ticket, String> usuariomodifico;
    public static volatile SingularAttribute<Ticket, Prioridad> idPrioridad;
    public static volatile SingularAttribute<Ticket, String> comentario;
    public static volatile SingularAttribute<Ticket, Date> fechamodifico;
    public static volatile SingularAttribute<Ticket, Boolean> status;

}