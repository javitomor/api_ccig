package mil.candes.core.configuration;

//rutas ApiRestFullCCIG
public class Routes {

	public final static String host = "http://localhost:8090";

	// API
	public final static String api = "/api";
	public final static String mm = "/mm";

	public final static String datosFormularioCargaMM = "/datoscarga";
	public final static String destinos = datosFormularioCargaMM + "/destinos";
	public final static String precedencias = datosFormularioCargaMM + "/precedencias";
	public final static String promotores = datosFormularioCargaMM + "/promotores";
	public final static String seguridades = datosFormularioCargaMM + "/seguridades";

	public final static String login = "/login";

	// clientRest
	public final static String cargarmm = "/cargarmm";
	public final static String root = "/v1";
	public final static String ccig = "/ccig";
}
