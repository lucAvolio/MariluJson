package data;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataGetter {
	
	public static void main(String[] args) {
		String [] arr = null;

			arr = getLinks("www.ebay.com","5001-Jewellery Design");
			for(String s: arr) {
				System.out.println(s);
			}

	}
	
	/*Restituisce i link puliti in formato stringa */
	public static String[] getLinks(String site, String resource) {
		JSONParser parser = new JSONParser();
		JSONObject middle = null;
		String[] arr = null;
		
		try {
			Object obj = parser.parse(new FileReader("prova.json"));
			JSONObject json = (JSONObject) obj;
			middle = (JSONObject) json.get(site);
			//JSONObject res = middle.get(resource);
			String var = middle.get(resource).toString();
			String values = var.replace("[", "").replace("]", "").replace("\"", "").replace("\\/", "/");
			//System.out.println(middle.values());
			//System.out.println(middle.entrySet());
			//System.out.println(s.size());
			arr = values.split(",");
			
		} catch (Exception e){
			System.out.println("Risorsa non presente per il sito specificato");
			System.out.println("Controllare sito internet e numero di risorsa");
		};
		
		
		return arr;
		
	}
	
}
