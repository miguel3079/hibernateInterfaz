package controler;

import java.awt.EventQueue;

import util.HibernateHelper;
import view.Interfaz;



public class Main {
	static Interfaz view = new Interfaz();
	HibernateHelper model = new HibernateHelper();
	
	
public static void main(String[] args) {
	view.lanzarVentana();
	
	}

}
