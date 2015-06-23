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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nhnnext.recover24.fantastic_summer_crawler.common.enums.WebtoonStateType;

@Entity
@Table(name="episodes")
@Cache(region = "episode", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Episode implements Serializable {

	private static final long serialVersionUID = -7785775055242281530L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "webtoon_state_code", length = 20, nullable = false)
	private WebtoonStateType webtookStateCode;
	
	@Column(name = "title", length=255, nullable=false)
	private String title;
	
	@Column(name = "link", length=255, nullable=false)
	private String link;
	
	@Column(name = "rating", nullable=true)
	private Double rating;
	
	@Column(name = "comment_count", nullable=true)
	private Long commentCount;
	
	@Column(name = "amount", nullable=true)
	private Long amount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="comic_id", nullable=false)
	private Comic comic;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "episode", cascade=CascadeType.ALL)
	private Set<Image> images = new HashSet<Image>(0);
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delay_time", nullable=true)
	private Date delayTime;
	
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

	public WebtoonStateType getWebtookStateCode() {
		return webtookStateCode;
	}

	public void setWebtookStateCode(WebtoonStateType webtookStateCode) {
		this.webtookStateCode = webtookStateCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Long getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Long commentCount) {
		this.commentCount = commentCount;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Comic getComic() {
		return comic;
	}

	public void setComic(Comic comic) {
		this.comic = comic;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Date getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
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
