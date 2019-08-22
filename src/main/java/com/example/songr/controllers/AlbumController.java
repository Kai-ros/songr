package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.AlbumRepository;
import com.example.songr.models.Song;
import com.example.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController
{
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model album)
    {
        List<Album> albums = albumRepository.findAll();
        album.addAttribute("albums", albums);
        return "allAlbums";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title, String artist, int songCount, long length, String imageUrl)
    {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

    @GetMapping("/album/{id}")
    public String getOneAlbum(@PathVariable long id, Model model)
    {
        Album album = albumRepository.findById(id).get();
        model.addAttribute("album", album);
        return "oneAlbum";
    }

    @PostMapping("/songs")
    public RedirectView addSong(String title, String artist, long length, int trackNumber, Album album)
    {
        Song song = songRepository.findByTitle(title);
        songRepository.save(song);
        return new RedirectView("/songs");
    }
}


