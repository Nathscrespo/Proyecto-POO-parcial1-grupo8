package modelo.admins;

import java.util.*;
import modelo.clases.DueñoMascota;
import modelo.main.NewMain;

public class AdminDueños { 
    
    public static ArrayList<DueñoMascota> arrDueño= new ArrayList<DueñoMascota>();
    
    public static void MenuDueños(){
        
        System.out.println("\nDueños de Mascotas existentes: ");
        
        
        if (arrDueño.size()==0){
            
            System.out.println("No hay Dueños registrados");
        }
        else{

            for (int i=0;i<arrDueño.size();i++){
                System.out.println("-"+arrDueño.get(i).nombre+" ID: "+arrDueño.get(i).getCedulaIdentidad());
        }
        }
        
        
        System.out.println("\n------Menú de opciones de dueños------");
        System.out.println("1.Crear dueño ");
        System.out.println("2.Editar dueño ");
        System.out.println("3.Regresar al menú principal ");
        
        Scanner sc= new Scanner(System.in);

        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch(opcion){

            case 1:
                System.out.print("\nIngrese la cedula del Dueño: ");
                String cedula = sc.nextLine();
                System.out.print("Ingrese los nombres: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese los apellidos: ");
                String apellido= sc.nextLine();
                System.out.print("Ingrese la direccion: ");
                String direccion= sc.nextLine();
                System.out.print("Ingrese un numero de telefono: ");
                String telefono= sc.nextLine();
                System.out.print("Ingrese la ciudad: ");
                String ciudad= sc.nextLine();
                System.out.print("Ingrese un E-mail: ");
                String correo= sc.nextLine();
                
                DueñoMascota dueño = new DueñoMascota(cedula,apellido,nombre,direccion, telefono,ciudad, correo);
                arrDueño.add(dueño);
                System.out.println("\n¡¡¡Dueño "+ dueño.nombre+ " registrado exitosamente!!!");
                
                System.out.println("\n1.Regresar al menú Dueño");
                System.out.println("2.Regresar al menú principal");
                System.out.print("Elige una opción: ");
                opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminDueños.MenuDueños();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
            
             break;


            case 2: 
                
                DueñoMascota modificable = null;
                int x=0;
                do{
                    if(x>0){
                        System.out.println("--- Id de dueño no encontrado ---");
                    }
                    System.out.print("\nIngrese el id del dueño que quiere modificar: ");
                    String id = sc.nextLine();
                    modificable = new DueñoMascota(id,"");
                    x++;
                }while(!(arrDueño.contains(modificable)));
                
                for(int i=0;i<arrDueño.size();i++){
                    if(arrDueño.get(i).equals(modificable)){
                        modificable = arrDueño.get(i);
                        i=arrDueño.size();
                    }
                }
                 
                System.out.println("1. Modificar nombre");
                System.out.println("2. Modificar apellido");
                System.out.println("3. Modificar direccion");
                System.out.println("4. Modificar telefono");
                System.out.println("5. Modificar ciudad");
                System.out.println("6. Modificar correo");
                System.out.println("7. Terminar modificacion");
//                se crea el menu para elegir las opciones de modificacion 
                int op = 0;
                while (op != 7){
                    System.out.print("\nElige una opción: ");
                    op = sc.nextInt();
                    sc.nextLine();
                    if (modificable!=null){
                        switch(op){
                            case 1:
                                System.out.print("\nIngrese los nombres: ");
                                String nombreM = sc.nextLine();
                                modificable.setNombre(nombreM);
                                break;
                            case 2:
                                System.out.print("Ingrese los apellidos: ");
                                String apellidoM= sc.nextLine();
                                modificable.setApellido(apellidoM);
                                break;
                            case 3:
                                System.out.print("Ingrese la direccion: ");
                                String direccionM= sc.nextLine();
                                modificable.setDireccion(direccionM);
                                break;
                            case 4:
                                System.out.print("Ingrese un numero de telefono: ");
                                String telefonoM= sc.nextLine();
                                modificable.setTelefono(telefonoM);
                                break;
                            case 5:
                                System.out.print("Ingrese la ciudad: ");
                                String ciudadM= sc.nextLine();
                                modificable.setCiudad(ciudadM);
                                break;
                            case 6:
                                System.out.print("Ingrese un E-mail: ");
                                String correoM= sc.nextLine();
                                modificable.setEmail(correoM);
                                break;
                        }
                    }else{
                        System.out.println("Este usuario no se encontró");
                        System.out.println("");
                    }
                }
//                aqui aparecen las opciones para elegir un menu de nuevo 
                System.out.println("\nModificacion terminada.");
                System.out.println("1.Regresar al menú Dueño");
                System.out.println("2.Regresar al menú principal");
                System.out.print("Elige una opción: ");
                opcion= sc.nextInt();
                sc.nextLine();
                if (opcion==1){
                    AdminDueños.MenuDueños();
                }
                else if (opcion==2){
                    NewMain.menuPrincipal();
                }
             break;


            case 3: NewMain.menuPrincipal();

            default: System.out.println("Opción no existente");
                    MenuDueños();  
                    
                    

        
        } 
    }
    
        
}