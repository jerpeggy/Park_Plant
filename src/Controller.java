import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {

    private FileChooser fileChooser = new FileChooser();

    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg, *.jpeg)", "*.JPG","*.JPEG");
    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
    FileChooser.ExtensionFilter extFilterTIFF = new FileChooser.ExtensionFilter("TIFF files (*.tiff, *.tif)", "*.JPG");
    FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
    FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
    FileChooser.ExtensionFilter extFilterRAW = new FileChooser.ExtensionFilter("RAW files (*.raw, *.cr2, *.nef)", "*.RAW","*.CR2","*.NEF");


    private Image[] photos = new Image[3];

    @FXML
    AnchorPane mainPageAnchor;
    @FXML
    AnchorPane addPageAnchor;
    @FXML
    ImageView photoViewer1;
    @FXML
    ImageView photoViewer2;
    @FXML
    ImageView photoViewer3;

    public void changeViewToAddPage(){
        addPageAnchor.setVisible(true);
        addPageAnchor.setDisable(false);
        mainPageAnchor.setVisible(false);
        mainPageAnchor.setDisable(true);
    }

    public void changeViewToMainPage(){
        addPageAnchor.setVisible(false);
        addPageAnchor.setDisable(true);
        mainPageAnchor.setVisible(true);
        mainPageAnchor.setDisable(false);
    }
    public void getPhotoOne(){
        ImageView imageView= new ImageView();
        fileChooser.getExtensionFilters().addAll(extFilterBMP,extFilterGIF,extFilterJPG,extFilterPNG,extFilterRAW,extFilterTIFF);
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview1 = null;
        try {
            bufferedPreview1 =ImageIO.read(file);
            Image preview1 = SwingFXUtils.toFXImage(bufferedPreview1,null);
            imageView.setImage(preview1);
            photoViewer1=imageView;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getPhotoTwo(){
        /*fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("tif", "tiff", "gif", "jpeg", "jpg", "jif", "jfif", "jp2", "jpx", "j2k", "j2c", "png"));
        photos[1] =fileChooser.showOpenDialog(addPageAnchor.getScene().getWindow());
        BufferedImage bufferedPreview2 = null;
        try {
            bufferedPreview2 =ImageIO.read(photos[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image preview2 = SwingFXUtils.toFXImage(bufferedPreview2,null);
        photoViewer2 = new ImageView(preview2);
*/
        fileChooser.getExtensionFilters().addAll(extFilterBMP,extFilterGIF,extFilterJPG,extFilterPNG,extFilterRAW,extFilterTIFF);
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview2 = null;
        try {
            bufferedPreview2 =ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image preview2 = SwingFXUtils.toFXImage(bufferedPreview2,null);
        photoViewer2.setImage(preview2);
    }

    public void getPhotoThree(){

        /*
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("tif", "tiff", "gif", "jpeg", "jpg", "jif", "jfif", "jp2", "jpx", "j2k", "j2c", "png"));
        photos[2] =fileChooser.showOpenDialog(addPageAnchor.getScene().getWindow());
        BufferedImage bufferedPreview3 = null;
        try {
            bufferedPreview3 =ImageIO.read(photos[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image preview3 = SwingFXUtils.toFXImage(bufferedPreview3,null);
        photoViewer3 = new ImageView(preview3);
*/
        fileChooser.getExtensionFilters().addAll(extFilterBMP,extFilterGIF,extFilterJPG,extFilterPNG,extFilterRAW,extFilterTIFF);
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview3 = null;
        try {
            bufferedPreview3 =ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image preview3 = SwingFXUtils.toFXImage(bufferedPreview3,null);
        photoViewer3.setImage(preview3);
    }


}
