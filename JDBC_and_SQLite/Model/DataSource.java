package JDBC_and_SQLite.Model;

import java.util.*;
import java.sql.*; 

public class DataSource {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\Java workspace\\com\\JDBC\\Model\\" + DB_NAME;
    
    // TABLE ALBUMS
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START = "SELECT " +TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + " FROM "+
                               TABLE_ALBUMS + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS +'.' + COLUMN_ALBUM_ARTIST + " = " +TABLE_ARTISTS +'.' + COLUMN_ARTIST_ID +
                               " WHERE " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + " = \'";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT = " ORDER BY " + TABLE_ALBUMS + '.' +COLUMN_ALBUM_NAME + " COLLATE NOCASE ";    
    
    public static final String QUERY_SONGS_BY_ARTIST_START = "SELECT "+TABLE_SONGS + '.' + COLUMN_SONGS_TITLE + " FROM " + 
                               TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON "+ TABLE_SONGS + '.' + COLUMN_SONGS_ALBUM + " = " + 
                               TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST+
                               " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID + " WHERE " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + " = "; 

    public static final String QUERY_SONGS_BY_ARTIST_ORDER = " ORDER BY " + TABLE_SONGS + '.'+ COLUMN_SONGS_TITLE + " COLLATE NOCASE ";

    /* Select artists.name, albums.name, songs.track from songs inner join albums on songs.album = albums._id inner join artists on 
       albums.artist = artists._id where songs.title = "Go Your Own Way" 
       order by artists.name, albums.name collate nocase; */
    public static final String QUERY_INFO_OF_SONG_START = "SELECT " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME+ ", " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_NAME + ", " + 
                                TABLE_SONGS + '.' + COLUMN_SONGS_TRACK + " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " +  TABLE_SONGS + '.' + COLUMN_SONGS_ALBUM + 
                                " = "+ TABLE_ALBUMS + '.' +COLUMN_ALBUM_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST + 
                                " = "+ TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID + " WHERE " + TABLE_SONGS + '.'+COLUMN_SONGS_TITLE + " = ";                                                                                      

    public static final String QUERY_INFO_OF_SONG_SORT = " ORDER BY " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + " COLLATE NOCASE";                                
    
    // Creating view
    /* Create view if not exists artist_list as select artists.name, albums.name as album, songs.track, songs.title from songs inner join albums on 
       songs.album = albums._id inner join artists on albums.artist = artists._id order by artists.name, albums.name, songs.track; */
    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW + " as SELECT " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + '.' + 
                               COLUMN_ALBUM_NAME + " as album, " + TABLE_SONGS + '.' + COLUMN_SONGS_TRACK + ", " + TABLE_SONGS + '.' + COLUMN_SONGS_TITLE + " FROM " + 
                               TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + '.' + COLUMN_SONGS_ALBUM + " = " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ID + 
                               " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + '.' + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + '.' + COLUMN_ARTIST_ID + " ORDER BY " + 
                               TABLE_ARTISTS + '.' + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + '.' +  COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + '.' + COLUMN_SONGS_TRACK;
                               
    public static final String QUERY_VIEW_SONG_INFO = "SELECT "+ COLUMN_ARTIST_NAME + ", " + COLUMN_SONGS_ALBUM + ", "+ COLUMN_SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONGS_TITLE + " = \""; 
    
