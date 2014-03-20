package com.vipshop.microscope.storage;

import java.util.Map;

import com.vipshop.microscope.common.trace.Span;
import com.vipshop.microscope.storage.hbase.HbaseStorageRepository;
import com.vipshop.microscope.storage.hbase.domain.AppTable;
import com.vipshop.microscope.storage.hbase.domain.TraceTable;
import com.vipshop.microscope.storage.mysql.MySQLStorageRepository;

/**
 * Storage API.
 * 
 * Storage API responsible for save data to database.
 * 
 * @author Xu Fei
 * @version 1.0
 */
public class StorageRepository {
	
	private static class StorageRepositoryHolder {
		public static StorageRepository storageRepository = new StorageRepository();
	}
	
	public static StorageRepository getStorageRepository() {
		return StorageRepositoryHolder.storageRepository;
	}
	
	private final HbaseStorageRepository hbaseStorageRepository = new HbaseStorageRepository();
	
	private final MySQLStorageRepository mysqlStorageRepository = new MySQLStorageRepository();
	
	public void createHbaseTable() {
		hbaseStorageRepository.create();
	}
	
	public void dropHbaseTable() {
		hbaseStorageRepository.drop();
	}
	
	public void reInitalizeHbaseTable() {
		hbaseStorageRepository.reInitalize();
	}
	
	public void save(AppTable appTable) {
		hbaseStorageRepository.save(appTable);
	}
	
	public void save(TraceTable traceTable) {
		hbaseStorageRepository.save(traceTable);
	}
	
	public void save(Span span) {
		hbaseStorageRepository.save(span);
	}
	
	public void saveException(Map<String, Object> exception) {
		hbaseStorageRepository.saveException(exception);
	}
	
	public void saveJVM(Map<String, Object> jvm) {
		hbaseStorageRepository.saveJVM(jvm);
	}
	
	public void saveTop(Map<String, Object> top) {
		hbaseStorageRepository.saveTop(top);
	}
	
	public void createMySQLTable() {
		mysqlStorageRepository.create();
	}
	
}
