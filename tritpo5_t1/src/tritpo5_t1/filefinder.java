/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tritpo5_t1;

import java.io.File;
import static tritpo5_t1.Tritpo5_t1.listWithFileNames;
import static tritpo5_t1.FXMLDocumentController.mp3List;

/**
 *
 * @author Acer-PC
 */
public class filefinder extends Thread {
    //static int i=0;
    private String str=new String(); 
    public filefinder(String s)
    {
        str=s;
    }
    @Override
    public void start()
    {
        try{
            File f = new File(str);
            for (File s : f.listFiles()) {
                if (s.isFile()) {
                    if (s.getName().endsWith(".mp3"))
                    {
                        listWithFileNames.add(s);
                        mp3List.add(new AudioParser(s));
                       // i++;
                       // if (i%100==0) System.out.println(i);
                    }
                } else if (s.isDirectory()) {
                    new filefinder(s.getAbsolutePath()).start();
                }
            }  
        }
        catch (NullPointerException e)
        {
            System.out.println("filefinder error");
        }
        catch (Exception e)
        {
            System.out.println("mp3 error");
        }
    }
}
