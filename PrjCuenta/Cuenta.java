import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta
{
    private String codCuenta = "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosRealizados;
    private static int cantCuentasCreadas;
    
    Cuenta(String nombreCuentaHabiente, double pSaldo) {
        this(pSaldo);
        this.nombreCuentaHabiente = nombreCuentaHabiente;
    }
    
    Cuenta(double pSaldo){
        saldo = pSaldo;
        fechaCreacion = determinarFechaCreacion();
        cantCuentasCreadas++;
        codCuenta += cantCuentasCreadas;
    }
    
    public void setNombreCuentaCuentaHabiente(String pNombreCuentaHabiente) {
        nombreCuentaHabiente = pNombreCuentaHabiente;
    }
    
    public String getCodCuenta() {
        return codCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public double depositar(double monto) {
        if(validarDeposito(monto)){
            saldo += monto;
            cantDepositosRealizados++;
        }
        return saldo;
    }
    
    public double retirar(double monto) {
        if(validarRetiro(monto)){
            saldo -= monto;
            cantRetirosRealizados++;
        }
        return saldo;
    }
    
    private boolean validarDeposito(double monto) {
        return monto > 0;
    }
    
    private boolean validarRetiro(double monto) {
        return monto <= saldo;
    }
    
    public static int getCantCuentasCreadas() {
        return cantCuentasCreadas;
    }
    
    public String toString() {
        String msg = "";
        
        msg += "-------- Información de la Cuenta ---------\n";
        msg += "Código de cuenta: " + codCuenta + "\n";
        msg += "Nombre de Cuenta Habiente: " + nombreCuentaHabiente + "\n";
        msg += "Saldo: " + saldo + "\n";
        msg += "Fecha de creación: " + fechaCreacion + "\n";
        msg += "Depositos realizados: " + cantDepositosRealizados + "\n";
        msg += "Retiros realizados: " + cantRetirosRealizados + "\n";
        return msg;
    }
    
    private String determinarFechaCreacion() {
        Date fecha = new Date(System.currentTimeMillis());
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        return formatoFecha.format(fecha);
    }
}