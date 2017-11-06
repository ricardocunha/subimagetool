package me.ricardocunha.subimage;



import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import me.ricardocunha.subimage.cv.TemplateMatching;
import me.ricardocunha.subimage.cv.TemplateMatchingAdapter;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    
    @Test
    public void imageContainsSubimage() throws IOException {
    	
		String basepath = new File(".").getCanonicalPath()+"\\resources\\";
		String image1 = basepath + "complete.jpg";
		String image2 = basepath + "part.jpg";
		
        TemplateMatching templateMatching = new TemplateMatchingAdapter();
        int[] points = templateMatching.imageContainsSubimage(image1, image2);
        // assert statements
		assertEquals(225, points[0]);
        assertEquals(32, points[1]);
    }
}
