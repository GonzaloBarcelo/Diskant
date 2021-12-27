// Descripcion de la calse sutomer
package main.java.isw21.domain;

import java.io.Serializable;

public class Customer implements Serializable{
    /**
     *
     */
    // Por ahora solo se almacenará la contrseña y el nombre de usuario. En el rpoximo Sprint se añadiran más
    // como por ejemplo mail, numero de telefono y grupos a los que pertenece.

    private static final long serialVersionUID = 1L;
    private String usuario;
    private String contraseña;
    private String email;

    public Customer() {
        this.setUsuario(new String());
        this.setContraseña(new String());
    }

    public Customer(String user, String pass) {
        this.setUsuario(user);
        this.setContraseña(pass);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String id) {
        this.usuario = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String name) {
        this.contraseña = name;
    }

    //Metodo equals --> Establecemos que para que un usuario sea igual a otro debe tener el nombre y la contraseña igual
    //En un futuro cambiará y se podrá acceder tambien por mail y por correo electrónico.
    // El método es util  en las funciones de añadir usuario y login.
    @Override
    public boolean equals(Object o){
        if (o instanceof Customer){
            Customer customerIN=(Customer)o;
            if (customerIN.getUsuario().equals(this.usuario)){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}