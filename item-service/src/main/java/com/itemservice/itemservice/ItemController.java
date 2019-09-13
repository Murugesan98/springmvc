package com.itemservice.itemservice;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController

@EnableHystrix
public class ItemController {
	
public static final  Logger logger= LoggerFactory.getLogger(ItemController.class);
@Autowired
ItemRepository itemRepository;

@Autowired
Environment environment;

@RequestMapping("api/service1/items/allitems")

public List<Items> getItemvalues(){
List<Items> item= itemRepository.findAll();
return item;

}
@RequestMapping("api/service1/items/{itemname}")
public Items getItem(@PathVariable String itemname) {
	logger.info("Inside getitem");
	 //Optional<Items> item= itemRepository.findOne(itemname);
	Items item= itemRepository.findOne(itemname);
	
item.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
return item;
}
@RequestMapping("items/fault-tolerance")
@HystrixCommand(fallbackMethod="fallbackgetitem")
public Items getitemFaultTolerance() {
	throw new  RuntimeException("someIssue");
}
public Items fallbackgetitem() {
	return new  Items("item_name",100L,"description",157);
	
}
}