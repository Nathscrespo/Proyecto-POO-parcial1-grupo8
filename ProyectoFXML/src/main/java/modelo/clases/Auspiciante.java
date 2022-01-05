
package modelo.clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import modelo.admins.AdminAuspiciantes;

public class Auspiciante extends Persona implements Serializable{

    private String webpage;
    private String codAuspiciante;
    private static final long serialVersionUID = 3333;
    
    
    // constructores
    
    public Auspiciante(){
        super();
    }

    public Auspiciante(String n){
        super(n);
    }
    

    public Auspiciante(String n,String d,String t, String c,String e,String w){
        super(n,d,t,c,e);
        webpage=w;
        
    }
    
    // getters y setters

    public String getWebpage() {
        return webpage;
    }

    public String getCodAuspiciante() {
        return codAuspiciante;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setCodAuspiciante(String codAuspiciante) {
        this.codAuspiciante = codAuspiciante;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
       
    
    // métodos 

    public static Auspiciante busquedaAuspiciante(String nombreAuspiciante){

        Auspiciante auspicianteBusqueda=new Auspiciante(nombreAuspiciante);
        Auspiciante auspicianteEncontrado= new Auspiciante();

        if (AdminAuspiciantes.arrAuspiciantes.contains(auspicianteBusqueda)){
            int indAuspiciante=AdminAuspiciantes.arrAuspiciantes.indexOf(auspicianteBusqueda);
            auspicianteEncontrado= (Auspiciante) AdminAuspiciantes.arrAuspiciantes.get(indAuspiciante);
        }

        return auspicianteEncontrado;
    }
    

    @Override
    public String toString(){
        return "nombre: "+nombre+" código: "+codAuspiciante;
    }
    
    public static void serializarAuspiciante(){
          
        try{
            FileOutputStream fout= new FileOutputStream("archivos/auspiciantes.ser");
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(AdminAuspiciantes.arrAuspiciantes);
            out.flush();
            
        }
        
        catch (IOException e){
            System.out.println(e);
        }

    
    }
    
}
