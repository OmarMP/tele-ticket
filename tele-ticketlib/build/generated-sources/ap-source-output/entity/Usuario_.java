package entity;

import entity.Departamento;
import entity.Incidencia;
import entity.Rol;
import entity.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-13T23:28:06")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Incidencia> incidenciaList;
    public static volatile SingularAttribute<Usuario, Departamento> idDepartamento;
    public static volatile ListAttribute<Usuario, Ticket> ticketList;
    public static volatile SingularAttribute<Usuario, Rol> idRol;
    public static volatile SingularAttribute<Usuario, String> idUsuario;
    public static volatile SingularAttribute<Usuario, Date> fechacreo;
    public static volatile SingularAttribute<Usuario, String> usuariomodifico;
    public static volatile SingularAttribute<Usuario, Date> fechamodifico;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> usuariocreo;
    public static volatile SingularAttribute<Usuario, Boolean> status;

}