import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Fanni on 15/05/16.
 */
//optimalizalas miatt, ez egz singleton osztaly, csak egy van belole az instance elvileg
    //itt majd minden kepet be kene tolteni egyszer es ezeket hasznalni.
public class Images {

    public static Images instance = new Images();
    public BufferedImage ground;
    public BufferedImage doorclosed;
    public BufferedImage rift;
    public BufferedImage scale;
    public BufferedImage specialwall;
    public BufferedImage wall;

    //ez elvileg nem hivhato es csak az instance erheto el...
    protected Images() {
        // Exists only to defeat instantiation.
        try {
            ground = ImageIO.read(new File("images/ground.jpg"));
            doorclosed = ImageIO.read(new File("images/doorclosed.jpg"));
            rift = ImageIO.read(new File("images/rift.jpg"));
            scale = ImageIO.read(new File("images/scale.jpg"));
            specialwall= ImageIO.read(new File("images/specialwall.jpg"));
            wall = ImageIO.read(new File("images/wall.jpg"));
        } catch (IOException e) {
        }
    }



    //FOGALMAM SINCS DE MEGY NETES copypaste :D
    public BufferedImage rotateDown( BufferedImage inputImage ) {
//We use BufferedImage because it’s provide methods for pixel manipulation
        int width = inputImage.getWidth(); //the Width of the original image
        int height = inputImage.getHeight();//the Height of the original image

        BufferedImage returnImage = new BufferedImage( width, height, inputImage.getType()  );
//we created new BufferedImage, which we will return in the end of the program
//it set up it to the same width and height as in original image
// inputImage.getType() return the type of image ( if it is in RBG, ARGB, etc. )

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB( width - x - 1, height - y - 1, inputImage.getRGB( x, y  )  );
            }
        }
//so we used two loops for getting information from the whole inputImage
//then we use method setRGB by whitch we sort the pixel of the return image
//the first two parametres is the X and Y location of the pixel in returnImage and the last one is the //source pixel on the inputImage
//why we put width – x – 1 and height –y – 1 is hard to explain for me, but when you rotate image by //180degree the pixel with location [0, 0] will be in [ width, height ]. The -1 is for not to go out of
//Array size ( remember you always start from 0 so the last index is lower by 1 in the width or height
//I enclose Picture for better imagination  ... hope it help you
        return returnImage;
//and the last return the rotated image

    }

    public BufferedImage rotateToLeft( BufferedImage inputImage ){
//The most of code is same as before
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        BufferedImage returnImage = new BufferedImage( height, width , inputImage.getType()  );
//We have to change the width and height because when you rotate the image by 90 degree, the
//width is height and height is width <img src='http://forum.codecall.net/public/style_emoticons/<#EMO_DIR#>/smile.png' class='bbc_emoticon' alt=':)' />

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB(y, width - x - 1, inputImage.getRGB( x, y  )  );
//Again check the Picture for better understanding
            }
        }
        return returnImage;

    }

    public BufferedImage rotateToRight( BufferedImage inputImage ){
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();
        BufferedImage returnImage = new BufferedImage( height, width , inputImage.getType()  );

        for( int x = 0; x < width; x++ ) {
            for( int y = 0; y < height; y++ ) {
                returnImage.setRGB( height - y -1, x, inputImage.getRGB( x, y  )  );
//Again check the Picture for better understanding
            }
        }
        return returnImage;
    }

}





