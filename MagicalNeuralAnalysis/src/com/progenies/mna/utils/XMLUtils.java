package com.progenies.mna.utils;

import org.w3c.dom.Node;

public class XMLUtils
{
	
	public static final String getValue(Node node)
	{
		if(node==null || node.getFirstChild()==null) return null;
		return node.getFirstChild().getNodeValue();
	}

}
