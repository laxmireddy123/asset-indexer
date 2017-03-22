package org.egov.assetcategory.indexer.consumers;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.egov.assetcategory.indexer.adapter.AssetCategoryAdapter;
import org.egov.assetcategory.indexer.contract.AssetIndexDetails;
import org.egov.assetcategory.indexer.model.AssetCategory;
import org.egov.assetcategory.indexer.repository.ElasticSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveAssetCategoryConsumer {

	
	public static final Logger LOGGER = LoggerFactory.getLogger(SaveAssetCategoryConsumer.class);

	@Autowired
	private ElasticSearchRepository elasticSearchRepository;

	@Autowired
	private AssetCategoryAdapter assetCategoryAdaptor;

	@KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = { "assetcategory-save-db",
			"assetcategory-update-db" })
	public void listen(ConsumerRecord<String, String> record) {
		LOGGER.info("key:" + record.key() + ":" + "value:" + record.value());
		
		System.out.println("this is asset consumer");

		if (record.topic().equals("assetcategory-save-db")) {

			ObjectMapper objectMapper = new ObjectMapper();
			AssetCategory assetCategory = null;
			try {
				LOGGER.info("SaveAssetCategoryConsumer assetcategory-save-db AssetCategoryDao:" + elasticSearchRepository);
				assetCategory = objectMapper.readValue(record.value(), AssetCategory.class);
			} catch (IOException e) {
				LOGGER.info(e.getMessage(), e);
			}
			if (assetCategory != null) {
				AssetIndexDetails assetIndexDetails = assetCategoryAdaptor.indexOnCreate(assetCategory);
				elasticSearchRepository.saveAssetCategory(assetIndexDetails);
			}
		}

		else if (record.topic().equals("assetcategory-update-db")) {

			ObjectMapper objectMapper = new ObjectMapper();
			AssetCategory assetCategory = null;
			try {
				LOGGER.info("SaveAssetCategoyConsumer assetcategory-update-db AssetCategoryDao:" + elasticSearchRepository);
				assetCategory = objectMapper.readValue(record.value(), AssetCategory.class);
			} catch (IOException e) {
				LOGGER.warn(e.getMessage(), e);
			}
			if (assetCategory != null) {
			AssetIndexDetails assetIndexDetails = assetCategoryAdaptor.indexOnCreate(assetCategory);
			elasticSearchRepository.updateAssetCategory(assetIndexDetails);
			}
		}

	}
}
