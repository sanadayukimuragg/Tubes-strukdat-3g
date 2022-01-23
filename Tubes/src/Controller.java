import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {
    @FXML
    private Button buttonAmbilAntrian;
    
    @FXML
    private Button buttonNextT1;

    @FXML
    private Button buttonNextT2;
    
    @FXML
    private Label labelNomorT1AntrianNasabah;

    @FXML
    private Label labelNomorT1AntrianTeller;

    @FXML
    private Label labelNomorT2AntrianNasabah;

    @FXML
    private Label labelNomorT2AntrianTeller;

    @FXML
    private Label labelPetunjukNasabah;

    @FXML
    private AnchorPane paneAntrianKosongT1;

    @FXML
    private AnchorPane paneAntrianKosongT2;

    @FXML
    private AnchorPane paneAntrianPenuh;

    @FXML
    private AnchorPane panePetunjukNasabah;

    int nomorAntrian = 0;
    LinkedQueue<Integer> queue = new LinkedQueue<>();


    @FXML
    // method pada button Ambil Antrian
    void clickAmbilAntrian(ActionEvent event) {
        nomorAntrian++;
        if(nomorAntrian > 20){   // jika size dari Queue > 20, maka akan menampilkan pesan antrian penuh                     //pesan nomor antrian sudah penuh
            antrianPenuh();         
            return;
        }
        queue.enqueue(nomorAntrian);
    }
    @FXML
    // mengganti warna button Ambil Antrian menjadi lebih gelap 5% ketika mouse masuk didalam area button
    void clickAmbilAntrianEntered(MouseEvent event) {
        buttonAmbilAntrian.setStyle("-fx-background-color : #0053F0;");
    }
    @FXML
    // mengembalikan warna button Ambil Antrian ke warna awal ketika mouse keluar area button
    void clickAmbilAntrianExited(MouseEvent event) {
        buttonAmbilAntrian.setStyle("-fx-background-color : #0560FD;");
    }

    @FXML
    // method pada button NEXT Teller 1
    void clickNextT1(ActionEvent event) {
        if(queue.sizeQueue()==0){           // mengecek apakah antrian masih ada atau sudah kosong
            paneAntrianKosongT1.setVisible(true);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1700) , new KeyValue(paneAntrianKosongT1.visibleProperty(), false)));
            timeline.play();
        }else{
            int nomorDequeue = queue.dequeue();        // menyimpan nilai yang di dequeue ke dalam nomorDequeu
            panePetunjukNasabah.setVisible(true);
            labelPetunjukNasabah.setText(String.format("Nasabah nomor %d silahkan menuju Teller 1", nomorDequeue));
            labelNomorT1AntrianNasabah.setText(String.valueOf(nomorDequeue));
            labelNomorT1AntrianTeller.setText(String.valueOf(nomorDequeue));
        }
    }
    @FXML
    // mengganti warna button NEXT Teller 1 menjadi lebih gelap 5% ketika mouse masuk didalam area button
    void clickNextT1Entered(MouseEvent event) {
        buttonNextT1.setStyle("-fx-background-color : #0053F0;");
    }
    @FXML
    // mengembalikan warna button NEXT Teller 1 ke warna awal ketika mouse keluar area button
    void clickNextT1Exited(MouseEvent event) {
        buttonNextT1.setStyle("-fx-background-color : #0560FD;");
    }

    @FXML
    // method pada button NEXT Teller 2
    void clickNextT2(ActionEvent event) {
        if(queue.sizeQueue()==0){
            paneAntrianKosongT2.setVisible(true);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1700) , new KeyValue(paneAntrianKosongT2.visibleProperty(), false)));
            timeline.play();
        }else{
            int nomorDequeue = queue.dequeue();
            panePetunjukNasabah.setVisible(true);
            labelPetunjukNasabah.setText(String.format("Nasabah nomor %d silahkan menuju Teller 2", nomorDequeue));
            labelNomorT2AntrianNasabah.setText(String.valueOf(nomorDequeue));
            labelNomorT2AntrianTeller.setText(String.valueOf(nomorDequeue));
        }
    }
    @FXML
    // mengganti warna button NEXT Teller 2 menjadi lebih gelap 5% ketika mouse masuk didalam area button
    void clickNextT2Entered(MouseEvent event) {
        buttonNextT2.setStyle("-fx-background-color : #0053F0;");
    }
    @FXML
    // mengembalikan warna button NEXT Teller 2 ke warna awal ketika mouse keluar area button
    void clickNextT2Exited(MouseEvent event) {
        buttonNextT2.setStyle("-fx-background-color : #0560FD;");
    }

    // method untuk menampilkan pesan antrian sudah penuh
    void antrianPenuh(){
        paneAntrianPenuh.setVisible(true);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(1700) , new KeyValue(paneAntrianPenuh.visibleProperty(), false)));
        timeline.play();
    }
}