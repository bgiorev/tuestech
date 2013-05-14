package Diary;


import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class DBrowser {
	
	 String path;
	 String windowsPath;
	 public DBrowser(){
	  File file = new File("./DBrowser.java");
	  this.path=file.getParentFile().getAbsolutePath();
	  this.path=this.path.substring(0,path.length()-1);
	 // System.out.println(this.path+"Excersises.html");
	 }

	public void Start (Display display,Shell shell) {
	  
	  DBrowser a = new DBrowser();
	 
	  Browser browser;
	  try {
	    browser = new Browser(shell, SWT.NONE);
	    browser.setUrl(a.path+"Excersises.html");
	    browser.setSize(1366,768);
	    browser.setLocation(0, 0);
	   
	  
	    } catch (SWTError e) {
	         System.out.println("problem init the borwser");
	       }
	  
	  shell.open();
	  
	  while (!shell.isDisposed()) {
	   if (!display.readAndDispatch()) display.sleep();
	  }
	 // display.dispose();

	  
	 }
	  
	  
	}

