import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("=== Bienvenido al conversor de monedas ===");
        System.out.print("Ingresa la cantidad que deseas convertir: ");
        double amount = scanner.nextDouble();

        System.out.print("Introduce el origen de la moneda: (ejemplos: \n" +
                "(USD: Dólar estadounidense), (EUR: Euro), (MXN: Peso mexicano), (JPY: Yen japonés), " +
                "(GBP: Libra esterlina), (AUD: Dólar australiano), (CAD: Dólar canadiense), " +
                "(CNY: Yuan chino), (KRW: Won surcoreano)");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Introduce a que moneda la quieres convertir: ");
        String toCurrency = scanner.next().toUpperCase();

        double result = converter.convert(amount, fromCurrency, toCurrency);
        System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, result, toCurrency);
    }
}
