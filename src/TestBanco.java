public class TestBanco {
    public static void main(String[] args) {

        // Se crean las cuentas
        CuentaAhorro cuentaAna = new CuentaAhorro("AH001", "Ana Perez", 50000, "2024-01-15");

        CuentaCorriente cuentaLuis = new CuentaCorriente("CC001", "Luis Gomez", 20000);

        CuentaEmpresarial cuentaTech = new CuentaEmpresarial("EM001", "Tech Solutions", 200000.0, "Tech Solutions", "123456789-0");

        CuentaAhorro cuentaMaria = new CuentaAhorro("AH002", "Maria Lopez", 15000, "2024-02-01");

        // Se utiliza el metodo mostrarinfo() para imprimir en consola la informacion
        System.out.println("--- Informacion ---");

        System.out.println("---------");
        cuentaAna.mostrarInfo();
        System.out.println("---------");
        cuentaLuis.mostrarInfo();
        System.out.println("---------");
        cuentaTech.mostrarInfo();
        System.out.println("---------");
        cuentaMaria.mostrarInfo();

        System.out.println("---- Operaciones ----");

        System.out.println("Ana Perez deposita $10.000:");
        cuentaAna.depositar(10000.0);

        System.out.println("\nLuis Gomez retira $25.000:");
        cuentaLuis.retirar(25000.0);

        System.out.println("\nTech Solutions retira $10.000:");
        cuentaTech.retirar(10000.0);

        System.out.println("\nMaria Lopez intenta retirar $20.000:");
        cuentaMaria.retirar(20000.0);
        System.out.println();

        System.out.println("---- Aplicar Interes ----");
        cuentaAna.aplicarInteres();
        cuentaLuis.aplicarInteres();
        cuentaTech.aplicarInteres();
        cuentaMaria.aplicarInteres();
        System.out.println();

        System.out.println("---- Estado Final de las Cuentas ----");

        cuentaAna.mostrarInfo();
        System.out.println("---------");
        cuentaLuis.mostrarInfo();
        System.out.println("---------");
        cuentaTech.mostrarInfo();
        System.out.println("---------");
        cuentaMaria.mostrarInfo();
        System.out.println();


        int totalCuentas = 4;
        // se suma los saldos usando los Getters
        double saldoTotal = cuentaAna.getSaldo() + cuentaLuis.getSaldo() + cuentaTech.getSaldo() + cuentaMaria.getSaldo();
        double promedioSaldo = saldoTotal / totalCuentas;

        // buscar cual es la cuenta con mayor saldo, y la comparamops de forma manual o una por una
        CuentaBancaria cuentaMayor = cuentaAna;

        if (cuentaLuis.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaLuis;
        }
        if (cuentaTech.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaTech;
        }
        if (cuentaMaria.getSaldo() > cuentaMayor.getSaldo()) {
            cuentaMayor = cuentaMaria;
        }

        System.out.println("Total de cuentas activas: " + totalCuentas);
        System.out.printf("Saldo total de todas las cuentas: $%.2f%n", saldoTotal);
        System.out.printf("Promedio de saldo: $%.2f%n", promedioSaldo);

        System.out.println("\nCuenta con el mayor saldo:");
        System.out.println("Número de cuenta: " + cuentaMayor.getNumeroCuenta());
        System.out.println("Titular: " + cuentaMayor.getTitular());
        System.out.printf("Saldo: $%.2f%n", cuentaMayor.getSaldo());








    }
}