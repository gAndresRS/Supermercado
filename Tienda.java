import java.io.*;
/**
 *
 * @author Andres
 */
public class Tienda {
    
    public static void main(String[] args) {
        Menus menu = new Menus();
        try{
            int opcion = menu.MenuPrincipal();
            while (opcion != 3){
                switch (opcion){
                    case 1:
                        System.out.println("Opcion 1");
                        opcion = menu.MenuPrincipal();

                    break;
                    case 2:
                        System.out.println("Opcion 2");
                        Gerente gerente = new Gerente();
                        int intento = 0;
                        do{
                            String contrasenaIn = menu.contrasena();
                            System.out.println(contrasenaIn);
                            boolean resp = menu.comprobarContrasena(gerente.getContrasena(), contrasenaIn);
                            if (!resp){//Si la contraseña se ingreso mal
                                System.out.println("¿Deseas ingresar intentar denuevo o salir al menu principla?");
                                intento = menu.nuevoIntento();
                            }else{//Si la contraseña se ingreso bien
                                System.out.println("Menu gerente");
                                int opcionGerente = 0;
                                do{
                                    opcionGerente = menu.menuGerente();
                                    switch (opcionGerente){
                                        case 1:
                                            System.out.println("Agregar producto");
                                            gerente.agregarProducto();
                                        break;
                                        case 2:
                                            System.out.println("Editar producto");
                                            
                                        break;
                                        case 3:
                                            System.out.println("Eliminar producto");
                                            gerente.eliminarProducto();
                                        break;
                                    }

                                }while(opcionGerente != 4);
                                intento = 1;//Para salir directo al menu principal
                            }
                        }while(intento != 1);
                        opcion = menu.MenuPrincipal();
                    break;
                }
            }
            menu.Despedida(); // Si decide salir en el retorno
        }catch(Exception e){
            menu.Catch();
        }/*catch(IOException archivos){
            menu.CatchArchivos();
        }*/
    }
    
}
