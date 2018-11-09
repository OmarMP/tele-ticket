package entity;

import entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-09T09:00:21")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> descripcion;
    public static volatile SingularAttribute<Departamento, Integer> idDepartamento;
    public static volatile ListAttribute<Departamento, Usuario> usuarioList;
    public static volatile SingularAttribute<Departamento, Date> fechacreo;
    public static volatile SingularAttribute<Departamento, String> departamento;
    public static volatile SingularAttribute<Departamento, String> usuariomodifico;
    public static volatile SingularAttribute<Departamento, Date> fechamodifico;
    public static volatile SingularAttribute<Departamento, String> usuariocreo;
    public static volatile SingularAttribute<Departamento, Boolean> status;

}