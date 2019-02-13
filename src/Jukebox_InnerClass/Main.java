package Jukebox_InnerClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner menuOptionScanner = new Scanner(System.in);
        System.out.println("Welcome to Jukebox_LinkedList: ");
        Jukebox jukebox = new Jukebox("Jukebox_LinkedList");

        boolean quit = false;

        printMenu();
        Scanner stringScanner = new Scanner(System.in);
        Scanner intScanner = new Scanner(System.in);
        String albumName;
        String songName;
        int songLenght;
        String playlistName;
        Playlist searchPlaylist = null;
        Album album;

        while (!quit) {

            int menuOption = menuOptionScanner.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("Enter album name to create: ");
                    albumName = stringScanner.nextLine();
                    jukebox.createAlbum(albumName);
                    printMenu();
                    break;
                case 2:
                    System.out.print("Enter album name to remove: ");
                    albumName = stringScanner.nextLine();
                    jukebox.removeAlbum(albumName);
                    printMenu();
                    break;
                case 3:
                    System.out.print("Enter album name to add the song to: ");
                    albumName = stringScanner.nextLine();
                    album = jukebox.albumExists(albumName);
                    if(album != null){
                        System.out.print("Enter song name to add: ");
                        songName = stringScanner.nextLine();
                        System.out.print("Enter song lenght ");
                        songLenght = intScanner.nextInt();
                        album.addSongToAlbum(songName, songLenght);
                    }
                    else {
                        System.out.println(albumName + " does not exists and song is not added!");
                    }
                    break;
                case 4:
                    System.out.print("Enter album name to remove first: ");
                    albumName = stringScanner.nextLine();
                    album = jukebox.albumExists(albumName);
                    if(album != null){
                        System.out.print("Enter song name to remove: ");
                        songName = stringScanner.nextLine();
                        album.removeSongFromAlbum(songName);
                    }
                    else {
                        System.out.println(albumName + " does not exists and song is not removed!");
                    }
                    break;
                case 5:
                    System.out.print("Enter playlist name to create: ");
                    playlistName = stringScanner.nextLine();
                    jukebox.createPlaylist(playlistName);
                    printMenu();
                    break;
                case 6:
                    System.out.print("Enter playlist name to delete: ");
                    playlistName = stringScanner.nextLine();
                    jukebox.removePlaylist(playlistName);
                    printMenu();
                    break;
                case 7:
                    System.out.print("Enter playlist name first! ");
                    playlistName = stringScanner.nextLine();
                    searchPlaylist = jukebox.playlistExists((playlistName));
                    System.out.print("Enter the song to add into the playlist ");
                    songName = stringScanner.nextLine();
                    Song searchSong = jukebox.songInAlbum(songName);
                    if(searchPlaylist != null && searchSong != null) {
                        searchPlaylist.addSongToPlaylist(searchSong);
                    }
                    break;
                case 8:
                    System.out.print("Enter playlist name first! ");
                    playlistName = stringScanner.nextLine();
                    searchPlaylist = jukebox.playlistExists((playlistName));
                    System.out.print("Enter the song to remove from the playlist");
                    songName = stringScanner.nextLine();
                    searchSong = jukebox.songInAlbum(songName);
                    if(searchPlaylist != null && searchSong != null) {
                        searchPlaylist.removeSongFromPlaylist(searchSong);
                    }
                    break;
                case 9:
                    System.out.print("Select a playlist to play ");
                    playlistName = stringScanner.nextLine();
                    searchPlaylist = jukebox.playlistExists((playlistName));
                    searchPlaylist.playSong();
                    printMenu();
                    break;
                default:
                    quit = true;
                    break;
            }


        }

    }

    private static void printMenu() {
        System.out.println("1. Create an Album ");
        System.out.println("2. Remove an Album ");
        System.out.println("3. Add song to Album ");
        System.out.println("4. Remove song from Album  ");
        System.out.println("5. Create a Playlist ");
        System.out.println("6. Remove a Playlist ");
        System.out.println("7. Add song to Playlist ");
        System.out.println("8. Remove song from Playlist  ");
        System.out.println("9. Start Playlist ");
        System.out.println("10. Quit ");
        System.out.print("Enter Option: ");
    }

}
