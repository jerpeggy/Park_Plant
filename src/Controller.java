import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Controller {

    private FileChooser fileChooser = new FileChooser();

    FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg, *.jpeg)", "*.JPG","*.JPEG");
    FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
    FileChooser.ExtensionFilter extFilterTIFF = new FileChooser.ExtensionFilter("TIFF files (*.tiff, *.tif)", "*.TIF","*.TIFF");
    FileChooser.ExtensionFilter extFilterBMP = new FileChooser.ExtensionFilter("BMP files (*.bmp)", "*.BMP");
    FileChooser.ExtensionFilter extFilterGIF = new FileChooser.ExtensionFilter("GIF files (*.gif)", "*.GIF");
    FileChooser.ExtensionFilter extFilterRAW = new FileChooser.ExtensionFilter("RAW files (*.raw, *.cr2, *.nef)", "*.RAW","*.CR2","*.NEF");

    FileChooser.ExtensionFilter extFilterIMAGES = new FileChooser.ExtensionFilter("all Image Files","*.RAW","*.CR2","*.NEF","*.GIF","*.BMP","*.TIF","*.TIFF","*.PNG","*.JPG","*.JPEG");

    private BufferedImage[] photos = new BufferedImage[3];

    private DirectoryChooser directoryChooser = new DirectoryChooser();

    @FXML
    private AnchorPane mainPageAnchor;
    @FXML
    private AnchorPane addPageAnchor;
    @FXML
    private TextField locationTextBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ImageView photoViewer1;
    @FXML
    private ImageView photoViewer2;
    @FXML
    private ImageView photoViewer3;
    @FXML
    private Button addPhotosButton;

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
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview1 = null;
        try {
            FileInputStream input = new FileInputStream(file);
            bufferedPreview1 =ImageIO.read(input);
            photos[0] = bufferedPreview1;
            Image preview1 = SwingFXUtils.toFXImage(bufferedPreview1,null);
            photoViewer1.setImage(preview1);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void getPhotoTwo(){
        fileChooser.getExtensionFilters().addAll(extFilterIMAGES,extFilterBMP,extFilterGIF,extFilterJPG,extFilterPNG,extFilterRAW,extFilterTIFF);
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview2 = null;
        try {
            FileInputStream input = new FileInputStream(file);
            bufferedPreview2 =ImageIO.read(input);
            photos[1] = bufferedPreview2;
            Image preview2 = SwingFXUtils.toFXImage(bufferedPreview2,null);
            photoViewer2.setImage(preview2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPhotoThree(){

        fileChooser.getExtensionFilters().addAll(extFilterIMAGES,extFilterBMP,extFilterGIF,extFilterJPG,extFilterPNG,extFilterRAW,extFilterTIFF);
        File file =fileChooser.showOpenDialog(null);
        BufferedImage bufferedPreview3 = null;
        try {
            FileInputStream input = new FileInputStream(file);
            bufferedPreview3 =ImageIO.read(input);
            photos[2] = bufferedPreview3;
            Image preview3 = SwingFXUtils.toFXImage(bufferedPreview3,null);
            photoViewer3.setImage(preview3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveImagesToDrive(){
        if(!locationTextBox.getText().isEmpty() && datePicker.getValue()!=null){
            int x=0;
            while(x<photos.length){
                if(photos[x]!=null) {
                    String locText = locationTextBox.getText().replace(' ', '_');
                    File outputFile = new File("src\\park_Pictures_Folder\\" + locText + "_" + datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "_" + (x + 1) + ".png");

                    try {
                        ImageIO.write(photos[x], "png", outputFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                x++;
            }
            addPhotosButton.setDisable(true);
            changeViewToMainPage();
        }
        else if(locationTextBox.getText().isEmpty()){
            locationTextBox.setPromptText("PLEASE INPUT LOCATION");
        }
        else if(datePicker.getValue()==null){
            datePicker.setPromptText("PLEASE SET VISIT DATE");
        }


    }

    public void saveImagesFromDrive(){
        File selectedDirectory = directoryChooser.showDialog(null);
        File parentDirectory = new File("src\\park_Pictures_Folder");
        File[] files = parentDirectory.listFiles();
        BufferedImage image = null;
        int x = 0;
        while(x<files.length){
            try {
                FileInputStream input = new FileInputStream(files[x]);
                image = ImageIO.read(input);
                ImageIO.write(image,"png",new File(selectedDirectory+"\\"+files[x].getName()));
            }
            catch(IOException e){

            }
            x++;
        }
    }


}
