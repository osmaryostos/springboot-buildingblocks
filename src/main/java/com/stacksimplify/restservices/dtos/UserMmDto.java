package com.stacksimplify.restservices.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;

public class UserMmDto {
	
	private Long userid;
	private String username;
	private String firstname;
	private List<Order> orders;
	
	public UserMmDto(Long userid, String username, String firstname, List<Order> orders) {
		this.userid = userid;
		this.username = username;
		this.firstname = firstname;
		this.orders = orders;
	}
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public static UserMmDto userToUserDto(User user) {
		return new UserMmDto(user.getUserid(), user.getUsername(), user.getFirstname(), user.getOrders()); 
	}
	
	public static List<UserMmDto> userListToUserDtoList(List<User> userList) {
		return userList.stream().map(UserMmDto::userToUserDto).collect(Collectors.toList());
	}

}
