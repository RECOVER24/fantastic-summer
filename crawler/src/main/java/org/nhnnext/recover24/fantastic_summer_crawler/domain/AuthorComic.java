package org.nhnnext.recover24.fantastic_summer_crawler.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "author_comic")
@Cache(region = "author_comic", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AssociationOverrides({
		@AssociationOverride(name = "pk.author", 
			joinColumns = @JoinColumn(name = "author_id")),
		@AssociationOverride(name = "pk.comic", 
			joinColumns = @JoinColumn(name = "comic_id")) })
public class AuthorComic implements Serializable {

	private static final long serialVersionUID = -3843599018509779672L;
	
	@EmbeddedId
	private AuthorComicID pk = new AuthorComicID();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable=true)
	private Date createDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "modify_date", nullable=true)
	private Date modifyDate;
	
	public AuthorComicID getPk() {
		return pk;
	}

	public void setPk(AuthorComicID pk) {
		this.pk = pk;
	}
	
	@Transient
	public Author getAuthor() {
		return this.pk.getAuthor();
	}
	
	public void setAuthor(Author author) {
		this.pk.setAuthor(author);
	}
	
	@Transient
	public Comic getComic() {
		return this.pk.getComic();
	}
	
	public void setComic(Comic comic) {
		this.pk.setComic(comic);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorComic other = (AuthorComic) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (modifyDate == null) {
			if (other.modifyDate != null)
				return false;
		} else if (!modifyDate.equals(other.modifyDate))
			return false;
		
		return true;
	}
	
	

}
