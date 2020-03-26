package main;

import java.util.Properties;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestPoperties {

	public static void main(String[] args) {

		String file = "app.properties";
		String XMLfile = "appXML.properties";

		System.out.println("Fichero properties " + file);
		obtenerProperties(file);

		System.out.println("\n\nFichero properties " + XMLfile);
		obtenerXMLProperties(XMLfile);

		// serverDHCP=127.0.0.1
		// port=5555
		// login=admin
		// password=admin

	}

	public static void obtenerProperties(String FILE) {

		String language = "";
		InetAddress IP = null;
		Integer port = null;

		Properties properties = new Properties();

		// language=ES
		// IP=127.0.0.1
		// port=5555

		// Cargamos valores desde fichero
		try {
			properties.load(new FileInputStream(FILE));

			language = properties.getProperty("language", "ES");
			IP = InetAddress.getByName(properties.getProperty("IP"));
			port = Integer.parseInt(properties.getProperty("port"));

		} catch (Exception e) {
			// Se ejecuta si el fichero no existe o alguna propiedad es null
		}

		// Mostramos los datos del fichero si existiera
		if (IP == null) {
			System.out.println("No existe el fichero.");
			language = "ES";
			try {
				IP = InetAddress.getByName("127.0.0.1");
			} catch (UnknownHostException e) {
			}
			port = 5555;
		} else {
			System.out.println("Language: " + language);
			System.out.println("IP: " + IP.getHostAddress());
			System.out.println("port: " + port);
		}

		// Establecemos las propiedades
		properties.setProperty("language", language);
		properties.setProperty("IP", IP.getHostAddress());
		properties.setProperty("port", String.valueOf(port));

		// Guardamos las propiedades en un fichero
		try {
			properties.store(new FileOutputStream(FILE), "Propiedades de mi aplicacion");
		} catch (Exception e) {

		}
	}

	public static void obtenerXMLProperties(String XML_FILE) {

		String language = "";
		InetAddress IP = null;
		Integer port = null;

		Properties properties = new Properties();

		// language=ES
		// IP=127.0.0.1
		// port=5555

		// Cargamos valores desde fichero
		try {
			properties.loadFromXML(new FileInputStream(XML_FILE));

			language = properties.getProperty("language", "ES");
			IP = InetAddress.getByName(properties.getProperty("IP"));
			port = Integer.parseInt(properties.getProperty("port"));

		} catch (Exception e) {
			// Se ejecuta si el fichero no existe o alguna propiedad es null
		}

		// Mostramos los datos del fichero si existiera
		if (IP == null) {
			System.out.println("No existe el fichero.");
			language = "ES";
			try {
				IP = InetAddress.getByName("127.0.0.1");
			} catch (UnknownHostException e) {
			}
			port = 5555;
		} else {
			System.out.println("Language: " + language);
			System.out.println("IP: " + IP.getHostAddress());
			System.out.println("port: " + port);
		}

		// Establecemos las propiedades
		properties.setProperty("language", language);
		properties.setProperty("IP", IP.getHostAddress());
		properties.setProperty("port", String.valueOf(port));

		// Guardamos las propiedades en un fichero
		try {
			properties.storeToXML(new FileOutputStream(XML_FILE), "Propiedades de mi aplicacion");
		} catch (Exception e) {

		}

	}

}
