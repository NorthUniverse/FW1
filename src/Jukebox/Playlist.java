package Jukebox;

import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String playlistName;
    private LinkedList<Song> songLinkedList;
    boolean goingForward = true;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;
        songLinkedList = new LinkedList<Song>();
    }

    public String getplaylistName() {
        return playlistName;
    }

    public void addSongToPlaylist(Song song) {
        songLinkedList.add(song);
        System.out.println(song.getSongName() + " has been added to " + getplaylistName());
    }

    public void removeSongFromPlaylist(Song song) {
        songLinkedList.remove(song);
        System.out.println(song.getSongName() + " has been added to " + getplaylistName());
    }

    public void playSong(int direction) {
        ListIterator<Song> i = songLinkedList.listIterator();
        if(direction == 10) {
            if(!goingForward) {
                i.next();
                goingForward = true;
            }
            if(i.hasNext()) {
                System.out.println("Now playing " + i.next());
            }
            else {
                System.out.println("You are the end of playlist");
            }
        }

        if(direction == 11) {
            if(goingForward) {
                i.previous();
                goingForward = false;
            }
            if(i.hasPrevious()) {
                System.out.println("Now playing " + i.previous());
            }
            else {
                System.out.println("You are the start of playlist");
            }
        }
        if(direction == 12) {
            if(goingForward) {
                i.previous();
                System.out.println("Now playing " + i.next());
            }
            else {
                i.next();
                System.out.println("Now playing " + i.previous());
            }
        }

    }

}
