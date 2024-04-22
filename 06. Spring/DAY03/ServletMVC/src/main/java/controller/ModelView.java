package controller;

import java.util.Map;

/**
 * MVC 에서 Model, View 정보를 관리하는 객체 
 * @author tj-bu-706-05
 *
 */
public class ModelView {

	Map<String, Object> model;
	String view;
	boolean redirect = false;
	
	public ModelView() {
		
	}

	public ModelView(Map<String, Object> model, String view) {
		this.model = model;
		this.view = view;
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	// 추가 메소드
	public void addModel(String name, Object object) {
		model.put(name, object);
	}
	
}