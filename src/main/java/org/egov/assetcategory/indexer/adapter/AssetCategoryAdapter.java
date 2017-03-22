package org.egov.assetcategory.indexer.adapter;


import org.egov.assetcategory.indexer.contract.AssetIndexDetails;
import org.egov.assetcategory.indexer.model.AssetCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class AssetCategoryAdapter {

	@Autowired
//	private AssetCategoryRepository  assetCategoryRepository;

	
	/***
	 * method to create assetIndexDetails object and populate values
	 * 
	 * @param Assetcategory
	 * @return AssetcategoryDetails
	 */
	public AssetIndexDetails indexOnCreate(AssetCategory assetCategory) {

		AssetIndexDetails assetIndexDetails = new AssetIndexDetails();
		assetIndexDetails = setAssetCategory(assetCategory, assetIndexDetails);
		
		

		return assetIndexDetails;
	}

	/***
	 * method to populate all assetcategory specific values assetcategorydetails object
	 * 
	 * @param assetcategoryDetails,assetcategory
	 * @return assetcategoryDetails
	 */
private AssetIndexDetails setAssetCategory(AssetCategory assetCategory, AssetIndexDetails assetIndexDetails) {
		
	assetIndexDetails.setAssetCategory(assetCategory);
		return assetIndexDetails;
	
	
	
	
	
}
}
