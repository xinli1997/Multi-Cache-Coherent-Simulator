//package snoop;

import javax.swing.*;

//import directory.steps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;  
public class snoop {	
	/*****创建panel2~panel5******/
	static Mypanel panel2 =new Mypanel();
	static Mypanel panel3 =new Mypanel();
	static Mypanel panel4 =new Mypanel();
	static Mypanel panel5 =new Mypanel();
	static JButton button1_1=new JButton("复位");
	static JButton button1_2=new JButton("步进");
	static JButton button1_3=new JButton("连续执行");
	static int panel;
	static int cache_num;
	static boolean hit;
	static int group;
	static int memory;
	static int check[]= {0,0} ;
	static int check2[]= {0,0,0,0};
	static int state=0;
	/*********memory的标题*********/
	static String[] Mem_ca={
			"Memory","","","Memory","","","Memory","",""
	};
	
	/*********memory中的内容*********/
	static String[][] Mem_Content ={
			{"0","","","10","","","20","",""},{"1","","","11","","","21","",""},{"2","","","12","","","22","",""},
			{"3","","","13","","","23","",""},{"4","","","14","","","24","",""},{"5","","","15","","","25","",""},
			{"6","","","16","","","26","",""},{"7","","","17","","","27","",""},{"8","","","18","","","28","",""},
			{"9","","","19","","","29","",""}
	};
	
	static JComboBox<String> Mylistmodel1_1 = new JComboBox<>(new Mylistmodel());
	static class Mylistmodel extends AbstractListModel<String> implements ComboBoxModel<String>{		
		private static final long serialVersionUID = 1L;
		String selecteditem=null;
		private String[] test={"直接映射","两路组相联","四路组相联"};
		public String getElementAt(int index){
			return test[index];
		}
		public int getSize(){
			return test.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem( ){
			return selecteditem;
		}
		public int getIndex() {
			for (int i = 0; i < test.length; i++) {
				if (test[i].equals(getSelectedItem()))
					return i;
			}
			return 0;
		}
		
	}
	static class Mylistmodel2 extends AbstractListModel<String> implements ComboBoxModel<String>{		
		private static final long serialVersionUID = 1L;
		String selecteditem=null;
		private String[] test={"读","写"};
		public String getElementAt(int index){
			return test[index];
		}
		public int getSize(){
			return test.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem( ){
			return selecteditem;
		}
		public int getIndex() {
			for (int i = 0; i < test.length; i++) {
				if (test[i].equals(getSelectedItem()))
					return i;
			}
			return 0;
		}
		
	}
	static JComboBox<String> Mylistmodel3_1 = new JComboBox<>(new Mylistmodel3());
	static class Mylistmodel3 extends AbstractListModel<String> implements ComboBoxModel<String>{		
		private static final long serialVersionUID = 1L;
		String selecteditem=null;
		private String[] test={"传块优化","不传块优化"};
		public String getElementAt(int index){
			return test[index];
		}
		public int getSize(){
			return test.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem( ){
			return selecteditem;
		}
		public int getIndex() {
			for (int i = 0; i < test.length; i++) {
				if (test[i].equals(getSelectedItem()))
					return i;
			}
			return 0;
		}
		
	}
	static JComboBox<String> Mylistmodel4_1 = new JComboBox<>(new Mylistmodel4());
	static class Mylistmodel4 extends AbstractListModel<String> implements ComboBoxModel<String>{		
		private static final long serialVersionUID = 1L;
		String selecteditem=null;
		private String[] test={"写回法","写直达"};
		public String getElementAt(int index){
			return test[index];
		}
		public int getSize(){
			return test.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem( ){
			return selecteditem;
		}
		public int getIndex() {
			for (int i = 0; i < test.length; i++) {
				if (test[i].equals(getSelectedItem()))
					return i;
			}
			return 0;
		}
		
	}

	
	static class Mypanel extends JPanel implements ActionListener {
		private static final long serialVersionUID = 1L;
		JLabel label=new JLabel("访问地址");
		JLabel label_2=new JLabel("Process1");
		JLabel label_3=new JLabel("");
		
