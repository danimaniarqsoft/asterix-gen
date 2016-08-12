package com.danimaniarqsoft.asterix.domain.scaffolding;

public class ScaffoldingContext {

    private PageContext pageContext;
    private ManagedBeanContext managedBeanContext;
    private ServiceContext serviceContext;

    public PageContext getPageContext() {
        return pageContext;
    }

    public void setPageContext(PageContext pageContext) {
        this.pageContext = pageContext;
    }

    public ManagedBeanContext getManagedBeanContext() {
        return managedBeanContext;
    }

    public void setManagedBeanContext(ManagedBeanContext managedBeanContext) {
        this.managedBeanContext = managedBeanContext;
    }

    public ServiceContext getServiceContext() {
        return serviceContext;
    }

    public void setServiceContext(ServiceContext serviceContext) {
        this.serviceContext = serviceContext;
    }
}
