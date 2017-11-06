package me.ricardocunha.subimage.cv;

import me.ricardocunha.subimage.cv.opencv.TemplateMatchingOpenCVImpl;

public class TemplateMatchingAdapter implements TemplateMatching {
	private TemplateMatchingOpenCVImpl impl;

	public TemplateMatchingAdapter() {
		this.impl = new TemplateMatchingOpenCVImpl();
	}
	/**
	 * Find a subimage inside an image, try to find image2 inside image1 if not found.
	 * 
	 * @param image1 Path for main image
	 * @param image2 Path for main subimage
	 */
	public int[] imageContainsSubimage(String image1, String image2) {
		int[] points= impl.imageContainsSubimage(image1, image2);
		if(points == null){
			return impl.imageContainsSubimage(image2,image1);
		} else {
			return points;
		}
	}

}
