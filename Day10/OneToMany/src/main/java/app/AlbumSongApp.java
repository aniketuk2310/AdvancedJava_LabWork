package app;

import java.time.LocalDate;
import java.util.List;

import dao.AlbumSongDao;
import dao.GenericDao;
import entity.Album;
import entity.Song;

public class AlbumSongApp {

	public static void main(String[] args) {
		
		GenericDao dao = new GenericDao();
		/*
		//adding an album with generic method
		Album album = new Album();
		album.setName("Hits of 2022");
		album.setReleaseDate(LocalDate.of(2022, 10, 20));
		album.setCopyright("T Series");
		dao.save(album);
		*/	
		/*
		//adding song to an album with generic method
		Album al = (Album) dao.fetchById(Album.class, 1);
		Song song = new Song();
		song.setTitle("Tum hi ho");
		song.setArtist("Mithun");
		song.setDuration(4.20);
		song.setAlbum(al);	
		dao.save(song);
		*/
		
		
		/*
		//adding song to an album with generic method
		Album al = (Album) dao.fetchById(Album.class, 1);
		Song song = new Song();
		song.setTitle("Sunn raha hai na tu");
		song.setArtist("Mithun");
		song.setDuration(5.20);
		song.setAlbum(al);	
		dao.save(song);
		*/		
		/*
		//adding song to an album with generic method
		Album al = (Album) dao.fetchById(Album.class, 1);
		Song song = new Song();
		song.setTitle("Chahun mein ya na");
		song.setArtist("Mithun");
		song.setDuration(3.50);
		song.setAlbum(al);	
		dao.save(song);
		*/
		
		
		AlbumSongDao adao = new AlbumSongDao();
		
		//selecting song by artist name
		List<Song> songs = adao.fetchSongsByArtist("Mithun");
		for(Song s : songs) {
			System.out.println(s.getTitle()+"==>"+s.getAlbum().getName());
		}
		
		//deleting record
//		dao.delete(Song.class, 4);
		
		//selecting song/album by id
		Album list = (Album) dao.fetchById(Album.class, 1);
		System.out.println(list.getName());		//Hits of 2022
		
		Song s1 = (Song) dao.fetchById(Song.class, 1);
		System.out.println(s1.getTitle());		//Tum hi ho
		
		//selecting song by copyright
		List<Song> song = adao.fetchSongByCopyright("T Series");
		for(Song s : song) {
			System.out.println(s.getTitle()+"==>"+s.getArtist());
		}
	}

}
