package Main;

import java.io.IOException;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.json.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Main {

    public static void main(String[] args) throws JSONException {
        final String apiKey = "kiRrdy1Kd5xyTFUzuBnqN3eeSWqcU7BqtVFw0ORVRb1euDIMn44Hu5VINcA3dQCf6BxiCfibRLqvlfLCwXzFeExSg65REredGCL16W1EOVm6vMDfbjS-wL2HNVqeXnYx";

        OkHttpClient client = new OkHttpClient(); // creates new HttpClient (client)

        JTextField term_fld = new JTextField(); // term field
        JTextField location_fld = new JTextField();
        JTextField price_fld = new JTextField();
        JTextField limit_fld = new JTextField();

        Object[] fields = {
                "Term", term_fld,
                "Location", location_fld,
                "Price", price_fld,
                "Limit", limit_fld
        };

        JOptionPane.showConfirmDialog(null, fields, "COVID Essentials", JOptionPane.OK_CANCEL_OPTION);
        String newRequest = getSearchTerms(term_fld, location_fld, price_fld, limit_fld);

        Request request = new Builder() // sends a request, which consists of the URL built using the criteria above
                .url("https://api.yelp.com/v3/businesses/search?" + newRequest)
                .get()
                .addHeader("Authorization", "Bearer" + " " + apiKey)
                .build();

        try {
            Response response = client.newCall(request).execute(); // client issues a new call using the request built (using the URL constructed above), and executes

            //System.out.println(response.body().string()); // prints out the response from the call as a string

            JSONObject jsonObject = new JSONObject(response.body().string().trim());
            JSONArray myResponse = (JSONArray) jsonObject.get("businesses");

            Output newOutput = new Output();
            String output = newOutput.displayOutput(myResponse);
            JOptionPane.showMessageDialog(null, output);
        }
        catch(IOException e){
            e.printStackTrace(); // if there's an error, it is caught and the stacktrace is returned
        }
    }

    static String getSearchTerms(JTextField term_fld, JTextField location_fld, JTextField price_fld, JTextField limit_fld) {
        String searchString;

        String term = term_fld.getText();   // retrieves text from term field
        String location = location_fld.getText();
        String price = price_fld.getText();
        String limit = limit_fld.getText();

        searchString = "location=";
        searchString += location + "&term=";
        searchString += term + "&limit=";
        searchString += limit + "&price=";
        searchString += price + "&sort_by=rating";

        return searchString;
    }
}

