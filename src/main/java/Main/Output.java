package Main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Output {

    public String displayOutput(JSONArray response) throws JSONException {

        String name;
        String address;
        String phone;
        String output = "";

        for(int i = 0; i < response.length(); i++) {
            name = getName(response, i);
            address = getAddress(response, i);
            phone = getPhone(response, i);

            output += name + "\n";
            output += address + "\n";
            output += phone + "\n\n";
        }

        return output;
    }

    private static String getName(JSONArray response, int i) throws JSONException {

        return response.getJSONObject(i).getString("name");
    }

    private static String getAddress(JSONArray response, int i) throws JSONException {

        JSONObject object = (JSONObject) response.getJSONObject(i).get("location");
        JSONArray addressArray = (JSONArray) object.get("display_address");
        return addressArray.get(0).toString();
    }

    private static String getPhone(JSONArray response, int i) throws JSONException {

        return response.getJSONObject(i).getString(("display_phone"));
    }
}
