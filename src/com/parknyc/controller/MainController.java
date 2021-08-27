package com.parknyc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.parknyc.entities.Review;
import com.parknyc.entities.Trail;
import com.parknyc.entities.User;
import com.parknyc.services.TrailServices;
import com.parknyc.services.UserServices;

@Controller
@SessionAttributes("userLogin")
public class MainController {
	
	TrailServices trailServices = new TrailServices();
	UserServices userServices = new UserServices();
	
	@ModelAttribute("userLogin")
	public User setUpUser() {
		return new User();
	}
	
	@RequestMapping(value = {"/", "/index"})
	public String indexHandler() {
		return "index";
	}

	@RequestMapping("/login")
	public String loginHandler() {
		return "login";
	}
	
	@RequestMapping("/logout") 
	public String logoutHandler(HttpSession session, SessionStatus status) {

		status.setComplete(); //used to mark a session attribute as not needed after the request has been processed by the controller
		session.invalidate();
		
		return "logout";
	}
	
	@RequestMapping("/profile")
	public ModelAndView loginHandler(@ModelAttribute User user, @SessionAttribute("userLogin") User userSession) {
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		List<Review> reviewList = null;
		
//		System.out.println(user.getEmail());
//		System.out.println(userServices.validateUser(user.getEmail(), user.getPassword()));
		
		if (userServices.validateUser(user.getEmail(), user.getPassword()) == true) {
			
			User foundUser = userServices.getUser(user.getEmail());
			
			userSession.setId(foundUser.getId());
			userSession.setEmail(foundUser.getEmail());
			userSession.setPassword(foundUser.getPassword());
			userSession.setFirstName(foundUser.getFirstName());
			
			System.out.println(userSession);
			
			reviewList = userServices.getReviews(foundUser.getId());
//			userSession.setReviews(reviewList);
			mav.addObject("reviews", reviewList);
			
//			for(Review review: reviewList) {
//				System.out.println(review);
//			}
			
			
			viewName = "profile";
		}
//		} else {
//			viewName = "login";
//		}

		mav.setViewName(viewName);
		return mav;
		
	}
		
	@RequestMapping("/register")
	public String registerHandler() {
		return "register";
	}
	
	@RequestMapping("/success")
	public ModelAndView successHandler(@ModelAttribute User user) {
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		
		boolean savedUser = userServices.createUser(user);
		System.out.println(savedUser);
		mav.addObject("user", savedUser);
		
		viewName = "create-account-success";
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping("/results")
	public ModelAndView searchHandler(@RequestParam("search-input") String name/*, @RequestParam("option") int option*/) {
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		List<Trail> trailsList = null;
		
//		if (option == 1) {
//			trailsList = trailServices.getAllTrailsByPark(name);
//			System.out.println(trailsList);
//		} else {
//			trailsList = trailServices.getTrail(name);	
//			System.out.println(trailsList);
//		}
		trailsList = trailServices.getTrails(name);
		
			
		mav.addObject("trails", trailsList);
		
		viewName = "results";
		mav.setViewName(viewName);
		 
		return mav;
	}
	
//	@RequestMapping("/trail-page/{name}/add-trail-review")
//	public ModelAndView addReviewHandler(@PathVariable("name") String trailName, @ModelAttribute Review review, @SessionAttribute("userLogin") User userSession) {
//		ModelAndView mav = new ModelAndView();
//		
//		
//		
//		return mav;
//	}
	
	@RequestMapping("/trail-page/{name}")
	public ModelAndView trailPageHandler(@PathVariable("name") String trailName, @ModelAttribute Review review, @SessionAttribute("userLogin") User userSession) {
		
		ModelAndView mav = new ModelAndView();
		String viewName = null;
		List<Trail> trails = null;
		Trail trail = null;
		List<Review> trailReviews = null;
		
		trails = trailServices.getTrail(trailName); //get the trail name from path
		mav.addObject("trail", trails);
		
		System.out.println(trails.get(0).getId()); //get id of trail
		trail = trailServices.getTrail(trails.get(0).getId()); //get trail with that id
		Trail trail2 = trails.get(0);
		System.out.println(trail2 == trail);
		
		
		System.out.println(trails);
		System.out.println(userSession);

		review.setUser(userSession);
		review.setTrail(trail);

		
		System.out.println(review);
			

		// get trail reviews
		trailReviews = trailServices.getTrailReviews(trails.get(0).getId()); 
		mav.addObject("reviews", trailReviews); 
		
		viewName = "trail-page";
		mav.setViewName(viewName);
		
		return mav;
	}

	
//	@RequestMapping("/trail-page/{name}") 
//	public ModelAndView trailPageHandler(@PathVariable("name") String trailName, @ModelAttribute Review review, @SessionAttribute("userLogin") User userSession) {
//		
//		ModelAndView mav = new ModelAndView();
//		String viewName = null;
//		List<Trail> trails = null;
//		Trail trail = null;
//		List<Review> trailReviews = null;
//		
//		trails = trailServices.getTrail(trailName); //get the trail name from path
//		mav.addObject("trail", trails);
//		
//		System.out.println(trails.get(0).getId()); //get id of trail
//		trail = trailServices.getTrail(trails.get(0).getId()); //get trail with that id
//		System.out.println(trails);
//		System.out.println(userSession);
//
//		review.setUser(userSession);
////		review.setTrail(trail);
//
//		
//		System.out.println(review);
//			
//
//		// get trail reviews
//		trailReviews = trailServices.getTrailReviews(trails.get(0).getId()); 
//		mav.addObject("reviews", trailReviews); 
//		
//		viewName = "trail-page";
//		mav.setViewName(viewName);
//		
//		return mav;
//	}
//	
	
	
//	@RequestMapping("/trail-page/{name}")
//	public ModelAndView trailPageHandler(@PathVariable("name") String trailName, @ModelAttribute Review review, @SessionAttribute("userLogin") User userSession) {
//		
//		ModelAndView mav = new ModelAndView();
//		String viewName = null;
//		
//		Trail trail = trailServices.getTrail(trailID);
////		review.setTrail(trail);
//		mav.addObject("trail", trail);
///
////		
////		System.out.println(review);
////		
////
////		review.setRating(rating);
////		review.setReview(reviewtext);
//		
//		System.out.println(review);
//		
//		
//
//		
//		viewName = "trail-page";
//		mav.setViewName(viewName);
//		
//		return mav;
//	}
	
	
}
