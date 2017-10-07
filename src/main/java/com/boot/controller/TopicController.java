package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Topic;
import com.boot.service.TopicService;


@RestController
public class TopicController {
	
	private TopicService topicService;
	
	@Autowired
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}
	
	//@RequestMapping("/topics")
	@GetMapping("/topics")
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}
	
	@GetMapping("/topics/{id}")
	//@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@PostMapping("/topics")
	//@RequestMapping(value="/topics",method=RequestMethod.POST)
	public void saveTopic(@RequestBody Topic topic) {
		topicService.saveTopic(topic);
	}
	
	@PutMapping("/topics")
	//@RequestMapping(value="/topics",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	//@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTipic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	


}
