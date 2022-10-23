package com.msdemokre.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.msdemokre.user.VO.Department;
import com.msdemokre.user.VO.ResponseTemplateVO;
import com.msdemokre.user.entity.User;
import com.msdemokre.user.repositery.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

	public ResponseTemplateVO getUserWithDepartment(Long userId) {

		ResponseTemplateVO vo=new ResponseTemplateVO();
		User user=userRepository.findByUserId(userId);
		
		Department department =
          restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);
		
//		Department department =
//		          restTemplate.getForObject("http://localhost:7001/departments/" + user.getDepartmentId()
//		                        ,Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
}
