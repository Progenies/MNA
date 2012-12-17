package com.progenies.mna.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class FormUtils
{
	
	public static <T, R> void copyFields(R fromObj, T toObj)
	{
		//recuperamos las propiedades de destino
		try {
			BeanInfo fromInfo=Introspector.getBeanInfo(fromObj.getClass());
			BeanInfo toInfo=Introspector.getBeanInfo(toObj.getClass());
			
			PropertyDescriptor fromProps[]=fromInfo.getPropertyDescriptors();
			PropertyDescriptor toProps[]=toInfo.getPropertyDescriptors();
			
			//recorro las propiedades destino
			for(PropertyDescriptor toProp : toProps)
			{
				//solo propiedades de lectura/escritura
				if(toProp.getReadMethod()!=null && toProp.getWriteMethod()!=null)
				{
					//busco la propiedad origen
					for(PropertyDescriptor fromProp : fromProps)
					{
						if(fromProp.getName().equals(toProp.getName()))
						{
							toProp.getWriteMethod().invoke(toObj, fromProp.getReadMethod().invoke(fromObj));
							break;
						}
					}
				}
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error copying properties", e);
		}
	}

}
