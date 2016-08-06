package wu.you.gui.uilts;

//import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
/**
 * 
 * @author WYG
 *����һ��������ݿ�Ĺ�����
 */
public class SqlHelper {
	//������Ҫ�ı���
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	//���������Ƕ������ļ���
	//private static FileInputStream fin=null;
	private static InputStream fin=null;
	private static Properties pp=null;
	//private static CallableStatement cs=null;
	//������ݿ�
	private static String url="";
	private static String username="";
	private static String password="";
	private static String driver="";
	//��̬��  ���ñ���ʱ��ͼ��ؽ�ȥ����ߴ���Ч��
	static{
		try{
			//���ļ��ж�ȡ������Ϣ
			pp=new Properties();
			//fin=new FileInputStream("dbinfo.properties");
			
			//������ʹ��java web ��ʱ���ȡ�����ļ�Ҫ���������  ��������������ֱ�Ӷ�ȡ��   ʹ����������������£�
			//Ϊʲô������ô����   �� ��Ϊ�������ȥ���ļ���ʱ��Ĭ�ϵ���Ŀ¼��src    ���������ļ�������com.shp.util���������ȡ������
			//SqlHelper.class.getClassLoader().getResourceAsStream("com/shp/util/dbinfo.properties");
			fin =SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fin);
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			password=pp.getProperty("password");
			driver=pp.getProperty("driver");
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fin=null;
		}
	}
	//�õ�����
	public static Connection getConnection(){
		try{
			ct =DriverManager.getConnection(url, username, password);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ct;
	}
	
	
	//��ҳ����
	public static ResultSet executeQuery2(){
		return null;
	}
	
	//��ArrayList��ѯ  �ﵽ���������Դ����ر�
	public static ArrayList executeQuery3(String sql,String[] parms){
		PreparedStatement pstmt=null;
		Connection conn=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			
			pstmt=conn.prepareStatement(sql);
			
			//���ʺŸ�ֵ
			if(parms!=null&&!parms.equals("")){
				for(int i=0;i<parms.length;i++){
					pstmt.setString(i+1, parms[i]);
				}
			}
			rs=pstmt.executeQuery();
			
			ArrayList al=new ArrayList();
			ResultSetMetaData rsmd=rs.getMetaData();//�����������ResultSet������еı�š����ͺ�����
			int column=rsmd.getColumnCount();//����������ش� ResultSet �����е�����     �������ǿ��Եõ���Ĳ�ѯ����ж�����
			while(rs.next()){
				Object[] ob=new Object[column];//�������飬������������ʾһ�����
				for(int i=1;i<=column;i++){
					ob[i-1]=rs.getObject(i);//��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ��ΪObject���鸳ֵ  i-1����Ϊ������㿪ʼ
			}
				al.add(ob);
		}
			return al;//al��һ�б������һ��ob�������飬Ҳ����������ÿ��Ԫ�ض��Ƕ���ÿ��Ԫ�ش���˵�ǰ�е�ǰ���е��Ǹ�ResultSet�е�ֵ
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("executeSqlResultSet��������"+e.getMessage());
			
		}finally{
			//�ر���Դ
			close(rs,conn,pstmt);
		}
	}
	
	//ͳһ��SQL���
	public static ResultSet executeQuery(String sql,String parameters[]){
		try{
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1,parameters[i]);
				}
			}
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return rs;
		
	}
	//���Ҫִ�ж���
	public static void executeUpdate1(String sql[],String parameters[][]){
		try{
			ct=getConnection();
			ct.setAutoCommit(false);	
			for(int i=0;i<sql.length;i++){
				if(parameters[i]!=null){
					ps=ct.prepareStatement(sql[i]);
				for(int j=0;j<parameters[i].length;j++){
					ps.setString(j+1, parameters[i][j]);
				}
				ps.executeUpdate();
			}
			}
			ct.commit();
		}catch(Exception e){
			e.printStackTrace();
			
			//�ع�
			try{
				ct.rollback();
			}catch(SQLException e1){
				e.printStackTrace();
			}
			
			throw new RuntimeException(e.getMessage());
		}finally{
		close(rs, ct, ps);
		}
	}
	
	//ִ�и��µķ���
	//��дһ��update
	//SQL ��ʽΪ��update ����   set �ֶ���=��  where  �ֶ�=��
	//parameters Ӧ����(��abc����23 );
	public static void executeUpdate(String sql,String parameters[]){
		//����һ��ps
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
		//��ֵ
			if(parameters!=null){
				for(int i=0;i<parameters.length;i++){
						ps.setString(i+1,parameters[i]);
				}
			}
			//ִ��
			ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();//�����׶�
				//�׳��쳣���׳�����ʱ�쳣�����Ե��øú���ĺ���һ��ѡ��
				//���Դ���Ҳ���Է�����
				throw new RuntimeException(e.getMessage());
		}finally{
			close(rs,ct, ps);
			
		}
	}
	
	//ִ�йرյķ���
	public static void close(ResultSet rs,Connection ct,Statement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps=null;//ʹ���������.
		}
		if(ct!=null){
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct=null;
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs=null;
		}
	}
	
	
	//�õ�ct �� ps�� rs
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
	public static ResultSet getRs(){
		return rs;
	}
	
	public static void delete(String id){
		
		
	}

}


//���������Oracle�ĵ��ô洢��̵Ĵ���
//	
//	public static CallableStatement CallPro2(String sql,String[] inparameters,Integer[] outparameters){
//		try{
//			ct=getConnection();
//			cs=ct.prepareCall(sql);
//			if(inparameters!=null){
//				for(int i=0;i<inparemeters.length;i++){
//					cs.setObject(i+1,inparameters[i]);
//				}
//			}
//			
//			//��out����ֵ
//			if(outparameters!=null){
//				for(int i=0;i<outparameters.length;i++){
//					cs.registerOutParameter(inparameters.length+1+i,outparameter);	
//				}
//			}
//			cs.execute();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			//����Ҫ�ر�
//		}
//		return cs;
//	}
//	
//	//���ô洢���
//	//SQL  ��call  ��̣�����������
//	public  static void callPro1(String sql,String []parameters){
//		
//		try{
//			ct=getConnection();
//			cs=ct.prepareCall(sql);
//			
//			//��Ÿ�ֵ
//			if(parameters!=null){
//				for(int i=0;i<parameters.length;i++){
//					cs.setObject(i+1,parameters[i]);
//				}
//			}
//			cs.execute();
//		}catch(Exception e){
//			e.printStackTrace();
//			throw new RuntimeException(e.getMessage());
//		}finally{
//			close(rs,cs,ct);
//		}
//	}