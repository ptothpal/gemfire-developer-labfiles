package io.pivotal.bookshop.events;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.internal.logging.LogService;
import org.apache.logging.log4j.Logger;

import io.pivotal.bookshop.domain.BookMaster;

public class BookMasterCacheLoader implements CacheLoader<Integer, BookMaster> {

	public BookMaster load(LoaderHelper<Integer, BookMaster> helper) {
		JdbcBookDAO dao = new JdbcBookDAO();
		
		Integer key = helper.getKey();
		return dao.getBook(key);
	}

	public void close() {
		// do nothing
	}

}
