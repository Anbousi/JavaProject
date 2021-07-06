package com.axsosacademy.demo.models;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity ;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paintings")
public class Painting {
	// attribute
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=true,length=64)
	private String pic;
	
	@Transient
	public String getPhotosImagePath() {
		if(pic == null || id == null ) return null;
		return"/painting-photos/" + id + "/" + pic;
	}

	@Size(min = 1, message = "Title must  be present")
	private String title;
	
	@Size(min = 1, message = "Description must  be present")
	private String descreption;
	
	@Min(1)
	private Double price;
	
	@Size(min = 1, message = "Artist name must  be present")
	private String artistname;
	
	@Size(min = 1, message = "Category must  be present")
	private String categoryname;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	public Painting() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	



	public Painting(@NotBlank String pic, @Size(min = 1, message = "Title must  be present") String title,
			@Size(min = 1, message = "Description must  be present") String descreption, @Min(1) Double price,
			@Size(min = 1, message = "Artist name must  be present") String artistname, Cart cart, Category category) {

		this.pic = pic;
		this.title = title;
		this.descreption = descreption;
		this.price = price;
		this.artistname = artistname;
		this.cart = cart;
		this.category = category;
	}





	// relationships
   
	@OneToOne(mappedBy="painting", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_id")
	private Category category;

	// getter and setter






	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescreption() {
		return descreption;
	}


	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}


	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	



}

