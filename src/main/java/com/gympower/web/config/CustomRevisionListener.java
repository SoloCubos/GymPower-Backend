package com.gympower.web.config;

import org.hibernate.envers.RevisionListener;

import com.gympower.web.entities.audit.Revision;

public class CustomRevisionListener implements RevisionListener{

    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity; 
    }
    
}
