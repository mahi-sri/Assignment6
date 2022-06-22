package com.libraryManagement.web.constants;

public interface Constants {
	String INVALID_CREDENTIALS = "*Invalid Credentials";
	String INVALID_INPUTS = "*Invalid Inputs";
	String INDEX_PAGE = "index.jsp";
	String EDIT_PAGE = "editForm.jsp";
	String PRODUCT_PAGE = "productManagement.jsp";
	String USERNAME = "username";
	String RECORDS = "records";
	String SHOW_ERROR = "showError";
	String ERROR_MESSAGE = "errorMessage";
	String HIBERNATE_CONFIGURATION_PRODUCT = "hibernate.cfg.product.xml";
	String HIBERNATE_CONFIGURATION_USER = "hibernate.cfg.xml";
	String DELETE_PRODUCT_BY_ID_QUERY = "delete from ProductModel s where s.prodId= :id";
	String UPDATE_PRODUCT_QUERY = "update ProductModel p set p.title= :title, p.quantity= :quant, p.image= :img, p.size= :size where p.prodId= :id";
	String UPDATE_PRODUCT_EXCEPT_IMAGE_QUERY = "update ProductModel p set p.title= :title, p.quantity= :quant, p.size= :size where p.prodId= :id";
	String FETCH_ALL_PRODUCTS_QUERY = "from ProductModel";
	String FETCH_ALL_USERS_QUERY = "from LoginModel";
	

}
