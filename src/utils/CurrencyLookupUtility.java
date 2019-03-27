package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyLookupUtility {

	private URL url;

	public CurrencyLookupUtility() {
		connectToApi();
	}
	
	public boolean connectToApi() {
		boolean output = false;
		
		try {
			url = new URL("path");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			int status = con.getResponseCode();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			
			if (status >= 200 && status < 300) {
				System.out.println("Content Valid Response");
				JsonParser parser = new JsonParser();
				JsonObject o = parser.parse(content.toString()).getAsJsonObject();
				
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

}
