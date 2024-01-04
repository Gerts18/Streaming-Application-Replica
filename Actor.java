import java.util.Scanner;
public class Actor implements java.io.Serializable,Esencial{
  private String nombre;
  private String biografia;
  private int id;

  private Participacion participaciones[] = new Participacion[100];
  private int cParticipaciones;

  private transient Scanner dt = new Scanner(System.in);


  public Actor (){

  }

  public Actor(String nombre, String biografia, int id){
       this.nombre = nombre;
       this.biografia = biografia;
       this.id = id;
   }

  public void mostrar(){
     System.out.println("......."+nombre+"......");
     System.out.println("Id                      :"+id);
     System.out.println("biografia            :"+biografia);
     System.out.println("");
  }

  public void agregar(){
    System.out.println("Agrega Datos de un Actor o Actriz");
    System.out.print("Nombre                         :");nombre=dt.nextLine();
    System.out.print("Id                             :");id=dt.nextInt();dt.nextLine();
    System.out.print("Biografia                      :");biografia=dt.nextLine();
    System.out.println("");

  }

  public void agregarParticipacion(String papel, String nombreContenido){
    participaciones[cParticipaciones++]=new Participacion( papel, nombreContenido);
  }

  public void mostrarParticipaciones(){
    System.out.println(".........."+nombre+"..........");
    System.out.println("Biografia            :"+biografia);
       System.out.println("");
    System.out.println("..........Participaciones..........");
    System.out.println("");
    for(int i=0; i<cParticipaciones; i++){
      participaciones[i].mostrar();
      System.out.println("");
    }
  }


  public String getNombre() {
      return nombre;
  }

  public String getBiografia() {
      return biografia;
  }

  public int getId() {
      return id;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public void setBibliografia(String biografia) {
      this.biografia = biografia;
  }

  public void setId(int id) {
      this.id = id;
  }


}
