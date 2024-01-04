public class Reproduccion implements java.io.Serializable,Esencial{
  private String fecha,hora;
  private int idPerfil;
  private String nombreContenido;
  private int status;
  private int meGusto;

  private String gustar,visto;


  public Reproduccion(){

  }

  public Reproduccion(String fecha,String hora, int idPerfil, String nombreContenido, int status, int meGusto) {
      this.fecha = fecha;
      this.hora = hora;
      this.idPerfil = idPerfil;
      this.nombreContenido = nombreContenido;
      this.status = status;
      this.meGusto = meGusto;
  }

  public void mostrar(){
    System.out.println("Contenido consumido         :"+nombreContenido);
    System.out.println("Fecha                       :"+fecha);
    System.out.println("Hora                        :"+hora);
    System.out.println("Perfil que lo consumio      :"+idPerfil);
    if(status==1){
      visto="Finalizado";
    }else if(status==2){
      visto="No lo termino de ver";
    }else if (status==3){
      visto="No especificado";
    }
    System.out.println("Status del contenido        :"+visto);
    if(meGusto==1){
      gustar="Le dio Like";
    }else if(meGusto==2){
      gustar="Le dio Dislike";
    }else if (meGusto==3){
      gustar="No especificado";
    }
    System.out.println("Le gusto el contenido?      :"+gustar);
  }


  public String getFecha() {
      return fecha;
  }

  public void setFecha(String fecha) {
      this.fecha = fecha;
  }

  public String getHora() {
      return hora;
  }

  public void setHora(String hora) {
      this.hora = hora;
  }

  public int getIdPerfil() {
      return idPerfil;
  }

  public void setIdPerfil(int idPerfil) {
      this.idPerfil = idPerfil;
  }

  public String getNombreContenido() {
      return nombreContenido;
  }

  public void setNombreContenido(String nombreContenido) {
      this.nombreContenido = nombreContenido;
  }

  public int getStatus() {
      return status;
  }

  public void setStatus(int status) {
      this.status = status;
  }

  public String getMeGusto() {
      return gustar;
  }

  public void setMeGusto(String gustar) {
      this.gustar = gustar;
  }



}
