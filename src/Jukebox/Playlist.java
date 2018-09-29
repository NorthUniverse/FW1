package Jukebox;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String playlistName;
    private LinkedList<Song> songLinkedList;

    public Playlist(String albumName) {
        this.playlistName = albumName;
        songLinkedList = new LinkedList<Song>();
    }

    public String getplaylistName() {
        return playlistName;
    }

    public void addSong(String songName, int songDuration) {
        Song searchSong = songExists(songName);
        if(searchSong == null) {
            songLinkedList.add(new Song(songName,songDuration));
            System.out.println(songName + " has been added to " + playlistName);
        }
        else {
            System.out.println(songName + " already exists in " + getplaylistName());
        }
    }

    public void removeSong(String songName) {
        Song searchSong = songExists(songName);
        if(searchSong != null) {
            songLinkedList.remove(searchSong);
        }
        else {
            System.out.println(songName + " does not exists in " + getplaylistName());
        }
    }

    public Song songExists(String songName) {
        ListIterator<Song> i = this.songLinkedList.listIterator();
        while(i.hasNext()) {
            if(i.next().getSongName().equals(songName)) {
                return i.next();
            }
        }
        return null;
    }
}