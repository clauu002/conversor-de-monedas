import com.google.gson.Gson;

public class CurrencyConverter {
    private final ExchangeRateService exchangeRateService;

    public CurrencyConverter() {
        this.exchangeRateService = new ExchangeRateService();
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        double exchangeRate = 0;
        try {
            exchangeRate = exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return amount * exchangeRate;
    }
}