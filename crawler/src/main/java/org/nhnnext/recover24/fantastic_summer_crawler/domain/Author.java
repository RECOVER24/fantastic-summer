package org.nhnnext.recover24.fantastic_summer_crawler.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nhnnext.recover24.fantastic_summer_crawler.common.enums.AuthorRoleType;

@Entity
@Table(name="authors")
@Cache(region = "author", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Author implements Serializable {
	
	private static final long serialVersionUID = -7192140129240370883L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", length=255, nullable=false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "author_role_code", length = 20, nullable = false)
	private AuthorRoleType authorRoleCode;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.author", cascade=CascadeType.ALL)
	private Set<AuthorComic> authorComics = new HashSet<AuthorComic>(0);
	
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable=true)
	private Date createDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "modify_date", nullable=true)
	private Date modifyDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthorRoleType getAuthorRoleCode() {
		return authorRoleCode;
	}

	public void setAuthorRoleCode(AuthorRoleType authorRoleCode) {
		this.authorRoleCode = authorRoleCode;
	}

	public Set<AuthorComic> getAuthorComics() {
		return authorComics;
	}

	public void setAuthorComics(Set<AuthorComic> authorComics) {
		this.authorComics = authorComics;
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
	
	

}
