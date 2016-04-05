package com.ocrcontact.byd.ocrcontact.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by bruno on 04/04/16.
 */
public class CameraController {

	private static CameraController instance = null;
	private static final String TAG = "CameraController.java";

	//Lazy creation of class
	private CameraController() {
		//private empty Constructor to prevent
		//generation of the class.
	}

	public static CameraController getInstance() {
		if(instance == null) {
			instance = new CameraController();
		}
		return instance;
	}

	public Intent startCameraActivity(String _path) {
		File file = new File(_path);
		Uri outputFileUri = Uri.fromFile(file);

		final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
		return intent;
	}

	public void setOrientationCamera(Bitmap bitmap,String _path){

		try {
			ExifInterface exif = new ExifInterface(_path);
			int exifOrientation = exif.getAttributeInt(
			ExifInterface.TAG_ORIENTATION,
			ExifInterface.ORIENTATION_NORMAL);

			Log.v(TAG, "Orient: " + exifOrientation);

			int rotate = 0;

			switch (exifOrientation) {
				case ExifInterface.ORIENTATION_ROTATE_90:
					rotate = 90;
					break;
				case ExifInterface.ORIENTATION_ROTATE_180:
					rotate = 180;
					break;
				case ExifInterface.ORIENTATION_ROTATE_270:
					rotate = 270;
					break;
			}

			Log.v(TAG, "Rotation: " + rotate);

			if (rotate != 0) {

				// Getting width & height of the given image.
				int w = bitmap.getWidth();
				int h = bitmap.getHeight();

				// Setting pre rotate
				Matrix mtx = new Matrix();
				mtx.preRotate(rotate);

				// Rotating Bitmap
				bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, mtx, false);
			}

			// Convert to ARGB_8888, required by tess
			bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);

		} catch (IOException e) {
			Log.e(TAG, "Couldn't correct orientation: " + e.toString());
		}

		// _image.setImageBitmap( bitmap );

	}



}
