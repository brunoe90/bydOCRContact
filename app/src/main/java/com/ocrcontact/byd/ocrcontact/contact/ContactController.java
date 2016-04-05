package com.ocrcontact.byd.ocrcontact.contact;

/**
 * Created by bruno on 04/04/16.
 */
public class ContactController {

	private static ContactController instance = null;

	//Lazy creation of class
	private ContactController() {
		//private empty Constructor to prevent
		//generation of the class.
	}

	public static ContactController getInstance() {
		if(instance == null) {
			instance = new ContactController();
		}
		return instance;
	}
}
