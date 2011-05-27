/*
 * Author: Sharon Moll
 * 
 */

package org.mondayspainter.servicehandler;

import java.util.ArrayList;

import org.mondayspainter.dataobject.Round;



public class PaintingHandler extends BasicHandler {

	public void savePaintingState() {
		
		ArrayList<Round> rounds = new Round().selectAll();
		if(rounds.size() > 0) {
			
			Round r = rounds.get(0);
			if(r.getPlayerId() == 1) { //check if player is activ painter
				
			}
		}
	}
	
}