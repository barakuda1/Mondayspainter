/*
    Author: Sharon Moll
    Date created: 8.03.2011
*/

Array.prototype.contains = function (searchValue) {
	var found = false;
	for (var i = 0; i < this.length; i++) {
		if ((found = this[i] === searchValue)) {
			break;
		}
	}
	return found;
}

var chat = {
		
	service: "MondayspainterService.xhtml",
	receivedMessages: [],

    init: function() {
    	setInterval(this.refreshChat, 1000);
    	
    	$('#chatmsg').keydown(function(event) {
			  if (event.keyCode == '13') {
			     event.preventDefault();
			     chat.sendMessage();
			  }
    	});
    	$('#chat button').click(function(){
    		chat.sendMessage();
    	});
    },
    
    sendMessage: function() {
    	 if($('#chatmsg').val() != '') {    		 
    		 $.ajax({
   	          	type: "POST",
   	          	url: chat.service,
   	          	data: {"controller": "ChatHandler", "function": "addMessage", "message": $('#chatmsg').val() },
   	          	success: function() {
   	          		$('#chatmsg').val('');
   	          	}
    		 });
    	 }   	
    },
    
    refreshChat: function() {
    	$.ajax({
	          type: "POST",
	          url: chat.service,
	          data: {"controller": "ChatHandler", "function": "getLastMessages"},
	          dataType: "json",
	          success: function(data){
	        	  $.each(data, function(i,item){
	        		  chat.addMessage(item.id, item.message, item.author);
	        	  });
	        	  $('#chathistory').animate({ scrollTop: $("#chathistory").attr("scrollHeight") }, 300);
            }
    	});
    },
	
    addMessage: function(id, msg, author) {
    	if(!this.receivedMessages.contains(id)) {
    		this.receivedMessages.push(id);
    		$('#chathistory').append('<div style="display:none">'+author+': '+msg+'</div>');    		
    		$('#chathistory div:last').fadeIn(200);
    	}
    }

};