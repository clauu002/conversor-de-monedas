import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ExchangeRateService {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/5937f741482a29fcd2532743/latest/";

    public double getExchangeRate(String sourceCurrency, String targetCurrency) throws Exception {
        // Construye la URL
        String requestUrl = API_URL + sourceCurrency;

        // Establece la conexión
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Verifica si la respuesta es exitosa (código 200)
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Error: " + responseCode);
        }

        // Lee la respuesta
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Parsea la respuesta JSON
        JSONObject jsonResponse = new JSONObject(response.toString());

        // Verifica si existe la clave "conversion_rates"
        if (!jsonResponse.has("conversion_rates")) {
            throw new RuntimeException("Error: 'conversion_rates' not found in the response.");
        }

        JSONObject rates = jsonResponse.getJSONObject("conversion_rates");

        // Obtiene la tasa de conversión
        if (!rates.has(targetCurrency)) {
            throw new RuntimeException("Error: Target currency not found.");
        }

        return rates.getDouble(targetCurrency);
    }
}
