package com.mkyong.repositories.sec;

import com.mkyong.models.sec.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/*
Create By: Ron Rith
Create Date: 1/2/2018
*/
@Repository("roleRepository")
public interface RoleRepository extends PagingAndSortingRepository<Role, Integer> {
	Role findByRole(String role);

}
