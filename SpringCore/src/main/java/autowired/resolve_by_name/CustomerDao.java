/****************************************************************************
* Copyright 2020 (C) Andrey Tokmakov
* CustomerDao.java class
*
* @name    : CustomerDao.java
* @author  : Tokmakov Andrey
* @version : 1.0
* @since   : Dec 14, 2020
****************************************************************************/

package autowired.resolve_by_name;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao implements IDao
{
	@Override
	public void result() {
		System.out.println("Customer Dao Implementation");
	}
}
