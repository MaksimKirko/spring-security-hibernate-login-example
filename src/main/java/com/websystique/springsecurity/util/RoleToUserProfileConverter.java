package com.websystique.springsecurity.util;

import com.websystique.springsecurity.model.Role;
import com.websystique.springsecurity.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserProfileConverter implements Converter<Object, Role> {

    @Autowired
    IRoleService IRoleService;

    /*
     * Gets Role by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Role convert(Object element) {
        Long id = Long.parseLong((String) element);
        Role role = IRoleService.getById(id);
        System.out.println("Role : " + role);
        return role;
    }

	/*
	 * Gets Role by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/*
	public Role convert(Object element) {
		String type = (String)element;
		Role profile= IRoleService.getByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}