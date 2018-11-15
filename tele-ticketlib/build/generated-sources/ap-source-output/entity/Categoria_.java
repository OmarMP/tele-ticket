package entity;

import entity.Incidencia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-15T16:02:10")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile ListAttribute<Categoria, Incidencia> incidenciaList;
    public static volatile SingularAttribute<Categoria, String> descricion;
    public static volatile SingularAttribute<Categoria, String> categoria;
    public static volatile SingularAttribute<Categoria, Date> fechacreo;
    public static volatile SingularAttribute<Categoria, String> usuariomodifico;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile SingularAttribute<Categoria, Date> fechamodifico;
    public static volatile SingularAttribute<Categoria, String> usuariocreo;
    public static volatile SingularAttribute<Categoria, Boolean> status;

}