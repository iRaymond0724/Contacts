package jia.dao;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.junit.Test;


/*
 github_教學 : https://cloud.tencent.com/developer/article/1416782
 */
public class Contacts extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Vector<Vector<String>> data = new Vector<Vector<String>>();
	public Vector<String> dataTitle = new Vector<String>();
	public static JLabel label_path = new JLabel();

	public void CreateJFrame(String title) {
		JFrame jFrame = new JFrame(title);
		FlowLayout flowLayout=new FlowLayout(FlowLayout.LEFT,20,40);
		jFrame.setLayout(flowLayout);
		Container container = jFrame.getContentPane();
		JButton input_btn = new JButton("选择档案");
		JButton output_btn = new JButton("一鍵轉換");
		JTable jTable = new JTable(3,3);
		input_btn.setVisible(true);
		output_btn.setVisible(true);
		input_btn.setSize(150, 150);
		output_btn.setSize(150,150);
		label_path.setVisible(true);
		jTable.setVisible(true);
	//	jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(input_btn);
		container.add(label_path);
		container.add(jTable);
		container.add(output_btn);
		container.setBackground(Color.white);
		jFrame.setVisible(true);
		jFrame.setSize(700,700);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		input_btn.addActionListener(new input_file());
	}
	
	class input_file implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JFileChooser chooser = new JFileChooser(get_DesktopDir());
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			// 建立過濾器，只允許csv和txt
			FileNameExtensionFilter filter = new FileNameExtensionFilter("csv & txt", "csv", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(chooser);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String select_Path = chooser.getSelectedFile().getPath();
				String selectFileName = chooser.getSelectedFile().getName();
				String[] getSelectFileName = selectFileName.split("[.]");
				String outputFile_path = chooser.getSelectedFile().getParent() + "\\vcf"+getSelectFileName[0]+".vcf";
				label_path.setText(select_Path);
				try {
					//設置輸入 & 輸出 路徑
					get_InputStreamReader(select_Path);
					get_OutputStreamWriter(outputFile_path);
										
					//取得輸入路徑檔案，並解析
					List<String> listContacts = ReadFileContacts(select_Path);
					
					List<jia.entity.Contacts>Object_Contacts_list = analysisFileToContactsClass(listContacts);
										
					//用解析結果，生成vcf檔案
					generate_cvf(outputFile_path,Object_Contacts_list);
					System.out.println("轉換成功 successful !");
					
				} catch (FileNotFoundException | UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
		
	}
	@Test
	public void test() throws IOException {
		jia.entity.Contacts cnt = new jia.entity.Contacts();
		cnt.setN_Name("老六");
		cnt.setFN("老六");
		cnt.setTEL("5566183");
		cnt.setTEL_second("1835566");
		cnt.setTEL_HOME("111111");
		//cnt.setTEL_WORK("22222");
		cnt.setTEL_PREF("33333");
		cnt.setTEL_WORK_FAX("44444");
		cnt.setTEL_HOME_FAX("55555");
		cnt.setTEL_PAGER("66666");
		cnt.setTEL_VOICE("777777");
		cnt.setEMAIL_HOME("myhome@qq.com");
		cnt.setEMAIL_WORK("mywork@yahoo.com.cn");
		cnt.setADR_HOME("富麗台北123號");
		cnt.setADR_WORK("富麗台北321號");
		cnt.setADR_CHARSET("富麗其他555號");
		cnt.setORG("建材成機構");
		cnt.setTITLE("清潔人員");
		cnt.setURL("www.testUrl.cn");
		cnt.setNOTE("測試人員");
		cnt.setBDAY("1999-09-09");
		cnt.setX_AIM("aimssaim");
		cnt.setX_MSN("msnnn");
		cnt.setX_YAHOO("yahoooo");
		cnt.setX_SKYPE("skyyype");
		cnt.setX_QQ("qqqq.qq.cn");
		cnt.setX_GOOGLE_TALK("googletalk");
		cnt.setX_ICQ("ICQQQQ");
		cnt.setX_JABBER("jabbbber");
		List<jia.entity.Contacts> list = new ArrayList<jia.entity.Contacts>();
		list.add(cnt);
		String test_path = get_DesktopDir()+"\\contact_01.vcf";
		ori_generate_cvf(test_path,list);
		System.out.println(cnt.toString()+"\n"+"#########################");
		System.out.println(cnt.generateContact(cnt));
		
	}
	@Test
	public void test_StringSpilt() {
		String a = "1,,4,5,,,7,2,";
		String[] b = a.split(",");
		for(int i = 0;i<b.length;i++) {
			System.out.println(b[i]);
		}
	}
	
	public static String inputFile_path=get_DesktopDir()+"\\JHF.csv";
//	public static String outputFile_path=get_DesktopDir() + "\\contact_01.vcf";
	
	
	public static void main(String[] args) throws IOException {
				
		new Contacts().CreateJFrame("vcf轉換");
		
	/*
		 
		//save a contact attr
		String[] Contacts_attr = null;
		//save from file import
		List<jia.entity.Contacts> Object_Contacts_list = new ArrayList(); 
		
		if(File_path_checked(outputFile_path)) {
		List<String> listContacts = ReadFileContacts(inputFile_path);
		for (String Contacts_String : listContacts) {
			Contacts_attr = Contacts_String.split(",");
			System.out.println(Contacts_attr[0]);
			jia.entity.Contacts cnt = new jia.entity.Contacts(Contacts_attr[0],Contacts_attr[0],Contacts_attr[1]);
			Object_Contacts_list.add(cnt);
			}
		
		generate_cvf(outputFile_path,Object_Contacts_list);
		System.out.println("successful !");
		}
	*/
	}
	
	public static OutputStreamWriter get_OutputStreamWriter(String outputFile_path) throws UnsupportedEncodingException, FileNotFoundException {
		FileOutputStream fileoutput = new FileOutputStream(outputFile_path);
		OutputStreamWriter outstreamwriter = new OutputStreamWriter(fileoutput,"UTF-8");

		return outstreamwriter;
	}
	
	public static InputStreamReader get_InputStreamReader(String select_path) throws FileNotFoundException, UnsupportedEncodingException{
		//File file_in = new File(select_path);
		FileInputStream fileinput = new FileInputStream(select_path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileinput,"GBK");
        
		return inputStreamReader;
	}
	
	public static List<jia.entity.Contacts> analysisFileToContactsClass(List<String> contacts_List) {
		
		// save a contact attr
		String[] Contacts_attr = null;
		// save from file import
		List<jia.entity.Contacts> Object_Contacts_list = new ArrayList<jia.entity.Contacts>();
		for (String Contacts_String : contacts_List) {
			Contacts_attr = Contacts_String.split(",");
			System.out.println(Contacts_attr[0]+","+Contacts_attr[1]);
			jia.entity.Contacts cnt = new jia.entity.Contacts(Contacts_attr[0], Contacts_attr[0], Contacts_attr[1],
					Contacts_attr[2],Contacts_attr[3],Contacts_attr[4],Contacts_attr[5],Contacts_attr[6],Contacts_attr[7],
					Contacts_attr[8],Contacts_attr[9],Contacts_attr[10],Contacts_attr[11],Contacts_attr[12],Contacts_attr[13],
					Contacts_attr[14],Contacts_attr[15],Contacts_attr[16],Contacts_attr[17],Contacts_attr[18],Contacts_attr[19],
					Contacts_attr[20],Contacts_attr[21],Contacts_attr[22],Contacts_attr[23],Contacts_attr[24],Contacts_attr[25],
					Contacts_attr[26],Contacts_attr[27]);
					System.out.println("Contacts_attr 長度 : "+Contacts_attr.length);
					for(int i =0;i<Contacts_attr.length;i++){
						System.out.print(Contacts_attr[i]+",");
					}
			Object_Contacts_list.add(cnt);
		}
		return Object_Contacts_list;
	}

	public static void generate_cvf(String out_path, List<jia.entity.Contacts> Object_Contacts_list)
			throws IOException {

		OutputStreamWriter outstreamwriter = get_OutputStreamWriter(out_path);

		for (jia.entity.Contacts contacts : Object_Contacts_list) {
			outstreamwriter.write(contacts.generateContact(contacts));
		}
		outstreamwriter.close();
	}
	
	public static void ori_generate_cvf(String out_path , List<jia.entity.Contacts> Object_Contacts_list) throws IOException {
		
		OutputStreamWriter outstreamwriter = get_OutputStreamWriter(out_path);

		for (jia.entity.Contacts contacts : Object_Contacts_list) {
			outstreamwriter.write(contacts.generateContact(contacts));
		}
			outstreamwriter.close();
	}
	
	public static String get_DesktopDir() {
		return FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	}
	
	public static List<String> ReadFileContacts(String select_path) throws IOException{
		List<String> listContacts = new ArrayList<String>();
        InputStreamReader inputStreamReader = get_InputStreamReader(select_path);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = null;
        while((line = br.readLine())!=null) {
        	listContacts.add(line);
        }
        br.close();
		
		
		return listContacts;
		
	}
	public static boolean OutputFile_path_checked(String path) throws IOException {
		File file_out = new File(path);
		if(path != null) {
			if(file_out.exists()) {
				return true;
			}else {
				file_out.createNewFile();
	            return true;
			}
		}else {
			return false;
		}
	}
	
	public static boolean InputFile_path_checked(String path) throws IOException {
		//实例化File类对象
		File file_in = new File(path);
		//文件判断，没有则生成
		if(file_in.exists()) {
			return true;
		}else {
			System.out.print("未選擇檔案");
			return false;
		}
		
	}
	

}
