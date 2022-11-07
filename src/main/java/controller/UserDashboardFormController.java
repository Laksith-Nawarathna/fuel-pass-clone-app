package controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import db.InMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import util.Navigation;
import util.Routes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserDashboardFormController {
    public Label lblName;
    public Label lblNIC;
    public Label lblAddress;
    public Label lblQuota;
    public ImageView imgQr;
    public Button btnDownload;
    public Button btnPrint;
    public AnchorPane pneDashboard;
    public Label lblLogout;


    public void initialize(){
        Platform.runLater(pneDashboard::requestFocus);
    }

    public void setData(String nic) throws WriterException {
        User user = InMemoryDB.findUser(nic);
        lblName.setText(user.getFirstName() + " " + user.getLastName());
        lblAddress.setText(user.getAddress());
        lblNIC.setText(user.getNic());
        lblQuota.setText(user.getQuota() + "L (Weekly)");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String plainSecret = user.getNic() + "-" + user.getFirstName();
        BitMatrix encode = qrCodeWriter.encode(plainSecret, BarcodeFormat.QR_CODE, 200, 200);
        WritableImage image = new WritableImage(200,200);
        PixelWriter pixelWriter = image.getPixelWriter();

        for (int y = 0; y < encode.getHeight(); y++) {
            for (int x = 0; x < encode.getWidth(); x++) {
                pixelWriter.setColor(x,y,encode.get(x,y) ? Color.PURPLE: Color.WHITE);
               /* if(encode.get(x,y)){
                    pixelWriter.setColor(x,y, Color.BLACK);
                }else{
                    pixelWriter.setColor(x,y,Color.WHITE);
                }*/
            }
        }
        imgQr.setImage(image);

    }
    public void lblLogoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigation(Routes.LOGIN);
    }

    public void btnDownloadOnAction(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save QR Code");
        File file = new File(System.getProperty("user.home"));
        fileChooser.setInitialDirectory(file);
        fileChooser.setInitialFileName("qr-code.png");
       /* fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("GIF files (*.gif)","*.gif"));
        */fileChooser.getExtensionFilters()
                        .add(new FileChooser.ExtensionFilter("PNG files (*.png)","*.png"));

        File saveLocation = fileChooser.showSaveDialog(btnDownload.getScene().getWindow());
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imgQr.getImage(), null);
        boolean saved = ImageIO.write(bufferedImage,"png", saveLocation);
        if(saved){
            new Alert(Alert.AlertType.INFORMATION,"Downloaded").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Failed to download").show();
        }

    }

    public void btnPrintOnAction(ActionEvent actionEvent) {

        if(Printer.getDefaultPrinter() == null){
            new Alert(Alert.AlertType.ERROR,"No default printer has been selected").showAndWait();
            return;
        }

        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if(printerJob != null){
            printerJob.showPageSetupDialog(btnPrint.getScene().getWindow());
            boolean success = printerJob.printPage(imgQr);
            if(success){
                printerJob.endJob();
            }else{
                new Alert(Alert.AlertType.ERROR,"Failed to print. Try again.").showAndWait();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Failed to initialize a new printer job").show();
        }

    }
}
