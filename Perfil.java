import java.util.Scanner;
public class Perfil implements java.io.Serializable,Esencial{
  private String nombre;
  private boolean restriccionEdad;
  private int id;

  private int op;
  private String restric;

  public Contenido parciales[]=new Contenido[100];
  private int cParciales;
  public Contenido likes[]=new Contenido[100];
  private int cLikes;

  private transient Scanner dt = new Scanner(System.in);

  private Contenido c;


  public Perfil(){

  }

  public Perfil(String nombre, boolean restriccionEdad, int id) {
      this.nombre = nombre;
      this.restriccionEdad = restriccionEdad;
      this.id = id;
  }


  public void mostrar(){
    System.out.println("......"+nombre+"......");
    System.out.println("Id del Perfil:"+id);
    if(restriccionEdad==true){
      System.out.println("Cuenta con restriccion de edad?: Si");
    }else{
      System.out.println("Cuenta con restriccion de edad?: No");
    }

    System.out.println("");

  }

  public void agregar(){
    System.out.print("Nombre del Perfil                       :");nombre=dt.nextLine();
    System.out.print("Aplicar Restriccion de edad (1)Si (2)No :");op=dt.nextInt();dt.nextLine();
    if(op==1){
      restriccionEdad=true;
    }else{
      restriccionEdad=false;
    }

  }



  public void agregarParcial(){
    int z=0;
    try{
      do {
        if (c.getNombre().equals(parciales[z].getNombre())) {
          break;
        }
        z++;

      } while (z<cParciales);

    }catch(NullPointerException e){
      parciales[cParciales]=c;
      cParciales++;
    }

    if(z==cParciales){
      parciales[cParciales]=c;
      cParciales++;
    }else{

    }
  }

  public void agregarLike(){
    int z=0;
    try{
      do {
        if (c.getNombre().equals(likes[z].getNombre())) {
          break;
        }
        z++;

      } while (z<cLikes);

    }catch(NullPointerException e){
      likes[cLikes]=c;
      cLikes++;
    }

    if(z==cLikes){
      likes[cLikes]=c;
      cLikes++;
    }else{

    }
  }

  public void quitarParcial(){
    int z=0;
    try{
      do {
        if (c.getNombre().equals(parciales[z].getNombre())) {
          break;
        }
        z++;

      } while (z<cParciales);

    }catch(NullPointerException e){

    }

    if(z==cParciales){

    }else{
      for(int i=z;i<cParciales;i++){
          parciales[i]=parciales[i+1];
        }
        cParciales--;
      }

  }

  public void quitarLike(){
    int z=0;
    try{
      do {
        if (c.getNombre().equals(likes[z].getNombre())) {
          break;
        }
        z++;

      } while (z<cLikes);

    }catch(NullPointerException e){

    }

    if(z==cLikes){

    }else{
      for(int i=z;i<cLikes;i++){
          likes[i]=likes[i+1];
        }
        cLikes--;
      }

  }


  public void mostrarParciales(){
    try{
      if(parciales[0]!=null){
        System.out.println(".....Peliculas que no terminaste de ver.....");
      }
      for(int i=0; i<cParciales; i++){
          System.out.print(" "+parciales[i].getNombre());
          System.out.println("");
         }
         System.out.println("");
    }catch(NullPointerException e){
      System.out.println("");
    }

  }

  public void mostrarLikes(){
    System.out.println(".....Peliculas que te gustaron.....");
    for(int i=0; i<cLikes; i++){
        System.out.print(" "+likes[i].getNombre());
        System.out.println("");
       }
       System.out.println("");

  }

  public void setFinalizado(Contenido contenido) {
    this.c = contenido;
    quitarParcial();

  }

  public void setDislike(Contenido contenido) {
    this.c = contenido;
    quitarLike();

  }

  public Contenido getParcial(int p){
      return parciales[p];
  }

  public Contenido getLike(int p) {
      return likes[p];
  }

  public void setParcial(Contenido contenido) {
    this.c = contenido;
    agregarParcial();
  }

  public void setLike(Contenido contenido) {
    this.c = contenido;
    agregarLike();
  }


  public String getNombre() {
      return nombre;
  }

  public int getId(){
      return id;
  }

  public boolean getRestriccionEdad() {
      return restriccionEdad;
  }

  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public void setRestriccionEdad(boolean restriccionEdad) {
      this.restriccionEdad = restriccionEdad;
  }

  public void setId(int id) {
      this.id = id;
  }


}
