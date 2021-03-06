package main.src.utils.test.db;

import main.src.bean.WordBean;
import main.src.common.Container;
import main.src.services.main.InsertRecordBO;
import main.src.utils.main.db.DatabaseInsertTool;
import main.src.utils.main.db.DatabaseQueryTool;
import main.src.utils.main.db.DatabaseUpdateTool;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseToolsTest {
	@Test
	void test1(){
		ArrayList<Object> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		ResultSet rs = DatabaseQueryTool.query(list);
		try{
			while (rs.next()){
				System.out.println(rs.getString("english"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void test2(){
		ArrayList<WordBean> list = new ArrayList<>();
		for(int i=0;i<3;i++){
			WordBean b = new WordBean(1,"sdf","sdf",null,null,0,0);
			list.add(b);
		}
		DatabaseUpdateTool.update(list);
	}

	@Test
	void test3(){
		String startTime = InsertRecordBO.getCurrentTime();
		InsertRecordBO.getRecordInstance().setStartTime(startTime);
		String endTime = InsertRecordBO.getCurrentTime();
		InsertRecordBO.getRecordInstance().setEndTime(endTime);
		InsertRecordBO.getRecordInstance().setTestWordCount(1);
		ArrayList<Object> recordList = new ArrayList<>();
		recordList.add(InsertRecordBO.getRecordInstance());
		DatabaseInsertTool.insert(recordList);
	}
}
