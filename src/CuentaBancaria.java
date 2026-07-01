public class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    protected double saldo;
    private double tasaInteres;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial, double tasaInteres) {
        if (saldoInicial < 0) {
            System.out.println("ERROR: El saldo inicial no puede ser negativo");
            this.saldo = 0;
        } else {
            this.saldo = saldoInicial;
        }

        if (tasaInteres < 0) {
            System.out.println("ERROR: La tasa de interés no puede ser negativa");
            this.tasaInteres = 0;
        } else {
            this.tasaInteres = tasaInteres;
        }

        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
    }

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.printf("Depósito exitoso de $%.2f. Nuevo saldo: $%.2f%n", monto, this.saldo);
        } else {
            System.out.println("ERROR: El monto a depositar debe ser positivo");
        }
    }

    // dejarlo vacio, e
    public void retirar(double monto) {

    }

    public void aplicarInteres() {

        double interesGenerado = this.saldo * (this.tasaInteres / 100);
        this.saldo += interesGenerado;
        System.out.printf("Interés aplicado a la cuenta %s: $%.2f generado (Tasa: %.1f%%). Nuevo saldo: $%.2f%n", this.numeroCuenta, interesGenerado, this.tasaInteres, this.saldo);
    }

    public void mostrarInfo() {
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo Actual: $%.2f%n", saldo);
        System.out.println("Tasa de Interés Anual: " + tasaInteres + "%");
    }


}
