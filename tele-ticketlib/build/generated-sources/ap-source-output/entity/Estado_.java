package entity;

import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-13T23:28:06")
@StaticMetamodel(Estado.class)
public class Estado_ { 

    public static volatile SingularAttribute<Estado, String> descripcion;
    public static volatile SingularAttribute<Estado, Integer> idEstado;
    public static volatile SingularAttribute<Estado, String> estado;
    public static volatile ListAttribute<Estado, Ticket> ticketList;
    public static volatile SingularAttribute<Estado, Date> fechacreo;
    public static volatile SingularAttribute<Estado, String> usuariomodifico;
    public static volatile SingularAttribute<Estado, Date> fechamodifico;
    public static volatile SingularAttribute<Estado, String> usuariocreo;
    public static volatile SingularAttribute<Estado, Boolean> status;

}