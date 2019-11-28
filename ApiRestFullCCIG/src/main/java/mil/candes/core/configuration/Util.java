package mil.candes.core.configuration;

public class Util {
	
	public final static String getNombreArchivo(String nombreOriginal) {
		
		return System.currentTimeMillis()+"_"+nombreOriginal;
	}

}
