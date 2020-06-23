package com.glassestore.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "order_detail", catalog = "glassestoredb")
@NamedQueries({
	@NamedQuery(name = "OrderDetail.bestSelling", 
			query = "SELECT od.glasses FROM OrderDetail od GROUP by od.glasses.glasseId "
					+ "ORDER BY SUM(od.quantity) DESC"),
	@NamedQuery(name = "OrderDetail.countByGlasses",
				query = "SELECT COUNT(*) FROM OrderDetail od WHERE od.glasses.glasseId =:glasseId")
	
})
public class OrderDetail{

	private OrderDetailId id = new OrderDetailId();
	private Glasses glasses;
	private GlassesOrder glasseOrder;
	private int quantity;
	private float subtotal;	

	public OrderDetail() {
	}

	public OrderDetail(OrderDetailId id) {
		this.id = id;
	}

	public OrderDetail(OrderDetailId id, Glasses glasses, GlassesOrder glasseOrder, int quantity, float subtotal) {
		this.id = id;
		this.glasses = glasses;
		this.glasseOrder = glasseOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
			@AttributeOverride(name = "glasseId", column = @Column(name = "glasses_id", nullable = false))})
	public OrderDetailId getId() {
		return this.id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "glasses_id", insertable = false, updatable = false, nullable = false)
	public Glasses getGlasses() {
		return this.glasses;
	}

	public void setBook(Glasses glasses) {
		this.glasses = glasses;
		this.id.setGlasses(glasses);
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
	public GlassesOrder getGlassesOrder() {
		return this.glasseOrder;
	}

	public void setGlassesOrder(GlassesOrder glasseOrder) {
		this.glasseOrder = glasseOrder;
		this.id.setGlassesOrder(glasseOrder);
	}
	
	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "subtotal", nullable = false, precision = 12, scale = 0)
	public float getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}	

}
