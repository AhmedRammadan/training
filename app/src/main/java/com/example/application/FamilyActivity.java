/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.application;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    MediaPlayer.OnCompletionListener monCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaplayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // Create a list of Words
        final ArrayList<Word> Words = new ArrayList<Word>();
        Words.add(new Word("father", "әpә", R.drawable.family_father,R.raw.family_father));
        Words.add(new Word("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        Words.add(new Word("son", "angsi", R.drawable.family_son,R.raw.family_son));
        Words.add(new Word("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        Words.add(new Word("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        Words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        Words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        Words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        Words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        Words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));
        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        CustomAdapter adapter = new CustomAdapter(this, Words,R.color.FamilyActivity);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // Word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.listView);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);   listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaplayer();
                Word word= Words.get(position);
                mediaPlayer=MediaPlayer.create(FamilyActivity.this,word.getAudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(monCompletionListener);
            }
        });
    }
    private void releaseMediaplayer(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        releaseMediaplayer();
    }
}
