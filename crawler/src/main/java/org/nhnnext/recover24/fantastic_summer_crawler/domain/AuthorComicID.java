package org.nhnnext.recover24.fantastic_summer_crawler.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AuthorComicID implements Serializable {

	private static final long serialVersionUID = 4908109350113884578L;
	
	@ManyToOne
	private Author author;
	
	@ManyToOne
	private Comic comic;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((comic == null) ? 0 : comic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorComicID other = (AuthorComicID) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (comic == null) {
			if (other.comic != null)
				return false;
		} else if (!comic.equals(other.comic))
			return false;
		return true;
	}

}
