package com.example.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Song
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String title;
    long length;
    int trackNumber;

    @ManyToOne
    Album album;

    public Song() {}

    public Song(String title, long length, int trackNumber, Album album)
    {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album = album;
    }

    public long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Album getAlbum()
    {
        return album;
    }

    public String toString()
    {
        return String.format(" %d %s", this.trackNumber, this.title);
    }

}









