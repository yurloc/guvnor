/*
 * Copyright 2011 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.guvnor.models.guided.dtable.shared.model;

import org.drools.guvnor.models.commons.shared.workitems.PortableWorkDefinition;

/**
 * A column representing the execution of a Work Item.
 */
public class ActionWorkItemCol52 extends ActionCol52 {

    private static final long serialVersionUID = 540l;

    private PortableWorkDefinition workItemDefinition;

    public PortableWorkDefinition getWorkItemDefinition() {
        return workItemDefinition;
    }

    public void setWorkItemDefinition( PortableWorkDefinition workItemDefinition ) {
        this.workItemDefinition = workItemDefinition;
    }

}