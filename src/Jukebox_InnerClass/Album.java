package Jukebox_InnerClass;

import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String albumName;
    SongList songList;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songList = new SongList();
    }

    public class SongList {
        private LinkedList<Song> songsList;

        public SongList() {
            this.songsList = new LinkedList<Song>();
        }

        public LinkedList<Song> getSongsList() {
            return songsList;
        }

        public void addSongToAlbum(Song song) {
            Song searchSong = songExists(song.getSongName());
            if(searchSong == null) {
                this.songsList.add(song);
                System.out.println(song.getSongName() + " has been added to " + albumName);
            }
            else {
                System.out.println(song.getSongName() + " already exists in " + getAlbumName());
            }
        }

        public Song songExists(String songName) {
            ListIterator<Song> i = this.songsList.listIterator();
            while(i.hasNext()) {
                if(i.next().getSongName().equals(songName)) {
                    i.previous();
                    return i.next();
                }
            }
            return null;
        }

        }

    public String getAlbumName() {
        return albumName;
    }

    public void addSongToAlbum(String songName, int songDuration) {
        this.songList.addSongToAlbum(new Song(songName,songDuration));
    }

    public void removeSongFromAlbum(String songName) {
        Song searchSong = songExists(songName);
        if(searchSong != null) {
            this.songList.getSongsList().remove(searchSong);
        }
        else {
            System.out.println(songName + " does not exists in " + getAlbumName());
        }
    }

    public Song songExists(String songName) {
        return this.songList.songExists(songName);
    }
}
