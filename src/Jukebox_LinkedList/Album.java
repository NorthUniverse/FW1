package Jukebox_LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String albumName;
    private LinkedList<Song> songLinkedList;

    public Album(String albumName) {
        this.albumName = albumName;
        songLinkedList = new LinkedList<Song>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void addSongToAlbum(String songName, int songDuration) {
        Song searchSong = songExists(songName);
        if(searchSong == null) {
            songLinkedList.add(new Song(songName,songDuration));
            System.out.println(songName + " has been added to " + albumName);
        }
        else {
            System.out.println(songName + " already exists in " + getAlbumName());
        }
    }

    public void removeSongFromAlbum(String songName) {
        Song searchSong = songExists(songName);
        if(searchSong != null) {
            songLinkedList.remove(searchSong);
        }
        else {
            System.out.println(songName + " does not exists in " + getAlbumName());
        }
    }

    public Song songExists(String songName) {
        ListIterator<Song> i = this.songLinkedList.listIterator();
        while(i.hasNext()) {
            if(i.next().getSongName().equals(songName)) {
                i.previous();
                return i.next();
            }
        }
        return null;
    }
}
