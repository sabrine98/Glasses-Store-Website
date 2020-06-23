package com.glassestore.entity;


import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderDetailId {

	private Glasses glasses;
	private GlassesOrder glasseOrder;
	
	public OrderDetailId() {
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "glasses_id", insertable = false, updatable = false, nullable = false)
	public Glasses getGlasses() {
		return this.glasses;
	}

	public void setGlasses(Glasses glasses) {
		this.glasses = glasses;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
	public GlassesOrder getGlassesOrder() {
		return this.glasseOrder;
	}

	public void setGlassesOrder(GlassesOrder glasseOrder) {
		this.glasseOrder = glasseOrder;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((glasses == null) ? 0 : glasses.hashCode());
		result = prime * result + ((glasseOrder == null) ? 0 : glasseOrder.hashCode());
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
		OrderDetailId other = (OrderDetailId) obj;
		if (glasses == null) {
			if (other.glasses != null)
				return false;
		} else if (!glasses.equals(other.glasses))
			return false;
		if (glasseOrder == null) {
			if (other.glasseOrder != null)
				return false;
		} else if (!glasseOrder.equals(other.glasseOrder))
			return false;
		return true;
	}
	
	

}
