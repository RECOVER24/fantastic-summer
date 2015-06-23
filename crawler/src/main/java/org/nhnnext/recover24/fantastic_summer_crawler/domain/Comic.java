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
import org.nhnnext.recover24.fantastic_summer_crawler.common.enums.WeekFrequencyType;

@Entity
@Table(name="comics")
@Cache(region = "comic", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Comic implements Serializable {
	
	private static final long serialVersionUID = 3915902099036361635L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title", length=255, nullable=false)
	private String title;
	
	@Column(name = "thumbnail_uri", length=255, nullable=false)
	private String thumbnailUri;
	
	@Column(name = "link", length=255, nullable=false)
	private String link;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "comic", cascade=CascadeType.ALL)
	private Set<Episode> episodes = new HashSet<Episode>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.comic", cascade=CascadeType.ALL)
	private Set<AuthorComic> authorComics = new HashSet<AuthorComic>(0);
	
	@Enumerated(EnumType.STRING)
	@Column(name = "week_frequency_code", length = 20, nullable = false)
	private WeekFrequencyType weekFrequencyCode;
	
	@Column(name = "monday", nullable=true)
	private Boolean monday;
	
	@Column(name = "tuesday", nullable=true)
	private Boolean tuesday;
	
	@Column(name = "wednesday", nullable=true)
	private Boolean wednesday;
	
	@Column(name = "thursday", nullable=true)
	private Boolean thursday;
	
	@Column(name = "friday", nullable=true)
	private Boolean friday;
	
	@Column(name = "saturday", nullable=true)
	private Boolean saturday;
	
	@Column(name = "sunday", nullable=true)
	private Boolean sunday;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnailUri() {
		return thumbnailUri;
	}

	public void setThumbnailUri(String thumbnailUri) {
		this.thumbnailUri = thumbnailUri;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Episode> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Episode> episodes) {
		this.episodes = episodes;
	}

	public Set<AuthorComic> getAuthorComics() {
		return authorComics;
	}

	public void setAuthorComics(Set<AuthorComic> authorComics) {
		this.authorComics = authorComics;
	}

	public WeekFrequencyType getWeekFrequencyCode() {
		return weekFrequencyCode;
	}

	public void setWeekFrequencyCode(WeekFrequencyType weekFrequencyCode) {
		this.weekFrequencyCode = weekFrequencyCode;
	}

	public Boolean getMonday() {
		return monday;
	}

	public void setMonday(Boolean monday) {
		this.monday = monday;
	}

	public Boolean getTuesday() {
		return tuesday;
	}

	public void setTuesday(Boolean tuesday) {
		this.tuesday = tuesday;
	}

	public Boolean getWednesday() {
		return wednesday;
	}

	public void setWednesday(Boolean wednesday) {
		this.wednesday = wednesday;
	}

	public Boolean getThursday() {
		return thursday;
	}

	public void setThursday(Boolean thursday) {
		this.thursday = thursday;
	}

	public Boolean getFriday() {
		return friday;
	}

	public void setFriday(Boolean friday) {
		this.friday = friday;
	}

	public Boolean getSaturday() {
		return saturday;
	}

	public void setSaturday(Boolean saturday) {
		this.saturday = saturday;
	}

	public Boolean getSunday() {
		return sunday;
	}

	public void setSunday(Boolean sunday) {
		this.sunday = sunday;
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
