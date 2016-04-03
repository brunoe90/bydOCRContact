package com.ocrcontact.byd.ocrcontact.tesseract;

import android.graphics.Bitmap;

import com.googlecode.tesseract.android.TessBaseAPI;

/**
 * Created by bruno on 03/04/16.
 */
public class TesseractController {

	private static final String TAG = "TessController.java";

	public String getTextcodification(String path,String lang,Bitmap imagen){

		TessBaseAPI baseApi = new TessBaseAPI();
		baseApi.setDebug(true);
		baseApi.init(path, lang);
		baseApi.setImage(imagen);

		String recognizedText = baseApi.getUTF8Text();

		baseApi.end();

		return recognizedText;

	}
}
