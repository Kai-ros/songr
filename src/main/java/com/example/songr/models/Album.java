package com.example.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    String artist;
    int songCount;
    long length;
    String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    List<Song> songs;

    public Album() {}

    public Album (String title, String artist, int songCount, long length, String imageUrl)
    {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getTitle()
    {
        return title;
    }

    public List<Song> getSongs()
    {
        return songs;
    }
}