		JTextField jtext=new JTextField("");
		JButton button=new JButton("执行");
		JComboBox<String> Mylistmodel = new JComboBox<>(new Mylistmodel2());
		
		
		/*********cache中的标题*********/
		String[] Cache_ca={"Cache","读/写","目标地址","共享/独占"};
		/*********cache中的内容*********/
		String[][] Cache_Content = {
				{"0"," "," "," "},{"1"," "," "," "},{"2"," "," "," "},{"3"," "," "," "}
		};
		/************cache的滚动模版***********/
		JTable table_1 = new JTable(Cache_Content,Cache_ca); 
		JScrollPane scrollPane = new JScrollPane(table_1);
		
		public Mypanel(){
			super();
			setSize(350, 250);
			setLayout(null);
			
			/*****添加原件********/
			add(jtext);
			add(label);
			add(label_2);
			add(label_3);
			add(button);
			add(Mylistmodel);
			add(scrollPane);
			//add(scrollPane2);
			
			/****设置原件大小与字体********/
			label_2.setFont(new Font("",1,16));
			label_2.setBounds(10, 10, 100, 30);
			
			label_3.setFont(new Font("",1,16));
			label_3.setBounds(130, 10, 150, 30);
			
			label.setFont(new Font("",1,16));
			label.setBounds(10, 50, 100, 30);
			
			jtext.setFont(new Font("",1,15));
			jtext.setBounds(100, 50, 50, 30);
			
			Mylistmodel.setFont(new Font("",1,15));
			Mylistmodel.setBounds(160, 50, 50, 30);
			
			scrollPane.setFont(new Font("",1,15));
			scrollPane.setBounds(10, 90, 310, 90);
			
			//scrollPane2.setFont(new Font("",1,15));
			//scrollPane2.setBounds(10, 190, 310, 180);
			
			button.setFont(new Font("",1,15));
			button.setBounds(220,50, 100, 35);
			
			/******添加按钮事件********/
			button.addActionListener(this);
		}
		
