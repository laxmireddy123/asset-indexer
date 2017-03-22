package org.egov.assetcategory.indexer.contract;

import java.util.Date;

import org.egov.assetcategory.indexer.model.AssetCategory;

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
public class AssetIndexDetails {

	
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
    
	public void setAssetCategory(AssetCategory assetCategory){
		
		this.assetCategoryName = assetCategory.getAssetCategoryName();
		this.assetCategoryCode = assetCategory.getAssetCategoryCode();
		this.assetCategoryType = assetCategory.getAssetCategoryType();
		this.parent = assetCategory.getParent();
		this.depreciationMethod = assetCategory.getDepreciationMethod();
		this.assetAccount = assetCategory.getAssetAccount();
		this.unitOfMeasurement = assetCategory.getUnitOfMeasurement();
		this.depreciationRate = assetCategory.getDepreciationRate();
		this.customFields = assetCategory.getCustomFields();
		this.accumulatedDepreciationAccount = assetCategory.getAccumulatedDepreciationAccount();
	    this.revaluationReserveAccount = assetCategory.getRevaluationReserveAccount();
	    this.depreciationExpenseAccount = assetCategory.getDepreciationExpenseAccount();
		
		
	}
	
}
