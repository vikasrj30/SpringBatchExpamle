package com.vz.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vz.springbatch.model.Api;
import com.vz.springbatch.repository.ApiRepository;

@Component
public class ApiWriter implements ItemWriter<Api> {

	 @Autowired
	private ApiRepository apiRepository;

	    @Override
	    public void write(List<? extends Api> api) throws Exception {

	        System.out.println("Data Saved for api: " + api);
	        apiRepository.save(api);
	    }

}
