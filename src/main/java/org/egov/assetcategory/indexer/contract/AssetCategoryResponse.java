package org.egov.assetcategory.indexer.contract;

import java.util.List;

import org.egov.assetcategory.indexer.contract.ResponseInfo;
import org.egov.assetcategory.indexer.model.AssetCategory;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
@ToString

public class AssetCategoryResponse {

	@JsonProperty("ResposneInfo")
	  private ResponseInfo resposneInfo = null;

	  @JsonProperty("AssetCategory")
	  private List<AssetCategory> assetcategory;
	
	
	
}
