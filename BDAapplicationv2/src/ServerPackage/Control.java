package ServerPackage;
import java.util.LinkedList;

import ComunPackage.Data;

public class Control {

	private LinkedList<Data> listData=new LinkedList<Data>();
	
	public Control() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void putData(Data varData) {
		listData.add(varData);
		notifyAll();
	}

	public synchronized Data takeData() {
		
		while(listData.size()==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Data aux=listData.poll();
		notifyAll();
		return aux;
		
	}

}
