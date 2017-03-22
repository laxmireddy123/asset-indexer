package org.egov.assetcategory.indexer.repository;

import java.util.Map;

import org.egov.assetcategory.indexer.config.PropertiesManager;
import org.egov.assetcategory.indexer.contract.AssetIndexDetails;
import org.egov.assetcategory.indexer.model.AssetCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class ElasticSearchRepository {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PropertiesManager propertiesManager;
	
	@Autowired
	private AssetCategory assetCategoryAdaptor;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchRepository.class);
	
	public void saveAssetCategory(AssetIndexDetails assetIndexDetails){
		
		String indexServiceHost = propertiesManager.getElasticSearchHostUrl();
		String indexSericeType = propertiesManager.getElasticSearchType();
		// check for both index name and type name and id before confirming the url 
		String url = indexServiceHost+"/"+indexSericeType; 
	 //  for index id + indexId;
	   restTemplate.postForObject(url, assetIndexDetails, Map.class);
	}
	
	public void updateAssetCategory(AssetIndexDetails assetIndexDetails) {
		
		String indexServiceHost = propertiesManager.getElasticSearchHostUrl();
		String indexSericeType = propertiesManager.getElasticSearchType();
		String id = assetIndexDetails.getAssetCategoryCode();
		String url = indexServiceHost + "/" + indexSericeType + "/" + id;
		LOGGER.info("URL is --" +url);
		// TODO add unique id
		restTemplate.postForObject(url, assetIndexDetails, Map.class);
	}
	
	
	
	
}
