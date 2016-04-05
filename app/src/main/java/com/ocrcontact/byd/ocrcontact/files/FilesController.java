package com.ocrcontact.byd.ocrcontact.files;

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

}
