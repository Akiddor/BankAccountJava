import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int buscarNumeroCuenta(Cuenta cuentas[], int n) {
        int i = 0, indice = 0;
        boolean encontrado = false;

        while ((i< cuentas.length) && (!encontrado)) {

            //Busqueda Secuencial

            if(cuentas[i].getNumeroCuenta() == n) {
                encontrado = true;
                indice = i;
            }

            i++;

        }

        if (encontrado == false) {
            indice = -1;
        }

        return indice;
    }


    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);

        String nombre;
        String apellido;
        String dni;
        int numeroCuenta,nCuentas = 0,op,indiceCuenta=0;
        double saldo,cantidad;
        Cuenta cuentas[];
        Cliente cliente;

        // Bienvenida
        System.out.printf("\nBienvenido al banco Bañorte");

        //Verificacion de los datos del usuario (Cliente)
        System.out.printf("\nIngrese su nombre del usuario: ");
        nombre = en.nextLine();
        System.out.printf("Ingrese su apellido del usuario: ");
        apellido = en.nextLine();
        System.out.printf("Ingrese su dni del usuario: ");
        dni = en.nextLine();

        // Pedimos el numero de cuentas que el usuario tiene a su disposicion
        System.out.print("Digite cuantas numero de cuentas tiene: ");
        nCuentas = en.nextInt();
        cuentas = new Cuenta[nCuentas];

        // Registrar el numero de cuentas que el usuario ingreso
        for (int i = 0; i < cuentas.length; i++) {

            System.out.println("\nDigite los datos para la cuenta " + (i + 1) + " : ");
            System.out.println("\nDigite el numero de cuenta ");
            numeroCuenta = en.nextInt();
            System.out.println("Digite el saldo de la cuenta");
            saldo = en.nextDouble();
            // Cuenta con el iterador i es igual a una nueva cuenta y le pasamos el numero de la cuenta y el saldo
            cuentas[i] = new Cuenta(numeroCuenta, saldo);

        }

        cliente = new Cliente(nombre,apellido,dni,cuentas);


        do {

            System.out.println("\t. :Menu:.");
            System.out.println("1. Ingresar dinero en la cuenta");
            System.out.println("2. Retirar dinero en la cuenta");
            System.out.println("3. Consultar dinero de la cuenta");
            System.out.println("4. Salir");
            System.out.println("Digite la opcion del menu: ");
            op = en.nextInt();

            switch (op) {
                case 1:
                    System.out.println("\nDigite el numero de cuenta ");
                    numeroCuenta = en.nextInt();
                    indiceCuenta = buscarNumeroCuenta(cuentas,numeroCuenta);

                    if (indiceCuenta == -1) {
                        System.out.println("\nEl numero de cuenta ingresado no existe");
                    }else {
                        System.out.println("\nDigite la cantidad de dinero a ingresar:");
                        cantidad = en.nextDouble();

                        cliente.ingresar_dinero(indiceCuenta,cantidad);
                        System.out.println("\nIngreso realizado correctamente");
                        System.out.println("Saldo disponible:   " + cliente.consultar_saldo(indiceCuenta) );
                    }
                    break;

                    case 2:
                        System.out.println("\nDigite el numero de cuenta ");
                        numeroCuenta = en.nextInt();
                        indiceCuenta = buscarNumeroCuenta(cuentas,numeroCuenta);

                        if (indiceCuenta == -1) {
                            System.out.println("\nEl numero de cuenta ingresado no existe");
                        }
                        else {
                            System.out.println("\nDigite la cantidad de dinero que desear retirar:");
                            cantidad = en.nextDouble();
                            if (cantidad > cliente.consultar_saldo(indiceCuenta)) {
                                System.out.println("\nSaldo insuficiente");
                            }else{
                                cliente.retirar_dinero(indiceCuenta,cantidad);
                                System.out.println("\nDinero retirado correctamente");
                                System.out.println("Saldo disponible: " + cliente.consultar_saldo(indiceCuenta));
                            }
                        }
                        break;
                        case 3:
                            System.out.println("\nDigite el numero de cuenta ");
                            numeroCuenta = en.nextInt();
                            indiceCuenta = buscarNumeroCuenta(cuentas,numeroCuenta);

                            if (indiceCuenta == -1) {
                                System.out.println("\nEl numero de cuenta ingresado no existe");
                            }
                            else {
                                System.out.println("Saldo disponible: " + cliente.consultar_saldo(indiceCuenta));

                            }
                        case 4:
                            break;
                default: System.out.println("Opcion no valida");

            }


        }while (op != 4);



    }
}