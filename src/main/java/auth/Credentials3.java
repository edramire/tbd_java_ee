package auth;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials3 {
     public Integer idu;
     public Integer idcom;
     public Integer idcat;

     public String descripcion;
     public String precio;
     public String duracion;
     public String titulo;
     public Date fecha;
     
}