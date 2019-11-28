package mil.candes.core.configuration;

//rutas ApiRestFullCCIG
public class Routes {

	public final static String host = "http://localhost:8090";

	// API
	public final static String api = "/api";
	public final static String mm = "/mm";

	public final static String datosFormularioCargaMM = "/datoscarga";
	public final static String destinos = datosFormularioCargaMM + "/destinos/all";
	public final static String destino = datosFormularioCargaMM + "/destinos/{descripcion}";
	public final static String precedencias = datosFormularioCargaMM + "/precedencias";
	public final static String promotores = datosFormularioCargaMM + "/promotor/all";
	public final static String promotor = datosFormularioCargaMM + "/promotor/{descripcion}";
	public final static String promotorId= mm+"/promotor/{id}";
	public final static String seguridades = datosFormularioCargaMM + "/seguridades";
	public final static String seguridad = mm + "/seguridad/{id}";
	public final static String guardarMM = mm + "/guardarentidad";
	public final static String guardarArchivoMM = mm + "/guardararchivo";
	public final static String obtenerTodosMensajesMilitares = mm + "/all";
	public final static String obtenerMensajeMilitar=mm+"/{id}";
	public final static String guardarMMdesdePdf = mm+"/guardardesdepdf";

	public final static String login = "/login";
	
	public final static String workDirectory = "/Users/javiermoreno/Downloads/Ejercito/ccig/pdfFiles/";

	// clientRest
	public final static String cargarmm = "/cargarmm";
	public final static String root = "/v1";
	public final static String ccig = "/ccig";
	
	
}
