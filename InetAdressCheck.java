package net.ukr.andy777;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class InetAdressCheck {

	private Map<String, String> result = new HashMap<String, String>();

	public InetAdressCheck() {
		super();
	}

	public void loadAdressFromFile(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String urlAdress = "";
			for (; (urlAdress = br.readLine()) != null;) {
				if (!result.containsKey(urlAdress)) {
					result.put(urlAdress, checkOneURL(urlAdress));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getResult() {
		return this.result;
	}

	public String checkOneURL(String urlAdress) {
		try {
			URL url = new URL(urlAdress);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int responceCode = con.getResponseCode();
			if (responceCode >= 200 && responceCode < 300) {
				return "YES";
			} else {
				return "NO: " + responceCode + " - " + con.getResponseMessage();
			}
		} catch (IOException e) {
			return "NO - not registed";
		}
	}
}
