import org.mondayspainter.methods.ChatMessageMethods;

/*
 * Author: Sharon Moll
 * 
 */


//for test purposes
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		MondayspainterService s = new MondayspainterService();
//		System.out.println(s.getJson());
		
		
//		Player cm = new Player();
//		ArrayList<Player> a = cm.selectAll();
////		cm.select();
//		
//		for(Player m : a) {
//			System.out.println(m.getName());
//		}
		
		ChatMessageMethods m = new ChatMessageMethods();
		m.getLastMessages();
		
//		cm.setPlayerId(5);
//		cm.delete();
//		cm.setText("challo!");
//		cm.update();
//		
//		System.out.println(cm.getId()+"="+cm.getText()+","+cm.getPlayerId());
		
//		ArrayList<ChatMessage> messages = new ChatMessage().selectAll();
//		
//		for(ChatMessage m : messages) {
//			System.out.println(m.getText());
//		}
		
	}

}
