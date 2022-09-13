package com.Product.Exception;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
	private static final long serialVersionUID =1L;
	
	private String resourceName;
	private String feildName;
	private Object feildValue;
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFeildName() {
		return feildName;
	}

	public Object getFeildValue() {
		return feildValue;
	}

	public ResourceNotFound(String resourceName, String feildName, Object feildValue) {
		super(String.format("%s not Found with the , %s : %s ",resourceName,feildName,feildValue ));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}
	
	
	

}
