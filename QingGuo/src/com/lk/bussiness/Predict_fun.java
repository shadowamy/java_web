package com.lk.bussiness;

import java.sql.SQLException;
import java.util.*;

import org.junit.Test;

import com.lk.TextClassfy.Text_classfy;
import com.lk.entity.Allthings_list;
import com.lk.entity.Things_record;

public class Predict_fun {

	
	public static List<Map.Entry<String, Double>> predict()
	{
		Call_Allthings_list cal = new Call_Allthings_list();
		Call_Things_records ctr = new Call_Things_records();
		
		Map<String, Double> predict_result = new HashMap<String, Double>();
		String result = null;
		
		List<Map.Entry<String, Double>> wordMap = null;
		
		try {
			
			List<Allthings_list> list_cal = cal.findAll();
			//List<Things_record> list_ctr = ctr.findLatest();
			
			for(Allthings_list al:list_cal)
			{
				long now_date = new Date().getTime()/1000/60;
				Things_record record = ctr.findLatestOne(al.getTh_name());
				long before_date = record.getRe_time().getTime()/1000/60;
				
				long pre_time = now_date-before_date;
				int pre_count = al.getTh_count();
				String key_name = Text_classfy.name_classfy(record.getRe_name());
				double pre_grade = (1.0*pre_count)/(1.0*Math.log(pre_time/60));
				
				if(predict_result.containsKey(key_name))
				{
					double before_grade = predict_result.get(key_name);
					predict_result.put(key_name, before_grade+pre_grade);
				}
				else
				{
					predict_result.put(key_name, pre_grade);
				}
				
				//System.out.println(pre_grade);
				
			}
			
			wordMap = new ArrayList<Map.Entry<String, Double>>(predict_result.entrySet());
			Collections.sort(wordMap, new Comparator<Map.Entry<String, Double>>() {// ����value����
				public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
					double result = o2.getValue() - o1.getValue();
					if (result > 0)
						return 1;
					else if (result == 0)
						return 0;
					else
						return -1;
				}
			});
				
			
			result = wordMap.get(0).getKey();
			
			//System.out.println(predict_result);
			//System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//return result;
		return wordMap;
	}
	
	
	@Test
	public void test() 
	{
		System.out.println(predict());
	}
}
