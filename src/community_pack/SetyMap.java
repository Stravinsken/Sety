package community_pack;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SetyMap {
	
	//웹페이지로 연결
	public void WebJoin() {
		String urlLink = "https://sety-5.hantaekyeong.repl.co/";
	      try {
	         //웹페이지 열기 시도
	         Desktop.getDesktop().browse(new URI(urlLink));
	      }catch(IOException e) {
	         //예외처리
	         e.printStackTrace();
	      }catch(URISyntaxException e) {
	         //예외처리
	         e.printStackTrace();
	      }
	}
}