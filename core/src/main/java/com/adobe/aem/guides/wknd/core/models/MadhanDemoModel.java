package com.adobe.aem.guides.wknd.core.models;

import com.adobe.aem.guides.wknd.core.models.impl.MadhanDemoMultiModel;

import java.util.List;

public interface MadhanDemoModel {

    public String getMadhanTitle();

    public String getMadhanDescription();

    public String getMobileNumber();

    public String getCompHeight();

    public String getMyName();

    public List<MadhanDemoMultiModel> getContact();
}
