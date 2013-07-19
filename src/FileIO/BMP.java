/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileIO;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Owner
 */
public class BMP {

    /**
     * Reads a bmp picture and outputs the grey scale values of the image
     *
     * @param filename
     * @return
     */
    public static int[][] read(String filename) {
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            System.err.println("'"+filename+"' not found");
        }
        
        Raster r = img.getRaster();
        int tmp[] = null;
        tmp = r.getPixels(r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight(), tmp );
        //int image[][] = new int[r.getWidth()][r.getHeight()];
        int image[][] = new int[r.getHeight()][r.getWidth()];
        
        int count = 0;
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++, count++){
                image[i][j] = tmp[count];
            }
        }
        
        return image;
    }
    
//    public static void main(String args[]){
//        BMP.read("test.bmp");
//    }
//    
}
