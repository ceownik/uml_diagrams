import java.awt.*;
import java.util.*;

import com.baselet.control.Constants;
import com.baselet.control.Utils;

@SuppressWarnings("serial")
public class <!CLASSNAME!> extends com.umlet.custom.CustomElement {
	
	// columns amount
	public int columnsCount = 0;
	
	//public Vector<int> columnsSize = new Vector<int>;


	public CustomElementImpl() {
		
	}
	
	@Override
	public void paint() {
		Vector<String> textlines = Utils.decomposeStrings(this.getPanelAttributes());
	
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
drawRectangle(0,0,onGrid(width),onGrid(height));
		/****CUSTOM_CODE END****/
	}
}