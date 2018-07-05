import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class directory {	
	/*****创建panel2~panel5******/
	static Mypanel panel2 =new Mypanel();
	static Mypanel panel3 =new Mypanel();
	static Mypanel panel4 =new Mypanel();
	static Mypanel panel5 =new Mypanel();
	static JButton button1_1=new JButton("复位");
	static JButton button1_2=new JButton("步进");
	static JButton button1_3=new JButton("连续执行");
	static int cache_num;
	static int group;
	static int memory;
	static int panel;
	static int host;
	static boolean hit;
	static boolean cont=false;
	static int check[]= {0,0} ;
	static int check2[]= {0,0,0,0};
	static int state=0;
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
		JLabel label_4=new JLabel(".");
		JTextField jtext=new JTextField("");
		JButton button=new JButton("执行");
		JComboBox<String> Mylistmodel = new JComboBox<>(new Mylistmodel2());
		
		
		/*********cache中的标题*********/
		String[] Cache_ca={"Cache","读/写","目标地址","独占/共享"};
		/*********cache中的内容*********/
		String[][] Cache_Content = {
				{"0"," "," "," "},{"1"," "," "," "},{"2"," "," "," "},{"3"," "," "," "}
		};
		/*********memory的标题*********/
		String[] Mem_ca={
				"Memory","",""
		};
		
		/*********memory中的内容*********/
		String[][] Mem_Content ={
				{"0","",""},{"1","",""},{"2","",""},{"3","",""},{"4","",""},{"5","",""},{"6","",""},{"7","",""},
				{"8","",""},{"9","",""}
		};
		/************cache的滚动模版***********/
		JTable table_1 = new JTable(Cache_Content,Cache_ca); 
		JScrollPane scrollPane = new JScrollPane(table_1);
		/************memory的滚动模版***********/
		JTable table_2 = new JTable(Mem_Content,Mem_ca); 
		JScrollPane scrollPane2 = new JScrollPane(table_2);
		
		public Mypanel(){
			super();
			setSize(400, 400);
			setLayout(null);
			
			/*****添加原件********/
			add(jtext);
			add(label);
			add(label_2);
			add(label_3);
			add(label_4);
			add(button);
			add(Mylistmodel);
			add(scrollPane);
			add(scrollPane2);
			
			/****设置原件大小与字体********/
			label_2.setFont(new Font("",1,16));
			label_2.setBounds(10, 10, 100, 30);
			
			label_3.setFont(new Font("",1,16));
			label_3.setBounds(130, 10, 150, 30);
			
			label_4.setFont(new Font("",1,16));
			label_4.setBounds(10, 370, 300, 30);
			
			label.setFont(new Font("",1,16));
			label.setBounds(10, 50, 100, 30);
			
			jtext.setFont(new Font("",1,15));
			jtext.setBounds(100, 50, 50, 30);
			
			Mylistmodel.setFont(new Font("",1,15));
			Mylistmodel.setBounds(160, 50, 50, 30);
			
			scrollPane.setFont(new Font("",1,15));
			scrollPane.setBounds(10, 90, 310, 90);
			
			scrollPane2.setFont(new Font("",1,15));
			scrollPane2.setBounds(10, 190, 310, 180);
			
			button.setFont(new Font("",1,15));
			button.setBounds(220,50, 100, 35);
			
			/******添加按钮事件********/
			button.addActionListener(this);
		}
		
		public void init(){
			/******Mypanel的初始化******/
			jtext.setText(" ");
			label_3.setText(" ");
			label_4.setText(" ");
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
		public void operate()
		{
			if(state==1)
			{	
				label_3.setText("本地");
				if(memory/10==0&&panel!=2)
				{
					panel2.label_3.setText("宿主");
					host=2;
				}
				else if(memory/10==1&&panel!=3)
				{
					panel3.label_3.setText("宿主");
					host=3;
				}
				else if(memory/10==2&&panel!=4)
				{
					panel4.label_3.setText("宿主");
					host=4;
				}
				else if(memory/10==3&&panel!=5)
				{
					panel5.label_3.setText("宿主");
					host=5;
				}
				else 
					{
					label_3.setText("本地 宿主");
					host=panel;
					}
				if(Mylistmodel1_1.getSelectedIndex() == 0) 
				{
				
						cache_num=memory%4;
						if(Cache_Content[cache_num][2]==" "||Integer.parseInt(Cache_Content[cache_num][2])!=memory)
					{
						if(Mylistmodel.getSelectedIndex()==0)
						{
						label_4.setText("读不命中");
						System.out.println( label_4);
						}
						else 
							{
							label_4.setText("写不命中");
							System.out.println( label_4);
							}
						hit=false;
						Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
						Cache_Content[cache_num][2]=Integer.toString(memory);
					}
						else
						{
							if(Mylistmodel.getSelectedIndex()==0)
							{
								label_4.setText("读命中");
								System.out.println( label_4);
							}
								else 
									{
									label_4.setText("写命中");
									System.out.println( label_4);
									}
							hit=true;
						}

				}
				if(Mylistmodel1_1.getSelectedIndex() == 1) 
				{
					Random random = new Random();
					int i = random.nextInt(2);
					
						if(Cache_Content[group*2][2]!=" "&&memory==Integer.parseInt(Cache_Content[group*2][2]))
					{
							cache_num=group*2;
						if(Mylistmodel.getSelectedIndex()==0)
						{
						label_4.setText("读命中");
						System.out.println( label_4);
						}
						else 
							{
							label_4.setText("写命中");
							System.out.println( label_4);
							}
						hit=true;
					}
						else if (Cache_Content[group*2+1][2]!=" "&&memory==Integer.parseInt(Cache_Content[group*2+1][2]))
						{
							cache_num=group*2+1;
							if(Mylistmodel.getSelectedIndex()==0)
							{
							label_4.setText("读命中");
							System.out.println( label_4);
							}
							else 
								{
								label_4.setText("写命中");
								System.out.println( label_4);
								}
							hit=true;
							
						}	
						else
						{
							
							hit=false;
							if(Cache_Content[group*2][2]==" "&&Cache_Content[group*2+1][2]==" ")
							{
								cache_num=group*2+i;
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
								label_4.setText("读不命中");
								System.out.println( label_4);
							}
								else 
									{
									label_4.setText("写不命中");
									System.out.println( label_4);
									}
						}
						Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
						Cache_Content[cache_num][2]=Integer.toString(memory);
					}		
		if(Mylistmodel1_1.getSelectedIndex() == 2) 
		{

				if(Cache_Content[0][2]!=" "&&memory==Integer.parseInt(Cache_Content[0][2]))
			{
					cache_num=0;
				if(Mylistmodel.getSelectedIndex()==0)
				{
				label_4.setText("读命中");
				System.out.println( label_4);
				}
				else 
					{
					label_4.setText("写命中");
					System.out.println( label_4);
					}
				hit=true;
				
			}
				else if (Cache_Content[1][2]!=" "&&memory==Integer.parseInt(Cache_Content[1][2]))
				{
					cache_num=1;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_4.setText("读命中");
					System.out.println( label_4);
					}
					else 
						{
						label_4.setText("写命中");
						System.out.println( label_4);
						}
					hit=true;
				}	
				else if (Cache_Content[2][2]!=" "&&memory==Integer.parseInt(Cache_Content[2][2]))
				{
					cache_num=2;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_4.setText("读命中");
					System.out.println( label_4);
					}
					else 
						{
						label_4.setText("写命中");
						System.out.println( label_4);
						}
					hit=true;
					
				}	
				else if (Cache_Content[3][2]!=" "&&memory==Integer.parseInt(Cache_Content[3][2]))
				{
					cache_num=3;
					if(Mylistmodel.getSelectedIndex()==0)
					{
					label_4.setText("读命中");
					System.out.println( label_4);
					}
					else 
						{
						label_4.setText("写命中");
						System.out.println( label_4);
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
						label_4.setText("读不命中");
						System.out.println( label_4);
					}
						else 
							{
							label_4.setText("写不命中");
							System.out.println( label_4);
							}
				}
				Cache_Content[cache_num][1]= (String) Mylistmodel.getSelectedItem();
				Cache_Content[cache_num][2]=Integer.toString(memory);
		
			}		}
			if(state==2)
			{
				if(hit == false)
				{
					label_4.setText("本地：向宿主发"+Cache_Content[cache_num][1]+"不命中（"+panel+","+memory+"）消息");
					System.out.println( label_4);
				}
				else if(Mylistmodel.getSelectedIndex() == 1&&Mylistmodel4_1.getSelectedIndex() == 0) {
					Cache_Content[cache_num][3]="独占";
					if(host==2)
					{
						panel2.Mem_Content[memory%10][1]="独占";
					}
					if(host==3)
					{
						panel3.Mem_Content[memory%10][1]="独占";
					}
					if(host==4)
					{
						panel4.Mem_Content[memory%10][1]="独占";
					}
					if(host==5)
					{
						panel5.Mem_Content[memory%10][1]="独占";
					}
				}
					
			}
			if(state==3)
			{
				if(Mylistmodel.getSelectedIndex() == 1)
				{
					if(host==2)
					{
						panel2.Mem_Content[memory%10][2]=" ";
						
					}
					if(host==3)
					{
						panel3.Mem_Content[memory%10][2]=" ";
						
					}
					if(host==4)
					{
						panel4.Mem_Content[memory%10][2]=" ";
						
						System.out.println( label_4);
					}
					if(host==5)
					{
						panel5.Mem_Content[memory%10][2]=" ";
						
					}
					for(int i=2;i<=5;i++)
					{
						if(i!=panel)
						{
							for(int j=0;j<4;j++)
							{
								if(panel2.Cache_Content[j][2]!=" "&&i==2&&memory==Integer.parseInt(panel2.Cache_Content[j][2]))
								{

									panel2.Cache_Content[j][1]=" ";
									panel2.Cache_Content[j][2]=" ";
									panel2.Cache_Content[j][3]=" ";
									panel2.label_3.setText("远程");
									label_4.setText("宿主：向远程结点2发作废（"+memory+"）的消息");
									System.out.println( label_4);
								}
								if(panel3.Cache_Content[j][2]!=" "&&i==3&&memory==Integer.parseInt(panel3.Cache_Content[j][2]))
								{
									panel3.Cache_Content[j][1]=" ";
									panel3.Cache_Content[j][2]=" ";
									panel3.Cache_Content[j][3]=" ";
									panel3.label_3.setText("远程");
									label_4.setText("宿主：向远程结点3发作废（"+memory+"）的消息");
									System.out.println( label_4);
								}
								if(panel4.Cache_Content[j][2]!=" "&&i==4 &&memory==Integer.parseInt(panel4.Cache_Content[j][2]))
								{
									panel4.Cache_Content[j][1]=" ";
									panel4.Cache_Content[j][2]=" ";
									panel4.Cache_Content[j][3]=" ";
									panel4.label_3.setText("远程");
									label_4.setText("宿主：向远程结点4发作废（"+memory+"）的消息");
									System.out.println( label_4);
								}
								if(panel5.Cache_Content[j][2]!=" "&&i==5&&memory==Integer.parseInt(panel5.Cache_Content[j][2]))
								{
									panel5.Cache_Content[j][1]=" ";
									panel5.Cache_Content[j][2]=" ";
									panel5.Cache_Content[j][3]=" ";
									panel5.label_3.setText("远程");
									label_4.setText("宿主：向远程结点5发作废（"+memory+"）的消息");
									System.out.println( label_4);
								}
							}
						}
					}
				}
				else 
					{
					label_4.setText("宿主：向远程结点发取数据块"+memory+"的消息");
					System.out.println( label_4);
					}
			}
			if(state==4)
			{
				if(Mylistmodel.getSelectedIndex() == 0&&hit==false)
				{
					if(host==2)
					{
						panel2.Mem_Content[memory%10][1]="共享";
						panel2.Mem_Content[memory%10][2]=panel2.Mem_Content[memory%10][2]+Integer.toString(panel-1);
					    label_4.setText("共享集合为"+panel2.Mem_Content[memory%10][2]);
					    System.out.println( label_4);
					}
					if(host==3)
					{
						panel3.Mem_Content[memory%10][1]="共享";
						panel3.Mem_Content[memory%10][2]=panel3.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						label_4.setText("共享集合为"+panel3.Mem_Content[memory%10][2]);
						System.out.println( label_4);
					}
					if(host==4)
					{
						panel4.Mem_Content[memory%10][1]="共享";
						panel4.Mem_Content[memory%10][2]=panel4.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						label_4.setText("共享集合为"+panel4.Mem_Content[memory%10][2]);
						System.out.println( label_4);
					}
					if(host==5)
					{
						panel5.Mem_Content[memory%10][1]="共享";
						panel5.Mem_Content[memory%10][2]=panel5.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						label_4.setText("共享集合为"+panel5.Mem_Content[memory%10][2]);
						System.out.println( label_4);
					}
				}
				else if(Mylistmodel.getSelectedIndex() == 1)
				{
					label_4.setText("宿主：把数据块送给本地结点");
					System.out.println( label_4);
					
				}
			}
			if(state==5)
			{
				if(Mylistmodel.getSelectedIndex() == 1&&Mylistmodel4_1.getSelectedIndex() == 0)
				{
					
					if(host==2)
					{
						panel2.Mem_Content[memory%10][2]=panel2.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						panel2.Mem_Content[memory%10][1]="独占";
					    label_4.setText("共享集合为"+panel2.Mem_Content[memory%10][2]);
					    System.out.println( label_4);
					}
					if(host==3)
					{
						panel3.Mem_Content[memory%10][2]=panel3.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						panel3.Mem_Content[memory%10][1]="独占";
						label_4.setText("共享集合为"+panel3.Mem_Content[memory%10][2]);
						System.out.println( label_4);
					}
					if(host==4)
					{
						panel4.Mem_Content[memory%10][2]=panel4.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						panel4.Mem_Content[memory%10][1]="独占";
						label_4.setText("共享集合为"+panel4.Mem_Content[memory%10][2]);
						System.out.println( label_4);
					}
					if(host==5)
					{
						panel5.Mem_Content[memory%10][2]=panel5.Mem_Content[memory%10][2]+Integer.toString(panel-1);
						panel5.Mem_Content[memory%10][1]="独占";
						label_4.setText("共享集合为"+panel5.Mem_Content[memory%10][2]);
						System.out.println( label_4);
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
						panel2.label_4.setText("读");
						else panel2.label_4.setText("写");
					state=0;
				group=memory%2;
				panel2.label_3.setText(" ");
				panel3.label_3.setText(" ");
				panel4.label_3.setText(" ");
				panel5.label_3.setText(" ");
			}
			if(e.getSource()==panel3.button)
			{
				panel=3;
				String txt=panel3.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel3.Mylistmodel.getSelectedIndex()==0)
					panel3.label_4.setText("读");
				else panel3.label_4.setText("写");
				state=0;
				group=memory%2;
				panel2.label_3.setText(" ");
				panel3.label_3.setText(" ");
				panel4.label_3.setText(" ");
				panel5.label_3.setText(" ");
			}
			if(e.getSource()==panel4.button)
			{
				panel=4;
				String txt=panel4.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel4.Mylistmodel.getSelectedIndex()==0)
					panel4.label_4.setText("读");
				else panel4.label_4.setText("写");
				group=memory%2;
				state=0;
				panel2.label_3.setText(" ");
				panel3.label_3.setText(" ");
				panel4.label_3.setText(" ");
				panel5.label_3.setText(" ");
			}
			if(e.getSource()==panel5.button)
			{
				panel=5;
				String txt=panel5.jtext.getText();
				memory=Integer.parseInt(txt);
				if(panel5.Mylistmodel.getSelectedIndex()==0)
					panel5.label_4.setText("读");
				else panel5.label_4.setText("写");
				group=memory%2;
				state=0;
				panel2.label_3.setText(" ");
				panel3.label_3.setText(" ");
				panel4.label_3.setText(" ");
				panel5.label_3.setText(" ");
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
		JFrame myjf = new JFrame("多cache一致性模拟之目录法");
		myjf.setSize(1800, 600);
		myjf.setLayout(null);
		myjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container C1 = myjf.getContentPane();
		
		/*****新建panel1*****/
		JPanel panel1 = new JPanel();

		C1.add(panel2);
		C1.add(panel3);
		C1.add(panel4);
		C1.add(panel5);
		panel2.setBounds(10, 100, 350, 500);
		panel3.setBounds(360, 100, 350, 500);
		panel4.setBounds(720, 100, 350, 500);
		panel5.setBounds(1080, 100, 350, 500);
		
		
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
		
		
		panel2.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory1");
		panel3.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory2");
		panel4.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory3");
		panel5.table_2.getColumnModel().getColumn(0).setHeaderValue("Memory4");
		
		for(int i=0;i<10;i++){
			panel3.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+10));
			panel4.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+10));
			panel5.Mem_Content[i][0]=String.valueOf((Integer.parseInt(panel3.Mem_Content[i][0])+20));
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

