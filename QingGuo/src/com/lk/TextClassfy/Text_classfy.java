package com.lk.TextClassfy;

import org.junit.Test;
import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

public class Text_classfy {

	public static String name_classfy(String name)
	{
		
		BasicTextClassifier classifier = new BasicTextClassifier();
		
		// 设置分类种类，并读取模型
		classifier.loadCategoryListFromFile("D:\\java_web\\QingGuo\\src\\com\\lk\\TextClassfy\\news_model\\category");
		classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
		classifier.getTextClassifier().loadModel("D:\\java_web\\QingGuo\\src\\com\\lk\\TextClassfy\\news_model");
		
		int topN = 3;  // 保留最有可能的3个结果
		ClassifyResult[] result = classifier.classifyText(name, topN); 
		
		return classifier.getCategoryName(result[0].label);

	}
	
	@Test
	public void test() 
	{
		System.out.println(name_classfy("笔记本电脑"));
	}
	
}
