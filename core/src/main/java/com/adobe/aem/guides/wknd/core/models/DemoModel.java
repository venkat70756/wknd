package com.adobe.aem.guides.wknd.core.models;


public interface DemoModel {

    public String getId();

    public String getHeading();

    public String getSubTitle();

}


/*
* We have to create the two files for the sling models (interface and class file)
*  we have to define the mehtods in the interface file based on the your cq:dialog file fileds
* 
*  
* we have to use the @Model annotation in the class file.
* with the help of implements keyword we have to establish the connection between interface and class.
* 
* @ValueMapValue annotation we can define the variablles.
*/
