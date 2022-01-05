package JDBC_and_SQLite.Model;

public class SongArtist {
    public String artistName;
    public String albumName;
    public int track;

    public SongArtist(){
        this.artistName = null; 
        this.albumName = null;
        this.track = 0;
    }

    public SongArtist(String art, String alb, int tra){
        this.artistName = art; 
        this.albumName = alb;
        this.track = tra;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }
    
}
