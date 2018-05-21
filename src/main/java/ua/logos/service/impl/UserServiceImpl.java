package ua.logos.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.logos.dto.UserDtoForList;
import ua.logos.dto.filter.SimpleFilter;
import ua.logos.entity.User;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository userRepos;

	@Override
	public void saveUser(User user) {
		userRepos.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userRepos.getOne(id);
	}

	@Override
	public List<User> findAllUser() {
		return userRepos.findAll();
	}

	@Override
	public List<User> findAllByFilter(SimpleFilter filter) {
		return userRepos.findAll(getSpecification(filter));
	}
	
	private Specification<User> getSpecification(SimpleFilter filter){
		return new Specification<User>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> q, CriteriaBuilder cb) {
				Predicate fnPredicate = null;
				Predicate lnPredicate = null;
				Predicate emailPredicate = null;
				Predicate loginPredicate = null;
				Predicate maxSalaryPredicate = null;
				Predicate minSalaryPredicate = null;
				
				List<Predicate> predicates = new ArrayList<>();
				
				if(!filter.getFirstName().isEmpty()) {
					fnPredicate = cb.like(root.get("firstName"),"%" + filter.getFirstName() + "%");
					predicates.add(fnPredicate);
				}
				if(!filter.getLastName().isEmpty()) {
					lnPredicate = cb.like(root.get("lastName"), "%" + filter.getLastName() + "%");
					predicates.add(lnPredicate);
				}
				if(!filter.getEmail().isEmpty()) {
					emailPredicate = cb.like(root.get("email"), "%" + filter.getEmail() + "%");
					predicates.add(emailPredicate);
				}
				if(!filter.getLogin().isEmpty()) {
					loginPredicate = cb.like(root.get("login"), "%" + filter.getLogin() + "%");
					predicates.add(loginPredicate);
				}
				
//				if(!filter.getMaxSalary().equals(null) && !filter.getMinSalary().equals(null)) {
//					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), filter.getMaxSalary());
//					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), filter.getMinSalary());
//					predicates.add(maxSalaryPredicate);
//					predicates.add(minSalaryPredicate);
//				} else if (filter.getMaxSalary().equals(null) && !filter.getMinSalary().equals(null)) {
//					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), filter.getMinSalary());
//					predicates.add(minSalaryPredicate);
//				} else {
//					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), filter.getMaxSalary());
//					predicates.add(maxSalaryPredicate);
//				}
				
//				if(!Integer.toString(filter.getMinSalary()).isEmpty() && !Integer.toString(filter.getMaxSalary()).isEmpty()) {
//					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), filter.getMaxSalary());
//					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), filter.getMinSalary());
//					predicates.add(maxSalaryPredicate);
//					predicates.add(minSalaryPredicate);
//				} else if (!Integer.toString(filter.getMinSalary()).isEmpty() && Integer.toString(filter.getMaxSalary()).isEmpty()) {
//					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), filter.getMinSalary());
//					predicates.add(minSalaryPredicate);
//				} else if (Integer.toString(filter.getMinSalary()).isEmpty() && !Integer.toString(filter.getMaxSalary()).isEmpty()) {
//					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), filter.getMaxSalary());
//					predicates.add(maxSalaryPredicate);
//				}
				
				
				if(!filter.getMinSalary().equals(null)) {
					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), filter.getMinSalary());
					predicates.add(minSalaryPredicate);
				} else if (filter.getMinSalary().equals(null)){
					minSalaryPredicate = cb.greaterThanOrEqualTo(root.get("salary"), 0);
					predicates.add(minSalaryPredicate);
				}
				
				if(!filter.getMaxSalary().equals(null)) {
					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), filter.getMaxSalary());
					predicates.add(maxSalaryPredicate);
				} else if(filter.getMaxSalary().equals(null)) {
					maxSalaryPredicate = cb.lessThanOrEqualTo(root.get("salary"), 1000000);
					predicates.add(maxSalaryPredicate);
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}
	
}
