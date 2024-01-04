import java.util.Scanner;
public class Membresia implements java.io.Serializable,Esencial{
  private String nombre;
  private String precio;
  private int calidad;
  private boolean descargas;
  private int dispositivos;
  private String cld,desc;
  private int de;

  private transient Scanner dt = new Scanner(System.in);


  public Membresia(){

  }

  public Membresia(String nombre, String precio, int calidad, boolean descargas, int dispositivos) {
      this.nombre = nombre;
      this.precio = precio;
      this.calidad = calidad;
      this.descargas = descargas;
      this.dispositivos = dispositivos;
  }

  public void mostrar(){
    System.out.println("..........Membresia "+nombre+"..........");
    System.out.println("Precio                   :"+precio);
    switch(calidad){
          case 1: cld="HD(720p)";break;
          case 2: cld="FULL HD(1080p)";break;
          case 3: cld="Ultra Hd (4k)";break;
        }
    System.out.println("Calidad Maxima           :"+cld);
    if(descargas==true){
      desc="Disponible";
    }else if(descargas==false){
      desc="No disponible";
    }
    System.out.println("Descargas de Contenido   :"+desc);
    System.out.println("Dispositivos Simultaneos :"+dispositivos);
  }


  public void agregar(){
    System.out.print("Tipo plan                                :");nombre=dt.nextLine();
    System.out.print("Precio sugerido (MXN)                    :");precio=dt.nextLine();
    System.out.print("");
    System.out.println("\n1-HD(720p)  \n2-FULL HD(1080p) \n3-Ultra Hd (4k) ");
    System.out.print("Calidad Maxima Permitida                 :");calidad=dt.nextInt();dt.nextLine();
    System.out.print("Permite Descargar contenido? (1)Si (2)No :");de=dt.nextInt();dt.nextLine();
    if(de==1){
      descargas=true;
    }else{
      descargas=false;
    }
    System.out.print("Cantidad Dispositivos simultaneos        :");dispositivos=dt.nextInt();dt.nextLine();
  }



  public String getNombre() {
      return nombre;
  }

  public String getPrecio() {
      return precio;
  }

  public int getCalidad() {
      return calidad;
  }

  public boolean getDescargas() {
      return descargas;
  }

  public int getDispositivos() {
      return dispositivos;
  }


  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public void setPrecio(String precio) {
      this.precio = precio;
  }

  public void setCalidad(int calidad) {
      this.calidad = calidad;
  }

  public void setDescargas(boolean descargas) {
      this.descargas = descargas;
  }

  public void setDispositivos(int dispositivos) {
      this.dispositivos = dispositivos;
  }


}
