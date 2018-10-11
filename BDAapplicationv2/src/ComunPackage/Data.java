package ComunPackage;

import java.io.Serializable;

public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TypeData type;
	private Object content;

	public Data(TypeData type, Object content) {
		this.type=type;
		this.content=content;
		// TODO Auto-generated constructor stub
	}

	public TypeData getType() {
		return type;
	}

	public Object getContent() {
		return content;
	}
	

}
