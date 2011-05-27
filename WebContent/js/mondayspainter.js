/*
    Author: Sharon Moll
    Date created: 8.03.2011
*/

// the three global variables for painting
var canvas, context, tool;

//mondayspainter namespace
var mondayspainter = {

    //settings
    background: '#ffffff',
    colorpickerId: 'colorpicker',
    defaultColor: '#000000',

    //clear canvas
    clearCanvas: function() {
        context.clearRect(0,0,canvas.width,canvas.height);
    },

    init: function() {
        //set default stroke style
        context.strokeStyle = "#cb3594";
        
        //init colorbar
        $('#colorbar img').each(function(){
            $(this).parent().css('background-color', $(this).attr('color'));
            $(this).click(function(){
                var c = $(this).attr('color');
                mondayspainter.setActiveColorObj($(this));
                mondayspainter.setColor(c);
                
                var pos = $(this).position();
                mondayspainter.showColorPicker(pos.left, pos.top, c);
            });
        });
        
        //init thickness chooser
        $('#toolbar #thikness div img').each(function(){
            var thikness = $(this).attr('thikness');
            $(this).css({height: thikness, width: 90});
            $(this).parent().click(function(){
                mondayspainter.setActiveThiknessObj($(this));
                context.lineWidth = thikness;
            });
        });
        
        //set default thikness
        mondayspainter.setActiveThiknessObj($('#toolbar #thikness div:first'));
        
        //init pen tool
        $('#pen').click(function(){
            if(mondayspainter.activeColorObj) {
                mondayspainter.setColor(mondayspainter.activeColorObj.attr('color'));
            } else {
                context.strokeStyle = mondayspainter.defaultColor;
            }
            $('#mondayspainter').css('cursor', 'url("img/pen-mini.png"), auto');
        });
        
        //init eraser tool
        $('#eraser').click(function(){
            context.strokeStyle = mondayspainter.background;
            $('#mondayspainter').css('cursor', 'url("img/eraser-mini.png"), auto');
        });
        
        //set default tool
        $('#pen').click();
        
        //init clear button
        $('#clear').click(function(){
        	mondayspainter.clearCanvas();
        });
        
        //init button click effect
        $('#pen, #eraser, #clear').click(function(){
            $(this).fadeOut(100).fadeIn(200);
        });
    },

    setActiveThiknessObj: function(obj) {
        if(mondayspainter.activeThiknessObj) {
            mondayspainter.activeThiknessObj.css({background: 'none'});
        }
        obj.css({background: '#e3e3e3'});
        mondayspainter.activeThiknessObj = $(obj);
    },

    showColorPicker: function(x, y, color) {
        $.farbtastic('#'+mondayspainter.colorpickerId).setColor(color);
        $('#'+mondayspainter.colorpickerId+' .farbtastic').css({
            visibility: 'visible',
            left: x+70,
            top: y-60
        });
    },

    setActiveColorObj: function(cObj) {
        if(mondayspainter.activeColorObj) {
            mondayspainter.activeColorObj.parent().css('background-image', 'none');
        }
        mondayspainter.activeColorObj = $(cObj);
    },

    setColor: function(color) {
        if(mondayspainter.activeColorObj) {
            mondayspainter.activeColorObj.parent().css('background-color', color);
            mondayspainter.activeColorObj.attr('color', color);
        }
        context.strokeStyle = color;
    }

};