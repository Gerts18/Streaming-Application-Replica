import java.util.Scanner;
public class Estudio implements java.io.Serializable,Esencial{
  private String nombre;
  private String rfc;
  private String correo;
  private String telefonoContacto;

  private transient Scanner dt = new Scanner(System.in);


  public Estudio(){

  }

  public Estudio(String nombre, String rfc, String correo,String telefonoContacto) {
      this.nombre = nombre;
      this.rfc = rfc;
      this.correo = correo;
      this.telefonoContacto = telefonoContacto;
  }

  public void mostrar(){
    System.out.println("..........Estudio..........");
    System.out.println("Nombre                  :"+nombre);
    System.out.println("Rfc                     :"+rfc);
    System.out.println("Correo                  :"+correo);
    System.out.println("Telefono de Contacto    :"+telefonoContacto);
  }



  public void agregar(){
    System.out.println("..........Datos del Estudio..........");
    System.out.print("Nombre                         :");nombre=dt.nextLine();
    System.out.print("Rfc                            :");rfc=dt.nextLine();
    System.out.print("Correo                         :");correo=dt.nextLine();
    System.out.print("Telefono de Contacto           :");telefonoContacto=dt.nextLine();
    System.out.println("");
  }

  public String getNombre() {
      return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public String getRfc() {
      return rfc;
  }

  public void setRfc(String rfc) {
      this.rfc = rfc;
  }

  public String getCorreo() {
      return correo;
  }

  public void setCorreo(String correo) {
      this.correo = correo;
  }

  public String getTelefonoContacto() {
      return telefonoContacto;
  }

  public void setTelefonoContacto(String telefonoContacto) {
      this.telefonoContacto = telefonoContacto;
  }

}
