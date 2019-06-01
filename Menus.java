//package ProyectoPOO;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
/**Esta clase se encargara de imprimir todos los menus
ademas de decidir el camino en la ejecucion */
public class Menus{
    Scanner scan = new Scanner(System.in);

/**Metodo constructor de la clase Menus*/
public Menus(){}
/**Nos dara la opurtunida de elegir entre el dueño de la tienda o un comprador*/
    public int  MenuPrincipal(){
        System.out.println("------------------------------------");
        System.out.println("              Tienda              ");      
        System.out.println("------------------------------------");                  
        System.out.println("        1) Comprador              ");
        System.out.println("        2) Vendedor               ");
        System.out.println("        3) Salir                  ");
        System.out.println("------------------------------------");
        int opcion = scan.nextInt();
        while(opcion<=0||opcion>=4){ //Fuera de rango
            Error();
            opcion=scan.nextInt();
        }
        return opcion;
    }

/**Menu que nos permitira dar retorno al menu principal o termino del programa*/
     public int RegresarMenuPrincipal(){
        System.out.println("------------------------------------");
        System.out.println("  1) Regresar al Menú Principal   ");
        System.out.println("  2) Salir                        ");
        System.out.println("------------------------------------");
        int regreso = scan.nextInt();
        while(regreso<=0||regreso>=3){//Fuera de rango
            Error();
            regreso = scan.nextInt();
        }
        return regreso;
    }


     public String nameProducto(){
        System.out.println("----------------------------------------");  
        System.out.println("º ¿Cómo deseas que se llame tu producto ?  ");   
        System.out.println("----------------------------------------"); 
        String name = scan.next();
        return name;
     }
/**Menu de excepciones, cuando existe una se lanza el menu y termina la ajecucion del programa*/
     public void Catch(){
        System.out.println("--------------------------------");
        System.out.println("                    Error     ");
        System.out.println("    Hasta Pronto              ");                  
        System.out.println("--------------------------------");
        System.exit(0);
    }
/**Menu que que aparece cuando se lanza una excepcion referente a un archivo*/
    public void CatchArchivos(){
        System.out.println("--------------------------------");
        System.out.println("               Error archivo    ");
        System.out.println("    Hasta Pronto                ");                  
        System.out.println("--------------------------------");
        System.exit(0);
    }
/**Menu de despedida, solo se imprimira cuando acabe la ejecucion */
     public void Despedida(){
        System.out.println("--------------------------------");
        System.out.println("    Hasta Pronto              ");                  
        System.out.println("--------------------------------");
        System.exit(0);
    }

/**Cuando el usuario ingresa un valor fuera del rango aparece este menu */
    public void Error(){
         System.out.println("¡¡¡¡¡¡¡¡Error!!!!!!!!!");
         System.out.println("Intentalo Nuevamente:");
    }

    public String contrasena(){
         scan.nextLine();//Para poder ingresar una linea 
         System.out.println("Ingrsa la contrasena");
         String contra = scan.nextLine();
         return contra;
    }

    public boolean comprobarContrasena(String contrasenaReal, String contrasenaIn){
        boolean resp = (contrasenaReal.equals(contrasenaIn))?true:false;
        return resp;
    }

    public int nuevoIntento(){
        System.out.println("------------------------------------");
        System.out.println("  1) Regresar al Menú Principal   ");
        System.out.println("  2) Nuevo intento                 ");
        System.out.println("------------------------------------");
        int intento = scan.nextInt();
        while(intento<=0||intento>=3){//Fuera de rango
            Error();
            intento = scan.nextInt();
        }
        return intento;
    }

    public int menuGerente(){
        System.out.println("------------------------------------");
        System.out.println("              Gerente               ");      
        System.out.println("------------------------------------");                  
        System.out.println("        1)  Agregar producto        ");
        System.out.println("        2)  Editar producto         ");
        System.out.println("        3)  Elinimar producto       ");
        System.out.println("        4)  Salir                   ");
        System.out.println("------------------------------------");
        int opcion = scan.nextInt();
        while(opcion<=0||opcion>=5){ //Fuera de rango
            Error();
            opcion = scan.nextInt();
        }
        return opcion;
    }

}