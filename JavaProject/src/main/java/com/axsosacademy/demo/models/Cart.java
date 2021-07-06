package com.axsosacademy.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
//	relationship
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private Order order;
	
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Painting painting;
		
    
	
	
	public Cart() {
	}
	
	
	public Cart(User user, Painting painting) {
		this.user = user;
		this.painting = painting;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order i) {
		this.order = i;
	}

	public Painting getPainting() {
		return painting;
	}
	public void setPainting(Painting painting) {
		this.painting = painting;
	}
	public Cart(User user, Order order) {
		this.user = user;
		this.order = order;
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}


}
