package io.hatchways.assessment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.hatchways.assessment.entity.Posts;
import io.hatchways.assessment.entity.Success;
import io.hatchways.assessment.exception.SortByNotFoundException;
import io.hatchways.assessment.exception.TagNotFoundException;


@RestController
@RequestMapping("/api")
public class BlogPostsController {
	
	public List<Posts> savePosts()
	{
	Posts p1 = new Posts(1, "Rylee Paul", 9, 960, 0.13, 50361, Arrays.asList("tech", "health"));
	
	Posts p2 = new Posts(2, "Zackery Turner", 12, 469, 0.68, 90406, Arrays.asList("startups", "tech", "history"));
	
	Posts p3 = new Posts(4, "Elisha Friedman", 8, 728, 0.88, 19645, Arrays.asList("science", "design", "tech"));

	
	List<Posts> posts = new ArrayList<>();
	posts.add(p1);
	posts.add(p2);
	posts.add(p3);
	
	return posts;
	}
	
	@GetMapping("/ping")
	public ResponseEntity<Success> getPing()
	{
		Success s1 = new Success("true");
		
		return ResponseEntity.status(HttpStatus.OK).body(s1);
		
	}
	
	
	
	@GetMapping("/posts")
	public List<Posts> getPosts(@RequestParam("tags") List<String> tags, @RequestParam("sortBy") String sortBy, @RequestParam(name="direction" , required=false , defaultValue="asc") String direction)
	{
		
		System.out.println(tags.size());
		
		if(tags.size() == 0)
		{
			throw new TagNotFoundException();
		}
		
		List<Posts> posts = savePosts();

		List<Posts> posts2 = new ArrayList<>();
		
		System.out.println("get all method is called");

		for (int i = 0; i < posts.size(); i++) {
			for (int j = 0; j < tags.size(); j++) {
				if (posts.get(i).getTags().contains(tags.get(j))) {
					posts2.add(posts.get(i));
					break;
				}
			}
		}
		
		if(sortBy.equals("id") && direction.equals("desc"))
		{
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) 
			{
				return o2.getId() - o1.getId();
						
			}
			
		  });
		  return posts2;
		}
		
		if(sortBy.equals("id") && (direction.equals("asc")))
		{
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) 
			{
				return o1.getId() - o2.getId();
						
			}
			
		  });
		  return posts2;
		}
		
		if(sortBy.equals("likes") && direction.equals("desc"))
		{
			System.out.println("likes- desc");
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) {
				return (int)o2.getLikes() - (int)o1.getLikes();
			}

		  });
		  return posts2;
		}
		
		if(sortBy.equals("likes") && (direction.equals("asc")))
		{
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) {
				return (int)o1.getLikes() - (int)o2.getLikes();
			}

		  });
		  return posts2;
		}
		
		if(sortBy.equals("popularity") && direction.equals("desc"))
		{
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) {
				return (int)(o2.getPopularity()*100 - o1.getPopularity()*100);
			}

		  });
		  return posts2;
		}
		
		if(sortBy.equals("popularity") && (direction.equals("asc")))
		{
		  Collections.sort(posts2, new Comparator<Posts>()
		  {

			@Override
			public int compare(Posts o1, Posts o2) {
				return (int)o1.getPopularity() - (int)o2.getPopularity();
			}

		  });
		  return posts2;
		}
		
		else
		{
			throw new SortByNotFoundException();
		}
		
			
		
	}
	
	

}
