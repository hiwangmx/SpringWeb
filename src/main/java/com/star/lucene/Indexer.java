package com.star.lucene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.star.utils.CloseUtils;

/**
 * 索引创建
 * 
 * @author Administrator
 *
 */
public class Indexer {

	/** 索引段名称 */
	private String fieldName;
	/** 问价段名称 */
	private String endStr;

	public Indexer(String fieldName, String endStr) {
		this.fieldName = fieldName;
		this.endStr = endStr;
	}

	/**
	 * 创建索引
	 * 
	 * @param indexDir
	 * @param dataDir
	 * @return
	 * @throws IOException
	 */
	public int index(File indexDir, File dataDir) throws IOException {

		// 路径是否存在
		if (!indexDir.exists() || !dataDir.exists()) {
			throw new IOException("indexDir or dataDir is not exists!");
		}

		// 是否是目录
		if (!indexDir.isDirectory() || !dataDir.isDirectory()) {
			throw new IOException("indexDir or dataDir is not directory!");
		}

		// 分词器
		Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_4_9, true);
		// 索引创建器配置
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LUCENE_4_9, analyzer);
		// 文件目录
		Directory directory = FSDirectory.open(dataDir);
		if (IndexWriter.isLocked(directory)) {
			IndexWriter.unlock(directory);
		}

		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		indexWriter.deleteAll();
		indexDirectory(indexWriter, dataDir);
		int numberIndexed = indexWriter.numDocs();
		CloseUtils.close(indexWriter);
		return numberIndexed;
	}
	
	/**
	 * 递归查询符合条件的文件
	 * @param indexWriter
	 * @param dir
	 * @throws IOException
	 */
	public void indexDirectory(IndexWriter indexWriter, File dir) throws IOException{
		File[] files = dir.listFiles();
		for(File file : files){
			if(file.isDirectory()){
				indexDirectory(indexWriter, dir);
			}else if(file.getName().endsWith(this.endStr)){
				indexFile(indexWriter, file);
			}
		}
	}

	/**
	 * 对文件创建索引
	 * @param indexWriter
	 * @param file
	 * @throws IOException
	 */
	public void indexFile(IndexWriter indexWriter, File file) throws IOException {
		// 判断是否 隐藏 存在 可读
		if (file.isHidden() || !file.exists() || !file.canRead()) {
			return;
		}
		System.out.println("indexed : " + file.getCanonicalPath());
		Document document = new Document();
		Field field = new Field(this.fieldName,
				file.getCanonicalPath(), Field.Store.YES, Index.ANALYZED);
		document.add(field);
	}

	/**
	 * 读取文件
	 * 
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public String getText(File file, String charset) throws IOException {
		InputStream fileInputStream = new FileInputStream(file);
		InputStreamReader inputStreamReader = new InputStreamReader(
				fileInputStream, charset);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = new String();
		StringBuilder sb = new StringBuilder();
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		CloseUtils.close(fileInputStream);
		CloseUtils.close(inputStreamReader);
		CloseUtils.close(bufferedReader);
		return sb.toString();
	}

}
