package com.hamami.songlisttry2;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lvPlayList);
        String rootis = " "+Environment.getExternalStorageDirectory().getName();
        ArrayList<File> mySongs = findSongs(Environment.getExternalStorageDirectory());

        for (int i= 0;i<mySongs.size(); i++)
        {
            Toast.makeText(this,mySongs.get(i).getName().toString(),Toast.LENGTH_SHORT).show();
        }

    }
    public ArrayList<File> findSongs(File root){
        ArrayList<File> al = new ArrayList<File>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory()&& !singleFile.isHidden()){
                al.addAll(findSongs(singleFile));
            }
            else {
                if (singleFile.getName().endsWith(".mp3")){
                    al.add(singleFile);
                }
            }
        }
        return al;
    }
    
}
