package MainTest;

import BaseDatos.ConexionPSQL;
import Controlador.ControladorAcceso;
import Controlador.ControladorAgregarFalla;
import Controlador.ControladorEquipo;
import Controlador.ControladorPersonal;
import Modelo.ModeloAcceso;
import Modelo.ModeloCatalogoFallas;
import Modelo.ModeloEquipo;
import Modelo.ModeloPersonal;
import Vista.AltaFallaCatalogo;
import Vista.AltaSolucionCatalogo;
import Vista.VistaPersonal;
import Vista.VistaAcceso;
import Vista.VistaAgregarFallta;
import Vista.VistaDetalleCLiente;
import Vista.VistaEquipo;
import Vista.VistaPersonal;


public class MainTest {


	public static void main(String[] args) {
		
		
		//ACCESO YA SIRVE
		//ControladorAcceso acces = new ControladorAcceso(new ModeloAcceso(), new VistaAcceso());
		
		//PERSONAL YA SIRVE 
		//ControladorPersonal con = new ControladorPersonal(new ModeloPersonal(), new Personal());
		
		//YA SIRVE **PERO FALTA DE ACOMODAR LA VISTA**
		ControladorEquipo con = new ControladorEquipo(new ModeloEquipo(), new VistaEquipo());
		
		//ControladorAgregarFalla con = new ControladorAgregarFalla(new ModeloCatalogoFallas(), new VistaAgregarFallta());
		
		//ConexionPSQL con = new ConexionPSQL();
		
		//VistaAcceso vs = new VistaAcceso();
		
		//new AltaFallaCatalogo();
		
		//new AltaSolucionCatalogo();
		
		//new VistaAcceso();
		
		//new VistaAgregarFallta();
		
		//new VistaDetalleCLiente();
		
		//new VistaEquipo();
		
		//new VistaPersonal();
		
		//new Personal();

	}

}
