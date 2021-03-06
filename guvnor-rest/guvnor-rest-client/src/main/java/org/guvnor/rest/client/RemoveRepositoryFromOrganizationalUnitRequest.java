package org.guvnor.rest.client;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class RemoveRepositoryFromOrganizationalUnitRequest extends JobRequest {

    private String organizationalUnitName;
    private String repositoryName;

    public String getOrganizationalUnitName() {
        return organizationalUnitName;
    }

    public void setOrganizationalUnitName( String organizationalUnitName ) {
        this.organizationalUnitName = organizationalUnitName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName( String repositoryName ) {
        this.repositoryName = repositoryName;
    }

}
