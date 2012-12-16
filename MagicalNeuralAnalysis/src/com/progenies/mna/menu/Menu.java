package com.progenies.mna.menu;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.InitializingBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Menu implements InitializingBean
{
	ArrayList<MenuEntry> entries;
	private String menuSource;
	
	public Menu()
	{
		entries=new ArrayList<MenuEntry>();
	}
	
	
	@Override
	public void afterPropertiesSet() throws Exception
	{
		//open menu
		Document doc=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Menu.class.getResource(menuSource).openStream());
		
		//get root
		NodeList nodes=doc.getFirstChild().getChildNodes();
		
		for(int i=0;i<nodes.getLength();i++)
		{
			addEntry(nodes.item(i), entries);
		}
	}
	

	private void addEntry(Node item, ArrayList<MenuEntry> targetCollection)
	{
		//check sanity: Solo de tipo elemento
		if(item==null || item.getNodeType() != Node.ELEMENT_NODE) return;
		
		Element menuEntry=(Element)item;
		
		entries.add(new MenuEntry(menuEntry));
		
	}


	public String getMenuSource() {
		return menuSource;
	}

	public void setMenuSource(String menuSource) {
		this.menuSource = menuSource;
	}
	
	public ArrayList<MenuEntry> getEntries() {
		return entries;
	}


	


}
