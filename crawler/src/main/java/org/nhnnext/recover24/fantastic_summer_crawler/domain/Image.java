package org.nhnnext.recover24.fantastic_summer_crawler.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="images")
@Cache(region = "image", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Image implements Serializable {
	
	private static final long serialVersionUID = -8930284192950947029L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "link", length=255, nullable=false)
	private String link;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="episode_id", nullable=false)
	private Episode episode;
	
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Episode getEpisode() {
		return episode;
	}

	public void setEpisode(Episode episode) {
		this.episode = episode;
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
