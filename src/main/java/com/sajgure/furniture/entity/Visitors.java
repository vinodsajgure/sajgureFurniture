package com.sajgure.furniture.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "visitors")
public class Visitors {
	
	@Id
	@Column( name = "visitor_count", nullable = false, unique = true)
	private long visitorCount;

	public long getVisitorCount() {
		return visitorCount;
	}

	public void setVisitorCount(long visitorCount) {
		this.visitorCount = visitorCount;
	}
		
}
