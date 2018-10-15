package ComunPackage;

import java.io.Serializable;

public enum TypeData implements Serializable{
	//user comands
	REQUEST_LOG,
	REQUEST_SIGN,
	
	//server comands
	DENIED_ACESS,
	ACESS_ACCEPT,
	USER_EXIST,
	USER_DO_NOT_EXIST
}
