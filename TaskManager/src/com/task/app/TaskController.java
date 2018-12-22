package com.task.app;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("")
public class TaskController {
	public static TaskDAO taskDAO = new TaskDAO();
	@GET
    @Path("/helloworld")
    public Response getHelloWorld() {
        String value = "Hello World";
        return Response.status(200).entity(value).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
    }
	@GET
    @Path("/")
    public Response getFrontPage() {
        String value = "Hello ..Welcome to Task Manager";
        return Response.status(200).entity(value).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
    }
	@GET
    @Path("/TaskManager")
    public Response getFront2Page() {
        String value = "Hello ..Welcome to Task Manager";
        return Response.status(200).entity(value).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
    }
	@GET
	@Path("/alltasks")
	 @Produces(MediaType.APPLICATION_JSON)
	   
	public Response getTask() {
		List<Task> tasksList = taskDAO.getAllTask();
		Task fsg = new Task();
		for(Task tsk:tasksList){
			fsg = tsk;
		}
		 return Response.status(200).entity(tasksList).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
	}
	@GET
	@Path("/parents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParentTask() {
		List<String> parentTasks = taskDAO.getParentTask();		
		 return Response.status(200).entity(parentTasks).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
	}
	@GET
	@Path("/task/{id}")
	 @Produces(MediaType.APPLICATION_JSON)	   
	public Response getTaskById(@PathParam("id") int taskId) {
		Task tkk = taskDAO.findTask(taskId);
		if(tkk !=null){
			return Response.status(200).entity(tkk).header("Access-Control-Allow-Origin", "http://localhost:4200").build();
		}else{
			return Response.status(200).entity("No Such Task").header("Access-Control-Allow-Origin", "http://localhost:4200").build();
		}
	}
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	   
	public Response updateTask(Task task) {
		List<String> skl = new ArrayList<String>();
		String updateTask = "";
		int statusUp =200;
		Task tkk = taskDAO.findTask(task.getTaskId());
		if(tkk !=null){
			taskDAO.updateTask(task);
			updateTask = "Task Found and Updated";
		}else{
			statusUp=200;
			updateTask = "No such Task";
		}
		skl.add(updateTask);
		return Response.status(200).entity(skl).header("Access-Control-Allow-Origin", "http://localhost:4200").header("Access-Control-Allow-Headers","Content-Type").header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS").build();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	   
	public Response addTask(Task task) {
		List<String> skl = new ArrayList<String>();
		String updateTask = "";
		int statusUp =200;
		Task tkk = taskDAO.findTask(task.getTaskId());
		if(tkk ==null){
			taskDAO.addTask(task);
			updateTask = "Task Added";
		}
		skl.add(updateTask);
		return Response.status(200).entity(task).header("Access-Control-Allow-Origin", "http://localhost:4200").header("Access-Control-Allow-Headers","Content-Type").header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS").build();
	}
	@DELETE
	@Path("/delete/{id}")
	public Response deleteTaskById(@PathParam("id") int taskId) {
		String delTask = "";
		int statusUp =200;
		Task tkk = taskDAO.findTask(taskId);
		if(tkk !=null){
			taskDAO.deleteTask(tkk);
			delTask = "Task Found and Deleted";
		}else{
			statusUp=404;
			delTask = "No such Task";
		}
		List<Task> tasksList = taskDAO.getAllTask();
		 return Response.status(statusUp).entity(tasksList).header("Access-Control-Allow-Origin", "http://localhost:4200").header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS").build();
	}
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTask(Task task) {
		String delTask = "";
		int statusUp =200;
		Task tkk = taskDAO.findTask(task.getTaskId());
		if(tkk !=null){
			taskDAO.deleteTask(tkk);
			delTask = "Task Found and Deleted";
		}else{
			delTask = "No such Task";
		}
		List<Task> tasksList = taskDAO.getAllTask();
		 return Response.status(statusUp).entity("").header("Access-Control-Allow-Origin", "http://localhost:4200").header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS").build();
	}
	@PUT
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(Task task) {
		List<Task> takList = new ArrayList<Task>();
		
		System.out.println("task=="+task.toString());
		takList = taskDAO.searchTaskByCriteria(task);
		return Response.status(200).entity(takList).header("Access-Control-Allow-Origin", "http://localhost:4200").header("Access-Control-Allow-Headers","Content-Type").header("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS").build();
	}
}
