package JDBC_and_SQLite.Model;

import java.util.*;

public class MainDB {
    
    public static void main(String[] args) {
        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Unable to establish connection!!");
            return;
        } else{
            System.out.println("Connection established!!");
        }
                // Artists list
        List<Artist> artists = dataSource.queryArtists(DataSource.ORDER_BY_DESC);
        if (artists == null) {
            System.out.println("No artists");
        } else {
            for (Artist artist : artists) {
                System.out.println(artist.getId()+ " " + artist.getName());
            }
        }

                // Albums By Artist
        List<String> albums = dataSource.queryAlbumsForArtists("Pink Floyd", 3);
        System.out.println(albums);
                
                // Songs by Artist                
        List<String> songs = dataSource.querySongsbyArtist("Iron Maiden", 2);
        for (String string : songs) {
            System.out.println(string);
        }
        System.out.println(songs.size());

                // Song Info
        List<SongArtist> songArtist = dataSource.queryArtistForSong("She\'s On Fire", 2);
        for (SongArtist songArtist2 : songArtist) {
            System.out.println( "Track: " + songArtist2.track + ", Album: " + songArtist2.albumName + ", Artist: " + songArtist2.artistName);
        }
        
        dataSource.querySongsMetadata();
        System.out.println("Songs: "+ dataSource.getCount(DataSource.TABLE_SONGS) +
                            ", Albums: "+ dataSource.getCount(DataSource.TABLE_ALBUMS) + 
                            ", Artists: "+ dataSource.getCount(DataSource.TABLE_ARTISTS));

        System.out.println(dataSource.createViewForSongArtists());     
        
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = console.nextLine();
        console.close();
        List<SongArtist> songArtistList = dataSource.querySongInfoView(title);
        if (songArtistList.isEmpty()) {
            System.out.println("List empty"); 
            return;
        }
        for (SongArtist songArtist2 : songArtistList) {
            System.out.println("Artist: "+ songArtist2.artistName + ", Album: " + songArtist2.albumName + ",  Track: " + songArtist2.track);
        }
        
        dataSource.insertSong("Sample", "Sample", "Sample", 1);
        dataSource.close();
    }
}
