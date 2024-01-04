import java.util.Scanner;
public class Cuenta implements java.io.Serializable,Esencial{
  private String nombre;
  private char metodoPago;
  private String correo;
  private String contra;
  private String tipoMembresia;
  private String mp;
  private char md;
  private int op;
  private int id;

  private transient Scanner dt = new Scanner(System.in);

  private Perfil perfiles[] = new Perfil[5];
  private int cPerfiles;


  public Cuenta(){

  }

  public Cuenta(String nombre, char metodoPago, String correo,String contra,String tipoMembresia ) {
        this.nombre = nombre;
        this.metodoPago = metodoPago;
        this.correo = correo;
        this.contra = contra;
        this.tipoMembresia = tipoMembresia;
    }

  public void mostrar(){
    System.out.println("Nombre                : "+nombre);
    switch(metodoPago){
          case 'T': mp="Tarjeta de credito/debito";break;
          case 'C': mp="Cupon canjeable/Tarjeta de regalo";break;
        }
    System.out.println("Metodo de pago        : "+mp);
    System.out.println("Correo                : "+correo);
    System.out.println("Tipo de Membresia     : "+tipoMembresia);
    System.out.println("");

  }

  public void agregar(){
    System.out.print("Nombre                        :");nombre=dt.nextLine();
    System.out.println("    \nT-Tarjeta de credito/debito \nC-Cupon canjeable/Tarjeta de regalo");
    System.out.print("Metodo de pago                :");metodoPago=dt.next().charAt(0);dt.nextLine();
    System.out.print("Correo                        :");correo=dt.nextLine();
  }

  public void agregarPerfil(){
    perfiles[cPerfiles]=new Perfil();
    perfiles[cPerfiles].agregar();
    perfiles[cPerfiles].setId(id);
    cPerfiles++;
  }


  public void agregarPerfil(String nombre, boolean restriccionEdad,int id){
    perfiles[cPerfiles++]=new Perfil(nombre,restriccionEdad,id);
  }

  public void mostrarPerfiles(){
    for(int i=0; i<cPerfiles; i++){
      System.out.println("Perfil "+(i+1) +":");
      perfiles[i].mostrar();
      System.out.println("");
    }
  }

  public void mostrarNombrePerfiles(){
    for(int i=0; i<cPerfiles; i++){
      System.out.print((i+1) +".-"+perfiles[i].getNombre());
      System.out.println("");
    }

  }

  public void setIdPerfil(int id){
    this.id=id;
  }


  public Perfil getPerfil(int p){
  return perfiles[p];
  }

  public Perfil getPerfil(){
  return perfiles[cPerfiles-1];
  }

  public void setPerfil(Perfil p,int num){
    this.perfiles[num]=p;
  }

  public String getTipoMembresia() {
      return tipoMembresia;
  }
  public void setTipoMembresia(String tipoMembresia) {
      this.tipoMembresia=tipoMembresia;
  }

  public String getContra() {
      return contra;
  }
  public void setContra(String contra) {
      this.contra=contra;
  }

  public String getNombre() {
      return nombre;
  }

  public char getMetodoPago() {
      return metodoPago;
  }

  public String getCorreo() {
      return correo;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public void setMetodoPago(char metodoPago) {
      this.metodoPago = metodoPago;
  }

  public void setCorreo(String correo) {
      this.correo = correo;
  }


}
