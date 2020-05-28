package Main;

import java.io.IOException;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.json.*;
import javax.swing.*;


public class Main {


    public static void main(String[] args) throws JSONException {
        final String apiKey = "kiRrdy1Kd5xyTFUzuBnqN3eeSWqcU7BqtVFw0ORVRb1euDIMn44Hu5VINcA3dQCf6BxiCfibRLqvlfLCwXzFeExSg65REredGCL16W1EOVm6vMDfbjS-wL2HNVqeXnYx";

        OkHttpClient client = new OkHttpClient(); // creates new HttpClient (client)

        JPanel panel = new JPanel();
        JRadioButton button1 = new JRadioButton("$");
        button1.setActionCommand("1");
        JRadioButton button2 = new JRadioButton("$$");
        button2.setActionCommand("2");
        JRadioButton button3 = new JRadioButton("$$$");
        button3.setActionCommand("3");
        JRadioButton button4 = new JRadioButton("$$$$");
        button4.setActionCommand("4");
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        ButtonGroup group = new ButtonGroup(); // mutually exclusive radio buttons
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

        JTextField term_fld = new JTextField(); // term field
        JTextField location_fld = new JTextField(); // location field
        JTextField limit_fld = new JTextField(); // limit field

        ImageIcon icon = new ImageIcon("src/main/resources/CELogo.png");

        Object[] fields = {
                "Term", term_fld,
                "Location", location_fld,
                "Price", panel,
                "Limit", limit_fld
        };

        // Display UI
        JOptionPane.showConfirmDialog(null, fields, "COVID Essentials", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION, icon);
        String newRequest = getSearchTerms(term_fld, location_fld, group, limit_fld);

        Request request = new Builder() // sends a request, which consists of the URL built using the criteria above
                .url("https://api.yelp.com/v3/businesses/search?" + newRequest)
                .get()
                .addHeader("Authorization", "Bearer" + " " + apiKey)
                .build();

        try {
            Response response = client.newCall(request).execute(); // client issues a new call using the request built (using the URL constructed above), and executes

            // Grab response and put into a json array for ease of use
            JSONObject jsonObject = new JSONObject(response.body().string().trim());
            JSONArray myResponse = (JSONArray) jsonObject.get("businesses");

            // Parse out json
            Output newOutput = new Output();
            String output = newOutput.displayOutput(myResponse);
            // Display output
            JOptionPane.showMessageDialog(null, output, "COVID Essentials", JOptionPane.NO_OPTION, icon);
        }
        catch(IOException e){
            e.printStackTrace(); // if there's an error, it is caught and the stacktrace is returned
        }
    }

    static String getSearchTerms(JTextField term_fld, JTextField location_fld, ButtonGroup group, JTextField limit_fld) {
        String searchString;

        String term = term_fld.getText();
        String location = location_fld.getText();
        String limit = limit_fld.getText();
        String price = group.getSelection().getActionCommand();

        searchString = "location=";
        searchString += location + "&term=";
        searchString += term + "&limit=";
        searchString += limit + "&price=";
        searchString += price + "&sort_by=rating";

        return searchString;
    }

}