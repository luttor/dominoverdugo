
package servidor.dato;
import ve.edu.ucab.cliente.ClienteSocket;

public class Usuario {

    private String nickname;
    private String clave;
    private String nombre;
    private String apellido;
    private String fechanaci;
    private String avatar;
    private int Score;


    // Constructor Para Crear un usuario
    public Usuario(String nickname, String clave, String nombre, String apellido, String fechanaci,String avatar) {
        this.nickname = nickname;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanaci = fechanaci;
        this.avatar= avatar;
    }
    // Constructor para Logear un Usuario
        public Usuario(String nickname, String clave) {
        this.nickname = nickname;
        this.clave = clave;
    }
            // Constructor para Logear un Usuario
        public Usuario() {
 
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechanaci() {
        return fechanaci;
    }

    public void setFechanaci(String fechanaci) {
        this.fechanaci = fechanaci;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void RegistroUsuario (Usuario U){

    }

    public void ValidaCuenta (Usuario U){

    }

    public void AccedePartida (Usuario U){

    }


}

