package com.lz.testseckill.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seckill")
public class Seckill {

	@Id
	@GeneratedValue
	Integer id;
	
	@Column(name="[price]")
	Double price;
	
	@Column(name="start_time")
	String startTime;
	
	@Column(name="end_time")
	String endTime;
	
	@Column(name="[name]")
	String name;

	@Column(name="[num]")
	Integer num;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Seckill [id=" + id + ", price=" + price + ", startTime="
				+ startTime + ", endTime=" + endTime + ", name=" + name
				+ ", num=" + num + "]";
	}	
	
}
