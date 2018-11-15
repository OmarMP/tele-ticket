package entity;

import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T16:02:10")
@StaticMetamodel(Prioridad.class)
public class Prioridad_ { 

    public static volatile SingularAttribute<Prioridad, String> descripcion;
    public static volatile ListAttribute<Prioridad, Ticket> ticketList;
    public static volatile SingularAttribute<Prioridad, Date> fechacreo;
    public static volatile SingularAttribute<Prioridad, String> usuariomodifico;
    public static volatile SingularAttribute<Prioridad, Integer> idPrioridad;
    public static volatile SingularAttribute<Prioridad, Date> fechamodifico;
    public static volatile SingularAttribute<Prioridad, String> usuariocreo;
    public static volatile SingularAttribute<Prioridad, String> prioridad;
    public static volatile SingularAttribute<Prioridad, Boolean> status;

}