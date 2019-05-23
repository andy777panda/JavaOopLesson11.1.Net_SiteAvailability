package net.ukr.andy777;

import java.io.File;
import java.util.Map;
import java.util.Set;

/*
 Lesson11
 1. Проверить доступность сайтов указанных в отдельном файле.
 */

public class Main {
	public static void main(String[] args) {
		InetAdressCheck iac = new InetAdressCheck();
		File file = new File ("siteAdress.txt");
		iac.loadAdressFromFile(file);
		Map<String,String> result = iac.getResult();
		Set<String> adress=result.keySet();
		for(String urlAdress:adress){
			System.out.println(urlAdress + "\t"+result.get(urlAdress));
		}
	}
}
