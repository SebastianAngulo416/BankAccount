public class CuentaEmpresarial extends CuentaBancaria {
    private String nombreEmpresa;
    private String rut;
    private double comisionRetiro;

    public CuentaEmpresarial(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, String rut) {
        super(numeroCuenta, titular, saldoInicial, 1.5);
        this.nombreEmpresa = nombreEmpresa;
        this.rut = rut;
        this.comisionRetiro = 2000.0;

        if (saldoInicial < 100000) {
            System.out.printf("ERROR: No se puede abrir la cuenta empresarial %s. Saldo mínimo requerido: $100,000.%n", numeroCuenta);
        }
    }

    @Override
    public void retirar(double monto) {
        double costoTotal = monto + comisionRetiro;

        if (costoTotal <= this.saldo) {
            this.saldo -= monto;
            this.saldo -= comisionRetiro;
            System.out.println("Retiro exitoso de la Empresa.");
            System.out.printf("Comisión por retiro cobrada: $%.2f%n", comisionRetiro);
            System.out.printf("Nuevo saldo: $%.2f%n", this.saldo);
        } else {
            System.out.printf("ERROR: Saldo insuficiente. El retiro más la comisión ($%.2f) supera tu saldo corporativo de $%.2f%n", costoTotal, this.saldo);
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("RUT: " + rut);
        System.out.println("Tipo de Cuenta: Empresarial");
    }
}
