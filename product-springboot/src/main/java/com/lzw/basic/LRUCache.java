/**
 * FileName: LRUCache
 * Author:   lzw
 * Date:     2020/3/10 22:01
 * Description:
 * History:
 */
package com.lzw.basic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 〈LRU 缓存〉
 *
 * @author lzw
 * @create 2020/3/10
 * @since 1.0.0
 */
public class LRUCache extends LinkedHashMap {

	/**
	 * 保存3个热点
	 */
	private static int MAX_ENTRIES;

	/**
	 * 初始化最大热点数量
	 * @param maxEntries
	 */
	public LRUCache(int maxEntries) {
		super();
		MAX_ENTRIES = maxEntries;
	}

	/**
	 * 如果返回true，则删除头结点
	 * @param eldest
	 * @return
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry eldest) {
		return size() > MAX_ENTRIES;
	}
}