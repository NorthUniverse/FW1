package Jukebox;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

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
        System.out.println(song.getSongName() + " has been added to " + getplaylistName() + " ");
    }

    public void removeSongFromPlaylist(Song song) {
        songLinkedList.remove(song);
        System.out.println(song.getSongName() + " has been added to " + getplaylistName() + " ");
    }

    public void playSong() {
        ListIterator<Song> i = this.songLinkedList.listIterator();
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        printPlaylistMenu();
        boolean goingForward = true;

        while (!quit) {

            int playlistMenuOption = scanner.nextInt();
            scanner.nextLine();

            switch (playlistMenuOption) {
                case 1:
                    if (!goingForward) {
                        i.next();
                        goingForward = true;
                    }
                    if (i.hasNext()) {
                        System.out.println("Now playing " + i.next().getSongName());
                    } else {
                        System.out.println("You are the end of playlist");
                    }
                    break;

                case 2:
                    if (goingForward) {
                        i.previous();
                        goingForward = false;
                    }
                    if (i.hasPrevious()) {
                        System.out.println("Now playing " + i.previous().getSongName());
                    } else {
                        System.out.println("You are the start of playlist");
                    }
                    break;

                case 3:
                    if (goingForward) {
                        i.previous();
                        System.out.println("Now playing " + i.next().getSongName());
                    } else {
                        i.next();
                        System.out.println("Now playing " + i.previous().getSongName());
                    }
                    break;

                case 4:
                    quit = true;
                    return;
                default:
                    quit = true;
                    break;
            }

        }


    }

    private void printPlaylistMenu() {
        System.out.println("1. Play Next Song");
        System.out.println("2. Play Previous Song");
        System.out.println("3. Play Same Song");
        System.out.println("4. Quit to Main Menu");

    }

}
