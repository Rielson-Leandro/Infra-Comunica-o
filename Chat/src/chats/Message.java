package chats;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable{
    
    public enum MsgType {
        Enter_Name,//Sever pede cliente para identifica��o
        User_Name, //nome do usu�rio resposta do cliente e porta
        Create_Group,//pares envia uma solicita��o de novo grupo
        List_Groups, //Lista de grupos dispon�veis
        Join_Group,
        Conv_Msg,
        Group_Msg,
        List_Users, //Lista de usu�rios on-line
        Bye,
        group_chat_message,
        
        
    }
    public Message() {
		super();
    }
    public Message(MsgType msg, String data) {
		super();
		this.msg = msg;
		this.data = data;
	}
    public Message(MsgType msg) {
		super();
		this.msg = msg;
	}
	public MsgType msg;
    public String data;
    public void dataTosend(MsgType m,String d){
        this.msg= m;
        this.data= d;
    }
}

class User_Message extends Message 
{
	
	public User_Message(User user) {
		super( MsgType.User_Name);
		this.user = user;
	}

	User user; 
	
}

class ListofUseres extends Message
{
	
	public ListofUseres(List<User> user_List) {
		super( MsgType.List_Users);
		this.userlist = user_List;
	}

	List<User> userlist;
}

class ListofGroups extends Message
{
	
	public ListofGroups(String data,ArrayList<Available_group> grouplist) {
		super( MsgType.List_Groups, data);
		this.grouplist = grouplist;
	}
	public ListofGroups(List<Available_group> available_groups_list) {
		super( MsgType.List_Groups);
		this.grouplist = available_groups_list;
	}

	List<Available_group> grouplist;
}
class broadcast_messsage_send  extends Message
{
	String group_name;
	String sender_name;
	public broadcast_messsage_send(String resala_nafsha,String group_name) {
		super(MsgType.group_chat_message, resala_nafsha);
		this.group_name=group_name;
		
	}
	
	@Override
	public String toString() {
		return "broadcast_messsage_send [group_name=" + group_name
				+ ", sender_name=" + sender_name +  ", msg="
				+ data + "]";
	}

	public broadcast_messsage_send(String resala_nafsha,String group_name,String sender_name) {
		super(MsgType.group_chat_message, resala_nafsha);
		this.group_name=group_name;
		this.sender_name=sender_name;
		
	}
	
}