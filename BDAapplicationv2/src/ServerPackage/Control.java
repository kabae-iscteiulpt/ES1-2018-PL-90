package ServerPackage;

import ComunPackage.Data;

public class Control {
	
	private Data data=null;
	
	public Control() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void putData(Data varData) {
		while(data!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		data=varData;
		notifyAll();
	}

	public synchronized Data takeData() {
		while(data==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Data aux=data;
		data=null;
		notifyAll();
		return aux;
	}

}
