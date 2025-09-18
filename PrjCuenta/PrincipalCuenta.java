import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrincipalCuenta
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cuenta> cuentas = new ArrayList<>();
        int actual = -1;
        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenú principal");
            System.out.println("1) Crear Cuenta");
            System.out.println("2) Conocer la cantidad de Cuentas Creadas");
            System.out.println("3) Listar Cuentas");
            System.out.println("4) Seleccionar Cuenta actual");
            System.out.println("5) Depositar");
            System.out.println("6) Retirar");
            System.out.println("7) Consultar Saldo");
            System.out.println("8) Consultar Estado (toString)");
            System.out.println("9) Establecer/Modificar nombre cuenta habiente");
            System.out.println("0) Salir");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1": {
                    System.out.print("Nombre de la cuenta (opcional, dejar en blanco si se desea): ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine();
                    Cuenta c;
                    if (nombre.isEmpty())
                        c = new Cuenta(saldo);
                    else
                        c = new Cuenta(nombre, saldo);
                    cuentas.add(c);
                    actual = cuentas.size() - 1;
                    System.out.println("Cuenta creada y seleccionado (índice " + actual + ").");
                    break;
                }
                case "2": { 
                    if (cuentas.isEmpty()) {
                        System.out.println("Cree una cuenta primero.");
                        break;
                    }
                    System.out.println("Número de cuentas creadas: " + Cuenta.getCantCuentasCreadas());
                    break;
                }
                case "3": { 
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creadas.");
                    } else {
                        System.out.println("Índice | Saldo | Código Cuenta");
                        for (int i = 0; i < cuentas.size(); i++) {
                            Cuenta c = cuentas.get(i);
                            System.out.printf("  %d    | %.2f | %s%n",
                                    i,
                                    c.getSaldo(),
                                    c.getCodCuenta());
                        }
                    }
                    break;
                }
                case "4": { 
                    if (cuentas.isEmpty()) {
                        System.out.println("Cree una cuenta primero.");
                        break;
                    }
                    System.out.print("Índice de la cuenta a seleccionar: ");
                    String idxS = sc.nextLine().trim();
                    try {
                        int idx = Integer.parseInt(idxS);
                        if (idx >= 0 && idx < cuentas.size()) {
                            actual = idx;
                            System.out.println("Cuenta índice " + actual + " seleccionado.");
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;
                }
                case "5": { 
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear y seleccionar una cuenta primero.");
                        break;
                    }
                    Cuenta c = cuentas.get(actual);
                    System.out.print("Ingrese el monto a depositar: ");
                    Double deposito = sc.nextDouble();
                    sc.nextLine();
                    System.out.printf("Saldo actual: %.2f%n", c.depositar(deposito));
                    break;
                }
                case "6": { 
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear y seleccionar una cuenta primero.");
                        break;
                    }
                    Cuenta c = cuentas.get(actual);
                    System.out.print("Ingrese el monto a retirar: ");
                    Double retiro = sc.nextDouble();
                    sc.nextLine();
                    System.out.printf("Saldo actual: %.2f%n", c.retirar(retiro));
                    break;
                }
                case "7": { 
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear y seleccionar una cuenta primero.");
                        break;
                    }
                    System.out.println("Saldo actual: " + cuentas.get(actual).getSaldo());
                    break;
                }
                case "8": { 
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear y seleccionar un rover primero.");
                        break;
                    }
                    System.out.println(cuentas.get(actual).toString());
                    break;
                }
                case "9": { 
                    if (actual < 0 || cuentas.isEmpty()) {
                        System.out.println("Debe crear y seleccionar un rover primero.");
                        break;
                    }
                    System.out.print("Ingrese el nuevo nombre de la cuenta: ");
                    String nombreCuenta = sc.nextLine().trim();
                    cuentas.get(actual).setNombreCuentaCuentaHabiente(nombreCuenta);
                    System.out.println("Nombre cambiado exitosamente.");
                    break;
                }
                case "0": {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                }
                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}