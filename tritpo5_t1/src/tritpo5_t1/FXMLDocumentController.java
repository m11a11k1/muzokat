/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tritpo5_t1;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import static tritpo5_t1.Tritpo5_t1.listWithFileNames;
import static tritpo5_t1.AudioParser.genres;

/**
 *
 * @author Acer-PC
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public ListView<String> trackList_Tracks = new ListView<>(); 
    public ListView<String> trackList_Genres = new ListView<>(); 
    public ListView<String> trackList_Artists = new ListView<>();
    public ListView<String> trackList_Albums = new ListView<>(); 
    public ListView<String> currentTagTrackList = new ListView<>();
    @FXML
    TextFlow albumLabel;
    @FXML
    TextFlow genreLabel;
    @FXML
    TextFlow artistLabel;
    
    
    public static ArrayList<AudioParser> mp3List = new ArrayList<>();   
    public ObservableList<String> trackNameList;
    private void convertFilesToListView()
    {
        ArrayList<String> trackNameTempList = new ArrayList<>();
        
        for (File fil : listWithFileNames) {
            trackNameTempList.add(fil.getName());
            //mp3List.add(new AudioParser(fil));
        }
        trackNameList = FXCollections.observableArrayList(trackNameTempList);
        trackList_Tracks.setItems(trackNameList);
    }
    
    public void createGenresListView()
    {
        ArrayList<String> trackNameTempList = new ArrayList<>();
        
        for (int i=0;i<81;i++) {
            trackNameTempList.add(genres[i]);
        }
        trackNameList = FXCollections.observableArrayList(trackNameTempList);
        trackList_Genres.setItems(trackNameList);
    }
    
    public void trackList_Tracks_OnClick()
    {
        AudioParser selectedTrack = mp3List.get(trackList_Tracks.getSelectionModel().getSelectedIndex());
        albumLabel.getChildren().clear();
        albumLabel.getChildren().add(new Text(selectedTrack.album)); 
        artistLabel.getChildren().clear();
        artistLabel.getChildren().add(new Text(selectedTrack.artist)); 
        genreLabel.getChildren().clear();
        genreLabel.getChildren().add(new Text(selectedTrack.genre)); 
    }
    
    public void trackList_Genres_OnClick()
    {
        ArrayList<String> trackNameTempList = new ArrayList<>();
            String selectedGenre = trackList_Genres.getSelectionModel().getSelectedItem();
            for (AudioParser fil : mp3List) {
                if(fil.genre.equals(selectedGenre))
                trackNameTempList.add(fil.sourceFile.getName());
            }
        trackNameList = FXCollections.observableArrayList(trackNameTempList);
        currentTagTrackList.setItems(trackNameList);
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        convertFilesToListView(); 
        createGenresListView();
    }    
    
}
