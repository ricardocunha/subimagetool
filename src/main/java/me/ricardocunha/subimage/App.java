package me.ricardocunha.subimage;

import java.io.File;
import java.io.IOException;

import me.ricardocunha.subimage.cv.TemplateMatching;
import me.ricardocunha.subimage.cv.TemplateMatchingAdapter;

/**
 * Find a subimage inside an image. Use params to load images or load default images.
 * 
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	
        System.out.println( "Get the position x and y if one image contains other inside" );
        String image1= null;
        String image2= null;
        //Use default images if any parameter is passed
        if (args.length == 0){
			String basepath = new File(".").getCanonicalPath()+"\\resources\\";
			image1 = basepath + "complete.jpg";
			image2 = basepath + "part.jpg";
        } else {
        	image1 = args[0];
        	image2 = args[1];
        }
        TemplateMatching templateMatching = new TemplateMatchingAdapter();
        int[] points = templateMatching.imageContainsSubimage(image1, image2);
        if (points != null){
        	System.out.println("Found image at ("+points[0]+","+points[1]+")");
        } else {
        	System.out.println("subimage NOT FOUND in template");
        }

    }
}
