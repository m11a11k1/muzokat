/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tritpo5_t1;
import org.farng.mp3.*;
import org.farng.mp3.id3.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 *
 * @author Acer-PC
 */
public class AudioParser {
    
    public File sourceFile;
    MP3File mp3file;
    public String genre,album,artist;
    public static String[] genres=GenreList.gens();
    public AudioParser(File source)
    {
        sourceFile=source;
        try{
            mp3file = new MP3File(sourceFile);
            ID3v1 tag = mp3file.getID3v1Tag();
            album = tag.getAlbum();
            if (tag.getGenre()>=0&&tag.getGenre()<80)
                genre = genres[tag.getGenre()];
            else 
                genre = genres[80];
            artist = tag.getArtist();
        }
        catch (FileNotFoundException | NullPointerException | TagException e)
        {
            genre = genres[80];
            artist = "Unknown Artist";
            album = "Unknown";
        }
        catch (IOException  e)
        {e.printStackTrace();}
    }
}
