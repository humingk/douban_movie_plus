// package org.humingk.movie.service.user.service.impl;
//
// import org.humingk.movie.service.user.service.MyUserDetailsService;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
// import javax.validation.ConstraintViolationException;
//
// @SpringBootTest
// @RunWith(SpringJUnit4ClassRunner.class)
// public class MyUserDetailsServiceImplTest {
//
//  @Autowired private MyUserDetailsService myUserDetailsService;
//
//  @Test
//  public void getUserByEmail() {
//        System.out.println(myUserDetailsService.getUserByEmail("email1").toString());
//  }
//
//  @Test(expected = ConstraintViolationException.class)
//  public void getUserByEmail2() {
//        System.out.println(myUserDetailsService.getUserByEmail("11").toString());
//  }
//
//  @Test
//  public void getRoleListByUserId() {
//        System.out.println(myUserDetailsService.getRoleListByUserId("humingk").toString());
//  }
//
//  @Test
//  public void loadUserByUsername() {
//        System.out.println(myUserDetailsService.loadUserByUsername("email1").toString());
//  }
// }
