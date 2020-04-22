import java.io.IOException;
import okhttp3.*;
import okhttp3.Request.Builder;
import org.json.*;


public class Main {

    public static void main(String[] args) throws JSONException, IOException{
        final String apiKey = "kiRrdy1Kd5xyTFUzuBnqN3eeSWqcU7BqtVFw0ORVRb1euDIMn44Hu5VINcA3dQCf6BxiCfibRLqvlfLCwXzFeExSg65REredGCL16W1EOVm6vMDfbjS-wL2HNVqeXnYx";
        // client id = yMAnFw28CmV0e5uPXObrJg

        OkHttpClient client = new OkHttpClient();
        String term = "seafood";
        String location = "Las Vegas";
        String price = "1"; // By dollar sign
        String limit = "5"; // Number of results

        Request request = new Builder()
                .url("https://api.yelp.com/v3/businesses/search?term=" + term + "&location=" + location + "&limit=" +limit + "&sort_by=rating&price=" + price +"")
                .get()
                .addHeader("Authorization", "Bearer" + " " + apiKey)
                .build();

        try {
            Response response = client.newCall(request).execute();

            System.out.println(response.body().string());

            /*JSONObject jsonObject = new JSONObject(response.body().string().trim());
            JSONArray myResponse = (JSONArray) jsonObject.get("businesses");
            System.out.println(myResponse.getJSONObject(0).getString("id")); */
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
