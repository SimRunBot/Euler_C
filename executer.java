import java.io.IOException;


public class executer {
	
	public static void main(String[] args) throws IOException {
		
		strings string_converter = new strings();//object aufruf der strings class
		
		
		
		
		String formular="http://pastebin.com/raw.php?i=";//präfix um nur den inhalt vom paste zu kriegen
		String paste_id="zVuyyf1w"; // id des pastes
		String final_url=formular+paste_id; // beides zusammen gefügt
		System.out.println(final_url);
		
		scraper scrap = new scraper();//object aufruf der scraper class
		
		String content=	scrap.scrapy_return(final_url);// holt den paste inhalt
		System.out.println(content.length());//länge des pastes
		string_converter.output(content);//summe die entsteht wenn jeder char vom string in int(ascii) konvertiert und zusammenaddiert wird
		
		String [] id_container = new String[149];
		
		id_container = scrap.id_scrape();
		
		String final_inhalt, final_content;
		
		for(int k=0;k<149;k++){
			System.out.println(id_container[k]+"\n");
			final_content = scrap.scrapy_return(id_container[k]);
			System.out.println(" LAENGE : " +final_content.length()+"\n");
			string_converter.output(final_content);
			
		}
		
		
		
	}

}
