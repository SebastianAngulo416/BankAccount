public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private double porcentajeComisionSobregiro;

    // Constructor Principal
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobregiro, double porcentajeComisionSobregiro) {

        super(numeroCuenta, titular, saldoInicial, 0.0);
        this.limiteSobregiro = limiteSobregiro;
        this.porcentajeComisionSobregiro = porcentajeComisionSobregiro;
    }

    // Constructor Secundario
    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 50000.0, 5.0);
    }

    @Override
    public void retirar(double monto) {

        if (monto <= (this.saldo + this.limiteSobregiro)) {

            double saldoAnterior = this.saldo;

            this.saldo -= monto;

            System.out.printf("Retiro exitoso de $%.2f en Cuenta Corriente.%n", monto);


            if (this.saldo < 0) {

                double montoSobregirado = Math.abs(this.saldo);

                double comision = montoSobregirado * (this.porcentajeComisionSobregiro / 100);

                this.saldo -= comision;
                System.out.printf("¡ALERTA SOBREGIRO! Comisión por sobregiro (%.1f%%): $%.2f%n", porcentajeComisionSobregiro, comision);
            }

            System.out.printf("Nuevo saldo: $%.2f%n", this.saldo);

        } else {
            System.out.println("ERROR: Operación rechazada. El monto supera el límite de sobregiro permitido");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.printf("Límite de Sobregiro Permitido: $%.2f%n", limiteSobregiro);
        System.out.println("Tipo de Cuenta: Corriente");
    }
}
