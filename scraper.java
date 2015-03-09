import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class scraper {
	
	public static void scrapy_print(String input_url) throws IOException{
		//printed den url inhalt direkt und die länge
		URL u = new URL(input_url);
		URLConnection conn = u.openConnection();
		BufferedReader in = new BufferedReader(
		                        new InputStreamReader(
		                            conn.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) 
		    buffer.append(inputLine);
		in.close();
		System.out.println(buffer.toString());
		System.out.println("Länge: "+buffer.length());
		
	}
	
	public static String[] id_scrape() throws IOException{
				// archiv anschauen
				
				String archiv_html = scrapy_return("http://pastebin.com/archive");
				String abfrage = "<tr>"; // rausfiltern von <tr> in dem relevante info steht ( ID)
				int first = archiv_html.indexOf(abfrage);//grenzen um daten auf relevante info zu kürzen
				int last = archiv_html.lastIndexOf(abfrage);
				
				System.out.println("\n"+"erster treffer: "+first +"\n"+"zweiter treffer: "+last);
				
				String archiv_firstcut = archiv_html.substring(first,last); // neuer String mit dem gearbeitet wird enthält nur <tr> blocks
				
				
				int [] id_collection = new int [149];//container für die indexe von href auf die die ID folgen wird
				
				int id_counter=0;
				for(int i=0;i<archiv_firstcut.length()-15;i++){ // fügt indexe von href hinzu und filtert /archive raus 
					
					if(archiv_firstcut.substring(i,i+4).equals("href") && archiv_firstcut.substring(i,i+15).equals("href=\"/archive/")==false){	
						//System.out.println(i); printed indexe
						
						id_collection[id_counter]=i;//sammelt die indexe
						id_counter++;
					}
					
				}
				
				System.out.println("ANZAHL \n"+id_counter);
				/** printed indexe
				for(int k=0;k<149;k++){
						System.out.println(id_collection[k]);
						
					}
					*/
					
				String [] IDs=new String [149];//neuer string array der als behälter für die IDS gilt
				
				for(int l=0;l<149;l++){
					IDs[l] ="http://pastebin.com/raw.php?i="+ archiv_firstcut.substring(id_collection[l]+7,id_collection[l]+15);
					//wegschneiden irrelevanter character übrig bleibt die paste ID und wird gespeichert in STRING ARRAY ID
					
				}
				for(int l=0;l<149;l++){
					System.out.println(IDs[l]);
					//gibt IDs aus
					
				}
				
			
		return IDs;
	}
	
public static String scrapy_return(String input_url) throws IOException{
		// gibt den url inhalt als string result zurück
		URL u = new URL(input_url);
		URLConnection conn = u.openConnection();
		BufferedReader in = new BufferedReader(
		                        new InputStreamReader(
		                            conn.getInputStream()));
		StringBuffer buffer = new StringBuffer();
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) 
		    buffer.append(inputLine);
		in.close();
		
		
		
		String result =buffer.toString();
		
		return result;
	}
	
}
