import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int buscarNumeroCuenta(Cuenta cuentas[], int n) {
        int i = 0, indice = 0;
        boolean encontrado = false;




        return n;
    }


    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);

        String nombre;
        String apellido;
        String dni;
        int numeroCuenta,nCuentas = 0,op;
        double saldo;
        Cuenta cuentas[];
        Cliente cliente;

        // Bienvenida
        System.out.printf("Bienvenido al banco Bañorte");

        //Verificacion de los datos del usuario (Cliente)
        System.out.printf("Ingrese su nombre del usuario: ");
        nombre = en.nextLine();
        System.out.printf("Ingrese su apellido del usuario: ");
        apellido = en.nextLine();
        System.out.printf("Ingrese su dni del usuario: ");
        dni = en.nextLine();

        // Pedimos el numero de cuentas que el usuario tiene a su disposicion
        System.out.printf("Digite cuantas numero de cuentas tiene");
        numeroCuenta = en.nextInt();
        cuentas = new Cuenta[nCuentas];

        // Registrar el numero de cuentas que el usuario ingreso
        for (int i = 0; i < cuentas.length; i++) {

            System.out.println("\nDigite los datos para la cuenta " + (i + 1) + " : ");
            System.out.println("Digite el numero de cuenta ");
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

            }


        }while (op != 4);



    }
}