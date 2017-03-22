package org.egov.assetcategory.indexer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class PropertiesManager {

	/*@Autowired
	 private Environment environment;*/
	 
	 @Value("${egov.services.lams.assetindexer.host}")
	 private String elasticSearchHostUrl;
	 
	 
	 @Value("${egov.services.lams.assetindexer.type}")
	 private String elasticSearchType;
	 
	
}
