package org.egov.assetcategory.indexer.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AssetCategory {

	private String assetCategoryName;
	private String assetCategoryCode;
	private String assetCategoryType;
	private String parent;
	private String depreciationMethod;
	private String assetAccount;
	private String unitOfMeasurement;
	private String depreciationRate;
	private String customFields;
	private String accumulatedDepreciationAccount;
    private String revaluationReserveAccount;
    private String depreciationExpenseAccount;
    
	
	
}
