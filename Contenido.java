import java.util.Scanner;
public class Contenido implements java.io.Serializable,Esencial{
  private String nombre;
  private char clasificacion;
  private String duracion;
  private String descripcion;
  private String nombreEstudio;
  private String genero;
  private String fecha;
  private int id;
  Actor r;


  private int op;
  private int cActores;
  private String cls;

  private Actor actores[]=new Actor[10];


  private transient Scanner dt = new Scanner(System.in);


  public Contenido(){

  }

  public Contenido(String nombre, char clasificacion, String duracion,String nombreEstudio,
                   String genero, String fecha, String descripcion, int id) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.genero = genero;
        this.fecha = fecha;
        this.nombreEstudio = nombreEstudio;
        this.id = id;
    }

  public void mostrar(){
    System.out.println(".........."+nombre+"..........");
    switch(clasificacion){
          case 'A': cls="A";break;
          case 'D': cls="B15";break;
          case 'B': cls="B";break;
          case 'C': cls="C";break;
        }
    System.out.println("Clasificacion           :"+cls);
    System.out.println("Duracion                :"+duracion);
    System.out.println("Genero                  :"+genero);
    System.out.println("Fecha de estreno        :"+fecha);
    System.out.println("Estudio                 :"+nombreEstudio);
    System.out.println("Descripcion             :"+descripcion);
    System.out.println("");
  }

  public void agregar(){
    System.out.println("Agrega Datos de Un nuevo Contenido");
    System.out.print("Nombre                        :");nombre=dt.nextLine();
    System.out.print("");
    System.out.println("\nA-Todas las edades \nB-Mayores de 12 \nC-Mayores de 18 \nD-Mayores de 15 ");
    System.out.print("Clasificacion                 :");clasificacion=dt.next().charAt(0);dt.nextLine();
    System.out.print("");
    System.out.print("Duracion                      :");duracion=dt.nextLine();
    System.out.print("Genero                        :");genero=dt.nextLine();
    System.out.print("Fecha de estreno              :");fecha=dt.nextLine();
    System.out.print("Id                            :");id=dt.nextInt();dt.nextLine();
    System.out.print("Descripcion                   :");descripcion=dt.nextLine();
  }

  public void agregarActor(){
    actores[cActores]=r;
    cActores++;
  }

  public void mostrarActores(){
    for(int i=0; i<cActores; i++){
      System.out.print("Actor "+(i+1));
      actores[i].mostrar();
      System.out.println("");
    }

  }

  public void mostrarNombreActores(){
    for(int i=0; i<cActores; i++){
      System.out.print("Actor "+(i+1)+".- "+actores[i].getNombre());
      System.out.println("");
    }
  }




  public Actor getActor(int i){
  return actores[i];
  }

  public void setActor(Actor r){
    this.r = r;
    agregarActor();
  }


  public String getNombre() {
        return nombre;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public char getClasificacion() {
      return clasificacion;
  }

  public void setClasificacion(char clasificacion) {
      this.clasificacion = clasificacion;
  }

  public String getDuracion() {
      return duracion;
  }

  public void setDuracion(String duracion) {
      this.duracion = duracion;
  }

  public String getDescripcion() {
      return descripcion;
  }

  public void setDescripcion(String descripcion) {
      this.descripcion = descripcion;
  }

  public String getGenero() {
      return genero;
  }

  public void setGenero(String genero) {
      this.genero = genero;
  }

  public String getFecha() {
      return fecha;
  }

  public void setFecha(String fecha) {
      this.fecha = fecha;
  }

  public String getNombreEstudio() {
      return nombreEstudio;
  }

  public void setNombreEstudio(String nombreEstudio) {
      this.nombreEstudio = nombreEstudio;
  }

  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }
}
