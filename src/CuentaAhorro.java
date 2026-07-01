public class CuentaAhorro extends CuentaBancaria {
    private String fechaApertura;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, String fechaApertura) {

        super(numeroCuenta, titular, saldoInicial, 2.5);

        if (saldoInicial < 10000) {
            System.out.printf("ERROR: No se puede abrir la cuenta %s. El saldo mínimo requerido es $10,000.%n", numeroCuenta);
        }
        this.fechaApertura = fechaApertura;
    }

    @Override
    public void retirar(double monto) {
        if (monto <= this.saldo) {
            this.saldo -= monto;
            System.out.printf("Retiro exitoso de $%.2f. Nuevo saldo: $%.2f%n", monto, this.saldo);
        } else {
            System.out.printf("ERROR: Saldo insuficiente en cuenta de ahorros. Saldo disponible: $%.2f%n", this.saldo);
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Fecha de Apertura: " + fechaApertura);
        System.out.println("Tipo de Cuenta: Ahorros");
    }
}