    // SELECT name, album, track, FROM artist_list where title = ?
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " + COLUMN_SONGS_ALBUM + ", " + COLUMN_SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + 
                                COLUMN_SONGS_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + '(' + COLUMN_ARTIST_NAME + ") VALUES(?)";    
    public static final String INSERT_ALBUM = "INSERT INTO " + TABLE_ALBUMS + '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS + '(' + COLUMN_SONGS_TRACK + ", " + COLUMN_SONGS_TITLE + ", " + COLUMN_SONGS_ALBUM + ") VALUES(?, ?, ?)"; 

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";
    
    private Connection conn;

    private PreparedStatement querySongInfoVeiw;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoVeiw = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to db: " + e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (querySongInfoVeiw != null) {
                querySongInfoVeiw.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("Couldn't close: " + e.getMessage());
        }
    }

    public List<Artist> queryArtists( int sortOrder) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if(sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if(sortOrder == ORDER_BY_DESC){
                sb.append(" DESC");
            } else {
                sb.append(" ASC");
            }
        }
        Statement st = null;
        ResultSet resultSet = null;
        try {
            st = conn.createStatement();
            resultSet = st.executeQuery(sb.toString());
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ALBUM_ID));
                artist.setName(resultSet.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch (Exception e) {
            System.out.println("Quering artists problem: "+ e.getMessage());
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                //nothing
            }
            try {
                if(st != null){
                    st.close();
                }
            } catch (SQLException e) {
                System.out.println("Closing problem");
            }
        }
    }

    public List<String> queryAlbumsForArtists(String artistName, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START + artistName + '\'' +' ');
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append(" DESC");
            } else {
                sb.append(" ASC");
            }
        }
        System.out.println("SQL Statement : " + sb.toString());
        try (Statement st = conn.createStatement(); 
             ResultSet rSet = st.executeQuery(sb.toString()))  {
            List<String> albums = new ArrayList<>();
            while(rSet.next()){
                albums.add(rSet.getString(COLUMN_ALBUM_NAME));  
            }            
            return albums;
        } catch (SQLException e) {
            // handle exception
            return null;
        }
    } 

    public List<String> querySongsbyArtist(String artist, int sortOrder){
        StringBuilder sb = new StringBuilder(QUERY_SONGS_BY_ARTIST_START);
        sb.append(" \'" + artist + "\' ");
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_SONGS_BY_ARTIST_ORDER);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append( " DESC");
            } else {
                sb.append(" ASC");
            }
        }
        System.out.println(sb.toString());
        try (Statement st = conn.createStatement(); 
            ResultSet rSet = st.executeQuery(sb.toString())) {
            List<String> result = new ArrayList<>();
            while (rSet.next()) {
                result.add(rSet.getString(COLUMN_SONGS_TITLE));
            }
            return result;
        } catch (Exception e) {
            // handle exception
            return null;
        }
    }

    public List<SongArtist> queryArtistForSong(String song, int sortOrder){
        StringBuilder sb = new StringBuilder();
        sb.append(QUERY_INFO_OF_SONG_START);
        sb.append("\"" + song + "\"" );
        if(sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_INFO_OF_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append(" DESC");
            } else {
                sb.append(" ASC");
            }
        }
        System.out.println(sb.toString());
        try (Statement st = conn.createStatement(); 
             ResultSet rSet = st.executeQuery(sb.toString())) {
            List<SongArtist> res = new ArrayList<>();
            while(rSet.next()){
                SongArtist now = new SongArtist(rSet.getString(1), rSet.getString(2), rSet.getInt(3));
                res.add(now);
            }
            return res;
        } catch (Exception e) {
            //handle exception
            return null;
        }
    }

    public void querySongsMetadata(){
        String sql = "SELECT * FROM " + TABLE_SONGS;
        try (Statement st = conn.createStatement(); 
            ResultSet rSet = st.executeQuery(sql)) {
            ResultSetMetaData rSetMetaData = rSet.getMetaData();
            int count = rSetMetaData.getColumnCount();
            for (int i = 1; i <=count; i++) {
                System.out.printf("Column index:%d \t Column name: %s \n",  i, rSetMetaData.getColumnName(i));
            }
        } catch (Exception e) {
            //handle exception
        }
    }

    public int getCount(String table){
        // String sql = "Select count(*) from " + table;
        /* try (Statement st = conn.createStatement(); 
             ResultSet rSet = st.executeQuery(sql)) {
            int count = rSet.getInt(1);
            return count;
        } */
        String sql = "Select count(*) as Count from " + table; 
        try (Statement st = conn.createStatement(); 
            ResultSet rSet = st.executeQuery(sql)) {
            int count = rSet.getInt("Count");
            return count;
        } catch (Exception e) {
            // handle exception
            return -1;
        } 
    }

    public boolean createViewForSongArtists(){
        try (Statement st = conn.createStatement()) {
            st.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (Exception e) {
            // handle exception
            return false;
        }
    }

    // Querying song info
    public List<SongArtist> querySongInfoView(String title){
        try {
          querySongInfoVeiw.setString(1, title);
          ResultSet rSet = querySongInfoVeiw.executeQuery();
          List<SongArtist> songInfoView = new ArrayList<>();
            while (rSet.next()) {
                SongArtist sArtist = new SongArtist();
                sArtist.setArtistName(rSet.getString(1));
                sArtist.setAlbumName(rSet.getString(2));
                sArtist.setTrack(rSet.getInt(3));
                songInfoView.add(sArtist);
            }
            return songInfoView;

        } catch (Exception e) {
            // handle exception
            System.out.println("Something is wrong" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private int insertArtist(String name) throws SQLException{
        queryArtist.setString(1, name);
        // check if artist exists
        ResultSet rSet = queryArtist.executeQuery();
        if (rSet.next()){
            return rSet.getInt(1);
        } else {
            // Need to insert artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist");
            }
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Could't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistID) throws SQLException{
        queryAlbum.setString(1, name);
        // check if artist album
        ResultSet rSet = queryAlbum.executeQuery();
        if (rSet.next()){
            return rSet.getInt(1);
        } else {
            // Need to insert album
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistID);
            int affectedRows = insertIntoAlbums.executeUpdate();
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album");
            }
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Could't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
            conn.setAutoCommit(false);
            int artistID = insertArtist(artist);
            int albumID = insertAlbum(album, artistID);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumID);
            
            int affectedRows = insertIntoSongs.executeUpdate();
            if (affectedRows == 1) {
                conn.commit();
            } else {
                throw new SQLException("Couldn't insert song");
            }
        } catch (Exception e) {
            System.out.println("Insert song exception: " +e.getMessage());
            try{
                System.out.println("Performing rollback ");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Rollback is failing: " + e.getMessage());
            } 
        } finally {
            try {
                System.out.println("Resetting default commit behaviour");
                conn.setAutoCommit(true);
            } catch (Exception e) {
                System.out.println("Couldn't reset to auto-commit: "+ e.getMessage());
            }    
        }      
    }    
}
