package com.example.musicplayer;

public class SampleData {
    private int Cover;
    private String SongName;
    private String Artist;

    public SampleData(int Cover, String SongName, String Artist){
        this.Cover = Cover;
        this.SongName = SongName;
        this.Artist = Artist;
    }

    public int getCover(){
        return this.Cover;
    }

    public String getSongName(){
        return this.SongName;
    }

    public String getArtist(){
        return this.Artist;
    }
}
