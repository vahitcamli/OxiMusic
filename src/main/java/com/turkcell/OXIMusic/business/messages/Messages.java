package com.turkcell.OXIMusic.business.messages;

public class Messages {

	public static class UserErrors{
		
		public static String User_Not_Found="userNotFound";
		public static String User_Already_Exists="userAlreadyExist";
		public static String Users_Not_Found="usersNotFound";
		
	}
	
	public static class GenreErrors{
		
		public static String Genre_Not_Found=" genreNotFound";
		public static String Genre_Already_Exists="genreAlreadyExist";
		public static String Genres_Not_Found="genresNotFound";
		
	}
	
	public static class ArtistErrors{
		
		public static String Artist_Not_Found=" artistNotFound";
		public static String Artist_Already_Exist="artistAlreadyExist";
		public static String Artists_Not_Found="artistsNotFound";
		
	}
	
	public static class AlbumErrors{
		
		public static String Album_Not_Found=" albumNotFound";
		public static String Album_Already_Exist="albumAlreadyExist";
		public static String Albums_Not_Found="albumsNotFound";
		
	}
	
	public static class SongErrors{
		
		public static String Song_Not_Found=" songNotFound";
		public static String Song_Already_Exist="songAlreadyExist";
		public static String Songs_Not_Found="songsNotFound";
		
	}
	
	public static class PaymentErrors{
		public static String User_is_Already_Subscriber="User is already a Subscriber";
		public static String User_is_Already_Partner="User is already a Partner";
	}
	
	public static class AuthErrors{
		public static String Eposta_Veya_Sifre_Hatali="E-posta veya sifre hatali";
	}
}
