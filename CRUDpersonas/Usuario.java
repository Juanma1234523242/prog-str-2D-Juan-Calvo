public class Usuario {

    private int codigo;
    private String fullName;
    private boolean estado;

    public Usuario(){}

    public Usuario(int codigo, String fullName){
        this.codigo = codigo;
        this.fullName = fullName;
        this.estado = true; //Se crea por default activo

    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public boolean getEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String statusText = estado ? "Activo" : "Inactivo";
        return "Usuario {Código: " + codigo + " | Nombre: " + fullName + " | Estado: " + statusText + "}";
    }

}
