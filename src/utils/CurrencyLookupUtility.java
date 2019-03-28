package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class CurrencyLookupUtility {

	private URL url;
	private JsonObject apiJsonObj;	
	private String apiPath = "https://poe.ninja/api/data/currencyoverview?league=Synthesis&type=Currency";
	private String backupJsonPath = "TestLogs/currencyoverview.json";
	private String userAgentString =  "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";

	public boolean connectToApi() {
		boolean output = false;
		
		try {
			url = new URL(apiPath);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("User-Agent", userAgentString);
			int status = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			
			if(verifyStatusGood(status)) {
				System.out.println("Content Valid Response");
				JsonParser parser = new JsonParser();
				apiJsonObj = parser.parse(content.toString()).getAsJsonObject();
				
				//System.out.println(o.toString());
				output = true;
			}

			con.disconnect();
			
		} catch (IOException e) {
			System.out.println("IO exception on currency lookup");
			
			e.printStackTrace();
		}
		
		return output;
	}
	
	public JsonObject getApiJsonObj() {
		return apiJsonObj;
	}
	
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	
	public boolean verifyStatusGood(int status) {
		if (status >= 200 && status < 300) {
			return true;
		}
		
		return false;		
	}
	
	public JsonObject getDefaultCurrencyValuesJson() {		
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = null;
		try {
			jsonObj = parser.parse(FileUtils.fileToStringUtf8(backupJsonPath)).getAsJsonObject();
			//System.out.println(jsonObj);
		} catch (JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

}
