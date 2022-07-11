package com.app;

import java.util.ArrayList;
import java.util.List;

import com.dao.GenericDao;
import com.entity.Author;
import com.entity.Book;

public class BookAuthorApp {
	public static void main(String[] args) {
		GenericDao dao = new GenericDao();
		
//1)		//first adding authors and then adding book and then setting existing authors to the book 
		/*
		//adding authors to the table
		Author a = new Author();
		a.setName("Aniket");
		a.setEmail("ani@gmail.com");
		dao.save(a);
		Author a1 = new Author();
		a1.setName("Kale");
		a1.setEmail("Kale@gmail.com");
		dao.save(a1);
		*/
		
//2)		
		/*
		//adding a book along with their authors to table
		Book b = new Book();
		b.setName("GK");
		b.setCost(100);
		
		//making list of authors for the book
		List<Author> author = new ArrayList<Author>();
		author.add((Author) dao.fetchById(Author.class,1));
		author.add((Author) dao.fetchById(Author.class, 2));
		
		b.setAuthors(author);
		dao.save(b);
		*/
		
//3)		
		/*
		//adding book and then setting the existing author to it
		Book book = new Book();
		book.setName("Poems");
		book.setCost(150);
		dao.save(book);
		*/
//4)		
		/*
		Book b = (Book) dao.fetchById(Book.class, 2);
		List<Author> a = new ArrayList<Author>();
		a.add((Author) dao.fetchById(Author.class, 1));
		b.setAuthors(a);
		dao.save(b);
		*/
		
//5)	adding book and authors simultaneously
		
		Book book = new Book();
		book.setName("Storeis");
		book.setCost(200);
		
		Author author1 = new Author();
		author1.setName("SRK");
		author1.setEmail("SRK@gmail.com");
		
		Author author2 = new Author();
		author2.setName("Salman");
		author2.setEmail("Salman@gmail.com");
		
		List<Author> list = new ArrayList<Author>();
		list.add(author1);
		list.add(author2);
		
		book.setAuthors(list);
		dao.save(book);
	}
}
