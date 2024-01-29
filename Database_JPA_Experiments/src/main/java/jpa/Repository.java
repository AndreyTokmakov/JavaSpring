/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* Repository.java class
*
* @name    : Repository.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 12, 2020
****************************************************************************/

package jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Customer, Long> {
	
	public List<Customer> findByLastName(String lastName);
	
	public Customer findById(long id);
}
