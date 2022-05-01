package io.hatchways.assessment.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Posts {
	
	private int id;
	
	private String author;
	
	private int authorId;
	
	private long likes;
	
	private double popularity;
	
	private long reads;
	
	private List<String> tags;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public double getPopularity() {
		return popularity;
	}

	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public long getReads() {
		return reads;
	}

	public void setReads(long reads) {
		this.reads = reads;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Posts(int id, String author, int authorId, long likes, double popularity, long reads, List<String> tags) {
		this.id = id;
		this.author = author;
		this.authorId = authorId;
		this.likes = likes;
		this.popularity = popularity;
		this.reads = reads;
		this.tags = tags;
	}
	
	public Posts() {
		
	}
	

}
