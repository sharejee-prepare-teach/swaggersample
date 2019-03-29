package com.mkyong.services.sec;

import com.mkyong.models.sec.Role;
import com.mkyong.models.sec.SecUser;
import com.mkyong.repositories.sec.RoleRepository;
import com.mkyong.repositories.sec.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/*
Create By: Ron Rith
Create Date: 1/2/2018
*/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public SecUser findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void saveUser(SecUser secUser) {
		secUser.setPassword(bCryptPasswordEncoder.encode(secUser.getPassword()));
        secUser.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        secUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(secUser);
	}

	public List<SecUser> findAllUsers() {
		return (List<SecUser>) userRepository.findAll();
	}

	public SecUser getUserById(Long id) {
		Optional<SecUser> secUser = userRepository.findById(id);
		return (SecUser) secUser.get();
	}

	public Page<SecUser> findAllPageable(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public void deleteUser(Long id) {
		Optional<SecUser> secUser = userRepository.findById(id);
		userRepository.delete(secUser.get());
	}

	public void updateUser(SecUser secUser, Long id) {
		secUser.setId(id);
		userRepository.save(secUser);
	}

	public SecUser findByEmailAndPassword(String email, String password) {
		SecUser secUser = null;
		if ((!email.isEmpty() && email != null) && (!password.isEmpty() && password != null)) {
			secUser = userRepository.findByEmailAndPassword(email,password);
			return secUser;
		}
		return null;
	}


}
