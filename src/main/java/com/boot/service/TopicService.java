package com.boot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.boot.model.Topic;

@Service("topicService")
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
									new Topic("spring","spring boot","spring boot basics"),
									new Topic("java","Java 8","Java 8 in action"),
									new Topic("js","Java Script","Java Script Fundamentals")
								));
	
	public List<Topic> getTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}
	
	public void saveTopic(Topic topic) {
		 topics.add(topic);
	}
	
	public void updateTopic(Topic topic) {
		Optional<Topic> optionalTopic = topics.stream()
											  .filter(t -> t.getId().equalsIgnoreCase(topic.getId()))
											  .findFirst();
		optionalTopic.ifPresent(t -> {
			t.setDescription(topic.getDescription());
			t.setName(topic.getName());
		});
	}
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equalsIgnoreCase(id));
	}

}
