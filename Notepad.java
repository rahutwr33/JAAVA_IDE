package notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.tools.JavaCompiler;
import static jdk.nashorn.internal.runtime.Debug.id;


public class Notepad<nvj>implements ActionListener
{
JMenu filemenu,help,output,font;
JMenuBar menubar;
JMenuItem newitem,openitem,saveitem,saveas,exititem,aboutus,compiler,interprator,myfont;
boolean opened = false;
boolean saved = false;
File openedFile;
JFrame f;
static JTextArea ta;
TextArea tb;
JScrollPane p;
JPanel pa;
Font fo;
JLabel l;
FileDialog fd;
FileReader fr;
BufferedReader br;
BufferedWriter bw;
FileWriter fw;
File fi=new File("Untitled");
String cmd,fname,dir,val,s1,sr,cmdr;
Object file;
JavaCompiler jc;

	 
Notepad()
	{
 
  try{

  f=new JFrame("MY_Editor");

     ta=new JTextArea(40,90);
     tb=new TextArea();
     ta.setBackground(Color.green);
     tb.setBackground(Color.yellow);
      
     p=new JScrollPane(ta);
       pa=new JPanel();
       l=new JLabel();
       menubar=new JMenuBar();
       filemenu=new JMenu("File");
       help=new JMenu("Help");
       output=new JMenu("Output");
       font=new JMenu("Font");
       saveas=new JMenuItem("Save File as");
    compiler=new JMenuItem("Compiler");
    interprator=new JMenuItem("Interprator");
    aboutus=new JMenuItem("Aboutus");
    newitem=new JMenuItem("Newfile");
    openitem=new JMenuItem("open");
    saveitem=new JMenuItem("save");
    exititem=new JMenuItem("exit");
    myfont=new JMenuItem("font");
    filemenu.setEnabled(true);
    filemenu.setVisible(true);
    compiler.setVisible(true);
    interprator.setVisible(true);
    
//add menuitem in menu....
    help.add(aboutus);
    help.setVisible(true);
    aboutus.setVisible(true);
    aboutus.addActionListener(this);
    output.add(compiler);
    output.add(interprator);
    output.addActionListener(this);
    compiler.addActionListener(this);
    interprator.addActionListener(this);
    interprator.setEnabled(true);
   
    help.setEnabled(true);
    aboutus.setEnabled(true);
    output.setEnabled(true);
    filemenu.add(newitem);
    filemenu.add(openitem);
    filemenu.add(saveitem);
    filemenu.add(saveas);
    filemenu.add(exititem);
    font.add(myfont);

//add menu in menubar...
    menubar.add(filemenu);
    menubar.add(help);
    menubar.add(font);
    menubar.setVisible(true);
    menubar.setEnabled(true);
    menubar.add(output);
    filemenu.setEnabled(true);
    newitem.setEnabled(true);
    newitem.addActionListener(this);
    openitem.setEnabled(true);
    openitem.addActionListener(this);
    saveitem.setEnabled(true);
    saveitem.addActionListener(this);
   exititem.setEnabled(true);
   exititem.addActionListener(this);
   compiler.setEnabled(true);
   saveas.setEnabled(true);
   saveas.addActionListener(this);
   
   f.setJMenuBar(menubar);
    f.add(pa);
    f.add(l);
    f.setContentPane(p);
    f.setSize(600,500);
    f.setVisible(true);
    f.setResizable(false);
    f.setLayout(new FlowLayout());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   tb.setVisible(false);
    
    ta.setEditable(true);
    ta.setVisible(true);
    f.add(ta);
    
 }
  catch(Exception ev)
  {}
	}
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	{
	Object File;
	
        if(e.getSource()==newitem)
	{
		
                
                ta.requestFocus();
            ta.reshape(0,0,640,410);
            ta.setText("");
        setTitle("Untitled");
        
	try
		{
		tb.setVisible(false);
			
		}
        catch(Exception es)
        {}
		}	
	
        else if(e.getSource()==exititem)
	{
	System.exit(0);
		
	}
	
        else if(e.getSource()==aboutus)
	{
		JOptionPane.showMessageDialog(f,"created by Rahul Tiwari\n\n"
				+"Email_id-->rahultwr33@gmail.com");
		
}
	else if(e.getSource()==openitem)
	{
	tb.setVisible(false);
        ta.setVisible(true);;
        ta.reshape(4,42,640,410);
        fd=new FileDialog(new Frame(),"OPEN File",FileDialog.LOAD);
        fd.show();
        fname=fd.getFile();
        dir=fd.getDirectory();

        try{
             fi=new File(dir,fname);
             setTitle(fi+"");
             ta.setText("");

             fr=new FileReader(fi);
             br=new BufferedReader(fr);
             String val=new String();
             while((val=br.readLine())!=null)
              {
                ta.append(val+"\n");
              }
           }catch(Exception exp){}
        ta.requestFocus();
        
}
else if(e.getSource()==saveitem)
	{
   
	try
		{
		String s=ta.getText();
		if(s.length()>0)
		{
		FileDialog fd= new FileDialog(new Frame(),"Save File As",FileDialog.SAVE);
                
		fd.setFile("temp.java");
                
		
		fd.setDirectory("C:\\Users\\abc\\Desktop");
		fd.setVisible(true);
		String path=fd.getDirectory()+fd.getFile();

		FileOutputStream fos=new FileOutputStream(path);
		System.out.println(s);
		byte[] b=s.getBytes();
		fos.write(b);
		fos.close();
		}
                }
        catch(NullPointerException eq){System.out.println(e);
		} catch (IOException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
else if(e.getSource()==saveas){
                try{
                String val;
                FileDialog fd=new FileDialog(new Frame(),"Save File As",FileDialog.SAVE);
                fd.show();
                fname=fd.getFile();
                dir=fd.getDirectory();
                setTitle(dir+fname);
                fi=new File(dir,fname);
                
                      fw=new FileWriter(fi);
                      bw=new BufferedWriter(fw);
                      fw.write(ta.getText());
                      fw.close();
                   }catch (Exception exp){System.out.println(exp);}
                 ta.requestFocus();

    
    
}

		else if(e.getSource()==compiler)
	{
		
		compiler();
		
	
		}
	else if(e.getSource()==interprator)
	{
		
		interprator();
		
	}
}
		
		private void setTitle(String string) {
			// TODO Auto-generated method stub
			
		}
		void compiler()
		{
                   
                f.add(tb);
                ta.setEditable(true);
               
               tb.reshape(0,292,640,160);
                ta.setVisible(true);
                tb.setVisible(true);
        comp();
                    
}
                void comp(){
                    if(fname.endsWith(".java"))
               {
                    tb.setText(" C O M P I L I N G !!");
                    try{
                         fw=new FileWriter(getTitle());
                          bw=new BufferedWriter(fw);
                          bw.write(ta.getText());
                          bw.close();
                       }catch (Exception expq){}
                   try
                    {
                       cmd = "javac"+" "+fname;
                       Process child = Runtime.getRuntime().exec(cmd);
                       InputStream in = child.getErrorStream();
                       DataInputStream dis=new DataInputStream(in);
                       String val;
                       tb.append("\n");
                       while((val=dis.readLine())!=null)
                         tb.append(val+"\n");
                       in.close();
                       try
                        {
                          child.waitFor();
                        }
                       catch(Exception ex){}
                       if(child.exitValue()==0)
                         {
                           tb.setText("Success class file created");
                         }
                     }
                    catch(Exception epv)
                    {
                         System.out.println(epv);
                    }
                  }
                 else
                  {
                      tb.setText("this is not a valid class");
                         
                  }
                }
                void interprator()
		{
                   
                    f.add(tb);
                ta.setEditable(true);
               tb.reshape(0,292,640,160);
                
                tb.setVisible(true);
		
            interprate();
                
    }
    void interprate(){
        
        tb.setText("");
               try
                {
                   int id = fname.indexOf('.');
                  String sr = fname.substring(0,id);
                   cmdr = "java"+" "+sr;
                   Process child = Runtime.getRuntime().exec(cmdr);
                   InputStream in = child.getInputStream();
                   DataInputStream dis=new DataInputStream(in);
                   String val;
                    tb.append("\n");
                    while((val=dis.readLine())!=null)
                            tb.append(val+"\n");
                    in.close();
                   try
                    {
                      child.waitFor();
                    }
                   catch(Exception ex){}
                   if(child.exitValue()!=0)
                     {
                       InputStream in1 = child.getErrorStream();
                       int re1;
                       while((re1=in1.read())!=-1)
                         tb.append(String.valueOf((char)re1));
                       in1.close();
                     }
                 }
                catch(Exception ep)
                 {
                   System.out.println(ep);
                 }

        
    }            
private String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}
		
                                   
public static void main(String rt[ ])
{
    new Notepad();
}
}
