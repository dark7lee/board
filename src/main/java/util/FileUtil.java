package util;

public class FileUtil {

	public static String getFileName(String contexdtDisposition) {
		//form-data
		// name=\"profile\" 
		// filename=\"Tulips.jpg\"
		String[] headers = contexdtDisposition.split(";"); 
		String fileName = null;
		for(String header : headers){
			if(header.startsWith(" filename=")){
				fileName = header.substring(" filename=".length() + 1, header.length() - 1 );
				break;
			}
		}
		return fileName;
	}
	
}
