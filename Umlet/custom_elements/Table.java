import java.awt.*;
import java.util.*;

import com.baselet.control.Constants;
import com.baselet.control.Utils;

@SuppressWarnings("serial")
public class <!CLASSNAME!> extends com.umlet.custom.CustomElement {
	
	// columns amount
	public Int columnsCount = 0;
	
	
	// columns length
	public Vector<Int> columnsSize = new Vector<Int>;
	
	
	// longest column width
	public Int longestColumnWidth = 0;
	
	
	// text lines to display
	public Vector<String> textlines = new Vector<String>;
	
	
	public CustomElementImpl() {
		
	}
	
	
	//
	public prepare()
	{
		return "after prepare";
	}
	
	@Override
	public void paint() {
		this.textlines = Utils.decomposeStrings(this.getPanelAttributes());
		Vector<String> textlines = this.textlines;
		
		String test = "before prepare";
		//test = this.prepare();
	
		/****CUSTOM_CODE START****/
//This is a self resizing component which displays data in table 
//you are able to resize at manually
//As soon as it is resized manually a new text is
//added to the property panel


setAutoresize(20,20,10);

int y=textHeight();

boolean center = true;
for(int i = 0; i < textlines.size(); i++) {
	String textline = textlines.get(i);
	if(textline.equals("--")) {
		drawLineHorizontal((int) (y-textHeight()*0.7));
		center = false;
		if (!isManualResized()) height -= (int) (textHeight()*0.75);
		y += textHeight()*0.3;
	}
	else {
		if (center) y += printCenter(textline,y); 
		else y += printLeft(textline,y);
	}
}
	//printLeft(this.columnsCount,100);
	printLeft(test,50);
drawRectangle(0,0,onGrid(width),onGrid(height));
		/****CUSTOM_CODE END****/
	}
}