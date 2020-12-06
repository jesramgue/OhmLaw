package rycom.sisautovig;
/* Imports propios */

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class sisautovig extends Activity {
    /** Called when the activity is first created. */
	//private EditText texto;
    
    /**
     * Metodo onCreate Inicializa la vista del menu
     * @param savedInstanceState .
     */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Inicializacion del menu

        //Fin inicializacion del menu
    }
	private int contarCamposVacios() {
		int liVacios = 0;
		if (((EditText) findViewById(R.id.EditText01)).getText().toString().equals("")) {
			liVacios++;
		} if (((EditText) findViewById(R.id.EditText02)).getText().toString().equals("")) {
			liVacios++;
		} if (((EditText) findViewById(R.id.EditText03)).getText().toString().equals("")) {
			liVacios++;
		}
		return liVacios;
	}
	/**
	 * Controlador del boton 1.
	 * @param avVista Vista a controlar (donde se encuentra el boton)
	 */
    public void miControladorDeVista(View avVista) {
    	switch (avVista.getId()) {
    	case R.id.EditText01:
    		//((EditText) findViewById(R.id.EditText01)).setText("");
    		break;
    	case R.id.EditText02:
    		//((EditText) findViewById(R.id.EditText02)).setText("");
    		break;
    	case R.id.EditText03:
    		//((EditText) findViewById(R.id.EditText03)).setText("");
    		break;
    	case R.id.Button01:
    		if (contarCamposVacios() >= 2) {
    			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
    			//Mensaje: al menos 2 campos deben estar rellenos.
				alt_bld.setMessage("Error, debes introducir dos campos y dejar vacio el campo a calcular")  
				.setCancelable(true);  
				//Creamos la alerta
				AlertDialog alert = alt_bld.create();  
				// Titulo e icono 
				alert.setTitle("Alerta");    
				alert.setIcon(R.drawable.ley_de_ohm);
				//Y mostramos
				alert.show();
				 
    		} else if (contarCamposVacios() == 0){ //hay dos campos rellenos
    			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
    			//Mensaje: al menos 2 campos deben estar rellenos.
				alt_bld.setMessage("Error, no hay nada que calcular, deja un campo a vacio para calcularlo")  
				.setCancelable(true);  
				//Creamos la alerta
				AlertDialog alert = alt_bld.create();  
				// Titulo e icono 
				alert.setTitle("Alerta");    
				alert.setIcon(R.drawable.ley_de_ohm);
				//Y mostramos
				alert.show();
    		} else {
    			if (!((EditText) findViewById(R.id.EditText01)).getText().toString().equals("")) {
        			if (!((EditText) findViewById(R.id.EditText02)).getText().toString().equals("")) {
        				//Calculamos el tercer campo: INTENSIDAD = V / R
        				String lsVoltaje = ((EditText) findViewById(R.id.EditText01)).getText().toString();
        				String lsResistencia = ((EditText) findViewById(R.id.EditText02)).getText().toString();
        				double ldVolt = Double.parseDouble(lsVoltaje);
        				double ldRes = Double.parseDouble(lsResistencia);
        				double ldInt = ldVolt/ldRes;
        				((EditText) findViewById(R.id.EditText03)).setText(""+ldInt);
        			} else if(!((EditText) findViewById(R.id.EditText03)).getText().toString().equals("")) {
        				//Calculamos el segundo campo: RESISTENCIA = V / I
        				String lsVoltaje = ((EditText) findViewById(R.id.EditText01)).getText().toString();
        				String lsIntensidad = ((EditText) findViewById(R.id.EditText03)).getText().toString();
        				double ldVolt = Double.parseDouble(lsVoltaje);
        				double ldInt = Double.parseDouble(lsIntensidad);
        				double ldRes = ldVolt/ldInt;
        				((EditText) findViewById(R.id.EditText02)).setText(""+ldRes);
        			}
        		} else { //Calculamos el primer campo: VOLTAJE = R * I
        			String lsIntensidad = ((EditText) findViewById(R.id.EditText03)).getText().toString();
    				String lsResistencia = ((EditText) findViewById(R.id.EditText02)).getText().toString();
    				double ldInt = Double.parseDouble(lsIntensidad);
    				double ldRes = Double.parseDouble(lsResistencia);
    				double ldVolt = ldRes*ldInt;
    				((EditText) findViewById(R.id.EditText01)).setText(""+ldVolt);
        			}
        		}
    		break;
    		}//switch
    	} 
    }
