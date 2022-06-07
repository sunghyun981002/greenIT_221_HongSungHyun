package atm;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	public static FileManager instance = new FileManager();
	
	String fileName ="atmData.txt";
	
	public void saveDate() {
		UserManager userManager = UserManager.instance;
		
		
		if(userManager.userSize() ==0) return;
		
		String data="";
		data += userManager.userSize();
		data += "\n";
		
		for(int i=0; i<userManager.userSize(); i++) {
			data += userManager.getId(i); data+="/";
			data += userManager.getPw(i); data+="/";
			data += userManager.getName(i);
			
			if(userManager.getAccCnt(i)>0) {
				data += "/";
				for(int j=0; j<userManager.getAccCnt(i); j++) {
//					for(int k=0; k< userManager.getUserAccList(j).size(); k++) {
						data += userManager.getUserAccList(i).get(j).getAccNum();
						data += "/";
						data += userManager.getUserAccList(i).get(j).getMoney();
						
						if(j!=userManager.getAccCnt(i)-1 ) {
							data += "/";
						}
						
//					}
				}
			}
			if(i!= userManager.userSize() -1) {
				data += "\n";
			}
			
		}
		FileWriter fw =null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			
			System.out.println("파일저장완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fw != null) {try {fw.close();} catch (IOException e) {}}
		}
	}

	

}
