package wu.you.gui.service;

import java.util.ArrayList;

import wu.you.gui.domain.Customer;
import wu.you.gui.uilts.SqlHelper;

public class CustomerService {
	
	//��֤�û��Ƿ�Ϸ� 
	//����ݿ���֤
	public boolean getFirst_name(Customer user){
		String sql = "select * from customer c where c.first_name=?";
		String parm[] = {user.getFirst_name()};
		ArrayList al = SqlHelper.executeQuery3(sql, parm);
		
			
			if(al.size()==0){
				return false;  	
			}else{
				Object object[]=(Object[]) al.get(0);
				for (int j = 0; j < object.length; j++) {
					System.out.println(object[j]);
					
				}
				user.setFirst_name((object[1]).toString());
				return true;
			}
		}
		
		
	}

