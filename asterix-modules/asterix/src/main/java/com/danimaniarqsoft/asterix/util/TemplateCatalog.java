package com.danimaniarqsoft.asterix.util;

public class TemplateCatalog {

    private static final String MANAGED_BEAN_TEMPLATE_PATH ="scaffolding/controller/";
    private static final String SERVICE_TEMPLATE_PATH ="scaffolding/service/";
    private static final String WEB_TEMPLATE_PATH ="scaffolding/web/";
    
    public static final String SELECT_ONE_MENU = "selectOneMenu.xhtml";
    public static final String CREATE_PAGE_TEMPLATE = WEB_TEMPLATE_PATH+"create.xhtml";
    public static final String DELETE_PAGE_TEMPLATE = WEB_TEMPLATE_PATH+"delete.xhtml";
    public static final String EDIT_PAGE_TEMPLATE = WEB_TEMPLATE_PATH+"edit.xhtml";
    public static final String LIST_PAGE_TEMPLATE = WEB_TEMPLATE_PATH+"list.xhtml";
    public static final String VIEW_PAGE_TEMPLATE = WEB_TEMPLATE_PATH+"view.xhtml";
    
    
    public static final String MANAGED_BEAN_TEMPLATE = MANAGED_BEAN_TEMPLATE_PATH+"ManagedBean.java";
    public static final String SERVICE_TEMPLATE = SERVICE_TEMPLATE_PATH+"Service.java";
}
