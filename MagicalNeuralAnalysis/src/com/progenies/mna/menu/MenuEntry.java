package com.progenies.mna.menu;

import java.io.Serializable;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.progenies.mna.utils.XMLUtils;

public class MenuEntry implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String nameKey;
	private ArrayList<MenuEntry> childs;
	private String url;
	
	public MenuEntry(Element menuEntry)
	{
		NodeList nodes=menuEntry.getChildNodes();
		for(int i=0;i<nodes.getLength();i++)
		{
			Node node=nodes.item(i);
			if(node.getNodeType()!=Node.ELEMENT_NODE) continue;
			
			if("nameKey".equals(node.getNodeName()))
				this.nameKey=XMLUtils.getValue(node);
			else if("url".equals(node.getNodeName()))
				this.url=XMLUtils.getValue(node);
			else if("childs".equals(node.getNodeName()))
			{
				this.childs=new ArrayList<MenuEntry>();
				NodeList childNodes=node.getChildNodes();
				for(int j=0;j<childNodes.getLength();j++)
				{
					Node child=childNodes.item(j);
					if(child.getNodeType()==Node.ELEMENT_NODE && child.getNodeName()!=null && "MenuEntry".equals(child.getNodeName()))
						childs.add(new MenuEntry((Element) child));
				}
			}
			
		}
		
	}
	
	
	public String getNameKey() {
		return nameKey;
	}
	public void setNameKey(String nameKey) {
		this.nameKey = nameKey;
	}
	public ArrayList<MenuEntry> getChilds() {
		return childs;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

	
}
