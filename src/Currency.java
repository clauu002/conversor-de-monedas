import java.util.Map;

public class Currency {
    private String base;
    private Map<String, Double> rates;

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}