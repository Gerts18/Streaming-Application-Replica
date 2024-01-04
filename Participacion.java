public class Participacion implements java.io.Serializable,Esencial{
  private String papel,nombreContenido;

  public Participacion() {
  }

  public Participacion(String papel, String nombreContenido) {
      this.papel = papel;
      this.nombreContenido = nombreContenido;
  }

  public void mostrar(){
    System.out.println(".........."+nombreContenido+"..........");
    System.out.println("Papel que desempeño: "+papel);
  }



  public String getPapel() {
      return papel;
  }

  public void setPapel(String papel) {
      this.papel = papel;
  }

  public String getNombreContenido() {
      return nombreContenido;
  }

  public void setNombreContenido(String nombreContenido) {
      this.nombreContenido = nombreContenido;
  }


}
