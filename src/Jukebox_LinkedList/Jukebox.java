package Jukebox_LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Jukebox {
    private String jukeboxName;
    private LinkedList<Album> albumLinkedList;
    private LinkedList<Playlist> playlistLinkedlist;

    public Jukebox(String jukeboxName) {
        this.jukeboxName = jukeboxName;
        albumLinkedList = new LinkedList<Album>();
        playlistLinkedlist = new LinkedList<Playlist>();
    }

    public void createAlbum(String albumName) {
        Album searchAlbum = albumExists(albumName);
        if (searchAlbum == null) {
            albumLinkedList.add(new Album(albumName));
            System.out.println("Album " + albumName + " has been created! ");
        } else {
            System.out.println(albumName + " already exists");
        }
    }

    public void removeAlbum(String songName) {
        Album searchAlbum = albumExists(songName);
        if (searchAlbum != null) {
            albumLinkedList.remove(searchAlbum);
        } else {
            System.out.println(songName + " does not exists");
        }
    }

    public Album albumExists(String albumName) {
        ListIterator<Album> i = this.albumLinkedList.listIterator();
        while (i.hasNext()) {
            if (i.next().getAlbumName().equals(albumName)) {
                i.previous();
                return i.next();
            }
        }
        return null;
    }

    public void createPlaylist(String playlistName) {
        Playlist searchPlaylists = playlistExists(playlistName);
        if (searchPlaylists == null) {
            playlistLinkedlist.add(new Playlist(playlistName));
            System.out.println("Playlist " + playlistName + " has been created! ");
        } else {
            System.out.println(playlistName + " already exists");
        }
    }

    public void removePlaylist(String playlistName) {
        Playlist searchPlaylists = playlistExists(playlistName);
        if (searchPlaylists != null) {
            playlistLinkedlist.remove(searchPlaylists);
        } else {
            System.out.println(playlistName + " does not exists");
        }
    }

    public Playlist playlistExists(String playlistName) {
        ListIterator<Playlist> i = this.playlistLinkedlist.listIterator();
        while (i.hasNext()) {
            if (i.next().getplaylistName().equals(playlistName)) {
                i.previous();
                return i.next();
            }
        }
        return null;
    }

    public Song songInAlbum(String songName) {
        ListIterator<Album> i = this.albumLinkedList.listIterator();
        while (i.hasNext()) {
            Song foundSong = i.next().songExists(songName);
            if(foundSong != null) {
                return foundSong;
            }
        }
        System.out.println(songName + " is not in any album!");
        return null;
    }
}
