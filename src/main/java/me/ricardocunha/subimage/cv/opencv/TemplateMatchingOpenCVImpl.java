package me.ricardocunha.subimage.cv.opencv;

import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import me.ricardocunha.subimage.cv.TemplateMatching;

public class TemplateMatchingOpenCVImpl implements TemplateMatching{
	/**
	 * Find a subimage inside an image
	 * 
	 * @param image1 Path for main image
	 * @param image2 Path for main subimage
	 */
	public int[] imageContainsSubimage(String image1, String image2) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		try {
		    Mat img1 = Imgcodecs.imread(image1);
		    Mat img2 = Imgcodecs.imread(image2);

		    int rows = img1.rows() - img2.rows() + 1;
		    int cols = img1.cols() - img2.cols() + 1;

		    Mat result = new Mat(rows, cols, CvType.CV_32FC1);

		    Imgproc.matchTemplate(img1, img2, result, Imgproc.TM_CCOEFF);

		    Imgproc.threshold(result, result, 0.5, 1.0, Imgproc.THRESH_TOZERO);

		    MinMaxLocResult mmr = Core.minMaxLoc(result);

		    Point matchLoc = mmr.maxLoc;

		    double threashhold = 0.40;
		    if (mmr.maxVal > threashhold) {
		    	return new int[]{new Double(matchLoc.x).intValue(),new Double(matchLoc.y).intValue()};
		    }
		} catch (Exception e) {

		}

		return null;
	}

}
