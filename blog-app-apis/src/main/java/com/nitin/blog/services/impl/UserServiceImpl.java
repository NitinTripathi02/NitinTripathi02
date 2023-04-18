package com.nitin.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitin.blog.entities.User;
import com.nitin.blog.exceptions.ResourceNotFoundException;
import com.nitin.blog.payloads.UserDto;
import com.nitin.blog.repositories.UserRepo;
import com.nitin.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//to create
	public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	//to updatee
	public UserDto updateUser(UserDto userDto, Integer UserId) {
         User user=this.userRepo.findById(UserId)
        		 .orElseThrow(()->new ResourceNotFoundException("User","Id",UserId));
 		user.setName(userDto.getName());
 		user.setEmail(userDto.getEmail());
 		user.setPassword(userDto.getPassword());
 		user.setAbout(userDto.getAbout());
 		
 		User Updateduser=this.userRepo.save(user);
 		UserDto userDto1=this.userToDto(Updateduser);
		return userDto1;
	}

	//to get by id
	public UserDto getUserById(Integer UserId) {
		User user=this.userRepo.findById(UserId)
       		 .orElseThrow(()->new ResourceNotFoundException("User","Id",UserId));
		return this.userToDto(user);
	}

	//to get all
	public List<UserDto> getAllUsers() {
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	//to delete with the help of id
	public void deleteUser(Integer UserId) {
		User user=this.userRepo.findById(UserId)
	       		 .orElseThrow(()->new ResourceNotFoundException("User","Id",UserId));
		this.userRepo.delete(user);
		}
	
	//Convert UserDto to User
	private User dtoToUser(UserDto userDto)
	{
		
		
		//It converts but its a tedious process we can get it done shortly using modelMapper
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
	     //we can convert the following userDto to user through ModelMapper by below steps
		User user=this.modelMapper.map(userDto,User.class);
		return user;
	}
	
	//Convert User to UserDto
	public UserDto userToDto(User user)
	{
//		UserDto userDto=new UserDto();
//	    userDto.setId(user.getId());
//	    userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		return userDto;
	    }
}
