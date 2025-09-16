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
        return saldo;
    }
    
    public double retirar(double monto) {
        return saldo;
    }
    
    private boolean validarRetiro(double monto) {
        return monto < saldo;
    }
    
    public static int getCantCuentasCreadas() {
        return cantCuentasCreadas;
    }
    
    public String toString() {
        return codCuenta;
    }
}