		public void init(){
			/******Mypanel的初始化******/
			jtext.setText(" ");
			label_3.setText(" ");
			Mylistmodel.setSelectedItem(null);
			for(int i=0;i<=3;i++)
				for(int j=1;j<=3;j++)
					Cache_Content[i][j]=" ";
			for(int i=0;i<=9;i++)
				for(int j=1;j<=2;j++)
					Mem_Content[i][j]=" ";
			setVisible(false);
			setVisible(true);
			
		}
		public void operate() {
			boolean optimize=false;
			if(state==1)
			{	
				
				if(Mylistmodel1_1.getSelectedIndex() == 0) 
				{
				
						cache_num=memory%4;
						if(Cache_Content[cache_num][2]==" "||Integer.parseInt(Cache_Content[cache_num][2])!=memory)
					{
						if(Mylistmodel.getSelectedIndex()==0)
						{
						label_3.setText("读不命中");
						System.out.println( label_3);
						}
						else 
							{
							label_3.setText("写不命中");
							System.out.println( label_3);
							Cache_Content[cache_num][3]="独占";
							}
						hit=false;
						Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
						Cache_Content[cache_num][2]=Integer.toString(memory);
					}
						else
						{
							if(Mylistmodel.getSelectedIndex()==0)
							{
								label_3.setText("读命中");
								System.out.println( label_3);
							}
								else 
									{
									label_3.setText("写命中");
									System.out.println( label_3);
									Cache_Content[cache_num][3]="独占";
									}
							hit=true;
						}

				}
				if(Mylistmodel1_1.getSelectedIndex() == 1) 
				{
					Random random = new Random();
					int i = random.nextInt(2);
					
						if(Cache_Content[group*2][2]!=" "&&memory==Integer.parseInt(Cache_Content[group*2][2]))//memory==Integer.parseInt(Cache_Content[group*2][2])
					{
							cache_num=group*2;
						if(Mylistmodel.getSelectedIndex()==0)
						{
						label_3.setText("读命中");
						System.out.println( label_3);
						}
						else 
							{
							label_3.setText("写命中");
							System.out.println( label_3);
							Cache_Content[cache_num][3]="独占";
							}
						hit=true;
					}
						else if (Cache_Content[group*2+1][2]!=" "&&memory==Integer.parseInt(Cache_Content[group*2+1][2]))
						{
							cache_num=group*2+1;
							if(Mylistmodel.getSelectedIndex()==0)
							{
							label_3.setText("读命中");
							System.out.println( label_3);
							}
							else 
								{
								label_3.setText("写命中");
								System.out.println( label_3);
								Cache_Content[cache_num][3]="独占";
								}
							hit=true;
							
						}	
						else
						{
							
							hit=false;
							if(Cache_Content[group*2][2]==" "&&Cache_Content[group*2+1][2]==" ")
							{
								cache_num=group*2+i;
								System.out.println(group);
								check[group]=i;
							}
							else if(Cache_Content[group*2][2]==" ")
							{
								cache_num=group*2;
								check[group]=0;
							}
							else if(Cache_Content[group*2+1][2]==" ")
							{
								cache_num=group*2+1;
								check[group]=1;
							}
							else if(check[group]==0)
							{
								cache_num=group*2+1;
								check[group]=1;
							}
							else 
							{
								cache_num=group*2;
								check[group]=0;
							}
							if(Mylistmodel.getSelectedIndex()==0)
							{
								label_3.setText("读不命中");
								System.out.println( label_3);
							}
								else 
									{
									label_3.setText("写不命中");
									System.out.println( label_3);
									Cache_Content[cache_num][3]="独占";
									}
						}
						Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
						Cache_Content[cache_num][2]=Integer.toString(memory);
					}		
		if(Mylistmodel1_1.getSelectedIndex() == 2) 
		{

				if(Cache_Content[0][2]!=" "&&memory==Integer.parseInt(Cache_Content[0][2]))//memory==Integer.parseInt(Cache_Content[0][2])
			{
					cache_num=0;
				if(Mylistmodel.getSelectedIndex()==0)
				{
				label_3.setText("读命中");
				System.out.println( label_3);
				}
				else 
					{
					label_3.setText("写命中");
					System.out.println( label_3);
					Cache_Content[cache_num][3]="独占";
					}
				hit=true;
				
			}
				else if (Cache_Content[1][2]!=" "&&memory==Integer.parseInt(Cache_Content[1][2]))
				{
					cache_num=1;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_3.setText("读命中");
					System.out.println( label_3);
					}
					else 
						{
						label_3.setText("写命中");
						System.out.println( label_3);
						Cache_Content[cache_num][3]="独占";
						}
					hit=true;
					
				}	
				else if (Cache_Content[2][2]!=" "&&memory==Integer.parseInt(Cache_Content[2][2]))
				{
					cache_num=2;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_3.setText("读命中");
					System.out.println( label_3);
					}
					else 
						{
						label_3.setText("写命中");
						System.out.println( label_3);
						Cache_Content[cache_num][3]="独占";
						}
					hit=true;
					
				}	
				else if (Cache_Content[3][2]!=" "&&memory==Integer.parseInt(Cache_Content[3][2]))
				{
					cache_num=3;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_3.setText("读命中");
					System.out.println( label_3);
					}
					else 
						{
						label_3.setText("写命中");
						System.out.println( label_3);
						Cache_Content[cache_num][3]="独占";
						}
					hit=true;
					
				}	
				else
				{
					
					hit=false;
					if(Cache_Content[0][2]==" ")
					{
						cache_num=0;
						check2[0]++;
					}
					else if(Cache_Content[1][2]==" ")
					{
						cache_num=1;
						check2[1]++;
					}
					else if(Cache_Content[2][2]==" ")
					{
						cache_num=2;
						check2[2]++;
					}
					else if(Cache_Content[3][2]==" ")
					{
						cache_num=3;
						check2[3]++;
					}
					
					else 
					{
						if(check2[0]<check2[1]&&check2[0]<check2[2]&&check2[0]<check2[3])
						{
							cache_num=0;
							check2[0]=0;
						}
						else if(check2[1]<check2[2]&&check2[1]<check2[3])
						{
							cache_num=1;
							check2[1]=0;
						}
						else if(check2[2]<check2[3])
						{
							cache_num=2;
							check2[2]=0;
						}
						else
						{
							cache_num=3;
							check2[3]=0;
						}
					}
					if(Mylistmodel.getSelectedIndex()==0)
					{
						label_3.setText("读不命中");
						System.out.println( label_3);
					}
						else 
							{
							label_3.setText("写不命中");
							System.out.println( label_3);
							Cache_Content[cache_num][3]="独占";
							}
				}
				Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
				Cache_Content[cache_num][2]=Integer.toString(memory);
		
			}		}
			if(state==2)
				{
						if(Mylistmodel.getSelectedIndex()==0)
						{
							if(Mylistmodel3_1.getSelectedIndex()==0) {
							for(int i=2;i<=5;i++)
							{
								if(i!=panel)
								{
									for(int j=0;j<4;j++)
									{

										if(i==2&&panel2.Cache_Content[j][1]=="写"&&panel2.Cache_Content[j][3]=="独占"&&memory==Integer.parseInt(panel2.Cache_Content[j][2]))
										{

											panel2.Cache_Content[j][3]="共享";
											label_3.setText("从1中传块");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==3&&panel3.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel3.Cache_Content[j][2])&&panel3.Cache_Content[j][3]=="独占")
										{
											panel3.Cache_Content[j][3]="共享";
											label_3.setText("从2中传块");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==4&&panel4.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel4.Cache_Content[j][2])&&panel4.Cache_Content[j][3]=="独占")
										{
											panel4.Cache_Content[j][3]="共享";
											label_3.setText("从3中传块");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==5&&panel5.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel5.Cache_Content[j][2])&&panel5.Cache_Content[j][3]=="独占")
										{
											panel5.Cache_Content[j][3]="共享";
											label_3.setText("从4中传块");
											System.out.println( label_3);
											optimize=true;
											break;
										}
									}
								}
							}
							if(optimize==false&&hit==false)	
							{
							label_3.setText("从memory中读");
							}
							
						}
							else {for(int i=2;i<=5;i++)
							{
								if(i!=panel)
								{
									for(int j=0;j<4;j++)
									{

										if(i==2&&panel2.Cache_Content[j][1]=="写"&&panel2.Cache_Content[j][3]=="独占"&&memory==Integer.parseInt(panel2.Cache_Content[j][2]))
										{

											panel2.Cache_Content[j][3]="共享";
											label_3.setText("1->mem从mem读");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==3&&panel3.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel3.Cache_Content[j][2])&&panel3.Cache_Content[j][3]=="独占")
										{
											panel3.Cache_Content[j][3]="共享";
											label_3.setText("2->mem从mem读");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==4&&panel4.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel4.Cache_Content[j][2])&&panel4.Cache_Content[j][3]=="独占")
										{
											panel4.Cache_Content[j][3]="共享";
											label_3.setText("3->mem从mem读");
											System.out.println( label_3);
											optimize=true;
											break;
										}
										if(i==5&&panel5.Cache_Content[j][1]=="写" &&memory==Integer.parseInt(panel5.Cache_Content[j][2])&&panel5.Cache_Content[j][3]=="独占")
										{
											panel5.Cache_Content[j][3]="共享";
											label_3.setText("4->mem从mem读");
											System.out.println( label_3);
											optimize=true;
											break;
										}
									}
								}
							}
					}}
						else
						{
									for(int i=2;i<=5;i++)
									{
										for(int j=0;j<4;j++)
										{
											if(!(i==panel&&j==cache_num))
											{

												if(panel2.Cache_Content[j][2]!=" "&&i==2&&memory==Integer.parseInt(panel2.Cache_Content[j][2]))
												{
													panel2.Cache_Content[j][1]=" ";
													panel2.Cache_Content[j][2]=" ";
													panel2.Cache_Content[j][3]=" ";
												}
												if(panel3.Cache_Content[j][2]!=" "&&i==3&&memory==Integer.parseInt(panel3.Cache_Content[j][2]))
												{
													panel3.Cache_Content[j][1]=" ";
													panel3.Cache_Content[j][2]=" ";
													panel3.Cache_Content[j][3]=" ";
												}
												if(panel4.Cache_Content[j][2]!=" "&&i==4&&memory==Integer.parseInt(panel4.Cache_Content[j][2]))
												{
													panel4.Cache_Content[j][1]=" ";
													panel4.Cache_Content[j][2]=" ";
													panel4.Cache_Content[j][3]=" ";
												}
												if(panel5.Cache_Content[j][2]!=" "&&i==5&&memory==Integer.parseInt(panel5.Cache_Content[j][2]))
												{
													panel5.Cache_Content[j][1]=" ";
													panel5.Cache_Content[j][2]=" ";
													panel5.Cache_Content[j][3]=" ";
												}
											}
										}
								}
									if(Mylistmodel4_1.getSelectedIndex() == 1)
									{
										label_3.setText("写入memory");
										System.out.println( label_3);
										Cache_Content[cache_num][3]="共享";
									}
						}
				}
				}


		public void actionPerformed(ActionEvent e){

			/******编写自己的处理函数*******/
			
			if(e.getSource()==panel2.button)
			{
				panel=2;
				String txt=panel2.jtext.getText();
				memory=Integer.parseInt(txt);
					if(panel2.Mylistmodel.getSelectedIndex()==0)
						panel2.label_3.setText("读");
						else panel2.label_3.setText("写");
					state=0;
				group=memory%2;
			}
			if(e.getSource()==panel3.button)
			{
				panel=3;
				String txt=panel3.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel3.Mylistmodel.getSelectedIndex()==0)
					panel3.label_3.setText("读");
				else panel3.label_3.setText("写");
				state=0;
				group=memory%2;
			}
			if(e.getSource()==panel4.button)
			{
				panel=4;
				String txt=panel4.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel4.Mylistmodel.getSelectedIndex()==0)
					panel4.label_3.setText("读");
				else panel4.label_3.setText("写");
				group=memory%2;
				state=0;
			}
			if(e.getSource()==panel5.button)
			{
				panel=5;
				String txt=panel5.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel5.Mylistmodel.getSelectedIndex()==0)
					panel5.label_3.setText("读");
				else panel5.label_3.setText("写");
				group=memory%2;
				state=0;
			}
			
			/**********显示刷新后的数据********/
			panel2.setVisible(false);
			panel2.setVisible(true);
			panel3.setVisible(false);
			panel3.setVisible(true);					
			panel4.setVisible(false);
			panel4.setVisible(true);
			panel5.setVisible(false);
			panel5.setVisible(true);
		}
	}
	static class next_step  extends JButton implements ActionListener{		
		private static final long serialVersionUID = 1L;

		public next_step() {
		button1_2.addActionListener(this);}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1_2)
			{
				state++;
				if(panel==2)
					panel2.operate();
				if(panel==3)
					panel3.operate();
				if(panel==4)
					panel4.operate();
				if(panel==5)
					panel5.operate();
				panel2.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel3.setVisible(true);					
				panel4.setVisible(false);
				panel4.setVisible(true);
				panel5.setVisible(false);
				panel5.setVisible(true);}
	}
	}
	static class steps  extends JButton implements ActionListener{		
		private static final long serialVersionUID = 1L;

		public steps() {
		button1_3.addActionListener(this);}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button1_3)
			{
				for(int i=0;i<6;i++)
				{
					state++;
				if(panel==2)
					panel2.operate();
				if(panel==3)
					panel3.operate();
				if(panel==4)
					panel4.operate();
				if(panel==5)
				
					panel5.operate();
			panel2.repaint();
			panel3.repaint();
			panel4.repaint();
			panel5.repaint();
		         /*panel2.setVisible(false);
				panel2.setVisible(true);
				panel3.setVisible(false);
				panel3.setVisible(true);					
				panel4.setVisible(false);
				panel4.setVisible(true);
				panel5.setVisible(false);
				panel5.setVisible(true);	*/
				/*try {
			        Thread.sleep(2000);
			} catch (InterruptedException e1) {
			        //e1.printStackTrace();
			       
			}*/
				}
				}
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame myjf = new JFrame("多cache一致性模拟之监听法");
		myjf.setSize(1500, 600);
		myjf.setLayout(null);
		myjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container C1 = myjf.getContentPane();
		
		JTable table_2 = new JTable(Mem_Content,Mem_ca); 
		JScrollPane scrollPane2 = new JScrollPane(table_2);
		
		/*****新建panel1*****/
		JPanel panel1 = new JPanel();

		C1.add(panel2);
		C1.add(panel3);
		C1.add(panel4);
		C1.add(panel5);
		C1.add(scrollPane2);
		panel2.setBounds(10, 100, 350, 200);
		panel3.setBounds(360, 100, 350, 200);
		panel4.setBounds(720, 100, 350, 200);
		panel5.setBounds(1080, 100, 350, 200);
		scrollPane2.setBounds(200,350,1000,180);
		scrollPane2.setFont(new Font("",1,15));
		//scrollPane2.setBounds(100, 250, 310, 180);
		
		/********设置每个Mypanel的不同的参数************/
		panel2.label_2.setText("Process1");
		panel3.label_2.setText("Process2");
		panel4.label_2.setText("Process3");
		panel5.label_2.setText("Process4");
		panel2.table_1.getColumnModel().getColumn(0).setHeaderValue("cache1");
		panel2.Cache_ca[0]="Cache1";
		panel3.table_1.getColumnModel().getColumn(0).setHeaderValue("cache2");
		panel3.Cache_ca[0]="Cache2";
		panel4.table_1.getColumnModel().getColumn(0).setHeaderValue("cache3");
		panel4.Cache_ca[0]="Cache3";
		panel5.table_1.getColumnModel().getColumn(0).setHeaderValue("cache4");
		panel5.Cache_ca[0]="Cache4";
		
		
		//panel2.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory1");
		//panel3.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory2");
		//panel4.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory3");
		//panel5.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory4");
		
		for(int i=0;i<10;i++){
			//panel3.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+10));
			//panel4.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+20));
			//panel5.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+30));
		}
		/********设置头部panel*****/
		panel1.setBounds(10, 10, 1500, 100);
		panel1.setLayout(null);
		
		JLabel label1_1=new JLabel("执行方式:单步执行");
		label1_1.setFont(new Font("",1,20));
		label1_1.setBounds(15, 15, 200, 40);
		panel1.add(label1_1);
		
		//JComboBox<String> Mylistmodel1_1 = new JComboBox<>(new Mylistmodel());
		Mylistmodel1_1.setBounds(220, 15, 150, 40);
		Mylistmodel1_1.setFont(new Font("",1,20));
		panel1.add(Mylistmodel1_1);
		Mylistmodel3_1.setBounds(600, 15, 150, 40);
		Mylistmodel3_1.setFont(new Font("",1,20));
		panel1.add(Mylistmodel3_1);
		Mylistmodel4_1.setBounds(800, 15, 150, 40);
		Mylistmodel4_1.setFont(new Font("",1,20));
		panel1.add(Mylistmodel4_1);
		
		button1_1.setBounds(400, 15, 70, 40);
		
		button1_2.setBounds(500, 15, 70, 40);
		button1_3.setBounds(1000, 15, 100, 40);
		/**********复位按钮事件（初始化）***********/
		button1_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				panel2.init();
				panel3.init();
				panel4.init();
				panel5.init();
				Mylistmodel1_1.setSelectedItem(null);
				state=0;
			}
		});

		button1_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				new next_step();
			}
		});
		button1_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){	
				new steps();
					}
			
		});
		/*panel2.Mem_Content[1][1]="11";*/
		panel1.add(button1_1);
		panel1.add(button1_2);
		panel1.add(button1_3);
		C1.add(panel1);
		myjf.setVisible(true);
		

		
	}

	
}

