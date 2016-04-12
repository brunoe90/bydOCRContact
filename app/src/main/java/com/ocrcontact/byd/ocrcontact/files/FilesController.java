package com.ocrcontact.byd.ocrcontact.files;
import android.util.Log;
import java.io.File;

/**
 * Created by bruno on 04/04/16.
 */
public class FilesController {

	private static FilesController instance = null;

	//Lazy creation of class
	private FilesController() {
		//private empty Constructor to prevent
		//generation of the class.
	}

	public static FilesController getInstance() {
		if(instance == null) {
			instance = new FilesController();
		}
		return instance;
	}

	// Metodos sobrecargados para crear archivos y carpetas
	public boolean[] create_dir_file(String[] paths) {

		int cant_dirs = 0;
		boolean[] dir_status = new boolean[paths.length];

		for (String path : paths) {

			File dir = new File(path);

			if (dir.exists()) {

				// Existe el directorio
				dir_status[cant_dirs] = true;

			} else {

				// Si no existe... se crea
				if (dir.mkdirs())
					dir_status[cant_dirs] = true;
				else
					dir_status[cant_dirs] = false;
			}

			cant_dirs++;
		}

		return dir_status;
	}

	// Crea un solo archivo/carpeta
	public boolean create_dir_file(String paths){

		File dir = new File(paths);

		if (dir.exists()) {
			// Existe el directorio
			return true;
		} else {
			// Si no existe... se crea
			if (dir.mkdirs())
				return true;
			else
				return false;
		}

	}

}
