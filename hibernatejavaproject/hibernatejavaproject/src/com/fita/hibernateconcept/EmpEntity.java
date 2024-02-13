package com.fita.hibernateconcept;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class EmpEntity {
	@Id
	private int id;
	private String name;
	@Embedded
	private Address address;
	private int salary;

	@Override
	public String toString() {
		return "Embe_concep{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address=" + address +
				", salary=" + salary +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmpEntity(int id, String name, Address address, int salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public EmpEntity(){
		super();
	}
}
