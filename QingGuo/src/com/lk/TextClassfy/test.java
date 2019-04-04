package com.lk.TextClassfy;

import org.thunlp.text.classifiers.BasicTextClassifier;
import org.thunlp.text.classifiers.ClassifyResult;
import org.thunlp.text.classifiers.LinearBigramChineseTextClassifier;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BasicTextClassifier classifier = new BasicTextClassifier();
		
		// 设置分类种类，并读取模型
		classifier.loadCategoryListFromFile("D:\\java_web\\QingGuo\\src\\com\\lk\\TextClassfy\\news_model\\category");
		classifier.setTextClassifier(new LinearBigramChineseTextClassifier(classifier.getCategorySize()));
		classifier.getTextClassifier().loadModel("D:\\java_web\\QingGuo\\src\\com\\lk\\TextClassfy\\news_model");
		
		/*
		 * 上面三行代码等价于设置如下参数，然后初始化并运行：
		 *
		   String defaultArguments = ""
		 +  "-l  my_novel_model"  // 设置您的训练好的模型的路径，这里的路径只是给出样例
		 ; 
		 classifier.Init(defaultArguments.split(" "));
		 classifier.runAsLinearBigramChineseTextClassifier();
		 * 
		 */
		
		// 之后就可以使用分类器进行分类
		String text = "足球";
		int topN = 3;  // 保留最有可能的3个结果
		ClassifyResult[] result = classifier.classifyText(text, topN); 
		for (int i = 0; i < topN; ++i) {
			// 输出分类编号，分类名称，以及概率值。
			System.out.println(result[i].label + "\t" + 
								classifier.getCategoryName(result[i].label) + "\t" + 
								result[i].prob); 
		}
		
	}

}
