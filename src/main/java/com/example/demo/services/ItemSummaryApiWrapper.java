package com.example.demo.services;

import com.example.demo.swagger.ebay.api.ItemSummaryApi;
import com.example.demo.swagger.ebay.model.ItemSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class ItemSummaryApiWrapper {

	@Autowired
	private ItemSummaryApi itemSummaryApi;

	public List<ItemSummary> search(String q) {
		return itemSummaryApi.search("", "", "", "", "", "", "100", "", q, "").getItemSummaries();
	}
}
