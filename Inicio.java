import java.util.Scanner;
public class Inicio {

    private static int seleccion;
    private static int opcion;
    private static String texto;

    public static void main (String args[]){

      Scanner dato = new Scanner (System.in);

      Hbo hbo = new Hbo("HDL170310NP7","hbomaxreleases@warnermediagroup.com","www.hbomax.com","1115032113946");


        System.out.println("1.-Usuario      2.-Administrador     0.-Salir");
        seleccion=dato.nextInt();

        if(seleccion==1){
          do{

            switch(opcion=menuUsuario()){
              case 1:hbo.iniciarSesion();break;

              case 2:hbo.registrarse();break;
            }

          }while(opcion!=0);

        }else if(seleccion==2){
          do{

            switch(opcion=menuAdministrador()){
              case 11:hbo.agregarContenido();break;
              case 12:hbo.mostrarContenidos();break;
              case 13:hbo.mostrarContenidos(texto);break;

              case 21:hbo.agregarCuenta();break;
              case 22:hbo.mostrarCuentas();break;
              case 23:hbo.mostrarCuentas(texto);break;

              case 31:hbo.agregarMembresia();break;
              case 32:hbo.mostrarMembresias();break;
              case 33:hbo.mostrarMembresias(texto);break;

              case 41:hbo.agregarEstudio();break;
              case 42:hbo.mostrarEstudios();break;
              case 43:hbo.mostrarEstudios(texto);break;

              case 51:hbo.mostrarReproducciones();break;
              case 52:hbo.mostrarReproducciones(texto);break;

            }

          }while(opcion!=0);

        }else if(seleccion==0){
          System.exit(0);
        }
  hbo.guardarDatos();

    }

    public static int menuAdministrador(){

      Scanner dato = new Scanner (System.in);
      System.out.println("1.-Contenido      2.-Cuentas      3.-Membresias      4.-Estudios      5.-Reproducciones      0.-Cancelar");
      opcion=dato.nextInt();
      if(opcion==0){
        return opcion;
      }else if(opcion==5){
        System.out.println("1.-Mostrar      2.-Buscar      0.-Cancelar  ");
        opcion=opcion*10+dato.nextInt();
        if(opcion%10==2){
          dato.nextLine();
          System.out.print("Qué quieres buscar? ");texto=dato.nextLine();
          System.out.println("");
        }
        return opcion;
      }
      System.out.println("1.-Agregar      2.-Mostrar      3.-Buscar      0.-Cancelar  ");
      opcion=opcion*10+dato.nextInt();

      if(opcion%10==3){
        dato.nextLine();
        System.out.print("Qué quieres buscar? ");texto=dato.nextLine();
        System.out.println("");
      }

      return opcion;


    }

    public static int menuUsuario(){
      Scanner dato = new Scanner (System.in);
      System.out.println("1.-Iniciar Sesion      2.-Registrarse     0.-Cancelar");
      opcion=dato.nextInt();
      return opcion;
    }

}
