package Jukebox;

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

    public addSong(String songName) {
        if(songExists(song)) {
            songLinkedList.add(song);
        }
        else {
            System.out.println(songName + " already exists in " + getAlbumName());
        }
    }

    public removeSong(String songName) {
        if(songExists(song)) {
            songLinkedList.remove(song);
        }
        else {
            System.out.println(songName + " does not exists in " + getAlbumName());
        }
    }

    public boolean songExists(String songName) {
        ListIterator<Song> i = songLinkedList.listIterator();
        while(i.hasNext()) {
            i.next().getSongName().equals(songName);
            return i;
        }
        return false;
    }
}
