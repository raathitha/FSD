package com.task.app;

import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;




import java.util.Map;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class  TaskDAO{
	MongoClient client = new MongoClient("localhost", 27017); //connect to mongodb
	MongoDatabase database = client.getDatabase("taskmanager"); 
	// Retieving a collection
    MongoCollection<Document> collection = database.getCollection("tasktable"); 
    MongoCollection<Document> parentcollection = database.getCollection("parenttask"); 
    String TASK_ID_KEY = "Task_ID";
    String PARENT_TASK = "Parent_Task";
    String START_DATE = "Start_Date";
    String END_DATE = "End_Date";
    String PRIORITY = "Priority";
    String TASK_NAME = "Task";
    
    public void addTask(Task task){
	    Document document = new Document(TASK_ID_KEY, String.valueOf(task.taskId)) 
	    .append(PARENT_TASK, task.parentTask)
	    .append(START_DATE, task.startDate) 
	    .append(TASK_NAME, task.taskName) 
	    .append(END_DATE, task.endDate) 
	    .append(PRIORITY, String.valueOf(task.priority));	   
	    collection.insertOne(document);    
    }
    
    public List<Task> getAllTask(){
    	  // Getting the iterable object 
        FindIterable<Document> iterDoc = collection.find(); 
        int i = 1; 
        // Getting the iterator 
        Iterator<Document> it = iterDoc.iterator(); 
        List<Task> taskList = new ArrayList<Task>();
        while (it.hasNext()) {  
           Document task = it.next();
           Task tk = new Task();
           tk.setTaskId(Integer.valueOf((String)task.get(TASK_ID_KEY)));
           tk.setParentTask((String)task.get(PARENT_TASK));
           tk.setTaskName((String)task.get(TASK_NAME));
           tk.setStartDate((String)task.get(START_DATE));
           tk.setEndDate((String)task.get(END_DATE));
           if(task.get(PRIORITY) !=null){
        	   tk.setPriority(Integer.valueOf((String)task.get(PRIORITY)));               
           }
           taskList.add(tk);
        }   

        return taskList;
    }
    public Map<Integer,Task> getTaskMap(){
  	  // Getting the iterable object 
      FindIterable<Document> iterDoc = collection.find(); 
      int i = 1; 
      // Getting the iterator 
      Iterator<Document> it = iterDoc.iterator(); 
      Map<Integer,Task> taskMap = new HashMap<Integer,Task>();
      while (it.hasNext()) {  
         Document task = it.next();
         Task tk = new Task();
         tk.setTaskId(Integer.valueOf((String)task.get(TASK_ID_KEY)));
         tk.setParentTask((String)task.get(PARENT_TASK));
         tk.setTaskName((String)task.get(TASK_NAME));
         tk.setStartDate((String)task.get(START_DATE));
         tk.setEndDate((String)task.get(END_DATE));
         if(task.get(PRIORITY) !=null){
      	   tk.setPriority(Integer.valueOf((String)task.get(PRIORITY)));               
         }
         taskMap.put(Integer.valueOf((String)task.get(TASK_ID_KEY)),tk);
      }   

      return taskMap;
  }
    public List<Task> searchTaskByCriteria(Task uTask){
    	List<Task> objectLsit = new ArrayList<Task>();
    	BasicDBObject whereQuery = new BasicDBObject();
    	if(uTask.parentTask !=null){
    		whereQuery.put(PARENT_TASK, uTask.parentTask);            
    	}if(uTask.startDate !=null){
    		whereQuery.put(START_DATE, uTask.startDate);            
    	}if(uTask.endDate !=null){
    		whereQuery.put(END_DATE, uTask.endDate);
    	}if(uTask.priority !=0){
    		whereQuery.put(PRIORITY, String.valueOf(uTask.priority));
    	}if(uTask.taskName !=null){
    		whereQuery.put(TASK_NAME, uTask.taskName);
    	}
      
        FindIterable<Document> cursor = collection.find(whereQuery);
        // Getting the iterator 
        Iterator<Document> it = cursor.iterator(); 
        while (it.hasNext()) {  
           Document task = it.next();
           Task tk = new Task();
           tk.setParentTask((String)task.get(PARENT_TASK));
           tk.setTaskName((String)task.get(TASK_NAME));
           tk.setStartDate((String)task.get(START_DATE));
           tk.setEndDate((String)task.get(END_DATE));
           if(task.get(PRIORITY) !=null){
        	   tk.setPriority(Integer.valueOf((String)task.get(PRIORITY)));               
           }
           objectLsit.add(tk);
        }   
        return objectLsit;
    }
    public void updateTask(Task uTask){
    	collection.updateMany(Filters.eq(TASK_ID_KEY, String.valueOf(uTask.taskId)),Updates.combine(
    	        Updates.set(PARENT_TASK, uTask.getParentTask()),
    	        Updates.set(TASK_NAME, uTask.getTaskName()),
    	        Updates.set(START_DATE, uTask.getStartDate()), 
    	        Updates.set(END_DATE, uTask.getEndDate()),
    	        Updates.set(PRIORITY, String.valueOf(uTask.getPriority()))
    	    ) ); 
    }
    
    public void deleteTask(Task uTask){
    	collection.deleteOne(Filters.eq(TASK_ID_KEY, String.valueOf(uTask.taskId))); 
    }
    public List<String> getParentTask(){
    	  // Getting the iterable object 
        FindIterable<Document> iterDoc = parentcollection.find(); 
        int i = 1; 
        // Getting the iterator 
        Iterator<Document> it = iterDoc.iterator(); 
        List<String> parentTaskList = new ArrayList<String>();
        while (it.hasNext()) {  
           Document ptask = it.next();
           parentTaskList.add((String)ptask.get("Task_Name"));
        }   

        return parentTaskList;
    }
    public Task findTask(int tkId){
    	Task tk = null;
    	Map<Integer,Task> tkMap = getTaskMap();
    	if(tkMap.get(tkId) !=null){
        	tk = tkMap.get(tkId);    		
    	}
		return tk;    	
    }
}
