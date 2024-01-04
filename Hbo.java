import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Hbo {
  private String rfc;
  private String correo;
  private String paginaWeb;
  private String numero;

  private String correoUsuario,contraUsuario,info;
  private char duracion;
  private int coContenidos,cActores,coCuentas,cMembresias,cEstudios,cReproducciones



  private Contenido contenidos[]=new Contenido[1000];
  private Actor actores[] = new Actor[10000];
  private Cuenta cuentas[] = new Cuenta[10000];
  private Membresia membresias[] = new Membresia[10];
  private Estudio estudios[] = new Estudio[1000];
  private Reproduccion reproducciones[] = new Reproduccion[10000];

  private Scanner dt = new Scanner(System.in);
  private int op,num,op2,op3;
  private char seleccion;
  private boolean verificacionCorrecta;

  private Perfil perfil;
  private Actor actor;


  public Hbo(){

  }

  public Hbo(String rfc, String correo, String paginaWeb, String numero) {
    this.rfc = rfc;
    this.correo = correo;
    this.paginaWeb = paginaWeb;
    this.numero = numero;
    inicializaDatos();
  }

  public void guardarDatos(){
    FileOutputStream file=null;
    ObjectOutputStream obj=null;
    try{
      file = new FileOutputStream("Contenidos.dat");
      obj =new ObjectOutputStream(file);
        for(int i=0;i<coContenidos;i++){
          obj.writeObject(contenidos[i]);
        }

         file=null;
         obj=null;

      file = new FileOutputStream("Actores.dat");
      obj =new ObjectOutputStream(file);
        for(int i=0;i<cActores;i++){
          obj.writeObject(actores[i]);
        }

        file=null;
        obj=null;

       file = new FileOutputStream("Cuentas.dat");
       obj =new ObjectOutputStream(file);
         for(int i=0;i<coCuentas;i++){
           obj.writeObject(cuentas[i]);
         }

         file=null;
         obj=null;

        file = new FileOutputStream("Membresias.dat");
        obj =new ObjectOutputStream(file);
          for(int i=0;i<cMembresias;i++){
            obj.writeObject(membresias[i]);
          }

        file = new FileOutputStream("Estudios.dat");
        obj =new ObjectOutputStream(file);
          for(int i=0;i<cEstudios;i++){
            obj.writeObject(estudios[i]);
          }

          file=null;
          obj=null;

         file = new FileOutputStream("Reproducciones.dat");
         obj =new ObjectOutputStream(file);
           for(int i=0;i<cReproducciones;i++){
             obj.writeObject(reproducciones[i]);
           }


    }catch(Exception e){
            System.out.println(e);
    }
  }

  private void cargarDatos(){
    FileInputStream file=null;
    ObjectInputStream obj=null;
    coContenidos=0;
    cActores=0;
    coCuentas=0;
    cMembresias=0;
    cReproducciones=0;
    cEstudios=0;
    try{
      file = new FileInputStream("Contenidos.dat");
      obj= new ObjectInputStream(file);
      contenidos[coContenidos]=(Contenido)obj.readObject();
      while(contenidos[coContenidos]!=null){
        coContenidos++;
        contenidos[coContenidos]=(Contenido)obj.readObject();
      }
    }catch(Exception a){
      try{
        file=null;
        obj=null;

       file = new FileInputStream("Actores.dat");
       obj= new ObjectInputStream(file);
       actores[cActores]=(Actor)obj.readObject();
       while(actores[cActores]!=null){
         cActores++;
         actores[cActores]=(Actor)obj.readObject();
       }
     }catch(Exception b){
        try{
          file=null;
          obj=null;

         file = new FileInputStream("Cuentas.dat");
         obj= new ObjectInputStream(file);
         cuentas[coCuentas]=(Cuenta)obj.readObject();
         while(cuentas[coCuentas]!=null){
           coCuentas++;
           cuentas[coCuentas]=(Cuenta)obj.readObject();
         }
       }catch(Exception c){
          try{
            file=null;
            obj=null;

           file = new FileInputStream("Membresias.dat");
           obj= new ObjectInputStream(file);
           membresias[cMembresias]=(Membresia)obj.readObject();
           while(membresias[cMembresias]!=null){
             cMembresias++;
             membresias[cMembresias]=(Membresia)obj.readObject();
           }

         }catch(Exception d){
            try{
              file=null;
              obj=null;

             file = new FileInputStream("Estudios.dat");
             obj= new ObjectInputStream(file);
             estudios[cEstudios]=(Estudio)obj.readObject();
             while(estudios[cEstudios]!=null){
               cEstudios++;
               estudios[cEstudios]=(Estudio)obj.readObject();
             }
            }catch(Exception e){
              try{
                file=null;
                obj=null;

               file = new FileInputStream("Reproducciones.dat");
               obj= new ObjectInputStream(file);
               reproducciones[cReproducciones]=(Reproduccion)obj.readObject();
               while(reproducciones[cReproducciones]!=null){
                 cReproducciones++;
                 reproducciones[cReproducciones]=(Reproduccion)obj.readObject();
               }
             }catch(Exception f){
                System.out.println("Los datos fueron cargados con exito");
                System.out.println("");
              }

            }

          }

        }

      }
    }
  }


  private void inicializaDatos(){

    cargarDatos();
/*

    estudios[0]=new Estudio("Disney","DSN19USA","disney@gmail.com","4456789023");
    estudios[1]=new Estudio("Warner Bros","WB18USA","warnermedia@gmail.com","4435678900");
    estudios[2]=new Estudio("Sony","SNUSA09","SonyEnterprises@gmail.com","8009002304");

    cEstudios=3;

    actores[0]=new Actor("Robet Downey Jr","Actor de buena fama gracias a que protagonizo la infame pelicula (Iron man) del 2008",2000);
    actores[1]=new Actor("Henry Cavil","Actor poco conocido en la industria, que se hizo de fama al ser seleccionado para interpretar al Hombre de Acero",2001);
    actores[2]=new Actor("Chris Hemsworth","Conocido simplemente como Chris Hemsworth, es un actor, actor de voz y productor australiano", 2003);
    actores[3]=new Actor("Mark Ruffalo","Es un actor, actor de voz, productor y director estadounidense. Inició su carrera como actor en los años 1990 apareciendo en varias series de televisión y películas con papeles menores hasta que logró reconocimiento con la película You Can Count On Me (2000)", 2004);
    actores[4]=new Actor("Scarlett Johansson","Es una actriz, cantante, directora, productora y empresaria estadounidense. Comenzó a mostrar intereses en la actuación desde temprana edad, y a lo largo de su infancia y adolescencia se formó en distintos institutos como actriz", 2005);
    actores[5]=new Actor("Chris Evans","Es un actor, actor de voz, director y productor estadounidense. Criado en el pueblo de Sudbury, mostró interés a temprana edad por la actuación y se mudó a Nueva York para estudiar teatro luego de terminar la secundaria",2006);
    actores[6]=new Actor("Ben Affleck", "Es un actor, director, productor y guionista estadounidense. Apoyado por su madre, inició su carrera como actor infantil de documentales educativos y después apareciendo en varias películas dirigidas por Kevin Smith, entre estas Mallrats (1995)", 2007);
    actores[7]=new Actor("Gal Gadot", "Gal Gadot Varsano es una actriz, productora y modelo israelí. A los 18 años, ganó el título de Miss Israel 2004 con el cual representó a Israel en Miss Universo 2004 donde no logró entrar al top de finalistas.",2008);

    cActores=8;

    contenidos [0]=new Contenido(".Avengers.",'B',"2h 23m", estudios[0].getNombre(), "Accion", "2012", "Un grupo de Heroes se unen para salvar el mundo",1000);
    contenidos [0].setActor(actores[0]);
    contenidos [0].setActor(actores[2]);
    contenidos [0].setActor(actores[3]);
    contenidos [0].setActor(actores[4]);
    contenidos [0].setActor(actores[5]);


    contenidos [1]=new Contenido(".Batman v Superman.",'B',"2h 58min",estudios[1].getNombre(), "Accion", "2016", "El enfrentamiento entre dos heroes, los cuales se uniran para enfrentar una amenaza mayor",1001);
    contenidos [1].setActor(actores[1]);
    contenidos [1].setActor(actores[6]);
    contenidos [1].setActor(actores[7]);

    actores[0].agregarParticipacion( "Actor Principal (Iron man)",contenidos[0].getNombre());
    actores[0].agregarParticipacion( "Actor Principal (Sherlock Homes)","Sherlock Holmes: Juego de sombras");
    actores[1].agregarParticipacion( "Actor principal (Superman)",contenidos[1].getNombre());
    actores[1].agregarParticipacion( "Actor Secundario (Sherlock Homes)","Enola Holmes");
    actores[2].agregarParticipacion( "Actor principal (Thor)",contenidos[0].getNombre());
    actores[2].agregarParticipacion( "Actor principal (Agente H)","Hombres de negro: internacional");
    actores[3].agregarParticipacion( "Actor principal (Hulk)",contenidos[0].getNombre());
    actores[4].agregarParticipacion( "Actriz principal (Viuda Negra)",contenidos[0].getNombre());
    actores[5].agregarParticipacion( "Actor principal (Capitan America)",contenidos[0].getNombre());
    actores[6].agregarParticipacion( "Actor principal (Batman)",contenidos[1].getNombre());
    actores[6].agregarParticipacion( "Presto voz (Jose)","José: el rey de los sueños");
    actores[7].agregarParticipacion( "Actriz principal (Wonder Woman)",contenidos[1].getNombre());


    coContenidos=2;


    membresias[0]=new Membresia("Estandar","200 MXN x Mes",1,true,2);
    membresias[1]=new Membresia("Deluxe","350 MXN x Mes",2,true,3);

    cMembresias=2;

    cuentas[0]=new Cuenta("German Torres",'T',"ger@gmail.com","12345",membresias[0].getNombre());
    cuentas[0].agregarPerfil("German",false,3001);
    cuentas[0].agregarPerfil("Mayis",true,3002);

    cuentas[1]=new Cuenta("Edgardo Mauricio",'T',"ed@gmail.com","12345",membresias[1].getNombre());
    cuentas[1].agregarPerfil("Ed",false,3003);

    coCuentas=2;
*/

  }

  public void agregarContenido(){
    contenidos[coContenidos]=new Contenido();
    contenidos[coContenidos].agregar();
    System.out.println("Actores que participan");
    System.out.print("Cuantos actores registraras?: ");
    op=dt.nextInt();
    for(int p=0;p<op;p++){
      System.out.println("1.-Agregar nuevo Actor     2.-Actor ya registrado");
      op2=dt.nextInt();
      if(op2==1){
        agregarActor();
      }else if(op2==2){
        System.out.println("Selecciona Al actor");
        mostrarActores();
        op2=dt.nextInt();dt.nextLine();
        System.out.print("Papel que desempeña en dicho contenido:");info=dt.nextLine();
        actores[op2-1].agregarParticipacion(info,contenidos[coContenidos].getNombre());
        contenidos[coContenidos].setActor(actores[op2-1]);
      }
    }
    System.out.println("1.-Estudio Nuevo      2.-Estudio ya existente");
    op=dt.nextInt();
    if(op==1){
      estudios[cEstudios]=new Estudio();
      estudios[cEstudios].agregar();
      contenidos[coContenidos].setNombreEstudio(estudios[cEstudios].getNombre());
      cEstudios++;

    }else if(op==2){
      System.out.println("Selecciona el Estudio encargado");
      for(int i=0; i<cEstudios; i++){
        System.out.println((i+1)+".-"+estudios[i].getNombre());
      }
      op=dt.nextInt();
      contenidos[coContenidos].setNombreEstudio(estudios[op-1].getNombre());

    }
    coContenidos++;
  }

  public void mostrarContenidos(){
    for(int i=0; i<coContenidos; i++){
    contenidos[i].mostrar();
    contenidos[i].mostrarActores();
    System.out.println("");
    }
  }

  public void mostrarContenidos(String texto){
  String megaCadena;
  Contenido r;
  for(int i=0; i<coContenidos; i++){
    r=contenidos[i];
    megaCadena=r.getNombre()+r.getClasificacion()+r.getDuracion()+r.getDescripcion()+r.getNombreEstudio()+
               r.getGenero()+r.getFecha()+r.getId();
  if(megaCadena.contains(texto)){
    r.mostrar();
    r.mostrarActores();
    System.out.println("");
    megaCadena="";
    }
   }
  }



  public void agregarEstudio(){
    estudios[cEstudios]=new Estudio();
    estudios[cEstudios].agregar();
    cEstudios++;
  }

  public void mostrarEstudios(){
    for(int i=0; i<cEstudios; i++){
      estudios[i].mostrar();
      System.out.println("");
    }
  }

  public void mostrarEstudios(String texto){
  String megaCadena;
  Estudio r;
  for(int i=0; i<cEstudios; i++){
    r=estudios[i];
    megaCadena=r.getNombre()+r.getRfc()+r.getCorreo()+r.getTelefonoContacto();
  if(megaCadena.contains(texto)){
    r.mostrar();
    System.out.println("");
    megaCadena="";
    }
   }
  }



  public void agregarActor(){
      actores[cActores]=new Actor();
      actores[cActores].agregar();dt.nextLine();
      System.out.print("Papel que desempeña en dicho contenido:");info=dt.nextLine();
      actores[cActores].agregarParticipacion(info,contenidos[coContenidos].getNombre());
      contenidos[coContenidos].setActor(actores[cActores]);
      cActores++;
  }

  public void mostrarActores(){
    System.out.println("..........ACTORES..........");
    for(int i=0; i<cActores; i++){
      System.out.println((i+1)+"-"+actores[i].getNombre());
    }
  }


  public void agregarCuenta(){
    int length;
    cuentas[coCuentas]=new Cuenta();
    cuentas[coCuentas].agregar();
    do{
      System.out.print("Escribe tu contraseña (5 digitos minimo):");contraUsuario=dt.nextLine();
      length = contraUsuario.length();
      if(length<5){
        System.out.println("");
        System.out.println("Contraseña demasiado corta, intenta introduciendo otra");
        System.out.println("");
        op=1;
      }else{
        op=0;
      }
    }while(op!=0);
    cuentas[coCuentas].setContra(contraUsuario);
    System.out.println("");
    mostrarMembresias();
    System.out.print("Elije plan                         :");op=dt.nextInt();dt.nextLine();
    cuentas[coCuentas].setTipoMembresia(membresias[op-1].getNombre());
    System.out.print("Cantos Perfiles usaras? (Maximo 5) :");op=dt.nextInt();dt.nextLine();
    System.out.println("");
    perfil=cuentas[coCuentas-1].getPerfil();
    int z=1;
    for(int i=0; i<op; i++){
      cuentas[coCuentas].setIdPerfil(perfil.getId()+z);
      cuentas[coCuentas].agregarPerfil();
      z++;
      System.out.println("");
    }
    System.out.println("");
    coCuentas++;
  }

  public void mostrarCuentas(){
    for(int i=0; i<coCuentas; i++){
      System.out.println("Cuenta: "+(i+1));
      cuentas[i].mostrar();
      System.out.println(".....Perfiles.....");
      System.out.println("");
      cuentas[i].mostrarPerfiles();
      System.out.println("");
    }
  }

  public void mostrarCuentas(String texto){
  String megaCadena;
  Cuenta r;
  for(int i=0; i<coCuentas; i++){
    r=cuentas[i];
    megaCadena=r.getNombre()+r.getMetodoPago()+r.getCorreo()+r.getTipoMembresia();
  if(megaCadena.contains(texto)){
    r.mostrar();
    r.mostrarPerfiles();
    System.out.println("");
    megaCadena="";
    }
   }
  }

  public void agregarMembresia(){
    membresias[cMembresias]= new Membresia();
    membresias[cMembresias].agregar();
    cMembresias++;
  }

  public void mostrarMembresias(){
    for(int i=0; i<cMembresias; i++){
      System.out.println("Plan: "+(i+1));
      membresias[i].mostrar();
      System.out.println("");
    }
  }

  public void mostrarMembresias(String texto){
  String megaCadena;
  Membresia r;
  for(int i=0; i<cMembresias; i++){
    r=membresias[i];
    megaCadena=r.getNombre()+r.getPrecio()+r.getCalidad()+r.getDescargas()+r.getDispositivos();
  if(megaCadena.contains(texto)){
    r.mostrar();
    System.out.println("");
    megaCadena="";
    }
   }
  }

  public void mostrarReproducciones(){
    for(int i=0; i<cReproducciones; i++){
      reproducciones[i].mostrar();
      System.out.println("");
    }
  }

  public void mostrarReproducciones(String texto){
  String megaCadena;
  Reproduccion r;
  for(int i=0; i<cReproducciones; i++){
    r=reproducciones[i];
    megaCadena=r.getFecha()+r.getHora()+r.getIdPerfil()+r.getNombreContenido()+r.getStatus()+r.getMeGusto();
  if(megaCadena.contains(texto)){
    r.mostrar();
    System.out.println("");
    megaCadena="";
    }
   }
  }

  public void agregarReproduccion(String fecha,String hora, int idPerfil, String nombreContenido,
                                 int status, int meGusto){
      reproducciones[cReproducciones++]=new Reproduccion(fecha,hora,idPerfil,nombreContenido,status,meGusto);
  }


  public void iniciarSesion(){
      int z=0;
      System.out.println("Introduce tu correo:");correoUsuario=dt.nextLine();
      System.out.println("Introduce tu Contrasena:");contraUsuario=dt.nextLine();
      do{
          if(correoUsuario.equals(cuentas[z].getCorreo()) & contraUsuario.equals(cuentas[z].getContra())){
            break;
          }
            z++;
      }while(z<coCuentas);

      if(z==coCuentas){
        System.out.println("");
        System.out.println("Correo y/o contraseña incorrectos");
        System.out.println("");
      }else{
        System.out.println("");
        System.out.println("Inicio de sesion exitoso");
        System.out.println("");
        System.out.println("Bienvenido "+cuentas[z].getNombre());
        System.out.println("");
        reproduccion(cuentas[z]);
      }
  }

  public void registrarse(){
    agregarCuenta();
    System.out.println("Registrado con exito");
    System.out.println("");
  }

  public void reproduccion(Cuenta cuenta){
    DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter hora  = DateTimeFormatter.ofPattern("HH:mm:ss");
    cuenta.mostrarNombrePerfiles();
    System.out.print("Elejir Perfil:");op=dt.nextInt();dt.nextLine();num=op-1;
    perfil=cuenta.getPerfil(op-1);

    do{
      System.out.println("1.-Catalogo      2.-Cuenta      0.-Cerrar Sesion");
      op=dt.nextInt();dt.nextLine();
      System.out.println("");

      switch(op){
        case 1:
                if(perfil.getParcial(0)!=null){
                  perfil.mostrarParciales();
                }
                if(perfil.getLike(0)!=null){
                  perfil.mostrarLikes();
                }

                for(int i=0; i<coContenidos; i++){
                    System.out.print((i+1)+" "+contenidos[i].getNombre());
                    System.out.println("");
                   }
                   System.out.println("");
                System.out.print("Elije el Contenido que deseas ver: ");op=dt.nextInt();dt.nextLine();
                System.out.println("");
                contenidos[op-1].mostrar();
                op3=op-1;
                System.out.println("");
                do{
                  System.out.println("1.Finalizo  \n2.Parcial  \n3.Like  \n4.Dislike  \n5.Actores  \n0.Cerrar");
                  op=dt.nextInt();dt.nextLine();
                  System.out.println("");
                  switch(op){
                    case 1:perfil.setFinalizado(contenidos[op3]);
                           agregarReproduccion(fecha.format(LocalDateTime.now()),hora.format(LocalDateTime.now()),perfil.getId(),
                                               contenidos[op3].getNombre(),1,3);
                           op=10;
                           break;

                    case 2:perfil.setParcial(contenidos[op3]);
                           agregarReproduccion(fecha.format(LocalDateTime.now()),hora.format(LocalDateTime.now()),perfil.getId(),
                                              contenidos[op3].getNombre(),2,3);
                           op=10;
                           break;

                    case 3:perfil.setLike(contenidos[op3]);
                    agregarReproduccion(fecha.format(LocalDateTime.now()),hora.format(LocalDateTime.now()),perfil.getId(),
                                        contenidos[op3].getNombre(),3,1);
                           op=10;
                           break;

                    case 4:perfil.setDislike(contenidos[op3]);
                    agregarReproduccion(fecha.format(LocalDateTime.now()),hora.format(LocalDateTime.now()),perfil.getId(),
                                        contenidos[op3].getNombre(),3,2);
                           op=10;
                           break;

                   case 5:contenidos[op3].mostrarNombreActores();
                          System.out.print("Elije :");op2=dt.nextInt();dt.nextLine();
                          System.out.println("");
                          actor=contenidos[op3].getActor(op2-1);
                          actor.mostrarParticipaciones();
                          System.out.println("");
                          break;

                    case 0:op=10;
                           break;
                  }
                }while(op!=10);
                break;

        case 2: System.out.println(".....Detalles de la Cuenta.....");
                cuenta.mostrar();
                perfil.mostrar();
                break;
      }
    }while(op!=0);

    cuenta.setPerfil(perfil,num);

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

  public String getPaginaWeb() {
      return paginaWeb;
  }

  public void setPaginaWeb(String paginaWeb) {
      this.paginaWeb = paginaWeb;
  }

  public String getNumero() {
      return numero;
  }

  public void setNumero(String numero) {
      this.numero = numero;
  }

}
