<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%
double total = (Runtime.getRuntime().totalMemory()) / (1024.0 * 1024);
double max = (Runtime.getRuntime().maxMemory()) / (1024.0 * 1024);
double free = (Runtime.getRuntime().freeMemory()) / (1024.0 * 1024);
//int activeThread = Thread.activeCount();
int waiting = 0;
int runnable = 0;
//out.println("availableProcessors():"+(Runtime.getRuntime().availableProcessors())+"<br/>");
//out.println("hashCode:"+(Runtime.getRuntime().hashCode())+"<br/>");
//out.println("(当前JVM的最大可用内存)maxMemory(): " + max + "MB<br/>");
//out.println("(当前JVM占用的内存总数)totalMemory(): " + total + "MB<br/>");
//out.println("(当前JVM空闲内存)freeMemory(): " + free + "MB<br/>");
//out.println("JVM实际可用内存: " + (max - total + free) + "MB<br/>");
  out.println("TOMCAT ID:" + session.getId()+"<br>");
Map <Thread, StackTraceElement[] > maps = Thread.getAllStackTraces();   
for(Map.Entry<Thread, StackTraceElement[]> entry : maps.entrySet()) {
	Thread t = entry.getKey();
	String s = t.getState().toString();
	if("WAITING".equals(s))
		waiting ++;
	else if("RUNNABLE".equals(s))
		runnable ++;
}
%>maxM:<%=max %>MB totalM:<%=total %>MB freeM:<%=free %>MB freeThread:<%=waiting %> runThread:<%=runnable %>